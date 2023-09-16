CREATE OR REPLACE PROCEDURE SP_CERRARASIGNATURA(ID_ASIGNATURA_IN IN NUMBER, RESULTADO_OUT OUT VARCHAR)

IS 

    SQL_ERRORCODE INT;
    SQL_ERRORMESSAGE VARCHAR(1500);
    PARAM_VAR NUMBER;
    CURSOR ALUMNOS_CURSO IS
        select 
            p.run, p.pri_nom, nvl(p.seg_nom,' ') as seg_nom, p.pri_ap, nvl(p.seg_ap, ' ') as seg_ap, round((a.p1 + a.p2)/2, 1) as nota
        from nota a  join persona p on a.run = p.run
        where a.id_asignatura = ID_ASIGNATURA_IN; 
    FILA_VAR ALUMNOS_CURSO%ROWTYPE;
BEGIN 
    UPDATE NOTA SET PF = ROUND((p1 + p2)/2, 1) WHERE ID_ASIGNATURA = ID_ASIGNATURA_IN;
    COMMIT;
    SELECT VALOR INTO PARAM_VAR FROM PARAMS WHERE ID_PARAM = 1;
    FOR FILA_VAR IN ALUMNOS_CURSO
    LOOP
        IF FILA_VAR.NOTA >=PARAM_VAR THEN
            UPDATE NOTA SET ESTADO = 'A' WHERE RUN = FILA_VAR.RUN AND ID_ASIGNATURA = ID_ASIGNATURA_IN; --SI LA NOTA ES MAYOR A LO DEFINIDO, APRUEBA
        ELSIF FILA_VAR.NOTA < PARAM_VAR THEN
            UPDATE NOTA SET ESTADO = 'R' WHERE RUN = FILA_VAR.RUN AND ID_ASIGNATURA = ID_ASIGNATURA_IN; -- SI ES MENOR, REPRUEBA
        END IF;
    END LOOP;
    UPDATE ASIGNATURA SET ESTADO = 'F' WHERE ID_ASIGNATURA = ID_ASIGNATURA_IN; --CAMBIA ESTADO A FINALIZADO
    COMMIT;
    RESULTADO_OUT := 0;
EXCEPTION WHEN OTHERS THEN
    SQL_ERRORMESSAGE:=SQLERRM;
    SQL_ERRORCODE:= SQLCODE;
    RESULTADO_OUT:=-1;
    INSERT INTO ERROR(ID_ERROR, PROCESO, COD_ERROR, MENSAJE_ERROR, FECHA) VALUES
                    ((SELECT NVL(MAX(ID_ERROR), 0)+1 FROM ERROR), 'SP_CERRARASIGNATURA',SQL_ERRORCODE,SQL_ERRORMESSAGE, CURRENT_TIMESTAMP );
    COMMIT;

END;

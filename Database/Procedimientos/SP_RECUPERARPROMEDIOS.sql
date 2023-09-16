CREATE OR REPLACE PROCEDURE SP_RECUPERARPROMEDIOS(ID_CURSO_IN IN NUMBER, RUN_IN IN NUMBER, P1_CURSO_OUT OUT NUMBER, P2_CURSO_OUT OUT NUMBER,
        PF_CURSO_OUT OUT NUMBER, P1_ALUMNO_OUT OUT NUMBER, P2_ALUMNO_OUT OUT NUMBER, PF_ALUMNO_OUT OUT NUMBER)
IS
    SQL_ERRORCODE INT;
    SQL_ERRORMESSAGE VARCHAR(1500);
BEGIN
    select NVL(ROUND(sum(p1)/count(p1), 1), 0) INTO P1_CURSO_OUT
        from v_notas2 where id_curso = ID_CURSO_IN and p1<> 0;
    select NVL(ROUND(sum(p2)/count(p2), 1),0) INTO P2_CURSO_OUT
        from v_notas2 where id_curso = ID_CURSO_IN and p2<> 0;
    select NVL(ROUND(sum(pf)/count(pf),1), 0) INTO PF_CURSO_OUT
        from v_notas2 where id_curso = ID_CURSO_IN and p2<> 0;
    
    select NVL(ROUND(sum(p1)/count(p1), 1), 0) INTO P1_ALUMNO_OUT
        from v_notas2 where id_curso = ID_CURSO_IN and p1<> 0 and run=RUN_IN;
    select NVL(ROUND(sum(p2)/count(p2), 1),0) INTO P2_ALUMNO_OUT
        from v_notas2 where id_curso = ID_CURSO_IN and p2<> 0 and run=RUN_IN;
    select NVL(ROUND(sum(pf)/count(pf),1), 0) INTO PF_ALUMNO_OUT
        from v_notas2 where id_curso = ID_CURSO_IN and p2<> 0 and run=RUN_IN;
EXCEPTION WHEN OTHERS THEN
    SQL_ERRORMESSAGE:=SQLERRM;
    SQL_ERRORCODE:= SQLCODE;

    INSERT INTO ERROR(ID_ERROR, PROCESO, COD_ERROR, MENSAJE_ERROR, FECHA) VALUES
                    ((SELECT NVL(MAX(ID_ERROR), 0)+1 FROM ERROR), 'SP_RECUPERARPROMEDIOS',SQL_ERRORCODE,SQL_ERRORMESSAGE, CURRENT_TIMESTAMP );
    COMMIT;
END;
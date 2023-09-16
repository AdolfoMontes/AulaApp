CREATE OR REPLACE PROCEDURE SP_INSERTARLECCION(DESCRIPCION_IN IN VARCHAR, DATE_IN IN DATE, USUARIO_IN VARCHAR, ID_ASIGNATURA_IN IN INT, RESULTADO_OUT OUT NUMBER)
IS
    VALIDADOR_LECCION INT;
    MSJ_ERROR VARCHAR(1000);
    ANIO_ASIGNATURA INT;
    VALIDADOR_ANIO INT;
BEGIN
    VALIDADOR_LECCION:= F_VALIDAREXISTENCIALECCION(DATE_IN, ID_ASIGNATURA_IN);
    SELECT ANIO INTO ANIO_ASIGNATURA FROM ASIGNATURA WHERE ID_ASIGNATURA = ID_ASIGNATURA_IN;
    IF ANIO_ASIGNATURA = EXTRACT(YEAR FROM DATE_IN) THEN
        VALIDADOR_ANIO:=0;
    ELSE
        VALIDADOR_ANIO:=-1; --El año seleccionado para la lección no coincide con el año de asignatura
    END IF;
    IF VALIDADOR_LECCION = -1 and VALIDADOR_ANIO =0 THEN
        UPDATE LECCIONARIO SET DESCRIPCION=DESCRIPCION_IN, FECHA_MOD= CURRENT_TIMESTAMP, USUARIO_MOD=USUARIO_IN WHERE FECHA = DATE_IN AND ID_ASIGNATURA = ID_ASIGNATURA_IN;
        RESULTADO_OUT :=1; --registro updateado
    ELSIF VALIDADOR_LECCION = 0 and VALIDADOR_ANIO =0 THEN
        INSERT INTO LECCIONARIO (ID_LECCION, DESCRIPCION, FECHA, FECHA_CREACION, USUARIO_CRE, ID_ASIGNATURA)
                    VALUES((SELECT NVL(MAX(ID_LECCION), 0)+1 FROM LECCIONARIO), DESCRIPCION_IN, DATE_IN, CURRENT_TIMESTAMP, USUARIO_IN, ID_ASIGNATURA_IN);
         RESULTADO_OUT :=0; --registro insertado
    ELSIF VALIDADOR_ANIO = -1 THEN
        RESULTADO_OUT:=-2;
    END IF;
    COMMIT;
EXCEPTION WHEN OTHERS THEN
    MSJ_ERROR:=SQLERRM ;
    DBMS_OUTPUT.PUT_LINE(MSJ_ERROR);
    RESULTADO_OUT :=-1; --Error
END;
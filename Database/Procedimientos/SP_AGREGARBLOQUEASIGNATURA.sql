CREATE OR REPLACE PROCEDURE SP_AGREGARBLOQUEASIGNATURA(ID_ASIGNATURA_IN IN NUMBER, ID_BLOQUEHORARIO_IN IN NUMBER)
IS
    SQL_ERRORCODE INT;
    SQL_ERRORMESSAGE VARCHAR(1500);
BEGIN
    INSERT INTO BLOQUE_ASIGNATURA (ID_HORARIO, ID_ASIGNATURA, ID_BLOQUEHORARIO) 
                VALUES( (SELECT NVL(MAX(ID_HORARIO), 0) +1 FROM BLOQUE_ASIGNATURA), ID_ASIGNATURA_IN, ID_BLOQUEHORARIO_IN );
EXCEPTION WHEN OTHERS THEN
    SQL_ERRORMESSAGE:=SQLERRM;
    SQL_ERRORCODE:= SQLCODE;

    INSERT INTO ERROR(ID_ERROR, PROCESO, COD_ERROR, MENSAJE_ERROR, FECHA) VALUES
                    ((SELECT NVL(MAX(ID_ERROR), 0)+1 FROM ERROR), 'SP_AGREGARBLOQUEASIGNATURA',SQL_ERRORCODE,SQL_ERRORMESSAGE, CURRENT_TIMESTAMP );
    COMMIT;
END;
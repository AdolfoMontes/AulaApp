
CREATE OR REPLACE PROCEDURE SP_GUARDAROBSERVACION(TIPO_IN IN VARCHAR, DESCRIPCION_IN IN VARCHAR, USUARIO_IN IN VARCHAR, RUN_IN IN NUMBER, ID_CURSO_IN IN NUMBER, RESULTADO_OUT OUT NUMBER)
IS 

    SQL_ERRORCODE INT;
    SQL_ERRORMESSAGE VARCHAR(1500);
BEGIN 
   INSERT INTO OBSERVACION (ID_OBS, TIPO, DESC_OBS, FECHA_INS, USR_CREACION, RUN, ID_CURSO) 
                        VALUES((SELECT NVL(MAX(ID_OBS), 0 )+1 FROM OBSERVACION), TIPO_IN, DESCRIPCION_IN, CURRENT_TIMESTAMP, USUARIO_IN, RUN_IN, ID_CURSO_IN);
                        COMMIT;
    RESULTADO_OUT:= 0;
EXCEPTION WHEN OTHERS THEN
    SQL_ERRORMESSAGE:=SQLERRM;
    SQL_ERRORCODE:= SQLCODE;
    RESULTADO_OUT:=-1;
    INSERT INTO ERROR(ID_ERROR, PROCESO, COD_ERROR, MENSAJE_ERROR, FECHA) VALUES
                    ((SELECT NVL(MAX(ID_ERROR), 0)+1 FROM ERROR), 'SP_GUARDAROBSERVACION',SQL_ERRORCODE,SQL_ERRORMESSAGE, CURRENT_TIMESTAMP );
    COMMIT;

END;

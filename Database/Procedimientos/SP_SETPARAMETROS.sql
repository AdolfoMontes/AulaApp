CREATE OR REPLACE PROCEDURE SP_SETPARAMETROS(PARAMETRO_IN IN NUMBER, VALOR_IN IN NUMBER, RESULTADO_OUT OUT NUMBER)
IS
    SQL_ERRORCODE INT;
    SQL_ERRORMESSAGE VARCHAR(1500);
    GET_PARAM NUMBER;
BEGIN
    GET_PARAM:= F_GETPARAMETRO(PARAMETRO_IN);
    IF GET_PARAM = -2 THEN
        INSERT INTO PARAMS (ID_PARAM, DESCRIPCION, VALOR) VALUES (( SELECT NVL(MAX(ID_PARAM), 0)+1 FROM PARAMS), 'Nota minima de aprobacion', VALOR_IN);
        COMMIT;
        RESULTADO_OUT:=0; --VALOR NO EXISTE, LO CREO
    ELSIF GET_PARAM >=0 THEN
        UPDATE PARAMS SET VALOR = VALOR_IN WHERE ID_PARAM =1;
        RESULTADO_OUT:=1; --VALOR EXISTE, UPDATEO
    END IF;
EXCEPTION WHEN OTHERS THEN
    SQL_ERRORMESSAGE:=SQLERRM;
    SQL_ERRORCODE:= SQLCODE;
    RESULTADO_OUT:=-1;
    INSERT INTO ERROR(ID_ERROR, PROCESO, COD_ERROR, MENSAJE_ERROR, FECHA) VALUES
                    ((SELECT NVL(MAX(ID_ERROR), 0)+1 FROM ERROR), 'SP_SETPARAMETROS',SQL_ERRORCODE,SQL_ERRORMESSAGE, CURRENT_TIMESTAMP );
    COMMIT;
END;
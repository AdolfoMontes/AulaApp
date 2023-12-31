CREATE OR REPLACE PROCEDURE SP_XXXXX()
IS
    SQL_ERRORCODE INT;
    SQL_ERRORMESSAGE VARCHAR(1500);
BEGIN
   
EXCEPTION WHEN OTHERS THEN
    SQL_ERRORMESSAGE:=SQLERRM;
    SQL_ERRORCODE:= SQLCODE;

    INSERT INTO ERROR(ID_ERROR, PROCESO, COD_ERROR, MENSAJE_ERROR, FECHA) VALUES
                    ((SELECT NVL(MAX(ID_ERROR), 0)+1 FROM ERROR), 'SP_XXXXX',SQL_ERRORCODE,SQL_ERRORMESSAGE, CURRENT_TIMESTAMP );
    COMMIT;
END;
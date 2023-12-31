CREATE OR REPLACE FUNCTION F_VALIDAR_APODERADO(RUN_IN NUMBER) RETURN NUMBER
IS
/*ZONA DECLARATIVA DE VARIABLES*/
RUN_VAR VARCHAR2(50);
RES_VAR NUMBER;
BEGIN
    /*CUERPO DE LA FUNCION*/
    SELECT RUN INTO RUN_VAR FROM APODERADO WHERE RUN=RUN_IN ;
    IF RUN_VAR IS NULL THEN
        RES_VAR:= 0;
    ELSE 
        RES_VAR:=1;
    END IF;
    RETURN RES_VAR;
EXCEPTION
WHEN NO_DATA_FOUND THEN
    RES_VAR:=0;
    RETURN RES_VAR;
WHEN OTHERS THEN
    RES_VAR:= 1;
    RETURN RES_VAR; 
    
END;

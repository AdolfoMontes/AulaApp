--EJECUTAR PROCEDIMIENTO
SET SERVEROUTPUT ON;
DECLARE
    RESULTADO_VAR NUMBER;
BEGIN
    SP_INSERTAR_USUARIO(18530636, '4','ADOLFO', NULL, 'MONTES', NULL, 'A', TO_DATE('20220101','YYYY-MM-DD'), 1, 'M', NULL, NULL, NULL, 5, 'CALLE FALSA 123', RESULTADO_VAR);
    DBMS_OUTPUT.PUT_LINE('RESULTADO ->' || RESULTADO_VAR);       
END;

--EJECUTAR FUNCION
SET SERVEROUTPUT ON;
DECLARE
BEGIN
    DBMS_OUTPUT.PUT_LINE('EXISTE->'||F_VALIDAR_RUN(18530636));
END;
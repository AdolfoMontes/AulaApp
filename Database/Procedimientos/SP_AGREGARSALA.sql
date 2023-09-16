CREATE OR REPLACE PROCEDURE SP_AGREGARSALA(COD_SALA_IN IN VARCHAR, PISO_IN IN VARCHAR, RESULTADO_OUT OUT NUMBER)
IS
    VALIDADOR_SALA VARCHAR2(20);
BEGIN
    SELECT COD_SALA INTO VALIDADOR_SALA FROM SALA WHERE COD_SALA = COD_SALA_IN AND ESTADO = 'A';
    IF VALIDADOR_SALA IS NULL THEN 
        INSERT INTO SALA(ID_SALA, COD_SALA, PISO, ESTADO) VALUES((SELECT NVL(MAX(ID_SALA), 0) + 1 FROM SALA), COD_SALA_IN, PISO_IN, 'A');
        COMMIT;
        RESULTADO_OUT:= 0;
    ELSE
        RESULTADO_OUT:= -2; --REGISTRO EXISTE
    END IF;
EXCEPTION 
WHEN NO_DATA_FOUND THEN
        INSERT INTO SALA(ID_SALA, COD_SALA, PISO, ESTADO) VALUES((SELECT NVL(MAX(ID_SALA), 0) + 1 FROM SALA), COD_SALA_IN, PISO_IN, 'A');
        COMMIT;
    RESULTADO_OUT:= 0;
WHEN OTHERS THEN
    ROLLBACK;
    RESULTADO_OUT:=-1;--ERROR NO CONTROLADO
END;
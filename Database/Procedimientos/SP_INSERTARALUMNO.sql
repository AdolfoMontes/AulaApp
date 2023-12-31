CREATE OR REPLACE PROCEDURE SP_INSERTARALUMNO(RUN_IN NUMBER, DV_IN CHAR, PRI_NOM_IN VARCHAR, SEG_NOM_IN VARCHAR, PRI_AP_IN VARCHAR, SEG_AP_IN VARCHAR, ESTADO_IN CHAR,
                                                FEC_NAC_IN DATE,  ID_SEXO_IN CHAR, ID_PUEBLO_IN INT, ID_CURSO_IN INT, COMUNA_IN INT, DESCRIPCION_IN VARCHAR,
                                                DISCAPACIDAD_IN IN VARCHAR2, ANIO_IN IN NUMBER, USR_CREACION_IN IN VARCHAR2, RESULTADO_OUT OUT NUMBER)
IS 
    VALIDADOR_RUN NUMBER;
    RESULTADO_INS_DISCAP NUMBER;
    --RESULTADO_INS_MATRICULA NUMBER;
    VAR_ROL NUMBER;
BEGIN
    VALIDADOR_RUN:=F_VALIDAR_RUN(RUN_IN);
    IF VALIDADOR_RUN = 0 THEN --RUN NO ESTA REGISTRADO, LO REGISTRAMOS
        IF DISCAPACIDAD_IN IS NOT NULL THEN
            SP_INSERTARDISCAPACIDAD(DISCAPACIDAD_IN,RESULTADO_INS_DISCAP);
        END IF;
        --SP_INSERTARMATRICULA(RUN_IN, ANIO_IN,USR_CREACION_IN, ID_CURSO_IN, RESULTADO_INS_MATRICULA);
        SP_INSERTAR_USUARIO(RUN_IN, DV_IN, PRI_NOM_IN, SEG_NOM_IN,PRI_AP_IN, SEG_AP_IN, ESTADO_IN, FEC_NAC_IN, 
                            5 , ID_SEXO_IN, ID_PUEBLO_IN, 0 , RESULTADO_INS_DISCAP, COMUNA_IN, DESCRIPCION_IN,
                            NULL, NULL, NULL,RESULTADO_OUT); 
        DBMS_OUTPUT.PUT_LINE(RESULTADO_OUT);
        COMMIT; 
    ELSE    
        RESULTADO_OUT:=-1;--RUT REGISTRADO
    END IF;

END;
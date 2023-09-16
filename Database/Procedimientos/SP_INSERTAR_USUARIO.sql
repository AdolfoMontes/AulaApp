CREATE OR REPLACE PROCEDURE SP_INSERTAR_USUARIO(RUN_IN INT, DV_IN CHAR, PRI_NOM_IN VARCHAR, SEG_NOM_IN VARCHAR, PRI_AP_IN VARCHAR, SEG_AP_IN VARCHAR, ESTADO_IN CHAR,
                                                FEC_NAC_IN DATE, ID_ROL_IN INT, ID_SEXO_IN CHAR, ID_PUEBLO_IN INT, ID_CURSO_IN INT, ID_DISCAPACIDAD_IN INT, COMUNA_IN INT, DESCRIPCION_IN VARCHAR,
                                                COD_USUARIO_IN VARCHAR, MAIL_IN VARCHAR, PASSWORD_IN VARCHAR, RESULTADO_OUT OUT NUMBER)  
IS
/*V 1.0 CAMILO OSORIO
V2.0 ADOLFO MONTES - AGREGA VALIDADOR DE USUARIO Y LOGICA PARA INSERCION DE ALUMNOS*/
   RES_VAR NUMBER;
   RUN_VAR NUMBER;
   USER_VAR NUMBER;
BEGIN
    /*CUERPO DE LA FUNCION*/
    RUN_VAR:=0;
    RUN_VAR:= F_VALIDAR_RUN(RUN_IN);
    USER_VAR:=0;
    IF COD_USUARIO_IN IS NOT NULL THEN
        USER_VAR:= F_VALIDAR_USUARIO(COD_USUARIO_IN);
    END IF;
    IF RUN_VAR=0 AND USER_VAR=0 THEN
        INSERT INTO DIRECCION(ID_DIRECCION, DESCRIPCION, ID_COMUNA)VALUES((SELECT NVL((MAX (ID_DIRECCION)),0)+1 FROM DIRECCION), DESCRIPCION_IN, COMUNA_IN );
        COMMIT;
         INSERT INTO PERSONA (
                    RUN,
                    DV,
                    PRI_NOM,
                    SEG_NOM,
                    PRI_AP,
                    SEG_AP,
                    ESTADO,
                    FEC_NAC,
                    ID_ROL,
                    ID_SEXO,
                    ID_PUEBLO,
                    ID_DIRECCION,
                    ID_CURSO,
                    ID_DISCAPACIDAD) 
                VALUES (RUN_IN,
                    DV_IN, 
                    PRI_NOM_IN, 
                    SEG_NOM_IN, 
                    PRI_AP_IN, 
                    SEG_AP_IN, 
                    ESTADO_IN,
                    FEC_NAC_IN,
                    ID_ROL_IN,
                    ID_SEXO_IN,
                    REPLACE(ID_PUEBLO_IN, 0, null),
                    (SELECT MAX (ID_DIRECCION) FROM DIRECCION),
                    REPLACE(ID_CURSO_IN,0,null),
                    REPLACE(ID_DISCAPACIDAD_IN,0,null));
                    IF ID_ROL_IN <>5 THEN
                        SP_GUARDAR_CREDENCIALES(RUN_IN, COD_USUARIO_IN, MAIL_IN, PASSWORD_IN); --SI EL CURSO TIENE DATA, ENTONCES NO SE INSERTAN CREDENCIALES
                                                                                                --POR QUE SERIA UN ALUMNO Y ELLOS NO LOGUEAN
                    END IF;
                    COMMIT;
                RESULTADO_OUT:=0;
    ELSE
        IF USER_VAR = 1 THEN
            RESULTADO_OUT:=2; --Resultado 2: Usuario existe 
        ELSIF RUN_VAR = 1 THEN
            RESULTADO_OUT:=1; -- Resultado 1: Run existe
        ELSE 
            RESULTADO_OUT:=3; --Resultado 3: Error no definido
        END IF;
    END IF;     
END;
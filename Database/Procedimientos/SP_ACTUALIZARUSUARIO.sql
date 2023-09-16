CREATE OR REPLACE PROCEDURE SP_ACTUALIZARUSUARIO(RUN_IN INT, PRI_NOM_IN VARCHAR, SEG_NOM_IN VARCHAR, PRI_AP_IN VARCHAR, SEG_AP_IN VARCHAR,
                                                FEC_NAC_IN DATE, ID_ROL_IN INT, ID_SEXO_IN CHAR, ID_PUEBLO_IN INT, COMUNA_IN INT, DESCRIPCION_IN VARCHAR,
                                                MAIL_IN VARCHAR, RESULTADO_OUT OUT NUMBER)  
IS

--V1.0 Adolfo Montes
BEGIN
    /*CUERPO DE LA FUNCION*/
    UPDATE USUARIO SET MAIL = MAIL_IN WHERE RUN = RUN_IN;
    UPDATE DIRECCION SET ID_COMUNA=COMUNA_IN, DESCRIPCION = DESCRIPCION_IN WHERE ID_DIRECCION = (SELECT ID_DIRECCION FROM PERSONA WHERE RUN= RUN_IN);
    UPDATE PERSONA SET PRI_NOM= PRI_NOM_IN, SEG_NOM=SEG_NOM_IN, PRI_AP = PRI_AP_IN, SEG_AP = SEG_AP_IN,
                    FEC_NAC = FEC_NAC_IN, ID_ROL=REPLACE(ID_ROL_IN, 0, null), ID_SEXO = ID_SEXO_IN, ID_PUEBLO = REPLACE(ID_PUEBLO_IN,0, null) 
                    WHERE RUN = RUN_IN;
    COMMIT;
    RESULTADO_OUT:=0;
    
EXCEPTION 
WHEN OTHERS THEN
    RESULTADO_OUT:=-1;
    ROLLBACK;
END;
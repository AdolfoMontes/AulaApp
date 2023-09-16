

CREATE OR REPLACE FUNCTION F_CONTARNOTASS1(RUN_IN NUMBER, ID_ASIGNATURA_IN NUMBER) RETURN INT
IS
    NOTA_VAR INT;
BEGIN
    select count(nota) INTO NOTA_VAR 
    from (select run, anio, id_asignatura, n, nota from NOTA
    unpivot ( 
      NOTA for n in ( N1, N2, N3, N4,N5,N6,N7,N8,N9,N10)
    ))b where NVL(nota, 0) <>0 and  id_asignatura = ID_ASIGNATURA_IN and run = RUN_IN;
    RETURN NOTA_VAR;
EXCEPTION WHEN NO_DATA_FOUND THEN
    RETURN 0;
END;
/

CREATE OR REPLACE FUNCTION F_CONTARNOTASS2(RUN_IN NUMBER, ID_ASIGNATURA_IN NUMBER) RETURN INT
IS
    NOTA_VAR INT;
BEGIN
    select count(nota) INTO NOTA_VAR 
    from (select run, anio, id_asignatura, n, nota from NOTA
    unpivot ( 
      NOTA for n in (N11, N12, N13, N14, N15, N16, N17, N18, N19, N20)
    ))b where NVL(nota, 0) <>0 and  id_asignatura = ID_ASIGNATURA_IN and run = RUN_IN;
    RETURN NOTA_VAR;
EXCEPTION WHEN NO_DATA_FOUND THEN
    RETURN 0;
END;

/

CREATE OR REPLACE FUNCTION F_SUMARNOTASS1(RUN_IN NUMBER, ID_ASIGNATURA_IN NUMBER) RETURN INT
IS
    CANTIDAD_VAR INT;
BEGIN
    Select sum(nota) into CANTIDAD_VAR
    from(select run, anio, id_asignatura, n, nota from NOTA
    unpivot ( 
      NOTA for n in ( N1, N2, N3, N4, N5, N6, N7, N8, N9, N10)
    )) x where id_asignatura = ID_ASIGNATURA_IN and run = RUN_IN;
    RETURN CANTIDAD_VAR;
EXCEPTION WHEN NO_DATA_FOUND THEN
    RETURN 1;
END;
/
CREATE OR REPLACE FUNCTION F_SUMARNOTASS2(RUN_IN NUMBER, ID_ASIGNATURA_IN NUMBER) RETURN INT
IS
    CANTIDAD_VAR INT;
BEGIN
    Select sum(nota) into CANTIDAD_VAR
    from(select run, anio, id_asignatura, n, nota from NOTA
    unpivot ( 
      NOTA for n in (N11, N12, N13, N14, N15, N16, N17, N18, N19, N20 )
    )) x where id_asignatura = ID_ASIGNATURA_IN and run = RUN_IN;
    RETURN CANTIDAD_VAR;
EXCEPTION WHEN NO_DATA_FOUND THEN
    RETURN 1;
END;
/

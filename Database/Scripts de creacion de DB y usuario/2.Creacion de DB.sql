


CREATE TABLE APODERADO
  (
    run            NUMBER (10) NOT NULL ,
    dv             CHAR (1) NOT NULL ,
    pri_nom        VARCHAR2 (30) NOT NULL ,
    seg_nom        VARCHAR2 (30) ,
    pri_ap         VARCHAR2 (30) NOT NULL ,
    seg_ap         VARCHAR2 (30)  NULL ,
    fec_nac        DATE NOT NULL ,
    telefono       VARCHAR2 (20) NOT NULL ,
    mail           VARCHAR2 (100) NOT NULL ,
    estado         CHAR (1) NOT NULL ,
    id_nivel       INTEGER NOT NULL ,
    id_estadocivil INTEGER NOT NULL ,
    id_direccion   INTEGER NOT NULL ,
    id_ocupacion   INTEGER NOT NULL ,
    id_parentesco  INTEGER,
    id_comuna      INTEGER
  ) ;

ALTER TABLE APODERADO ADD CONSTRAINT APODERADO_PK PRIMARY KEY ( run ) ;


CREATE TABLE ASIGNATURA
  (
    id_asignatura  INTEGER NOT NULL ,
    nom_asignatura VARCHAR2 (100) NOT NULL ,
    cod_asignatura VARCHAR2 (15) NOT NULL ,
    anio           NUMBER (5) NOT NULL ,
    estado         CHAR (1) NOT NULL ,
    usr_creacion   VARCHAR2 (20) NOT NULL ,
    fecha_creacion DATE NOT NULL ,
    calculo        NUMBER (1) NOT NULL ,
    id_curso       INTEGER NOT NULL ,
    id_sala        INTEGER NOT NULL,
    doc_asignado   INTEGER NULL
  ) ;
ALTER TABLE ASIGNATURA ADD CONSTRAINT ASIGNATURA_PK PRIMARY KEY ( id_asignatura ) ;


CREATE TABLE ASISTENCIA
  (
    id_asistencia    INTEGER NOT NULL ,
    fecha_creacion   DATE NOT NULL ,
    fecha_asistencia DATE NOT NULL ,
    estado           CHAR (1) NOT NULL ,
    usr_creacion     VARCHAR2 (20) NOT NULL ,
    run              NUMBER (10) NOT NULL ,
    id_curso         INTEGER NOT NULL
  ) ;
ALTER TABLE ASISTENCIA ADD CONSTRAINT ASISTENCIA_PK PRIMARY KEY ( id_asistencia ) ;


CREATE TABLE BLOQUE
  (
    id_horario   INTEGER NOT NULL ,
    hora_ini     VARCHAR2 (5) NOT NULL ,
    hora_ter     VARCHAR2 (5) NOT NULL ,
    dia_semana   NUMBER (1) NOT NULL ,
    usr_creacion VARCHAR2 (20) NOT NULL ,
    fecha_cre    DATE ,
    estado       CHAR (1) NOT NULL
  ) ;
ALTER TABLE BLOQUE ADD CONSTRAINT BLOQUE_PK PRIMARY KEY ( id_horario ) ;





CREATE TABLE COMUNA
  (
    id_comuna  INTEGER NOT NULL ,
    nom_comuna VARCHAR2 (100) NOT NULL ,
    id_region  INTEGER NOT NULL
  ) ;
ALTER TABLE COMUNA ADD CONSTRAINT COMUNA_PK PRIMARY KEY ( id_comuna ) ;


CREATE TABLE CURSO
  (
    id_curso     INTEGER NOT NULL ,
    cod_curso    VARCHAR2 (15) NOT NULL ,
    nom_curso    VARCHAR2 (50) NOT NULL ,
    cantidad_max NUMBER (4) NOT NULL ,
    id_nivel     INTEGER NOT NULL ,
    anio         NUMBER (4) NOT NULL,
    id_docente   INTEGER NULL,
    estado       CHAR(1) NOT NULL
  ) ;
ALTER TABLE CURSO ADD CONSTRAINT CURSO_PK PRIMARY KEY ( id_curso ) ;


CREATE TABLE DIRECCION
  (
    id_direccion INTEGER NOT NULL ,
    descripcion  VARCHAR2 (150) NOT NULL ,
    id_comuna    INTEGER NOT NULL
  ) ;
ALTER TABLE DIRECCION ADD CONSTRAINT DIRECCION_PK PRIMARY KEY ( id_direccion ) ;

CREATE TABLE GESTION_OTP
   (  "ID_GESTION" NUMBER(*,0) NOT NULL ENABLE, 
  "MAIL" VARCHAR2(150 BYTE) NOT NULL ENABLE, 
  "RUN" NUMBER(10,0) NOT NULL ENABLE, 
  "HORA_ENVIO" TIMESTAMP (6) NOT NULL ENABLE, 
  "USADO" NUMBER(1,0) NOT NULL ENABLE, 
  "HORA_USO" TIMESTAMP (6), 
  "ESTADO" CHAR(1 BYTE) NOT NULL ENABLE, 
  "CODIGO_OTP" VARCHAR2(150 BYTE), 
   CONSTRAINT "GESTION_OTP_PK" PRIMARY KEY ("ID_GESTION")
   );



CREATE TABLE DISCAPACIDAD
  (
    id_discapacidad  INTEGER NOT NULL ,
    nom_discapacidad VARCHAR2 (100) NOT NULL
  ) ;
ALTER TABLE DISCAPACIDAD ADD CONSTRAINT DISCAPACIDAD_PK PRIMARY KEY ( id_discapacidad ) ;


CREATE TABLE ESTADO_CIVIL
  (
    id_estadocivil INTEGER NOT NULL ,
    nom_estado     VARCHAR2 (50) NOT NULL
  ) ;
ALTER TABLE ESTADO_CIVIL ADD CONSTRAINT ESTADO_CIVIL_PK PRIMARY KEY ( id_estadocivil ) ;


CREATE TABLE INSTITUCION
  (
    cod_institucion INTEGER NOT NULL ,
    nom_institucion VARCHAR2 (100) NOT NULL ,
    rut             VARCHAR2 (15) NOT NULL ,
    tipo_estab      VARCHAR2 (30) NOT NULL,
    logo            BLOB NULL
  ) ;
ALTER TABLE INSTITUCION ADD CONSTRAINT INSTITUCION_PK PRIMARY KEY ( cod_institucion ) ;


CREATE TABLE LECCIONARIO
  (
    id_leccion     INTEGER NOT NULL ,
    descripcion    VARCHAR2 (255) NOT NULL ,
    fecha          DATE NOT NULL ,
    fecha_creacion TIMESTAMP(6) NOT NULL ,
    usuario_cre    VARCHAR2 (20) NOT NULL ,
    id_asignatura  INTEGER,
    firma          VARCHAR2(100 BYTE), 
    fecha_mod      TIMESTAMP (6), 
    usuario_mod    VARCHAR2(100 BYTE),
    fecha_firma    TIMESTAMP (6)
  );
  
ALTER TABLE LECCIONARIO ADD CONSTRAINT LECCIONARIO_PK PRIMARY KEY ( id_leccion ) ;


CREATE TABLE MATRICULA
  (
    num_matricula   INTEGER NOT NULL ,
    anio            NUMBER (4) NOT NULL ,
    fec_matricula   DATE NOT NULL ,
    estado          CHAR (1) NOT NULL ,
    usr_creacion    VARCHAR2 (20) NOT NULL ,
    usr_eliminacion VARCHAR2 (20) ,
    fec_eliminacion DATE,
    nivel           NUMBER(10) NULL
  ) ;
ALTER TABLE MATRICULA ADD CONSTRAINT MATRICULA_PK PRIMARY KEY ( num_matricula ) ;


CREATE TABLE NIVEL_EDUCACION
  (
    id_nivel    INTEGER NOT NULL ,
    descripcion VARCHAR2 (30) NOT NULL
  ) ;
ALTER TABLE NIVEL_EDUCACION ADD CONSTRAINT NIVEL_EDUCACION_PK PRIMARY KEY ( id_nivel ) ;



 CREATE TABLE "AULAAPP"."ERROR" 
   (  
    "ID_ERROR" NUMBER(*,0) NOT NULL ENABLE, 
    "PROCESO" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
    "COD_ERROR" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
    "MENSAJE_ERROR" VARCHAR2(1500 BYTE) NOT NULL ENABLE, 
    "FECHA" TIMESTAMP (6) NOT NULL ENABLE, 
     CONSTRAINT "ERROR_PK" PRIMARY KEY ("ID_ERROR")
   );



CREATE TABLE OBSERVACION
  (
    id_obs       INTEGER NOT NULL ,
    tipo         CHAR (1) NOT NULL ,
    desc_obs     VARCHAR2 (255) NOT NULL ,
    fecha_ins    DATE NOT NULL ,
    usr_creacion VARCHAR2 (20) NOT NULL ,
    run          NUMBER (10) NOT NULL,
    ID_CURSO     INTEGER NOT NULL 
  ) ;
ALTER TABLE OBSERVACION ADD CONSTRAINT OBSERVACION_PK PRIMARY KEY ( id_obs ) ;


CREATE TABLE OCUPACION
  (
    id_ocupacion INTEGER NOT NULL ,
    descripcion  VARCHAR2 (150) NOT NULL
  ) ;
ALTER TABLE OCUPACION ADD CONSTRAINT OCUPACION_PK PRIMARY KEY ( id_ocupacion ) ;


CREATE TABLE PARENTESCO
  (
    id_parentesco  INTEGER NOT NULL ,
    nom_parentesco VARCHAR2 (30) NOT NULL
  ) ;
ALTER TABLE PARENTESCO ADD CONSTRAINT PARENTESCO_PK PRIMARY KEY ( id_parentesco ) ;


CREATE TABLE PERSONA
  (
    run             NUMBER (10) NOT NULL ,
    dv              CHAR (1) NOT NULL ,
    pri_nom         VARCHAR2 (30) NOT NULL ,
    seg_nom         VARCHAR2 (30) ,
    pri_ap          VARCHAR2 (30) NOT NULL ,
    seg_ap          VARCHAR2 (30) ,
    estado          CHAR (1) NOT NULL ,
    fec_nac         DATE NOT NULL ,
    id_rol          INTEGER ,
    id_sexo         CHAR (1) NOT NULL ,
    num_matricula   INTEGER ,
    id_pueblo       INTEGER ,
    id_direccion    INTEGER NOT NULL ,
    id_curso        INTEGER NULL ,
    id_discapacidad INTEGER
  ) ;

CREATE UNIQUE INDEX PERSONA__IDXv1 ON PERSONA
  (
    num_matricula ASC
  )
  ;
ALTER TABLE PERSONA ADD CONSTRAINT PERSONA_PK PRIMARY KEY ( run ) ;


CREATE TABLE PERSONA_APODERADO
  (
    run           NUMBER (10) NOT NULL ,
    run_apoderado NUMBER (10) NOT NULL
  ) ;
ALTER TABLE PERSONA_APODERADO ADD CONSTRAINT PERSONA_APODERADO_PK PRIMARY KEY ( run ) ;


CREATE TABLE PERSONA_ASIGNATURA
  (
    run           NUMBER (10) NOT NULL ,
    id_asignatura INTEGER NOT NULL
  ) ;


CREATE TABLE PORCENTAJE
  (
    porcentaje    NUMBER (3) NOT NULL ,
    num_nota      NUMBER (3) NOT NULL ,
    id_asignatura INTEGER
  ) ;


CREATE TABLE PUEBLO_ORIGINARIO
  (
    id_pueblo  INTEGER NOT NULL ,
    nom_pueblo VARCHAR2 (150) NOT NULL
  ) ;
ALTER TABLE PUEBLO_ORIGINARIO ADD CONSTRAINT PUEBLO_ORIGINARIO_PK PRIMARY KEY ( id_pueblo ) ;


CREATE TABLE REGION
  (
    id_region  INTEGER NOT NULL ,
    nom_region VARCHAR2 (150) NOT NULL
  ) ;
ALTER TABLE REGION ADD CONSTRAINT REGION_PK PRIMARY KEY ( id_region ) ;


CREATE TABLE ROL
  (
    id_rol      INTEGER NOT NULL ,
    descripcion VARCHAR2 (30) NOT NULL
  ) ;
ALTER TABLE ROL ADD CONSTRAINT ROL_PK PRIMARY KEY ( id_rol ) ;


CREATE TABLE SALA
  (
    id_sala  INTEGER NOT NULL ,
    cod_sala VARCHAR2 (20) NOT NULL ,
    piso     VARCHAR2 (10) NOT NULL ,
    estado   CHAR (1) NOT NULL
  ) ;
ALTER TABLE SALA ADD CONSTRAINT SALA_PK PRIMARY KEY ( id_sala ) ;


CREATE TABLE SEXO
  (
    id_sexo     CHAR (1) NOT NULL ,
    descripcion VARCHAR2 (30) NOT NULL
  ) ;
ALTER TABLE SEXO ADD CONSTRAINT SEXO_PK PRIMARY KEY ( id_sexo ) ;


CREATE TABLE USUARIO
  (
    run         NUMBER (10) NOT NULL ,
    cod_usuario VARCHAR2 (20) NOT NULL ,
    mail        VARCHAR2 (100) NOT NULL ,
    password    VARCHAR2 (100) NOT NULL ,
    estado      CHAR (1) NOT NULL,
    foto        BLOB null
  ) ;

ALTER TABLE USUARIO ADD CONSTRAINT USUARIO_PK PRIMARY KEY ( run ) ;

CREATE TABLE BLOQUE_ASIGNATURA
  (
    id_horario       INTEGER NOT NULL ,
    id_asignatura    INTEGER NOT NULL ,
    id_bloquehorario INTEGER NOT NULL
  ) ;
ALTER TABLE BLOQUE_ASIGNATURA ADD CONSTRAINT BLOQUE_ASIGNATURA_PK PRIMARY KEY ( id_horario ) ;


  CREATE TABLE PARAMS
   (  ID_PARAM NUMBER(38,0) NOT NULL ENABLE, 
      DESCRIPCION VARCHAR2(1000 BYTE) NOT NULL ENABLE, 
      VALOR NUMBER(9,4) NOT NULL ENABLE
     ) ;

CREATE TABLE NOTA
  (
    id_nota       INTEGER NOT NULL ,
    run           NUMBER (10) ,
    id_asignatura INTEGER ,
    anio          NUMBER (4) NOT NULL ,
    n1 decimal (9,4) ,
    n2 decimal (9,4) ,
    n3 decimal (9,4) ,
    n4 decimal (9,4) ,
    n5 decimal (9,4) ,
    n6 decimal (9,4) ,
    n7 decimal (9,4) ,
    n8 decimal (9,4) ,
    n9 decimal (9,4) ,
    n10 decimal (9,4) ,
    n11 decimal (9,4) ,
    n12 decimal (9,4) ,
    n13 decimal (9,4) ,
    n14 decimal (9,4) ,
    n15 decimal (9,4) ,
    n16 decimal (9,4),
    n17 decimal (9,4) ,
    n18 decimal (9,4) ,
    n19 decimal (9,4) ,
    n20 decimal (9,4) ,
    p1 decimal (9,4) ,
    p2 decimal (9,4) ,
    pf decimal (9,4) ,
    estado CHAR (1) NOT NULL
  ) ;
ALTER TABLE NOTA ADD CONSTRAINT NOTA_PKv2 PRIMARY KEY ( id_nota ) ;


CREATE TABLE CIERRE
  (
    id_cierre INTEGER NOT NULL ,
    run       NUMBER (10) NOT NULL ,
    anio      NUMBER (4) NOT NULL ,
    p1 decimal (9,4) ,
    p2 decimal (9,4) ,
    pf decimal (9,4) ,
    estado CHAR (1) NOT NULL ,
    curso  VARCHAR2 (50) NOT NULL
  ) ;
ALTER TABLE CIERRE ADD CONSTRAINT CIERRE_PK PRIMARY KEY ( id_cierre ) ;


CREATE SEQUENCE CIERRE_id_cierre_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER CIERRE_id_cierre_TRG BEFORE
  INSERT ON CIERRE FOR EACH ROW WHEN (NEW.id_cierre IS NULL) BEGIN :NEW.id_cierre := CIERRE_id_cierre_SEQ.NEXTVAL;
END;
/

create sequence sec_ingresoAsistencia
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
/

ALTER TABLE NOTA ADD CONSTRAINT NOTA_ASIGNATURA_FK FOREIGN KEY ( id_asignatura ) REFERENCES ASIGNATURA ( id_asignatura ) ;

ALTER TABLE NOTA ADD CONSTRAINT NOTA_PERSONA_FK FOREIGN KEY (
run
) REFERENCES PERSONA (
run
) ;


ALTER TABLE APODERADO ADD CONSTRAINT APODERADO_DIRECCION_FK FOREIGN KEY ( id_direccion ) REFERENCES DIRECCION ( id_direccion ) ;

ALTER TABLE APODERADO ADD CONSTRAINT APODERADO_ESTADO_CIVIL_FK FOREIGN KEY ( id_estadocivil ) REFERENCES ESTADO_CIVIL ( id_estadocivil ) ;

ALTER TABLE APODERADO ADD CONSTRAINT APODERADO_NIVEL_EDUCACION_FK FOREIGN KEY ( id_nivel ) REFERENCES NIVEL_EDUCACION ( id_nivel ) ;

ALTER TABLE APODERADO ADD CONSTRAINT APODERADO_OCUPACION_FK FOREIGN KEY ( id_ocupacion ) REFERENCES OCUPACION ( id_ocupacion ) ;

ALTER TABLE APODERADO ADD CONSTRAINT APODERADO_PARENTESCO_FK FOREIGN KEY ( id_parentesco ) REFERENCES PARENTESCO ( id_parentesco ) ;

ALTER TABLE ASIGNATURA ADD CONSTRAINT ASIGNATURA_CURSO_FK FOREIGN KEY ( id_curso ) REFERENCES CURSO ( id_curso ) ;

ALTER TABLE ASIGNATURA ADD CONSTRAINT ASIGNATURA_SALA_FK FOREIGN KEY ( id_sala ) REFERENCES SALA ( id_sala ) ;

ALTER TABLE ASISTENCIA ADD CONSTRAINT ASISTENCIA_CURSO_FK FOREIGN KEY ( id_curso ) REFERENCES CURSO ( id_curso ) ;

ALTER TABLE ASISTENCIA ADD CONSTRAINT ASISTENCIA_PERSONA_FK FOREIGN KEY (
run
) REFERENCES PERSONA (
run
) ;

ALTER TABLE COMUNA ADD CONSTRAINT COMUNA_REGION_FK FOREIGN KEY ( id_region ) REFERENCES REGION ( id_region ) ;

ALTER TABLE CURSO ADD CONSTRAINT CURSO_NIVEL_EDUCACION_FK FOREIGN KEY ( id_nivel ) REFERENCES NIVEL_EDUCACION ( id_nivel ) ;

ALTER TABLE DIRECCION ADD CONSTRAINT DIRECCION_COMUNA_FK FOREIGN KEY ( id_comuna ) REFERENCES COMUNA ( id_comuna ) ;

ALTER TABLE LECCIONARIO ADD CONSTRAINT LECCIONARIO_ASIGNATURA_FK FOREIGN KEY ( id_asignatura ) REFERENCES ASIGNATURA ( id_asignatura ) ;



ALTER TABLE OBSERVACION ADD CONSTRAINT OBSERVACION_PERSONA_FK FOREIGN KEY (
run
) REFERENCES PERSONA (
run
) ;

ALTER TABLE PERSONA_APODERADO ADD CONSTRAINT PERSONA_APODERADO_FK FOREIGN KEY ( run_apoderado ) REFERENCES APODERADO (
run
) ;

ALTER TABLE PERSONA_APODERADO ADD CONSTRAINT PERSONA_APODERADO_PERSONA_FK FOREIGN KEY (
run
) REFERENCES PERSONA (
run
) ;

ALTER TABLE BLOQUE_ASIGNATURA ADD CONSTRAINT BLOQUE_ASIGNATURA_FK FOREIGN KEY ( id_asignatura ) REFERENCES ASIGNATURA ( id_asignatura ) ;

ALTER TABLE BLOQUE_ASIGNATURA ADD CONSTRAINT BLOQUE_ASIGNATURA_BLOQUE_FK FOREIGN KEY ( id_bloquehorario ) REFERENCES BLOQUE ( id_horario );

ALTER TABLE PERSONA ADD CONSTRAINT PERSONA_CURSO_FK FOREIGN KEY ( id_curso ) REFERENCES CURSO ( id_curso ) ;

ALTER TABLE PERSONA ADD CONSTRAINT PERSONA_DIRECCION_FK FOREIGN KEY ( id_direccion ) REFERENCES DIRECCION ( id_direccion ) ;

ALTER TABLE PERSONA ADD CONSTRAINT PERSONA_DISCAPACIDAD_FK FOREIGN KEY ( id_discapacidad ) REFERENCES DISCAPACIDAD ( id_discapacidad ) ;

ALTER TABLE PERSONA ADD CONSTRAINT PERSONA_MATRICULA_FK FOREIGN KEY ( num_matricula ) REFERENCES MATRICULA ( num_matricula ) ;

ALTER TABLE PERSONA ADD CONSTRAINT PERSONA_PUEBLO_ORIGINARIO_FK FOREIGN KEY ( id_pueblo ) REFERENCES PUEBLO_ORIGINARIO ( id_pueblo ) ;

ALTER TABLE PERSONA ADD CONSTRAINT PERSONA_ROL_FK FOREIGN KEY ( id_rol ) REFERENCES ROL ( id_rol ) ;

ALTER TABLE PERSONA ADD CONSTRAINT PERSONA_SEXO_FK FOREIGN KEY ( id_sexo ) REFERENCES SEXO ( id_sexo ) ;

ALTER TABLE PERSONA_ASIGNATURA ADD CONSTRAINT PER_ASIG_ASIGNATURA_FK FOREIGN KEY ( id_asignatura ) REFERENCES ASIGNATURA ( id_asignatura ) ;

ALTER TABLE PERSONA_ASIGNATURA ADD CONSTRAINT PER_ASIG_PERSONA_FK FOREIGN KEY (
run
) REFERENCES PERSONA (
run
) ;

ALTER TABLE PORCENTAJE ADD CONSTRAINT PORCENTAJE_ASIGNATURA_FK FOREIGN KEY ( id_asignatura ) REFERENCES ASIGNATURA ( id_asignatura ) ;


/

CREATE OR REPLACE VIEW V_ALUMNOS 
AS
SELECT p.run||'-'||p.dv as runAlumno,
        p.pri_nom ||' ' ||p.seg_nom ||' '||p.pri_ap ||' '|| p.seg_ap as nombreAlumno,
        case when p.estado = 'A' then 'Activo'
        when p.estado = 'X' then 'Eliminado'
        when p.estado = 'R' then 'Retirado'
        when p.estado = 'E' then 'Expulsado'
        end as Estado,
        case
        when cur.cod_curso is null then ' '
        else 
            NVL(n3.descripcion||' ' ||cur.cod_curso, ' ')
        end as cursoactual,
        cur.anio,
        d.descripcion||', '||c.nom_comuna||', ' || reg.nom_region as Direccion,
        se.descripcion AS SEXO,
        NVL(dis.nom_discapacidad, ' ') as discapacidad,
        NVL(ne.descripcion, ' ') as NivelAlumno,
        TO_CHAR(p.fec_nac, 'DD/MM/YYYY') as FechaNacimiento,
        TO_number(TRUNC((SYSDATE - p.fec_nac)/ 365), '999') as edad,
        NVL(po.nom_pueblo, ' ') as pueblooriginario,
        apo.run||'-'||apo.dv as runApoderado,
        apo.pri_nom||' '||apo.seg_nom||' '|| apo.pri_ap||' '||apo.seg_ap as NombreApoderado,
        ocu.descripcion as OcupacionApoderado,
        par.nom_parentesco as ParentescoApoderado,
        dir.descripcion||', '||com2.nom_comuna||', ' || reg2.nom_region as DireccionApoderado,
        ned.descripcion as nivelApoderado,
        mat.num_matricula as numeromatricula,
        mat.fec_matricula as fechamatricula,
        mat.usr_creacion as usuariocreacion,
        nvl(mat.usr_eliminacion,' ') as usuarioeliminacion,
        apo.telefono,
        apo.mail,
        cur.id_curso,
        P.RUN,
        nvl(p.pri_nom,' ') as pri_nom,
        nvl(p.seg_nom,' ') as seg_nom,
        nvl(p.pri_ap, ' ') as pri_ap,
        nvl(p.seg_ap, ' ') as seg_ap,
        nvl(pp.pri_nom, ' ') || ' ' || nvl(pp.seg_nom, ' ') ||' ' || nvl(pp.pri_ap, ' ') || ' '|| nvl(pp.seg_ap, ' ') as profesorjefe
           FROM PERSONA P JOIN ROL R ON p.id_rol = r.id_rol
JOIN DIRECCION D ON P.ID_DIRECCION = d.id_direccion
JOIN COMUNA C ON D.ID_COMUNA = c.id_comuna
JOIN REGION REG ON C.ID_REGION = reg.id_region
JOIN PERSONA_APODERADO PA ON P.RUN = pa.run
JOIN APODERADO APO ON pa.run_apoderado = apo.run
JOIN DIRECCION DIR ON APO.ID_DIRECCION=DIR.ID_DIRECCION
JOIN COMUNA COM2 ON DIR.ID_COMUNA = COM2.ID_COMUNA
JOIN REGION REG2 ON COM2.ID_REGION = REG2.ID_REGION
LEFT JOIN pueblo_originario po on p.id_pueblo = po.id_pueblo
join ocupacion ocu on apo.id_ocupacion = ocu.id_ocupacion
join sexo se on p.id_sexo = se.id_sexo
join parentesco par on apo.id_parentesco = par.id_parentesco
join nivel_educacion ned on apo.id_nivel = ned.id_nivel
left join discapacidad dis on p.id_discapacidad = dis.id_discapacidad
left join matricula mat on p.num_matricula = mat.num_matricula
left join nivel_educacion ne on mat.nivel = ne.id_nivel
LEFT join curso cur on cur.id_curso = p.id_curso 
left join nivel_educacion n3 on cur.id_nivel = n3.id_nivel
left JOIN PERSONA PP ON PP.RUN = cur.id_docente
where r.descripcion = 'Alumno';
/

CREATE OR REPLACE VIEW V_ALUMNOSSINCURSO
AS
select p.run, p.dv, p.pri_nom, NVL(p.seg_nom, ' ') as seg_nom, p.pri_ap, NVL(p.seg_ap, ' ') as seg_ap, p.estado, m.anio, n.descripcion, m.fec_matricula, id_nivel
    from persona p 
    join matricula m on p.num_matricula = m.num_matricula
    join nivel_educacion n on m.nivel = n.id_nivel
where id_rol=5 and id_curso is null;

/

CREATE OR REPLACE VIEW V_ASIGNATURAS
AS
SELECT a.id_asignatura, a.nom_asignatura, a.cod_asignatura, a.anio,a.calculo,
  n.descripcion ||  ' ' || b.cod_curso as compuesto,
  n.descripcion as nivel,
  nvl(CAST(p.run as VARCHAR2(20)),' ') as doc_asignado,
  nvl(p.pri_nom,' ')||' '||nvl(p.seg_nom,' ') ||' ' || nvl(pri_ap, ' ')||' ' || nvl(seg_ap, ' ') as nombre_docente,
  d.cod_sala,
  a.estado
FROM ASIGNATURA a JOIN CURSO b on a.id_curso = b.id_curso 
join sala d  on a.id_sala = d.id_sala
join nivel_educacion n on b.id_nivel = n.id_nivel
left join persona p on a.doc_asignado = p.run;

/

CREATE OR REPLACE VIEW V_CURSOS
AS
SELECT C.ID_CURSO, C.COD_CURSO, C.NOM_CURSO, n.descripcion, C.ANIO, 
        case when
         p.run is null then ' '
         else 
         P.RUN ||'-' ||p.dv
         end AS RUN,
         P.PRI_NOM 
        ||' ' ||P.SEG_NOM||' '||P.PRI_AP||' '||P.SEG_AP AS NOMBREDOCENTE, C.CANTIDAD_MAX,
        (SELECT COUNT(RUN) FROM PERSONA PER WHERE PER.ID_CURSO=C.ID_CURSO AND PER.ESTADO = 'A') AS ALUMNOSACTUALES,
        c.estado,
        n.descripcion ||  ' ' || c.cod_curso as COMPUESTO,
        n.id_nivel
FROM CURSO C LEFT JOIN PERSONA P ON C.ID_DOCENTE = P.RUN
JOIN NIVEL_EDUCACION N ON n.id_nivel = c.id_nivel;

/


CREATE OR REPLACE VIEW V_PERSONAS
AS
SELECT
    p.run as SIN_DV,
    p.run as DV,
    p.run || '-' ||p.dv as RUN,
    p.pri_nom ||' '||
    p.seg_nom ||' '||
    p.pri_ap ||' '|| 
    p.seg_ap as Nombre_Completo,
    TO_CHAR(p.fec_nac, 'dd-MM-YYYY') as FEC_NAC,
    s.descripcion as Sexo,
    NVL(pb.nom_pueblo, ' ') as Pueblo,
    d.descripcion ||', '|| 
    c.nom_comuna ||', '|| 
    reg.nom_region as Direccion,
    u.mail,
    u.cod_usuario,
    r.descripcion as ROL,
    p.estado,
    u.password
FROM
    persona p
    left join rol r on p.id_rol=r.id_rol
    join sexo s on s.id_sexo = p.id_sexo
    left join pueblo_originario pb on p.id_pueblo = pb.id_pueblo
    join direccion d on p.id_direccion = d.id_direccion
    join comuna c on d.id_comuna = c.id_comuna
    join region reg on c.id_region=reg.id_region
    join usuario u on p.run = u.run
    where p.id_curso is null;
/




CREATE OR REPLACE VIEW V_ALUMNOSSINCURSO
AS
select p.run, p.dv, p.pri_nom, NVL(p.seg_nom, ' ') as seg_nom, p.pri_ap, NVL(p.seg_ap, ' ') as seg_ap, p.estado, m.anio, n.descripcion, m.fec_matricula, id_nivel
    from persona p 
    join matricula m on p.num_matricula = m.num_matricula
    join nivel_educacion n on m.nivel = n.id_nivel
where id_rol=5 and id_curso is null;

/

CREATE OR REPLACE VIEW V_ASIGNATURAS
AS
SELECT a.id_asignatura, a.nom_asignatura, a.cod_asignatura, a.anio,a.calculo,
  n.descripcion ||  ' ' || b.cod_curso as compuesto,
  n.descripcion as nivel,
   b.id_nivel as id_nivel,
  b.id_curso as id_curso,
  nvl(CAST(p.run as VARCHAR2(20)),' ') as doc_asignado,
  nvl(p.pri_nom,' ')||' '||nvl(p.seg_nom,' ') ||' ' || nvl(pri_ap, ' ')||' ' || nvl(seg_ap, ' ') as nombre_docente,
  d.cod_sala,
  a.estado
FROM ASIGNATURA a JOIN CURSO b on a.id_curso = b.id_curso 
join sala d  on a.id_sala = d.id_sala
join nivel_educacion n on b.id_nivel = n.id_nivel
left join persona p on a.doc_asignado = p.run;

/

CREATE OR REPLACE VIEW V_CURSOS
AS
SELECT C.ID_CURSO, C.COD_CURSO, C.NOM_CURSO, n.descripcion, C.ANIO, 
        case when
         p.run is null then ' '
         else 
         P.RUN ||'-' ||p.dv
         end AS RUN,
         P.PRI_NOM 
        ||' ' ||P.SEG_NOM||' '||P.PRI_AP||' '||P.SEG_AP AS NOMBREDOCENTE, C.CANTIDAD_MAX,
        (SELECT COUNT(RUN) FROM PERSONA PER WHERE PER.ID_CURSO=C.ID_CURSO AND PER.ESTADO = 'A') AS ALUMNOSACTUALES,
        c.estado,
        n.descripcion ||  ' ' || c.cod_curso as COMPUESTO,
        n.id_nivel
FROM CURSO C LEFT JOIN PERSONA P ON C.ID_DOCENTE = P.RUN
JOIN NIVEL_EDUCACION N ON n.id_nivel = c.id_nivel;

/

CREATE OR REPLACE VIEW V_NOTAS
AS
select
    p.run,
    p.dv, 
    p.pri_nom, 
    nvl(p.seg_nom, ' ') as seg_nom, 
    p.pri_ap, 
    nvl(p.seg_ap, ' ') as seg_ap, 
    c.id_curso, 
    c.nom_curso,
    c.cod_curso,
    ne.descripcion,
    a.id_asignatura,
    a.nom_asignatura, 
    a.cod_asignatura,
    a.anio,
    (select nvl(pers.pri_ap, '') ||' ' || nvl(pers.seg_ap,'') || ', '|| nvl(pers.pri_nom, '')|| ' ' || nvl(pers.seg_nom, '' ) from persona pers where pers.run = c.id_docente
    and pers.id_rol = (select id_rol from rol where descripcion = 'Docente'))  as docentejefe,
    (select nvl(pers.pri_ap, '') ||' ' || nvl(pers.seg_ap,'') || ', '|| nvl(pers.pri_nom, '')|| ' ' || nvl(pers.seg_nom, '' ) from persona pers where pers.run = a.doc_asignado
    and pers.id_rol = (select id_rol from rol where descripcion = 'Docente')) as docenteasignatura,
    n.id_nota,
    nvl(n.n1,0) as n1,
    nvl(n.n2,0) as n2,
    nvl(n.n3,0) as n3,
    nvl(n.n4,0) as n4,
    nvl(n.n5,0) as n5,
    nvl(n.n6,0) as n6,
    nvl(n.n7,0 ) as n7,
    nvl(n.n8, 0) as n8,
    nvl(n.n9, 0) as n9,
    nvl(n.n10, 0 ) as n10,
    nvl(n.n11, 0) as n11,
    nvl(n.n12, 0) as n12,
    nvl(n.n13, 0) as n13,
    nvl(n.n14, 0) as n14,
    nvl(n.n15, 0) as n15,
    nvl(n.n16, 0) as n16,
    nvl(n.n17, 0) as n17,
    nvl(n.n18, 0) as n18,
    nvl(n.n19, 0) as n19,
    nvl(n.n20, 0) as n20,
    nvl(n.p1, 0) as p1,
    nvl(n.p2, 0) as p2,
    nvl(n.pf, 0) as pf,
    case when n.estado = 'A' then 'Aprobado'
    when n.estado = 'R' then 'Reprobado'
    when n.estado = 'C' then 'Convalidado'
    when n.estado = 'X' then 'Eliminado'
     --Z en curso
    else 'En curso'
    end as estado
from persona p join curso c on p.id_curso = c.id_curso
join asignatura a on a.id_curso = c.id_curso
join nivel_educacion ne on ne.id_nivel = c.id_nivel
left join nota n on p.run = n.run and n.id_asignatura = a.id_asignatura
where p.id_rol = 5 and p.estado <> 'X' order by p.pri_ap ;             

/


CREATE OR REPLACE VIEW V_PERSONAS
AS
SELECT
    p.run as SIN_DV,
    p.run as DV,
    p.run || '-' ||p.dv as RUN,
    p.pri_nom ||' '||
    p.seg_nom ||' '||
    p.pri_ap ||' '|| 
    p.seg_ap as Nombre_Completo,
    TO_CHAR(p.fec_nac, 'dd-MM-YYYY') as FEC_NAC,
    s.descripcion as Sexo,
    NVL(pb.nom_pueblo, ' ') as Pueblo,
    d.descripcion ||', '|| 
    c.nom_comuna ||', '|| 
    reg.nom_region as Direccion,
    u.mail,
    u.cod_usuario,
    r.descripcion as ROL,
    p.estado,
    u.password
FROM
    persona p
    left join rol r on p.id_rol=r.id_rol
    join sexo s on s.id_sexo = p.id_sexo
    left join pueblo_originario pb on p.id_pueblo = pb.id_pueblo
    join direccion d on p.id_direccion = d.id_direccion
    join comuna c on d.id_comuna = c.id_comuna
    join region reg on c.id_region=reg.id_region
    join usuario u on p.run = u.run
    where p.id_curso is null;
/

CREATE OR REPLACE VIEW V_ASISTENCIA AS

SELECT ASI.RUN AS runAlumno,
        P.PRI_NOM ||' ' ||P.SEG_NOM ||' '||P.PRI_AP ||' '|| P.SEG_AP AS nombreAlumno,
        ASI.ID_CURSO AS idCurso,
        CUR.NOM_CURSO AS nombreCurso,
        CASE WHEN ASI.ESTADO = 1 THEN 'Presente'
        WHEN ASI.ESTADO = 0 THEN 'Ausente'
        END AS estadoAsistencia,
        TO_CHAR(ASI.FECHA_ASISTENCIA,'dd-MM-YYYY') AS fechaAsistencia,
        TO_CHAR(ASI.FECHA_CREACION,'dd-MM-YYYY') AS fechaCreacion,
        ASI.ID_ASISTENCIA AS idAsistencia,
        ASI.USR_CREACION AS usuarioCreacion

FROM ASISTENCIA ASI JOIN PERSONA P ON ASI.RUN = P.RUN
    JOIN CURSO CUR ON ASI.ID_CURSO = CUR.ID_CURSO
;

/


CREATE OR REPLACE VIEW V_NOTAS2
AS
SELECT
p.run, p.pri_nom, p.seg_nom, p.pri_ap, p.seg_ap, 
a.id_asignatura, n.id_curso, n.nom_curso, a.nom_asignatura, n.n1,  n.n2,  n.n3,  n.n4,  n.n5,  n.n6,  n.n7,
 n.n8,  n.n9,  n.n10,  n.n11,  n.n12,  n.n13,  n.n14,  n.n15,  n.n16, n.n17, n.n18,  n.n19, n.n20,  n.p1,  n.p2, n.pf, n.estado,
 n.docentejefe, n.docenteasignatura
from persona_asignatura pa join asignatura a on pa.id_asignatura = a.id_asignatura
join persona p on pa.run = p.run
join v_notas n on p.run = n.run and a.id_asignatura = n.id_asignatura;
/


  CREATE TABLE AAP_VERSION
   (  "ID" NUMBER(*,0) NOT NULL ENABLE, 
  "ARCHIVO" VARCHAR2(200 BYTE) NOT NULL ENABLE, 
  "VERSION" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
  "FECHA" TIMESTAMP (6) NOT NULL ENABLE, 
  "CHANGELOG" VARCHAR2(1500 BYTE) NOT NULL ENABLE, 
  "DEPRECADO" NUMBER(*,0) NOT NULL ENABLE
   );


/


  CREATE TABLE EVENTO 
   (  "ID_EVENTO" NUMBER NOT NULL ENABLE, 
  "TITULO" VARCHAR2(255 BYTE) NOT NULL ENABLE, 
  "DETALLE" VARCHAR2(1500 BYTE) NOT NULL ENABLE, 
  "TIPO" NUMBER(1,0) NOT NULL ENABLE,
  "FECHA_INS" TIMESTAMP (6) NOT NULL ENABLE,
  "ESTADO" CHAR (1) NOT NULL,
  "USR_CREACION" VARCHAR2 (100) NOT NULL
   );

/

CREATE OR REPLACE VIEW V_NOTAS3
AS
SELECT
p.run,
p.pri_nom,
p.seg_nom,
p.pri_ap,
p.seg_ap, 
a.id_asignatura,
n.id_curso,
n.nom_curso,
a.nom_asignatura,
a.anio,
n.n1,
n.n2,
n.n3,
n.n4,
n.n5,
n.n6,
n.n7,
n.n8,
n.n9,
n.n10,
n.n11,
n.n12,
n.n13,
n.n14,
n.n15,
n.n16,
n.n17,
n.n18,
n.n19,
n.n20,
n.p1,
n.p2,
n.pf
from persona_asignatura pa join asignatura a on pa.id_asignatura = a.id_asignatura
join persona p on pa.run = p.run
join v_notas n on p.run = n.run and a.id_asignatura = n.id_asignatura;

/

CREATE OR REPLACE VIEW V_OBSERVACION
AS
SELECT p.run || '-' ||p.dv AS run,
p.pri_nom ||' ' ||p.seg_nom ||' '||p.pri_ap ||' '|| p.seg_ap as nombrealumno,
p.id_curso AS idCurso, c.NOM_CURSO, 
CASE WHEN ob.TIPO = '-' THEN 'Negativa'
    WHEN ob.TIPO = '+' THEN 'Positiva' END AS tipo,
    TO_CHAR (ob.fecha_ins,'dd-MM-YYYY') AS fecha_ins,
CASE WHEN ob.DESC_OBS IS NULL THEN 'No hay observaciones...' 
ELSE ob.DESC_OBS
END AS Descripcion_Observacion,
ob.USR_CREACION
    FROM observacion ob JOIN persona p ON p.RUN = ob.RUN
                    JOIN curso c ON p.ID_CURSO = c.ID_CURSO;

/

CREATE OR REPLACE VIEW V_LECCIONARIO AS
SELECT LEC.DESCRIPCION AS descripcionLeccion,
    TO_CHAR(LEC.FECHA,'dd-MM-yyyy') AS fechaLeccion,
    LEC.FECHA_CREACION AS fechaCreacion,
    LEC.USUARIO_CRE AS usuarioCreacion,
    LEC.ID_ASIGNATURA AS idAsignatura,
    ASI.NOM_ASIGNATURA AS nombreAsignatura,
    ASI.COD_ASIGNATURA AS codigoAsignatura,
    ASI.ANIO AS AnioAsignatura,
    ASI.ID_CURSO AS idCurso,
    ASI.DOC_ASIGNADO AS docenteAsignatura
FROM LECCIONARIO LEC JOIN ASIGNATURA ASI ON ASI.ID_ASIGNATURA = LEC.ID_ASIGNATURA
;

/

CREATE OR REPLACE VIEW V_HORARIOS AS

select bl.ID_HORARIO,
a.nom_asignatura, 
a.COD_ASIGNATURA,
a.ID_ASIGNATURA,
case when bl.DIA_SEMANA = 1 then 'Lunes'
     when bl.DIA_SEMANA = 2 then 'Martes'
     when bl.DIA_SEMANA = 3 then 'Miercoles'
     when bl.DIA_SEMANA = 4 then 'Jueves'
     when bl.DIA_SEMANA = 5 then 'Viernes'
     when bl.DIA_SEMANA = 6 then 'Sabado'
     when bl.DIA_SEMANA = 7 then 'Domingo'
     end as diaSemana,
bl.HORA_INI || ' - ' || bl.HORA_TER as horas,
c.ID_CURSO as idCurso,
c.NOM_CURSO as nombreCurso
from asignatura a join bloque_asignatura ba on ba.ID_ASIGNATURA = a.ID_ASIGNATURA
                  join bloque bl on bl.ID_HORARIO = ba.ID_BLOQUEHORARIO
                  join curso c on c.ID_CURSO = a.ID_CURSO;


/


CREATE OR REPLACE VIEW V_ALUMNOS2
AS
SELECT p.run||'-'||p.dv as runAlumno,
        p.pri_nom ||' ' ||p.seg_nom ||' '||p.pri_ap ||' '|| p.seg_ap as nombreAlumno,
        case when p.estado = 'A' then 'Activo'
        when p.estado = 'X' then 'Eliminado'
        when p.estado = 'R' then 'Retirado'
        when p.estado = 'E' then 'Expulsado'
        end as Estado,
        case
        when cur.cod_curso is null then ' '
        else 
            NVL(n3.descripcion||' ' ||cur.cod_curso, ' ')
        end as cursoactual,
        cur.anio,
        d.descripcion||', '||c.nom_comuna||', ' || reg.nom_region as Direccion,
        se.descripcion AS SEXO,
        NVL(dis.nom_discapacidad, ' ') as discapacidad,
        NVL(ne.descripcion, ' ') as NivelAlumno,
        TO_CHAR(p.fec_nac, 'DD/MM/YYYY') as FechaNacimiento,
        TO_number(TRUNC((SYSDATE - p.fec_nac)/ 365), '999') as edad,
        NVL(po.nom_pueblo, ' ') as pueblooriginario,
        apo.run||'-'||apo.dv as runApoderado,
        apo.pri_nom||' '||apo.seg_nom||' '|| apo.pri_ap||' '||apo.seg_ap as NombreApoderado,
        ocu.descripcion as OcupacionApoderado,
        par.nom_parentesco as ParentescoApoderado,
        dir.descripcion||', '||com2.nom_comuna||', ' || reg2.nom_region as DireccionApoderado,
        ned.descripcion as nivelApoderado,
        mat.num_matricula as numeromatricula,
        mat.fec_matricula as fechamatricula,
        mat.usr_creacion as usuariocreacion,
        nvl(mat.usr_eliminacion,' ') as usuarioeliminacion,
        apo.telefono,
        apo.mail,
        cur.id_curso,
        P.RUN,
        ASI.ID_ASIGNATURA,
        ASI.NOM_ASIGNATURA
        FROM PERSONA P JOIN ROL R ON p.id_rol = r.id_rol
JOIN DIRECCION D ON P.ID_DIRECCION = d.id_direccion
JOIN COMUNA C ON D.ID_COMUNA = c.id_comuna
JOIN REGION REG ON C.ID_REGION = reg.id_region
JOIN PERSONA_APODERADO PA ON P.RUN = pa.run
JOIN APODERADO APO ON pa.run_apoderado = apo.run
JOIN DIRECCION DIR ON APO.ID_DIRECCION=DIR.ID_DIRECCION
JOIN COMUNA COM2 ON DIR.ID_COMUNA = COM2.ID_COMUNA
JOIN REGION REG2 ON COM2.ID_REGION = REG2.ID_REGION
LEFT JOIN pueblo_originario po on p.id_pueblo = po.id_pueblo
join ocupacion ocu on apo.id_ocupacion = ocu.id_ocupacion
join sexo se on p.id_sexo = se.id_sexo
join parentesco par on apo.id_parentesco = par.id_parentesco
join nivel_educacion ned on apo.id_nivel = ned.id_nivel
left join discapacidad dis on p.id_discapacidad = dis.id_discapacidad
left join matricula mat on p.num_matricula = mat.num_matricula
left join nivel_educacion ne on mat.nivel = ne.id_nivel
LEFT join curso cur on cur.id_curso = p.id_curso 
left join nivel_educacion n3 on cur.id_nivel = n3.id_nivel
JOIN ASIGNATURA ASI ON CUR.ID_CURSO = ASI.ID_CURSO
where r.descripcion = 'Alumno';

/


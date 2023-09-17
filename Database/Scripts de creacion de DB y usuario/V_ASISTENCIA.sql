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
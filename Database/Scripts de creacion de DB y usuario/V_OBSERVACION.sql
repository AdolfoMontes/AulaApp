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
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
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
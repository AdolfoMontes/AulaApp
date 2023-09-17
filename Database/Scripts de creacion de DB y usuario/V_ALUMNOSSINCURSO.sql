CREATE OR REPLACE VIEW V_ALUMNOSSINCURSO
AS
select p.run, p.dv, p.pri_nom, NVL(p.seg_nom, ' ') as seg_nom, p.pri_ap, NVL(p.seg_ap, ' ') as seg_ap, p.estado, m.anio, n.descripcion, m.fec_matricula, id_nivel
    from persona p 
    join matricula m on p.num_matricula = m.num_matricula
    join nivel_educacion n on m.nivel = n.id_nivel
where id_rol=5 and id_curso is null;
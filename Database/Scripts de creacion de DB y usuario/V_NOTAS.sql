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
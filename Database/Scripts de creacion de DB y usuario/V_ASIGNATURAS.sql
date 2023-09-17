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
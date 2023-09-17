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
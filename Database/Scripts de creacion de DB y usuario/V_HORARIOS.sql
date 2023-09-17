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
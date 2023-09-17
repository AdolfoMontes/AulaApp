
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

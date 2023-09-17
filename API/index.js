const express = require('express')
const oracledb = require('oracledb');
const app = express();
const res = require('express/lib/response');
const router = express.Router();
const port = 3000;
const nodemailer = require('nodemailer');
var bodyParser = require('body-parser')
var jsonParser = bodyParser.json();
const cors = require('cors');
app.use(cors())


//config
const dbConfig = {
  user : 'AULAAPP',
  password : 'AULAAPP',
  connectString : ''
  };


var password = 'AULAAPP';
//Headers
app.use(express.json());
app.use(express.urlencoded());
app.use(require('./routes/mail.js'));

const allowedOrigins = ['http://localhost:8100'];
app.use((req, res, next) => {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Headers', 'Authorization, X-API-KEY, Origin, X-reqed-With, Content-Type, Accept, Access-Control-Allow-req-Method');
  res.header('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, DELETE');
  res.header('Allow', 'GET, POST, OPTIONS, PUT, DELETE');
  next();
});




/*********************************************************/

async function obtenerUsuarios(req, res) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);

    console.log('connected to database');
    result = await connection.execute(`SELECT * FROM USUARIO`);

  } catch (err) {
    //send error message
    return res.send(err.message);
  } finally {
    if (connection) {
      try {
        // Always close connections
        await connection.close();
        console.log('close connection success');
      } catch (err) {
        console.error(err.message);
      }
    }
    if (result.rows.length == 0) {
      return res.send('query send no rows');
    } else {
      return res.send(result.rows);
    }

  }
}

app.get('/usuario', function (req, res) {
  obtenerUsuarios(req, res);
})

// /*********************************************************/

async function validarUsuario(req, res, run, pass) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);
	result = await connection.execute('SELECT * FROM USUARIO where run =:run and password=:pass', [run, pass]  );
  } catch (err) {
    //enviar mensaje de error
	console.log(err);
	
    return res.send(err.message);
  } finally {
    if (connection) {
      try {
        await connection.close(); 
      } catch (err) {
        return console.error(err.message);
      }
    }
    if (result.rows.length == 0) {
      const responseData ={
        result: 'LOGIN NOK'
      }
      return res.send(JSON.stringify(responseData));
    } else {
      const responseData ={
        result: 'LOGIN OK'
      }
      return res.send(JSON.stringify(responseData));
      //return res.send(result.rows);
    }
  }
}

app.get('/loginusuario', function (req, res) {
  let run = req.query.run;
  let pass = req.query.pass;

  validarUsuario(req, res, run, pass );
})


/*********************************************************/
async function recuperarDatosUsuario(req, res, run) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);
	result = await connection.execute('SELECT RUN,NOMBRE_COMPLETO,FEC_NAC,SEXO,PUEBLO,DIRECCION,MAIL,COD_USUARIO,ROL,ESTADO, PASSWORD, SIN_DV FROM V_PERSONAS WHERE  SIN_DV =:run', [run]  );
  } catch (err) {
    //enviar mensaje de error
	console.log(err);
	
    return res.send(err.message);
  } finally {
    if (connection) {
      try {
        await connection.close(); 
      } catch (err) {
        return console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('[]');
    } else {
      const responseData ={
        result: result.rows
      }
      return res.send(JSON.stringify(responseData));
    }
  }
}

app.get('/datosUsuario', function (req, res) {
  let run = req.query.run;

  recuperarDatosUsuario(req, res, run );
})


/*********************************************************/
async function obtenerNiveles(req, res) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);

    console.log('connected to database');
    result = await connection.execute(`SELECT id_nivel , descripcion  FROM NIVEL_EDUCACION WHERE ID_NIVEL < 13 ORDER BY 1`,[],
    { outFormat: oracledb.OUT_FORMAT_OBJECT }
    );
  } catch (err) {
    return res.send(err.message);
  } finally {
    if (connection) {
      try {

        await connection.close();
        console.log('close connection success');
      } catch (err) {
        console.send(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('No hay cursos disponibles');
    } else {

      return res.json(result.rows);
    }

  }
}


app.get('/nivel', function (req, res) {
  obtenerNiveles(req, res);
})

/*********************************************************************/

async function obtenerCursos(req, res, ID_NIVEL) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);

    console.log('connected to database');
    result = await connection.execute(`SELECT id_curso, id_nivel, compuesto FROM V_CURSOS where estado = 'A' and id_nivel=:ID_NIVEL order by id_nivel asc, compuesto asc`,[ID_NIVEL],
    //result = await connection.execute(`SELECT id_curso, id_nivel, compuesto FROM V_CURSOS where estado = 'A' order by id_nivel asc, compuesto asc`,[],
   
    { outFormat: oracledb.OUT_FORMAT_OBJECT }
    );
  } catch (err) {
    return res.send(err.message);
  } finally {
    if (connection) {
      try {

        await connection.close();
        console.log('close connection success');
      } catch (err) {
        console.send(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.sendStatus(404);
    } else {

      return res.send(result.rows);
    }

  }
}
app.get('/obtenerCursos', function (req, res) {
  let ID_NIVEL = req.query.ID_NIVEL;
  obtenerCursos(req, res, ID_NIVEL);
})
/*********************************************************************/

async function obtenerInfoCurso(req, res, id_curso) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);

    console.log('connected to database');
    result = await connection.execute(`SELECT id_curso, cod_curso, nom_curso, descripcion, anio, compuesto, id_nivel FROM V_CURSOS where estado = 'A' and id_curso=:id_curso`,[id_curso],
   
    { outFormat: oracledb.OUT_FORMAT_OBJECT }
    );
  } catch (err) {
    return res.send(err.message);
  } finally {
    if (connection) {
      try {

        await connection.close();
        console.log('close connection success');
      } catch (err) {
        console.send(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.sendStatus(404);
    } else {

      return res.send(result.rows);
    }

  }
}


app.get('/obtenerInfoCurso', function (req, res) {
  let id_curso = req.query.id_curso;
  obtenerInfoCurso(req, res,id_curso );
})

/******************************************************/
/*********************************************************************/

async function obtenerInfoAsignatura(req, res, id_asignatura) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);

    console.log('connected to database');
    result = await connection.execute(`SELECT ID_ASIGNATURA, NOM_ASIGNATURA, COD_ASIGNATURA, ANIO, CALCULO, COMPUESTO, NIVEL, ID_NIVEL, ID_CURSO, DOC_ASIGNADO, NOMBRE_DOCENTE, COD_SALA, ESTADO 
    FROM V_ASIGNATURAS WHERE ID_ASIGNATURA=:id_asignatura`,[id_asignatura],
   
    { outFormat: oracledb.OUT_FORMAT_OBJECT }
    );
  } catch (err) {
    return res.send(err.message);
  } finally {
    if (connection) {
      try {

        await connection.close();
        console.log('close connection success');
      } catch (err) {
        console.send(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.sendStatus(404);
    } else {

      return res.send(result.rows);
    }

  }
}


app.get('/obtenerInfoAsignatura', function (req, res) {
  let id_asignatura = req.query.id_asignatura;
  obtenerInfoAsignatura(req, res,id_asignatura );
})

/******************************************************/

app.post('/cambiarClave',jsonParser ,function (req, res) {
  const cuerpo = (req.body);
  console.log(cuerpo)
  const clave = cuerpo.clave;
  const run = cuerpo.run;
  cambiarClave(req, res, clave, run );
})


async function cambiarClave(req, res, clave, run) {
  let connection;

  try {
      connection = await oracledb.getConnection(dbConfig);

      const query = "UPDATE USUARIO SET PASSWORD=:clave where run=:run";

      const result = await connection.execute(query, {
          clave: clave,
          run: run
      }, { autoCommit: true});

      console.log(result);
      if(result.rowsAffected>=1){
        res.send('0');
      }else{
        res.send('-1')
      }
      
  } catch (err) {
      console.error(err);
      res.send(err);
  } finally {
      if (connection) {
          try {
              await connection.close();
          } catch (err) {
              console.error(err);
              res.send(err);
          }
      }
  }
}
/******************************************************/


async function obtenerAlumnos(req, res, idCurso) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);

    console.log('connected to database');
    result = await connection.execute(`select runalumno, nombrealumno, estado, cursoactual, anio, direccion, sexo, discapacidad,
    nivelalumno, fechanacimiento, edad, pueblooriginario, id_curso, run from v_alumnos
    where estado = 'Activo' and id_curso=:idCurso`,[idCurso],
    
    { outFormat: oracledb.OUT_FORMAT_OBJECT });
  } catch (err) {
    return res.send(err.message);
  } finally {
    if (connection) {
      try {

        await connection.close();
        console.log('close connection success');
      } catch (err) {
        console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('query send no rows');
    } else {

      return res.send(result.rows);
    }

  }
}


app.get('/cursoAlumno', function (req, res) {
  let idCurso = req.query.idCurso;
  obtenerAlumnos(req, res, idCurso);
})

app.get('/asignatura', function (req, res) {
  let idCurso = req.query.idCurso;
  obtenerAsignatura(req, res, idCurso);
})

async function obtenerAsignatura(req, res, idCurso) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);

    console.log('connected to database');
    result = await connection.execute(`select ID_ASIGNATURA, NOM_ASIGNATURA, COD_ASIGNATURA, ANIO, ESTADO,USR_CREACION,
    FECHA_CREACION, CALCULO, ID_CURSO, ID_SALA, DOC_ASIGNADO
    from ASIGNATURA
    where ESTADO = 'A' and id_curso=:idCurso`,[idCurso],
    
    { outFormat: oracledb.OUT_FORMAT_OBJECT });
  } catch (err) {
    return res.send(err.message);
  } finally {
    if (connection) {
      try {
        
        await connection.close();
        console.log('close connection success');
      } catch (err) {
        console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('query send no rows');
    } else {
      
      console.log(result.rows);
      return res.send(result.rows);
    }

  }
}


/******************************************************/

app.post('/confirmarAsistencia',jsonParser ,function (req, res) {
  const cuerpo = (req.body);
  console.log(req);
  const fecha_asistencia = cuerpo.fecha_asistencia;
  const estado = cuerpo.estado;
  const usr_creacion = cuerpo.usr_creacion;
  const run = cuerpo.run;
  const id_curso = cuerpo.id_curso;
  const dias_bloqueo = cuerpo.dias_bloqueo;
  console.log(cuerpo.estado)
  confirmarAsistencia(req, res, fecha_asistencia, estado, usr_creacion, run, id_curso, dias_bloqueo);
})


async function confirmarAsistencia(req, res, fecha_asistencia, estado, usr_creacion, run, id_curso, dias_bloqueo) {
  let connection;
  let bindVars = {
    O_CUR_RGTSGRAN_TYP: {type: oracledb.CURSOR, dir: oracledb.BIND_OUT}
  }

  try {
      connection = await oracledb.getConnection(dbConfig);

      const query = `BEGIN SP_INSERTARASISTENCIA(:fecha_asistencia, :estado, :usr_creacion, :run, :id_curso, :dias_bloqueo, :resultado); END;`;

      const result = await connection.execute(query, {
          fecha_asistencia: fecha_asistencia,
          estado: estado,
          usr_creacion: usr_creacion,
          run: run,
          id_curso: id_curso,
          dias_bloqueo: dias_bloqueo,
          resultado: {type: oracledb.INTEGER, dir: oracledb.BIND_OUT}
      }, { autoCommit: true});

      console.log(result);
      res.send(result);

      // if(result.rowsAffected>=1){
      //   res.send('0');
      // }else{
      //   res.send('-1')
      // }
      
  } catch (err) {
      console.error(err);
      res.send(err);
  } finally {
      if (connection) {
          try {
              await connection.close();
          } catch (err) {
              console.error(err);
              res.send(err);
          }
      }
  }
}

/******************************/
async function obtenerAsistencia(req, res, idCurso, fechaAsistencia) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);

    console.log('connected to database');
    result = await connection.execute(` SELECT runAlumno, nombreAlumno, idCurso, nombreCurso, estadoAsistencia, fechaAsistencia, fechaCreacion, idAsistencia, usuarioCreacion FROM V_ASISTENCIA WHERE idCurso=:idCurso AND fechaAsistencia=:fechaAsistencia ORDER BY nombreAlumno ASC`,[idCurso, fechaAsistencia],
    
    { outFormat: oracledb.OUT_FORMAT_OBJECT });
  } catch (err) {
    return res.send(err.message);
  } finally {
    if (connection) {
      try {

        await connection.close();
        console.log('close connection success');
      } catch (err) {
        console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('query send no rows');
    } else {
      console.log(result.rows);
      return res.send(result.rows);
    }

  }
}


app.get('/obtenerAsistencia', function (req, res) {
  let idCurso = req.query.idCurso;
  let fechaAsistencia = req.query.fechaAsistencia;
  obtenerAsistencia(req, res, idCurso, fechaAsistencia);
})

/******************************************************/

app.post('/confirmarLeccionario',jsonParser ,function (req, res) {
  const cuerpo = (req.body);
  console.log(req);
  const descripcion = cuerpo.descripcion;
  const fecha_asistencia = cuerpo.fecha_asistencia;
  const usr_creacion = cuerpo.usr_creacion;
  const id_asignatura = cuerpo.id_asignatura;
  confirmarLeccionario(req, res, descripcion, fecha_asistencia, usr_creacion, id_asignatura);
})

async function confirmarLeccionario(req, res, descripcion, fecha_asistencia, usr_creacion, id_asignatura) {
  let connection;
  let bindVars = {
    O_CUR_RGTSGRAN_TYP: {type: oracledb.CURSOR, dir: oracledb.BIND_OUT}
  }

  try {
      connection = await oracledb.getConnection(dbConfig);

      const query = `BEGIN SP_INSERTARLECCION(:descripcion, :fecha_asistencia, :usr_creacion, :id_asignatura, :resultado); END;`;

      const result = await connection.execute(query, {
        descripcion: descripcion,
        fecha_asistencia: fecha_asistencia,
          usr_creacion: usr_creacion,
          id_asignatura: id_asignatura,
          resultado: {type: oracledb.INTEGER, dir: oracledb.BIND_OUT}
      }, { autoCommit: true});

      console.log(result);
      res.send(result);

      // if(result.rowsAffected>=1){
      //   res.send('0');
      // }else{
      //   res.send('-1')
      // }
      
  } catch (err) {
      console.error(err);
      res.send(err);
  } finally {
      if (connection) {
          try {
              await connection.close();
          } catch (err) {
              console.error(err);
              res.send(err);
          }
      }
  }
}

/******************************************************/

app.post('/confirmarObservacion',jsonParser ,function (req, res) {
  const cuerpo = (req.body);
  console.log(req);
  const tipo = cuerpo.tipo;
  const desc_obs = cuerpo.desc_obs;
  const usr_creacion = cuerpo.usr_creacion;
  const run = cuerpo.run;
  const id_curso = cuerpo.id_curso;
  confirmarObservacion(req, res, tipo, desc_obs, usr_creacion, run, id_curso);
})

async function confirmarObservacion(req, res, tipo, desc_obs, usr_creacion, run, id_curso) {
  let connection;
  let bindVars = {
    O_CUR_RGTSGRAN_TYP: {type: oracledb.CURSOR, dir: oracledb.BIND_OUT}
  }

  try {
      connection = await oracledb.getConnection(dbConfig);

      const query = `BEGIN SP_GUARDAROBSERVACION(:tipo, :desc_obs, :usr_creacion, :run, :id_curso, :resultado); END;`;

      const result = await connection.execute(query, {
        tipo: tipo,
        desc_obs: desc_obs,
          usr_creacion: usr_creacion,
          run: run,
          id_curso: id_curso,
          resultado: {type: oracledb.INTEGER, dir: oracledb.BIND_OUT}
      }, { autoCommit: true});

      console.log(result);
      res.send(result);

      // if(result.rowsAffected>=1){
      //   res.send('0');
      // }else{
      //   res.send('-1')
      // }
      
  } catch (err) {
      console.error(err);
      res.send(err);
  } finally {
      if (connection) {
          try {
              await connection.close();
          } catch (err) {
              console.error(err);
              res.send(err);
          }
      }
  }
}

/******************************/
app.get('/obtenerLeccionario', function (req, res) {
  let idAsignatura = req.query.idAsignatura;
  let fechaLeccion = req.query.fechaLeccion;
  obtenerLeccionario(req, res, idAsignatura, fechaLeccion);
})

async function obtenerLeccionario(req, res, idAsignatura, fechaLeccion) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);

    console.log('connected to database');
    result = await connection.execute(` SELECT descripcionLeccion, fechaLeccion, fechaCreacion, usuarioCreacion, idAsignatura, nombreAsignatura, codigoAsignatura, AnioAsignatura, idCurso, docenteAsignatura FROM V_LECCIONARIO WHERE idAsignatura=:idAsignatura AND fechaLeccion=: fechaLeccion`,[idAsignatura, fechaLeccion],
    
    { outFormat: oracledb.OUT_FORMAT_OBJECT });
  } catch (err) {
    return res.send(err.message);
  } finally {
    if (connection) {
      try {

        await connection.close();
        console.log('close connection success');
      } catch (err) {
        console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('query send no rows');
    } else {
      console.log(result.rows);
      return res.send(result.rows);
    }

  }
}

/******************************/
async function obtenerObservacion(req, res, run) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);

    console.log('connected to database');
    result = await connection.execute(`SELECT run, nombrealumno, idCurso, nom_curso, tipo, fecha_ins, descripcion_observacion, usr_creacion FROM V_OBSERVACION WHERE run=:run ORDER BY fecha_ins`,[run],
    
    { outFormat: oracledb.OUT_FORMAT_OBJECT });
  } catch (err) {
    return res.send(err.message);
  } finally {
    if (connection) {
      try {

        await connection.close();
        console.log('close connection success');
      } catch (err) {
        console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('query send no rows');
    } else {
      console.log(result.rows);
      return res.send(result.rows);
    }

  }
}


app.get('/obtenerObservacion', function (req, res) {// revisar!
  let run = req.query.run;
  obtenerObservacion(req, res, run);
})

/******************************/
async function obtenerHorarioCurso(req, res, idCurso) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);

    console.log('connected to database');
    result = await connection.execute(`select nom_asignatura, id_asignatura,    
    LISTAGG(diasemana || ': ' ||horas, ', ') 
    WITHIN GROUP (ORDER BY id_horario) AS descripcion
    from v_horarios where idcurso=:idCurso 
    GROUP BY nom_asignatura, id_asignatura` ,[idCurso],
    
    { outFormat: oracledb.OUT_FORMAT_OBJECT });
  } catch (err) {
    return res.send(err.message);
  } finally {
    if (connection) {
      try {

        await connection.close();
        console.log('close connection success');
      } catch (err) {
        console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('query send no rows');
    } else {
      console.log(result.rows);
      return res.send(result.rows);
    }

  }
}


app.get('/obtenerHorarioCurso', function (req, res) {
  let idCurso = req.query.idCurso;
  obtenerHorarioCurso(req, res, idCurso);
})
/******************************************************/

/******************************/
async function obtenerHorarioAsignatura(req, res, idAsignatura) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);

    console.log('connected to database');
    result = await connection.execute(`select nom_asignatura, id_asignatura,    
    LISTAGG(diasemana || ': ' ||horas, ', ') 
    WITHIN GROUP (ORDER BY nom_asignatura) AS descripcion
    from v_horarios where id_asignatura=:idAsignatura 
    GROUP BY nom_asignatura, id_asignatura`,[idAsignatura],
    
    { outFormat: oracledb.OUT_FORMAT_OBJECT });
  } catch (err) {
    return res.send(err.message);
  } finally {
    if (connection) {
      try {

        await connection.close();
        console.log('close connection success');
      } catch (err) {
        console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('query send no rows');
    } else {
      console.log(result.rows);
      return res.send(result.rows);
    }

  }
}


app.get('/obtenerHorarioAsignatura', function (req, res) {
  let idAsignatura = req.query.idAsignatura;
  obtenerHorarioAsignatura(req, res, idAsignatura);
})
/******************************************************/

app.post('/ingresarNotas',jsonParser ,function (req, res) {
  const cuerpo = (req.body);
  console.log(req);
  const run = cuerpo.run;
  const id_asignatura = cuerpo.id_asignatura;
  const anio = cuerpo.anio;
  const n1 = cuerpo.n1;
  const n2 = cuerpo.n2;
  const n3 = cuerpo.n3;
  const n4 = cuerpo.n4;
  const n5 = cuerpo.n5;
  const n6 = cuerpo.n6;
  const n7 = cuerpo.n7;
  const n8 = cuerpo.n8;
  const n9 = cuerpo.n9;
  const n10 = cuerpo.n10;
  const semestre= cuerpo.semestre;
  ingresarNotas(req, res, run, id_asignatura, anio, n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, semestre);
})

async function ingresarNotas(req, res, run, id_asignatura, anio, n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, semestre) {
  let connection;
  let bindVars = {
    O_CUR_RGTSGRAN_TYP: {type: oracledb.CURSOR, dir: oracledb.BIND_OUT}
  }

  try {
      connection = await oracledb.getConnection(dbConfig);

      const query = `BEGIN SP_INSERTARNOTASEMESTRE(:run, :id_asignatura, :anio, :n1, :n2, :n3, :n4, :n5, :n6, :n7, :n8, :n9, :n10, :semestre, :resultado); END;`;

      const result = await connection.execute(query, {
        run: run,
        id_asignatura: id_asignatura,
        anio: anio,
          run: run,
          n1: n1,
          n2: n2,
          n3: n3,
          n4: n4,
          n5: n5,
          n6: n6,
          n7: n7,
          n8: n8,
          n9: n9,
          n10: n10,
          semestre: semestre,
          resultado: {type: oracledb.VARCHAR, dir: oracledb.BIND_OUT}
      }, { autoCommit: true});

      console.log(result);
      res.send(result);

      // if(result.rowsAffected>=1){
      //   res.send('0');
      // }else{
      //   res.send('-1')
      // }
      
  } catch (err) {
      console.error(err);
      res.send(err);
  } finally {
      if (connection) {
          try {
              await connection.close();
          } catch (err) {
              console.error(err);
              res.send(err);
          }
      }
  }
}

/******************************/
app.get('/obtenerNotasAsignatura', function (req, res) {
  let run = req.query.run;
  let id_asignatura = req.query.id_asignatura;
  let semestre = req.query.semestre;
  obtenerNotasAsignatura(req, res, run, id_asignatura, semestre);
})

async function obtenerNotasAsignatura(req, res, run, id_asignatura, semestre ) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);

    console.log('connected to database');
    if(semestre=='2'){
      result = await connection.execute(` SELECT RUN, PRI_NOM, SEG_NOM, PRI_AP, SEG_AP, ID_ASIGNATURA, ID_CURSO, NOM_CURSO, NOM_ASIGNATURA, ANIO, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20, P2, PF FROM V_NOTAS3 WHERE RUN=:run AND ID_ASIGNATURA=:id_asignatura`,[run, id_asignatura],{ outFormat: oracledb.OUT_FORMAT_OBJECT });
    }else if(semestre=='1'){
      result = await connection.execute(` SELECT RUN, PRI_NOM, SEG_NOM, PRI_AP, SEG_AP, ID_ASIGNATURA, ID_CURSO, NOM_CURSO, NOM_ASIGNATURA, ANIO, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, P1 FROM V_NOTAS3 WHERE RUN=:run AND ID_ASIGNATURA=:id_asignatura`,[run, id_asignatura],{ outFormat: oracledb.OUT_FORMAT_OBJECT });
    }
  } catch (err) {
    return res.send(err.message);
  } finally {
    if (connection) {
      try {

        await connection.close();
        console.log('close connection success');
      } catch (err) {
        console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('query send no rows');
    } else {
      console.log(result.rows);
      return res.json(result.rows);
    }

  }
}
/******************************/
app.get('/obtenerNotas', function (req, res) {
  let run = req.query.run;
  let id_curso = req.query.id_curso;
  let semestre = req.query.semestre;
  obtenerNotas(req, res, run, id_curso, semestre);
})

async function obtenerNotas(req, res, run, id_curso, semestre ) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);

    console.log('connected to database');
    if(semestre=='2'){
      result = await connection.execute(` SELECT RUN, PRI_NOM, SEG_NOM, PRI_AP, SEG_AP, ID_ASIGNATURA, ID_CURSO, NOM_CURSO, NOM_ASIGNATURA, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20, P2, PF FROM V_NOTAS2 WHERE RUN=:run AND ID_CURSO=:id_curso`,[run, id_curso],{ outFormat: oracledb.OUT_FORMAT_OBJECT });
    }else if(semestre=='1'){
      result = await connection.execute(` SELECT RUN, PRI_NOM, SEG_NOM, PRI_AP, SEG_AP, ID_ASIGNATURA, ID_CURSO, NOM_CURSO, NOM_ASIGNATURA, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, P1 FROM V_NOTAS2 WHERE RUN=:run AND ID_CURSO=:id_curso`,[run, id_curso],{ outFormat: oracledb.OUT_FORMAT_OBJECT });
    }
  } catch (err) {
    return res.send(err.message);
  } finally {
    if (connection) {
      try {

        await connection.close();
        console.log('close connection success');
      } catch (err) {
        console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('query send no rows');
    } else {
      console.log(result.rows);
      return res.json(result.rows);
    }

  }
}

/*********************************************************/
async function recuperarCredencialesUsuario(req, res, mail) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);
	result = await connection.execute('SELECT RUN,NOMBRE_COMPLETO,FEC_NAC,SEXO,PUEBLO,DIRECCION,MAIL,COD_USUARIO,ROL,ESTADO, PASSWORD, SIN_DV FROM V_PERSONAS WHERE  MAIL =:mail', [mail],{ outFormat: oracledb.OUT_FORMAT_OBJECT }  );
  } catch (err) {
    //enviar mensaje de error
	console.log(err);
	
    return res.send(err.message);
  } finally {
    if (connection) {
      try {
        await connection.close(); 
      } catch (err) {
        return console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('[]');
    } else {
      const responseData ={
        result: result.rows
      }
      return res.json(result.rows);
    }
  }
}

app.post('/recuperarCredencialesUsuario', function (req, res) {
  let mail = req.body.mail;

  recuperarCredencialesUsuario(req, res, mail );
})


/*********************************************************/
async function obtenerUsuariosRol(req, res, run) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);
	result = await connection.execute('SELECT SIN_DV, RUN, NOMBRE_COMPLETO, FEC_NAC, SEXO, PUEBLO, DIRECCION, MAIL, COD_USUARIO, ROL, ESTADO FROM v_personas WHERE SIN_DV=: run', [run],{ outFormat: oracledb.OUT_FORMAT_OBJECT }  );
  } catch (err) {
    //enviar mensaje de error
	console.log(err);
	
    return res.send(err.message);
  } finally {
    if (connection) {
      try {
        await connection.close(); 
      } catch (err) {
        return console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('[]');
    } else {
      const responseData ={
        result: result.rows
      }
      return res.json(result.rows);
    }
  }
}

app.post('/obtenerUsuariosRol', function (req, res) {
  let run = req.body.run;

  obtenerUsuariosRol(req, res, run );
})

/*********************************************************/
async function obtenerAsignaturasDocente(req, res, run) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);
	result = await connection.execute('SELECT ID_ASIGNATURA, NOM_ASIGNATURA, COD_ASIGNATURA, ANIO, CALCULO, COMPUESTO, NIVEL, ID_NIVEL, ID_CURSO, DOC_ASIGNADO, NOMBRE_DOCENTE, COD_SALA, ESTADO FROM V_ASIGNATURAS WHERE DOC_ASIGNADO=: run ORDER BY COMPUESTO', [run],{ outFormat: oracledb.OUT_FORMAT_OBJECT }  );
  } catch (err) {
    //enviar mensaje de error
	console.log(err);
	
    return res.send(err.message);
  } finally {
    if (connection) {
      try {
        await connection.close(); 
      } catch (err) {
        console.log('cualquier wea');
        return console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('[]');
    } else {
      const responseData ={
        result: result.rows
      }
      return res.json(result.rows);
    }
  }
}

app.post('/obtenerAsignaturasDocente', function (req, res) {
  let run = req.body.run;

  obtenerAsignaturasDocente(req, res, run );
})



/*********************************************************/
async function obtenerAsignaturasDocenteNivel(req, res, run, id_nivel) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);
	result = await connection.execute('SELECT ID_ASIGNATURA, NOM_ASIGNATURA, COD_ASIGNATURA, ANIO, CALCULO, COMPUESTO, NIVEL, ID_NIVEL, ID_CURSO, DOC_ASIGNADO, NOMBRE_DOCENTE, COD_SALA, ESTADO FROM V_ASIGNATURAS WHERE DOC_ASIGNADO=: run AND ID_NIVEL=: id_nivel ORDER BY ID_NIVEL', [run, id_nivel],{ outFormat: oracledb.OUT_FORMAT_OBJECT }  );
  } catch (err) {
    //enviar mensaje de error
	console.log(err);
	
    return res.send(err.message);
  } finally {
    if (connection) {
      try {
        await connection.close(); 
      } catch (err) {
        return console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('[]');
    } else {
      const responseData ={
        result: result.rows
      }
      return res.json(result.rows);
    }
  }
}

app.post('/obtenerAsignaturasDocenteNivel', function (req, res) {
  let run = req.body.run;
  let id_nivel = req.body.id_nivel;

  obtenerAsignaturasDocenteNivel(req, res, run, id_curso );
})
/*********************************************************/
async function obtenerAsignaturasDocenteCurso(req, res, run, id_curso) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);
	result = await connection.execute('SELECT ID_ASIGNATURA, NOM_ASIGNATURA, COD_ASIGNATURA, ANIO, CALCULO, COMPUESTO, NIVEL, ID_NIVEL, ID_CURSO, DOC_ASIGNADO, NOMBRE_DOCENTE, COD_SALA, ESTADO FROM V_ASIGNATURAS WHERE DOC_ASIGNADO=: run AND ID_CURSO=: id_curso ORDER BY ID_NIVEL', [run, id_curso],{ outFormat: oracledb.OUT_FORMAT_OBJECT }  );
  } catch (err) {
    //enviar mensaje de error
	console.log(err);
	
    return res.send(err.message);
  } finally {
    if (connection) {
      try {
        await connection.close(); 
      } catch (err) {
        return console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('[]');
    } else {
      const responseData ={
        result: result.rows
      }
      return res.json(result.rows);
    }
  }
}

app.post('/obtenerAsignaturasDocenteCurso', function (req, res) {
  let run = req.body.run;
  let id_curso = req.body.id_curso;

  obtenerAsignaturasDocenteCurso(req, res, run, id_curso );
})

/*********************************************************/
async function obtenerCursosDocente(req, res, run) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);
	result = await connection.execute('SELECT COMPUESTO, ID_CURSO, NIVEL FROM V_ASIGNATURAS WHERE DOC_ASIGNADO=: run GROUP BY ID_CURSO, COMPUESTO, NIVEL ORDER BY ID_CURSO', [run],{ outFormat: oracledb.OUT_FORMAT_OBJECT }  );
  } catch (err) {
    //enviar mensaje de error
	console.log(err);
	
    return res.send(err.message);
  } finally {
    if (connection) {
      try {
        await connection.close(); 
      } catch (err) {
        return console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('[]');
    } else {
      const responseData ={
        result: result.rows
      }
      return res.json(result.rows);
    }
  }
}

app.post('/obtenerCursosDocente', function (req, res) {
  let run = req.body.run;


  obtenerCursosDocente(req, res, run);
})
/*********************************************************/
async function obtenerAlumnosAsignatura(req, res, id_asignatura) {
  let connection;
  try {
    connection = await oracledb.getConnection(dbConfig);
	result = await connection.execute('SELECT RUNALUMNO, NOMBREALUMNO, ESTADO, CURSOACTUAL, ANIO, DIRECCION, SEXO, DISCAPACIDAD, NIVELALUMNO, FECHANACIMIENTO, EDAD, PUEBLOORIGINARIO, NUMEROMATRICULA,  FECHAMATRICULA, ID_CURSO, RUN, ID_ASIGNATURA, NOM_ASIGNATURA  FROM V_ALUMNOS2 WHERE ID_ASIGNATURA=: id_asignatura', [id_asignatura],{ outFormat: oracledb.OUT_FORMAT_OBJECT }  );
  } catch (err) {
    //enviar mensaje de error
	console.log(err);
	
    return res.send(err.message);
  } finally {
    if (connection) {
      try {
        await connection.close(); 
      } catch (err) {
        return console.error(err.message);
      }
    }
    if (result.rows.length == 0) {

      return res.send('[]');
    } else {
      const responseData ={
        result: result.rows
      }
      return res.json(result.rows);
    }
  }
}

app.post('/obtenerAlumnosAsignatura', function (req, res) {
  let id_asignatura = req.body.id_asignatura;


  obtenerAlumnosAsignatura(req, res, id_asignatura);
})



module.exports = router;

app.listen(port, () => console.log("AulaApp API escuchando en puerto %s!", port))

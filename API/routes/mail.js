const express = require('express');
const oracledb = require('oracledb');
const nodemailer = require('nodemailer');
const router = express.Router();
var ejs = require('ejs');
var handlebars = require('handlebars');
var smtpTransport = require('nodemailer-smtp-transport');
const res = require('express/lib/response');
var bodyParser = require('body-parser')
var jsonParser = bodyParser.json();

var fs = require('fs');

const dbConfig = {
    user : 'AULAAPP',
    password : 'AULAAPP',
    connectString : ''
    };


var readHTMLFile = function(path, callback) {
    fs.readFile(path, {encoding: 'utf-8'}, function (err, html) {
        if (err) {
            throw err;
            callback(err);
        }
        else {
            callback(null, html);
        }
    });
};


router.post("/send-email/", (req, res) =>{  //funcion para envio de correos 
    const {nombres} = req.body;
    const {mail}= req.body;
    const {codigoOtp}= req.body;
    
    let data = {
        nombres: nombres ,
        mail: mail,
        codigoOtp : codigoOtp
    }
    var transporter = nodemailer.createTransport(smtpTransport({
        service: 'gmail',
        host: 'smtp.gmail.com',
        auth: {
            user: 'AulaAppTeam@gmail.com',
            pass: 'vyurnndpdyjwrfdg'
        }
    }));
    readHTMLFile(process.cwd() + '/templates/plantilla.html', (err, html)=>{
    
        let render_html = ejs.render(html, {data: data});//RENDERIZACION DE LA PLANTILLA CON EJS
    
        var template = handlebars.compile(render_html);//USAMOS handlebars PARA LA PLANTILLA
        var htmlToSend = template({op:true});
    
        var mailOptions = {
            from: 'AulaAppTeam@gmail.com', //CORREO DEL REMITENTE
            to: mail, //CORREO DE DESTINO
            subject: 'Tu código de autorización de AulaApp', //ASUNTO DEL CORREO
            html: htmlToSend
        };
      
        transporter.sendMail(mailOptions, function(error, info){
            if (!error) {
                console.log('Email sent: ' + info.response);
                res.status(200).jsonp(req.body);
            }else{
                res.status(500).send(error.message);
            }
        });
    });

});

router.post("")


/**************************************************************** */

router.post('/validarCodigo',jsonParser ,function (req, res) {
    const cuerpo = (req.body);
    console.log(cuerpo)
    const mail = cuerpo.mail;
    const run = cuerpo.run;
    const codigoOtp = cuerpo.codigoOtp;
    validarCodigo(req, res, mail, run, codigoOtp);
  })
  
  
  async function validarCodigo(req, res, mail, run, codigoOtp) {
    let connection;
    let bindVars = {
        O_CUR_RGTSGRAN_TYP: {type: oracledb.CURSOR, dir: oracledb.BIND_OUT}
      }
    try {
        connection = await oracledb.getConnection(dbConfig);
  
        const query = `BEGIN SP_VALIDARCODIGOTP(:mail,:run,:codigoOtp, :resultado); END;`;
  
        const result = await connection.execute(query, {mail:mail , run:run, codigoOtp:codigoOtp, 
                            resultado: {type: oracledb.INTEGER, dir: oracledb.BIND_OUT} }
        , { autoCommit: true});
  
        console.log(result);
        res.send(result);
        
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

  router.post('/crearCodigo',jsonParser ,function (req, res) {
    const cuerpo = (req.body);
    console.log(cuerpo)
    const run = cuerpo.run;
    const mail = cuerpo.mail;
    crearCodigo(req, res, run, mail);
  })

  async function crearCodigo(req, res, run, mail) {
    let connection;
    let bindVars = {
        O_CUR_RGTSGRAN_TYP: {type: oracledb.CURSOR, dir: oracledb.BIND_OUT}
      }
    try {
        connection = await oracledb.getConnection(dbConfig);
  
        const query = `BEGIN SP_CREARCODIGOOTP(:mail,:run, :resultado); END;`;
  
        const result = await connection.execute(query, {mail:mail , run:run, 
                            resultado: {type: oracledb.INTEGER, dir: oracledb.BIND_OUT} }
        , { autoCommit: true});
  
        console.log(result);
        res.send(result);
        
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
  


module.exports = router;
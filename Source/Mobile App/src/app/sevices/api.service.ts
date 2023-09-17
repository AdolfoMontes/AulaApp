import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Usuario } from '../models/usuario.models';
import { Respuesta } from '../interface/Respuesta';
import { map} from 'rxjs/operators';
import { AlertController, NavController } from '@ionic/angular';
import { Persona } from '../interface/persona';
import { Nivel } from '../interface/nivel';
import { Curso } from '../interface/curso';
import { Alumno } from '../interface/alumno';
import { Asistencia } from '../interface/asistencia';
import { Asignatura } from '../interface/asignatura';
import { Leccionario } from '../interface/leccionario';
import { Nota } from '../interface/nota';
import { Horario } from '../interface/horario';
import { Observacion } from '../interface/observacion';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  listaAlumnos: Alumno[] = [];
  listaHorarios: Horario[] = [];
  formato: string;

  constructor(private http: HttpClient,  
    public alertController:AlertController, 
    public navController: NavController) { }
  rutaBase: string = 'http://localhost:3000';

 

  public usuarioAuth : string;
  public claveAuth : string;
  public usuarioLogueado : Persona;
  public usuarioRecuperar: Persona;
  obtenerUsuarios(){
    return this.http.get<Usuario[]>(this.rutaBase + '/usuario');
  }

  obtenerUsuariosRol(run){
    return this.http.post(this.rutaBase + '/obtenerUsuariosRol',{run});
  }


  recuperarCredencialesUsuario(mail){
    return this.http.post(this.rutaBase + '/recuperarCredencialesUsuario',{mail});
  }

  cambiarClave(run, nuevaContrasena){
    // console.log(run);
    // console.log(nuevaContrasena);
    return this.http.post(this.rutaBase + '/cambiarClave',{clave:nuevaContrasena,run:run})
    
  }

  obtenerNiveles(){
    return this.http.get<Nivel>(this.rutaBase + '/nivel');
  }

  obtenerAsignaturasDocente(run){
    return this.http.post<Nivel>(this.rutaBase + '/obtenerAsignaturasDocente',{run})

  }
  obtenerAsignaturasDocenteNivel(run, id_nivel){
    return this.http.post<Asignatura>(this.rutaBase + '/obtenerAsignaturasDocenteNivel',{run, id_nivel})

  }
  obtenerAsignaturasDocenteCurso(run, id_curso){
    return this.http.post<Asignatura>(this.rutaBase + '/obtenerAsignaturasDocenteCurso',{run, id_curso})

  }
  
  obtenerCursos(ID_NIVEL){
    return this.http.get<Curso>(this.rutaBase + '/obtenerCursos?ID_NIVEL=' + ID_NIVEL);
  }
  obtenerInfoCursos(id_curso){
    return this.http.get<Curso>(this.rutaBase + '/obtenerInfoCurso?id_curso=' + id_curso);
  }
  obtenerInfoAsignatura(id_asignatura){
    return this.http.get<Curso>(this.rutaBase + '/obtenerInfoAsignatura?id_asignatura=' + id_asignatura);
  }
  obtenerCursosDocente(run){
    return this.http.post<Curso>(this.rutaBase + '/obtenerCursosDocente',{run})
  }
  
  obtenerAlumnos(idCurso){
    return this.http.get<Alumno[]>(this.rutaBase + '/cursoAlumno?idCurso=' + idCurso);
  }
  
  obtenerAlumnosAsignatura(id_asignatura){
    return this.http.post<Alumno>(this.rutaBase + '/obtenerAlumnosAsignatura',{id_asignatura})

  }


  obtenerAsignatura(idCurso){
    return this.http.get<Asignatura[]>(this.rutaBase + '/asignatura?idCurso=' + idCurso);
  }

  obtenerAsistencia(idCurso, fechaAsistencia){
    return this.http.get<Asistencia[]>(this.rutaBase + '/obtenerAsistencia?idCurso=' + idCurso + '&fechaAsistencia='+ fechaAsistencia);
  }

  obtenerLeccionario(idAsignatura, fechaLeccion){
    return this.http.get<Leccionario[]>(this.rutaBase + '/obtenerLeccionario?idAsignatura=' + idAsignatura + '&fechaLeccion='+ fechaLeccion);
  }

  obtenerObservacion(run){
    return this.http.get<Observacion[]>(this.rutaBase + '/obtenerObservacion?run=' + run);
  }

  obtenerHorarioCurso(idCurso){
    return this.http.get<Horario[]>(this.rutaBase + '/obtenerHorarioCurso?idCurso=' + idCurso);
  }
  obtenerHorarioAsignatura(idAsignatura){
    return this.http.get<Horario[]>(this.rutaBase + '/obtenerHorarioAsignatura?idAsignatura=' + idAsignatura);
  }

  obtenerNotasAsignatura(run, id_asignatura, semestre){
    return this.http.get<Nota>(this.rutaBase + '/obtenerNotasAsignatura?run='+run +'&id_asignatura='+id_asignatura+'&semestre='+semestre)
  }
  obtenerNotas(run, id_curso, semestre){
    return this.http.get<Nota>(this.rutaBase + '/obtenerNotas?run='+run +'&id_curso='+id_curso+'&semestre='+semestre)
  }


  validarLogin(usuario, contrasena) {
    return this.http.get<Respuesta>(this.rutaBase + '/loginusuario?run=' + usuario + '&pass=' + contrasena)
      .pipe( map(auth => {
        if(auth.result === 'LOGIN OK'){
          ///console.log(usuario + contrasena);
          this.usuarioAuth=usuario;
          this.claveAuth=contrasena;
       }
      return auth;
     }));
    }

    recuperarDatosUsuario(run) {
      return this.http.get<Respuesta>(this.rutaBase + '/datosUsuario?run=' + run)
        .pipe( map(auth => {
          
          console.log(auth);
          if(auth != null){
            // debugger;
            try{
              this.usuarioLogueado = {
                runCompleto:auth.result[0][0],
                nombreCompleto:auth.result[0][1],
                fecNacimiento: auth.result[0][2] ,
                sexo:auth.result[0][3],
                pueblo: auth.result[0][4],
                direccion: auth.result[0][5],
                correo : auth.result[0][6],
                codigoUsuario : auth.result[0][7],
                rolUsuario: auth.result[0][8],  
                estadoUsuario: auth.result[0][9],
                passwordUsuario: auth.result[0][10],
                runUsuario: auth.result[0][11]
                
              }
              // console.log(this.usuarioLogueado);
              localStorage.setItem('runCompleto',this.usuarioLogueado.runCompleto);
              localStorage.setItem('nombreCompleto',this.usuarioLogueado.nombreCompleto);
              localStorage.setItem('fecNacimiento',this.usuarioLogueado.fecNacimiento);
              localStorage.setItem('sexo',this.usuarioLogueado.sexo);
              localStorage.setItem('pueblo',this.usuarioLogueado.pueblo);
              localStorage.setItem('direccion',this.usuarioLogueado.direccion);
              localStorage.setItem('correo',this.usuarioLogueado.correo);
              localStorage.setItem('codigoUsuario',this.usuarioLogueado.codigoUsuario);
              localStorage.setItem('rolUsuario',this.usuarioLogueado.rolUsuario);
              localStorage.setItem('estadoUsuario',this.usuarioLogueado.estadoUsuario);
              localStorage.setItem('passwordUsuario',this.usuarioLogueado.passwordUsuario);
              localStorage.setItem('runUsuario',this.usuarioLogueado.runUsuario);
            }catch{
              console.log('error');
              this.usuarioLogueado = {runCompleto:''
              };
            }
         }
        return auth;
       }));
      }
      

      enviarCorreo(nombres, mail, codigoOtp){
        return this.http.post(this.rutaBase+ '/send-email',{nombres, mail, codigoOtp})
      }

      crearCodigoOtp(run, mail){
        return this.http.post(this.rutaBase+ '/crearCodigo',{run, mail})
      }

      validarCodigo(codigoOtp, mail, run){
        return this.http.post(this.rutaBase+ '/validarCodigo',{codigoOtp, mail, run})
      }
      
      confirmarAsistencia(fecha_asistencia, estado, usr_creacion, run, id_curso, dias_bloqueo){
        return this.http.post(this.rutaBase+ '/confirmarAsistencia',{fecha_asistencia, estado, usr_creacion, run, id_curso, dias_bloqueo})
      }

      confirmarLeccionario(descripcion, fecha_asistencia, usr_creacion, id_asignatura){
        return this.http.post(this.rutaBase + '/confirmarLeccionario', {descripcion, fecha_asistencia, usr_creacion, id_asignatura})
      }

      confirmarObservacion(tipo, desc_obs, usr_creacion, run, id_curso){
        return this.http.post(this.rutaBase + '/confirmarObservacion', {tipo, desc_obs, usr_creacion, run, id_curso})
      }

      ingresarNotas(run, id_asignatura, anio, n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, semestre){
        return this.http.post(this.rutaBase + '/ingresarNotas', {run, id_asignatura, anio, n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, semestre})
      }

      // recuperarCredencialesUsuario(run){
      //   return this.http.post<Usuario>(this.rutaBase+'recuperarCredencialesUsuario',{run})
      // }
      
}

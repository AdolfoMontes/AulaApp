import { Component, OnInit } from '@angular/core';
import { element } from 'protractor';
import { format, parseISO } from 'date-fns';
import { Alumno } from 'src/app/interface/alumno';
import { Asistencia } from 'src/app/interface/asistencia';
import { ApiService } from 'src/app/sevices/api.service';
import { AlertController, ToastController } from '@ionic/angular';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-ingresar-asistencia-doc',
  templateUrl: './ingresar-asistencia-doc.page.html',
  styleUrls: ['./ingresar-asistencia-doc.page.scss'],
})
export class IngresarAsistenciaDocPage implements OnInit {

  listaAsistencia: Asistencia[]=[];
  listaAlumnos: Alumno[]=[];
  alumnoPresente: boolean;
  alumnoPresenteNum: number;
  
  runDocente: string;
  mdl_nivel: any;
  mdl_curso: any;
  mdl_asignatura: any;
  
  formato ='';
  fechaSys='';
  lista: [{}];

  constructor(public apiService: ApiService,
    public alertController: AlertController,
    public toastController: ToastController,
    public router: Router,
    private route: ActivatedRoute) {
    this.fechaSyst();
    // this.setHoy();
    // this.obtenerAlumnosApi()

    this.listaAsistencia;
  }
  
  ngOnInit() {
      // this.formato = format(parseISO(format(new Date(),  'yyyy-MM-dd')), ' dd-MM-yyyy')
      this.formato = localStorage.getItem('fecha');
      this.mdl_curso = localStorage.getItem('idCurso');
      console.log('id curso:: '+localStorage.getItem('idCurso'))
      console.log('fecha formato:: '+localStorage.getItem('fecha'))
    
    
    this.apiService.recuperarDatosUsuario(localStorage.getItem('userLogged')).subscribe(data=>{
      this.lista = [this.apiService.usuarioLogueado];
      // console.log(this.lista);
      this.runDocente = localStorage.getItem('userLogged');
      console.log(this.runDocente);
      
    }
    );
    this.listarAlumnos();

  }
  

  fechaSyst(){
    this.fechaSys = format(parseISO(format(new Date(),  'yyyy-MM-dd')), 'dd-MM-yyyy');
  }
  
  listarAlumnos(){
    console.log(this.mdl_curso);
    
    this.apiService.obtenerAlumnosAsignatura(this.mdl_curso).subscribe(data=>{
      console.log(data);
      for(let elemento in data){
        this.listaAlumnos.push(data[elemento]);
      }
      console.log(this.listaAlumnos);
      this.listaAsistencia = this.listaAlumnos;
    for(let atrib of this.listaAsistencia){
      atrib.PRESENTE = false;
      atrib.PRESENTE_NUM = 0;

      atrib.FECHA_CREACION = this.fechaSys;
      atrib.FECHA_ASISTENCIA = this.formato;
      atrib.USR_CREACION = this.runDocente;
     
      
      this.alumnoPresente = atrib.PRESENTE;
      
      this.alumnoPresenteNum = Number(atrib.PRESENTE); 
      
      atrib.PRESENTE_NUM = Number(atrib.PRESENTE);
      console.log(atrib.FECHA_ASISTENCIA);            
      
      
      
    } 
    console.log(this.listaAsistencia);
    })

    

    
  }

  asistenciaAlumnoCambiada(){
    
    for(let elemento of this.listaAsistencia){
      // elemento.PRESENTE = false;
      
      this.alumnoPresente = elemento.PRESENTE;
      this.alumnoPresente = !this.alumnoPresente;
      if(!this.alumnoPresente){
        elemento.PRESENTE_NUM = 1;
      }else{
        elemento.PRESENTE_NUM = 0;
      }
      console.log(this.listaAsistencia);  
    }
  }
  confirmarAsistencia(){
    //metodo de post que envía la info de la asistencia a bbdd
    // console.log(this.listaAsistencia);
    
    let DIAS_BLOQUEO = 7;
    for(let elemento of this.listaAsistencia){
      
      // console.log(PRESENTE_NUM);
      
      console.log(elemento.FECHA_CREACION,
        elemento.FECHA_ASISTENCIA,
        elemento.PRESENTE,
        elemento.PRESENTE_NUM,
        elemento.USR_CREACION,
        elemento.RUN,
        elemento.ID_CURSO,
        );
      this.apiService.confirmarAsistencia(elemento.FECHA_ASISTENCIA, elemento.PRESENTE_NUM, elemento.USR_CREACION, elemento.RUN, elemento.ID_CURSO, DIAS_BLOQUEO).subscribe(data=>{
        console.log(data);
        this.presentarAlerta('Asistencia Registrada Correctamente');
        this.router.navigate(['inicio-docente/asistencia']);  
      });
    }
  }
  
  irInicioDocente(){
    this.router.navigate(['inicio-docente']).then(()=>{
      window.location.reload();
    });
  }

  atras(){
    this.router.navigate(['inicio-docente/asistencia']);
  }

  refresh(){
    window.location.reload();
  }

  async errorGenerico(tipo, mensaje) {  //Usar este mensaje para evitar crear una por cada tipo.
    const toast = await this.toastController.create({
      header: tipo,
      message: mensaje,
      position: 'top',
      icon: 'close',
      duration:3500,
      color: 'danger',
      buttons: ['Ok'],
    });
    await toast.present();

    const { role } = await toast.onDidDismiss();
    console.log('onDidDismiss resolved with role', role)
}


  async presentarAlerta(message) {
    const toast = await this.toastController.create({
      position: 'top',
      message: message,
      icon: 'checkmark-circle',
      color: 'success',
      duration: 2000
    });
    toast.present();
  }
}

import { Component, OnInit } from '@angular/core';
import { element } from 'protractor';
import { format, parseISO } from 'date-fns';
import { Alumno } from 'src/app/interface/alumno';
import { Asistencia } from 'src/app/interface/asistencia';
import { ApiService } from 'src/app/sevices/api.service';
import { AlertController, ToastController } from '@ionic/angular';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-asistencia-alumnos',
  templateUrl: './asistencia-alumnos.page.html',
  styleUrls: ['./asistencia-alumnos.page.scss'],
})
export class AsistenciaAlumnosPage implements OnInit {

  listaAsistencia: Asistencia[]=[];
  alumnoPresente: boolean;
  alumnoPresenteNum: number;
  
  
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
    this.listarAlumnos();

    this.listaAsistencia;
    this.apiService.recuperarDatosUsuario(localStorage.getItem('userLogged')).subscribe(data=>{
      this.lista = [this.apiService.usuarioLogueado];
      console.log(this.lista);
      }
      );
  }
  
  ngOnInit() {
  }

  fechaSyst(){
    this.fechaSys = format(parseISO(format(new Date(),  'yyyy-MM-dd')), 'dd-MM-yyyy');
  }
  
  listarAlumnos(){

    this.listaAsistencia = this.apiService.listaAlumnos;
    this.formato = this.apiService.formato;
    for(let atrib of this.listaAsistencia){
      atrib.PRESENTE = false;
      atrib.PRESENTE_NUM = 0;

      atrib.FECHA_CREACION = this.formato;
      atrib.FECHA_ASISTENCIA = this.formato;
      atrib.USR_CREACION = this.apiService.usuarioLogueado.runUsuario
     
      console.log(atrib.FECHA_ASISTENCIA);      

      this.alumnoPresente = atrib.PRESENTE;
 
      this.alumnoPresenteNum = Number(atrib.PRESENTE); 

      atrib.PRESENTE_NUM = Number(atrib.PRESENTE);
      

      
    } 
    console.log(this.listaAsistencia);

    
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
        this.presentarAlerta('Asistencia Registrada Correctamente')
        this.router.navigate(['inicio']);
      });
    }
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

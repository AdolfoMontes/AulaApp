import { Component, OnInit, ViewChild } from '@angular/core';
import { PickerController, ModalController, ToastController, IonDatetime } from '@ionic/angular';
import { format, parseISO } from 'date-fns';
import { ApiService } from 'src/app/sevices/api.service';
import { Nivel } from 'src/app/interface/nivel';
import { Curso } from 'src/app/interface/curso';
import { Alumno } from 'src/app/interface/alumno';
import { Asistencia } from 'src/app/interface/asistencia';
import { Router } from '@angular/router';


@Component({
  selector: 'app-ver-asistencia',
  templateUrl: './ver-asistencia.page.html',
  styleUrls: ['./ver-asistencia.page.scss'],
})
export class VerAsistenciaPage implements OnInit {
  listaNivel: Nivel[] = [];
  listaCursos: Curso[] =[];
  listaAlumnos: Alumno[] = [];
  listaAsistencia: Asistencia[] =[];

  mdl_curso: Curso;
  mdl_nivel: number;
  mdl_alumno: Alumno;
  nivel:Nivel;
  mostrarCurso: boolean= false;
  mostrarAlumno: boolean = false;
  mostrarNivel: boolean = false;
  formatoAlum ='';
  mostrarPickerFecha = false;
  dateValue = format(new Date(),  'yyyy-MM-dd');
  formato = '';
  fechaSys = format(new Date(),  'yyyy-MM-dd');
  isEnabled =true;
  lista: [{}];
  @ViewChild(ModalController,) modalhdv: ModalController;
  @ViewChild(IonDatetime) datetime: IonDatetime
 
  constructor(public _pickerCtrl: PickerController, 
    public modalController: ModalController,
    public apiService: ApiService,
    public toastController: ToastController,
    public router: Router) {
      this.apiService.recuperarDatosUsuario(localStorage.getItem('userLogged')).subscribe(data=>{
        this.lista = [this.apiService.usuarioLogueado];
        console.log(this.lista);
        }
        );
     }

  

  ngOnInit() {
    this.obtenerNIvelApi();
    this.formato = format(parseISO(format(new Date(),  'yyyy-MM-dd')), 'dd-MM-yyyy');
 
  }
  setHoy() {
    this.formato = format(parseISO(format(new Date(),  'yyyy-MM-dd')), 'dd-MM-yyyy');
  }


  fechaCambiada(value) {
    if(this.datetime.value > this.fechaSys){
      this.errorGenerico('Error!','La fecha seleccionada no puede ser en el futuro!')
      this.mostrarPickerFecha = false;
      this.mostrarCurso = false;
      this.mostrarNivel = false;
      this.datetime.cancel(true);
    }else if(this.datetime.value = this.fechaSys){
      console.log(value);
      // this.dateValue = value;
      // this.formato = this.fechaSys;
      this.formato = this.datetime.value;
      this.formato = format(parseISO(value),'dd-MM-yyyy'); 
      console.log(this.formato);

      this.mostrarPickerFecha = false;
    }else{
      console.log(value);
      // this.dateValue = value;
      // this.formato = this.fechaSys;
      this.formato = format(parseISO(value),'dd-MM-yyyy'); 
      console.log(this.formato);

      this.mostrarPickerFecha = false;
    }

  }

  cerrar() {
    this.datetime.cancel(true);
  }

  seleccionar() {
    if(this.datetime.value > this.fechaSys){
      console.log(this.datetime.value);
      this.errorGenerico('Error!','La fecha seleccionada no puede ser en el futuro!')
      this.datetime.cancel(true);
      this.mostrarNivel = false;
      this.mostrarCurso = false;
    }else if(this.datetime.value = this.fechaSys){
      this.formato = this.datetime.value;
      this.formato = format(parseISO(format(new Date(),  'yyyy-MM-dd')), ' dd-MM-yyyy');
      console.log(this.datetime.value);
      this.datetime.confirm(true);
      this.mostrarNivel = true;
    }else{
      this.datetime.confirm(true);
      this.mostrarNivel = true;
    }
  }

  cerrarModal() {
    this.listaAsistencia = [];
    this.modalController.dismiss({
      'dismissed': true
    });
    
    this.mostrarCurso = false;
    this.mostrarNivel = false;
    this.isEnabled = true;
  }

  obtenerNIvelApi(){

    this.apiService.obtenerNiveles().subscribe(data => {
      for(let elemento in data){
        
        this.listaNivel.push(data[elemento]);
        // console.log(data);
        
      }
    }, err=>{
      this.presentToastWithOptions('Sin resultados','La búsqueda no arrojó resultados.')
    });  

  }

  onChange(selectedValue){
    this.mdl_curso=undefined;
    this.mdl_nivel=undefined;
    console.log("Selected:",selectedValue);
    this.mostrarCurso = true;
  }

  obtenerCursoApi(){
    if(this.mdl_nivel === undefined){
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
      this.mostrarCurso = false;
    }
    this.listaCursos=[];
    this.apiService.obtenerCursos(this.mdl_nivel).subscribe(data => {
      for(let elemento in data){
        this.listaCursos.push(data[elemento]);}
        this.mostrarCurso = true;
    }, err =>{
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
      this.mdl_curso = undefined;
      this.mdl_nivel = undefined;
      this.mostrarCurso = false;
      this.mostrarNivel = false;
    });
  }
  
  obtenerValor(valor){
    this.mdl_nivel = valor;
  }

  // obtenerValorCurso(valor){
  //   this.mdl_curso = valor;
  // }

  obtenerAsistencia(){
    if(this.mdl_curso === undefined){
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
    }else{
      this.listaAsistencia = []; 
      this.apiService.obtenerAsistencia(this.mdl_curso,this.formato).subscribe(data =>{
        for(let elemento in data){
          this.listaAsistencia.push(data[elemento]);
        }
        console.log(this.listaAsistencia);
        this.isEnabled = false;

      },err =>{
        this.isEnabled = true;
        this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
        this.mdl_curso = undefined;
      this.mdl_nivel = undefined;
      this.mostrarCurso = false;
      this.mostrarNivel = false;
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

  async presentToast(message) {
    const toast = await this.toastController.create({
      position: 'bottom',
      message: message,
      duration: 2000
    });
    toast.present();
  }

  async presentToastWithOptions(header, message) {
    const toast = await this.toastController.create({
      message: message,
      icon: 'information-circle',
      position: 'top',
      buttons: [
       {
          text: 'Aceptar',
          role: 'cancel',
          handler: () => {

          }
        }
      ]
    });
    await toast.present();

    const { role } = await toast.onDidDismiss();
    console.log('onDidDismiss resolved with role', role);
  }
}

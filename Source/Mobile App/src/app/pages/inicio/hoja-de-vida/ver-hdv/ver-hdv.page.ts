import { Component, OnInit, ViewChild } from '@angular/core';
import { PickerController, ModalController, ToastController } from '@ionic/angular';
import { ApiService } from 'src/app/sevices/api.service';
import { Nivel } from 'src/app/interface/nivel';
import { Curso } from 'src/app/interface/curso';
import { Alumno } from 'src/app/interface/alumno';
import { Observacion } from 'src/app/interface/observacion';

@Component({
  selector: 'app-ver-hdv',
  templateUrl: './ver-hdv.page.html',
  styleUrls: ['./ver-hdv.page.scss'],
})
export class VerHdvPage implements OnInit {

  constructor(public _pickerCtrl: PickerController, 
    public modalController: ModalController,
    public apiService: ApiService,
    public toastController: ToastController) {
      
     }

  listaNivel: Nivel[] = [];
  listaCursos: Curso[] =[];
  listaAlumnos: Alumno[] = [];
  listaObservacion: Observacion[] = [];
  mdl_curso: Curso;
  mdl_nivel: number;
  mdl_alumno: string;
  nivel:Nivel;
  mostrarNivel: boolean= true;
  mostrarCurso: boolean= false;
  mostrarAlumno: boolean = false;
  isEnabled=true;
  formatoAlum ='';
  @ViewChild(ModalController,) modalhdv: ModalController;

  ngOnInit() {
    this.obtenerNIvelApi()
  }

  cerrar() {

    this.modalController.dismiss({
      'dismissed': true
    });
    this.mdl_nivel = undefined;
    this.mdl_curso = undefined;
    this.mdl_alumno = undefined;
    this.mostrarCurso = false;
    this.mostrarAlumno = false;
  }

  obtenerNIvelApi(){

    this.apiService.obtenerNiveles().subscribe(data => {
      for(let elemento in data){
        
        this.listaNivel.push(data[elemento]);        
      }
    });    

  }

  onChange(selectedValue){
    console.log("Selected:",selectedValue);
    console.log(this.listaObservacion);
    
    // this.mostrarCurso = true;
    // if(this.mostrarCurso === true){
    //   this.mostrarAlumno = true;

    // }
  }


  obtenerCursoApi(){
    this.listaCursos=[];
    this.apiService.obtenerCursos(this.mdl_nivel).subscribe(data => {
      for(let elemento in data){
        this.listaCursos.push(data[elemento]);}
        this.mostrarCurso = true;
      }, err =>{
        // this.errorGenerico('Error','La búsqueda no arrojó resultados.')
        
        this.mostrarCurso = false;
    })
    ;    

  }
  obtenerValor(valor){
    this.mdl_nivel = valor;
  }

  // obtenerValor(valor){
  //   this.mdl_nivel = valor;
  // }

  obtenerAlumnosApi(){
 
    this.listaAlumnos =[];
    this.apiService.obtenerAlumnos(this.mdl_curso).subscribe(data =>{
      for(let elemento in data){
        this.listaAlumnos.push(data[elemento]);       
      }
      console.log(data);
      console.log(this.mdl_curso.ID_CURSO);
      console.log(this.listaAlumnos);
      this.apiService.listaAlumnos = this.listaAlumnos;
      // this.listaObservacion = this.listaAlumnos;
      this.mostrarAlumno = true;
      
      
    }, err =>{
      this.presentToastWithOptions('Sin resultados','La búsqueda no arrojó resultados.');
      this.mostrarAlumno = false;
    })
    
  }

  obtenerObservacionApi(){
    this.listaObservacion = [];
    this.apiService.obtenerObservacion(this.mdl_alumno).subscribe(data =>{
      for(let elemento in data){
        this.listaObservacion.push(data[elemento]);
        console.log(data[elemento]);
        console.log(this.listaObservacion);        
      }
      this.isEnabled = false;
      
      
    },err =>{      
      this.presentToastWithOptions('Sin resultados','La búsqueda no arrojó resultados.')
      this.mostrarAlumno = false;
      this.mostrarCurso = false;
      this.mdl_nivel= undefined;
      
    });
  }

  async errorGenerico(header, message) {
    const toast = await this.toastController.create({
      header: header,
      position: 'top',
      message: message,
      duration: 2000,
      color:'danger',
      icon:'close-outline'
    });
    toast.present();
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
      header: header,
      message: message,
      position: 'top',
      color: 'danger',
      icon:'close-outline',
      duration: 2000,
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


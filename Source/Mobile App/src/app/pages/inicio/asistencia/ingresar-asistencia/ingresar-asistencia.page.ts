import { Component, OnInit, ViewChild } from '@angular/core';
import { IonDatetime, PickerController, ToastController } from '@ionic/angular';
import { format, parseISO } from 'date-fns';
import { AlertController } from '@ionic/angular';
import { ApiService } from 'src/app/sevices/api.service';
import { Nivel } from 'src/app/interface/nivel';
import { Curso } from 'src/app/interface/curso';
import { Alumno } from 'src/app/interface/alumno';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ingresar-asistencia',
  templateUrl: './ingresar-asistencia.page.html',
  styleUrls: ['./ingresar-asistencia.page.scss'],
})
export class IngresarAsistenciaPage implements OnInit {

  mostrarPickerFecha = false;
  mdl_nivel: number;
  mdl_curso: Curso;
  dateValue = format(new Date(),  'yyyy-MM-dd');
  fechaSys = format(new Date(),  'yyyy-MM-dd');
  formato = '';
  mostrarNivel: boolean= false;
  mostrarCurso: boolean=false; 
  listaNivel: Nivel[] = [];
  listaCursos: Curso[] =[];
  listaAlumnos: Alumno[] = [];
  lista: [{}];
  @ViewChild(IonDatetime,) datetime: IonDatetime


  constructor( public _pickerCtrl: PickerController,
    public alertController: AlertController,
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
    this.formato = format(parseISO(format(new Date(),  'yyyy-MM-dd')), ' dd-MM-yyyy');
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
    this.mdl_curso = undefined;
    console.log("Selected:",selectedValue);
    this.mostrarCurso = true;
  }

  obtenerCursoApi(){
    if(this.mdl_nivel === undefined){
      this.mostrarCurso = false;
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
    }else{
      this.listaCursos=[];
      this.apiService.obtenerCursos(this.mdl_nivel).subscribe(data => {
        for(let elemento in data){
          console.log(this.mdl_curso);
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
  }
  
  obtenerValor(valor){
    this.mdl_nivel = valor;
  }

  // obtenerValorCurso(valor){
  //   this.mdl_curso = valor;
  // }

  
  obtenerAlumnosApi(){
    if(this.mdl_curso === undefined){
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
    }else{
      this.listaAlumnos =[];
      this.apiService.obtenerAlumnos(this.mdl_curso).subscribe(data =>{      
        for(let elemento in data){
          this.listaAlumnos.push(data[elemento]);       
        }
        this.apiService.listaAlumnos = this.listaAlumnos;
        this.apiService.formato = this.formato;
        this.router.navigate(['inicio/asistencia/asistencia-alumnos']);
        
      }, err =>{
        this.errorGenerico('Ups!','Ha ocurrido un error, vuelva a ingresar e intentélo nuevamente.');
      })

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

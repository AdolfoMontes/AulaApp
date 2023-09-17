import { Component, OnInit, ViewChild } from '@angular/core';
import { IonDatetime, PickerController, ToastController } from '@ionic/angular';
import { format, parseISO } from 'date-fns';
import { ApiService } from 'src/app/sevices/api.service';
import { Nivel } from 'src/app/interface/nivel';
import { Curso } from 'src/app/interface/curso';
import { Alumno } from 'src/app/interface/alumno';
import { Observacion } from 'src/app/interface/observacion';
import { Router } from '@angular/router';
@Component({
  selector: 'app-nueva-hdv-doc',
  templateUrl: './nueva-hdv-doc.page.html',
  styleUrls: ['./nueva-hdv-doc.page.scss'],
})
export class NuevaHdvDocPage implements OnInit {
  runDocente: string;
  mostrarAlumno: boolean = true;
  mostrarTipo: boolean = false;
  mostrarObservacion: boolean = false;
  listaNivel: Nivel[] = [];
  listaCursos: Curso[] =[];
  listaAlumnos: Alumno[] = [];
  listaObservacion: Observacion[] = [];

  mdl_curso: any;
  mdl_nivel: any;
  mdl_alumno: any;
  
  isDisableConf= true;
  formato ='';

  box_positiva: boolean = false;
  box_negativa: boolean = false;
  box_alumnoFinalString = '';
  id_curso: number;
  txt_observacion: string = '';
  usr_creacion:string;
  nivel:Nivel;
  lista: [{}]; 


  @ViewChild(IonDatetime) datetime: IonDatetime

  constructor(public _pickerCtrl: PickerController,
    public apiService: ApiService,
    public toastController: ToastController,
    public router: Router) {
    this.listaObservacion;
    this.apiService.recuperarDatosUsuario(localStorage.getItem('userLogged')).subscribe(data=>{
      this.lista = [this.apiService.usuarioLogueado];
      console.log(this.lista);
      }
      );
      this.usr_creacion = localStorage.getItem('userLogged');
    // this.obtenerNIvelApi();
    // this.obtenerAlumnosApi();
    // this.listarAlumnos();
  }
  
  ngOnInit() {
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
    this.obtenerAlumnosApi();

    
  }

  onChangeAlumno(selectedValue){
    console.log("Selected:",selectedValue);
    this.mostrarTipo =true;
    // this.mdl_curso = undefined;
    // this.mostrarCurso = true;
    // if(this.mostrarAlumno){
    //   this.mostrarTipo = true;          
    // }  
    // this.txt_observacion='';

  }

  onChange(selectedValue){
    // this.mdl_curso = undefined;
    // console.log("Selected:",selectedValue);
    // this.mostrarCurso = true;
    // if(this.mostrarAlumno){
    //   this.mostrarTipo = true;          
    // }  
    // this.txt_observacion='';

  }

  obtenerValor(valor){
    this.mdl_nivel = valor;
  }

  obtenerAlumnosApi(){
    if(this.mdl_curso === undefined){
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
    }else{
      this.listaAlumnos =[];
      this.apiService.obtenerAlumnos(this.mdl_curso).subscribe(data =>{      
        for(let elemento in data){
          this.listaAlumnos.push(data[elemento]);
          this.listaObservacion = this.listaAlumnos;
    
        }

        // this.mostrarAlumno = true;

        
      }, err =>{
        this.errorGenerico('Ups!','Ha ocurrido un error, vuelva a ingresar e intentélo nuevamente.');
      })

    }
  }

  listarAlumnos(){
    
    this.listaObservacion = this.apiService.listaAlumnos; 
    for(let atrib of this.listaObservacion){
      atrib.USR_CREACION = localStorage.getItem('userLogged');
      this.usr_creacion = atrib.USR_CREACION;
    }

    // console.log(this.apiService.listaAlumnos);
    // console.log(this.asistenciaAlumnoCambiada());
    
    // for(let elemento of this.listaAsistencia){
    //   elemento.PRESENTE = this.alumnoPresente;
    //   this.alumnoPresente = !this.alumnoPresente;
    //   console.log(elemento.PRESENTE = this.alumnoPresente);
      
    // }
    
    
    
  }

  actualizaPositiva(){
    this.box_negativa = false;
    if(this.box_positiva === true){
      this.box_negativa = false;
      this.box_alumnoFinalString = String(this.box_positiva);
      this.box_alumnoFinalString = '+';
      this.mostrarObservacion = true;
      // this.mostrarObservacion = true;
      // if(this.mostrarObservacion){
        //   this.isEnabled=false;
        // }
      }else{
        this.box_positiva = false;
        this.mostrarObservacion = false;
      
    }
  }

  actualizaNegativa(){
    this.box_positiva = false;
    if(this.box_negativa === true){
      this.box_positiva = false;
      this.box_alumnoFinalString = String(this.box_negativa);
      this.box_alumnoFinalString = '-';
      this.mostrarObservacion = true;

      // this.mostrarObservacion = true;
      // if(this.mostrarObservacion){
      //   this.isEnabled=false;
      // }
    }else{
      this.box_negativa = false;
      this.mostrarObservacion = false;
    }
  }

  entradaObservacion(){
    this.isDisableConf = false;
    

  }

  confirmarObservacion() {
    console.log(this.box_alumnoFinalString);
    console.log(this.txt_observacion);
    console.log(this.formato);
    console.log(this.usr_creacion);
    console.log(this.mdl_alumno);

    
    if(this.txt_observacion === '' ){
      this.errorGenerico('Atención!','Debe ingresar todos los campos!')
    }else{
      this.box_alumnoFinalString;
      this.txt_observacion;
      this.formato;
      this.usr_creacion;
      this.mdl_alumno;
      this.id_curso;

      console.log('tipo de observacion: ' + this.box_alumnoFinalString);//tipo de observacion   
      console.log('desc. observacion: ' + this.txt_observacion);//desc. observacion
      console.log('fecha observacion: ' + this.formato);//fecha observacion
      console.log('usuario creador observacion: ' + this.usr_creacion);//usuario creador observacion
      console.log('run alumno: ' + this.mdl_alumno);//run alumno
      console.log(this.listaObservacion);
      
      this.apiService.confirmarObservacion(this.box_alumnoFinalString, this.txt_observacion, this.usr_creacion, this.mdl_alumno, this.mdl_curso).subscribe(data=>{
        console.log(data);
        console.log('confirma cambios')
      this.box_alumnoFinalString= '';
      this.txt_observacion= '';
      this.formato= '';
      this.mdl_alumno= '';
      this.router.navigate(['inicio-docente/hoja-de-vida']);
      this.presentToast('Exito!', 'Observación registrada correctamente.');
        
      })
    }
  }

  irInicioDocente(){
    this.router.navigate(['inicio-docente']).then(()=>{
      window.location.reload();
    });
  }

  atras(){
    this.router.navigate(['inicio-docente/hoja-de-vida']);
    
  }

  refresh(){
    window.location.reload();
  }

  async presentToast(header,message) {
    const toast = await this.toastController.create({
      position: 'top',
      message: message,
      duration: 2000,
      color: 'success'
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
 

}
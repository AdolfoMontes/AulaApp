import { Attribute, Component, OnInit, ViewChild } from '@angular/core';
import { IonDatetime, PickerController, ToastController } from '@ionic/angular';
import { format, parseISO } from 'date-fns';
import { ApiService } from 'src/app/sevices/api.service';
import { Nivel } from 'src/app/interface/nivel';
import { Curso } from 'src/app/interface/curso';
import { Asignatura } from 'src/app/interface/asignatura';
import { Leccionario } from 'src/app/interface/leccionario';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ingresar-leccionario',
  templateUrl: './ingresar-leccionario.page.html',
  styleUrls: ['./ingresar-leccionario.page.scss'],
})
export class IngresarLeccionarioPage implements OnInit {

  listaNivel: Nivel[] = [];
  listaCursos: Curso[] =[];
  listaAsignatura: Asignatura[] = [];
  listaLeccionario: Leccionario[] = [];
  mdl_curso: Curso;
  mdl_nivel: number;
  mdl_asignatura:any;
  mostrarNivel: boolean= false; 
  mostrarCurso: boolean= false; 
  mostrarAsignatura: boolean = false;
  mostrarObjetivo: boolean = false;
  mostrarPickerFecha = false;
  txt_descLeccionario = '';
  id_asignatura: number;
  dateValue = format(new Date(),  'yyyy-MM-dd');
  formato = '';
  fechaSys='';
  nivel:Nivel;
  usr_creacion:string;
  formatoAsignatura = '';
  lista: [{}];
  @ViewChild(IonDatetime) datetime: IonDatetime

  constructor( public _pickerCtrl: PickerController,
    public apiService: ApiService,
    public toastController: ToastController,
    public router: Router) {
      this.fechaSyst();
      this.setHoy();
      console.log(this.formato);
      this.apiService.recuperarDatosUsuario(localStorage.getItem('userLogged')).subscribe(data=>{
        this.lista = [this.apiService.usuarioLogueado];
        console.log(this.lista);
        }
        );
      this.usr_creacion = localStorage.getItem('userLogged');
    
  }

  ngOnInit() {
    this.obtenerNIvelApi()
  }

  setHoy() {
    this.formato = format(parseISO(format(new Date(),  'yyyy-MM-dd')), 'dd-MM-yyyy');
  }

  fechaSyst(){
    this.fechaSys = format(parseISO(format(new Date(),  'yyyy-MM-dd')), 'dd-MM-yyyy');
  }

  fechaCambiada(value) {
    console.log(value);
    this.dateValue = value;
    this.formato = format(parseISO(value),' dd-MM-yyyy'); 
    this.mostrarPickerFecha = false;

  }

  cerrar() {
    this.datetime.cancel(true);
  }

  seleccionar() {
    this.datetime.confirm(true);
    this.mostrarNivel = true;
  }


  obtenerNIvelApi(){

    this.apiService.obtenerNiveles().subscribe(data => {
      for(let elemento in data){
        
        this.listaNivel.push(data[elemento]);
        // console.log(data);
        
      }
    },err=>{
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
        this.mdl_curso = undefined;
        this.mdl_asignatura = '';
    });    

  }

  onChange(selectedValue){
    console.log("Selected:",selectedValue);

    if(this.mostrarCurso){
      this.mostrarAsignatura=true;
    }
 
  }

  activarObjetivo(){
    this.mostrarObjetivo = true;
  }

 
  obtenerCursoApi(){
    if(this.mdl_nivel === undefined){
      this.mostrarCurso = false;
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados, inténtelo nuevamente.')
      this.mdl_asignatura ='';
    }else{
      this.listaCursos=[];
      this.apiService.obtenerCursos(this.mdl_nivel).subscribe(data => {
        for(let elemento in data){
          this.listaCursos.push(data[elemento]);}
          this.mostrarCurso = true;
          
      }, err =>{
        this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
        this.mdl_curso = undefined;
        this.mdl_asignatura = '';
        this.txt_descLeccionario = '';
        this.mostrarCurso = false;
        this.mostrarAsignatura = false;
        this.mostrarObjetivo = false;
      });
    }
  }

  obtenerAsignaturaApi(){

    if(this.mdl_curso === undefined){
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
      this.mdl_asignatura = '';
    }else{
      this.listaAsignatura =[];
      this.apiService.obtenerAsignatura(this.mdl_curso).subscribe(data =>{
        for(let elemento in data){
          this.listaAsignatura.push(data[elemento]);
        }
        console.log(this.listaAsignatura);
      }, err =>{
        this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.');
        this.mdl_asignatura = '';
      })
    }

  }


  async presentToast(header,message) {
    const toast = await this.toastController.create({
      header: header,
      position: 'bottom',
      message: message,
      duration: 3000,
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



  confirmaLeccionario(){
    if(this.txt_descLeccionario === '' || this.mdl_curso === undefined || this.mdl_asignatura === undefined){
      this.errorGenerico('Atención!','Todos los campos deben ser llenados!')
    }else{
      this.txt_descLeccionario;
    this.fechaSys;
    this.formato;
    this.usr_creacion;
    this.mdl_asignatura;
    console.log('desc leccionario: ' + this.txt_descLeccionario);//descripcion  
    console.log('fecha sys: ' + this.fechaSys);//fecha sys
    console.log('fecha leccionario: ' + this.formato);//fecha leccionario
    console.log('usuario creador observacion: ' + this.usr_creacion);//usuario creador observacion
    console.log('id_asignatura: ' + this.mdl_asignatura);//id asignatura
    // console.log('id curso: ' + this.id_curso);//firma (nombre usuario?)
    // console.log('id curso: ' + this.id_curso);//fecha modificacion
    // console.log('id curso: ' + this.id_curso);//usuario modificacion
    // console.log('id curso: ' + this.id_curso);//fecha firma
    console.log(this.listaLeccionario);
    this.apiService.confirmarLeccionario(this.txt_descLeccionario, this.formato, this.usr_creacion, this.mdl_asignatura).subscribe(data=>{
      console.log(data);
      this.presentToast('Exito!','Leccionario registrado correctamente.');
      this.txt_descLeccionario= '';
      this.formato= '';
      this.usr_creacion= '';
      this.mdl_asignatura= 0;
      this.router.navigate(['inicio/leccionario'])
      
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
    console.log('onDidDismiss resolved with role', role)
}
}
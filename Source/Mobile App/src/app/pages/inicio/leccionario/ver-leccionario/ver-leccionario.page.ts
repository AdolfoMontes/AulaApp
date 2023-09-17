import { Attribute, Component, OnInit, ViewChild } from '@angular/core';
import { IonDatetime, ModalController, PickerController, ToastController } from '@ionic/angular';
import { format, parseISO } from 'date-fns';
import { ApiService } from 'src/app/sevices/api.service';
import { Nivel } from 'src/app/interface/nivel';
import { Curso } from 'src/app/interface/curso';
import { Asignatura } from 'src/app/interface/asignatura';
import { Leccionario } from 'src/app/interface/leccionario';
@Component({
  selector: 'app-ver-leccionario',
  templateUrl: './ver-leccionario.page.html',
  styleUrls: ['./ver-leccionario.page.scss'],
})
export class VerLeccionarioPage implements OnInit {

  listaNivel: Nivel[] = [];
  listaCursos: Curso[] =[];
  listaAsignatura: Asignatura[] = [];
  listaLeccionario: Leccionario[] = [];

  mdl_curso: Curso;
  mdl_nivel: number;
  mdl_asignatura: any;
  mostrarNivel: boolean= false; 
  mostrarCurso: boolean= false; 
  mostrarAsignatura: boolean = false;
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
  isEnabled = true;
  @ViewChild(IonDatetime) datetime: IonDatetime;
  @ViewChild(ModalController,) modalhdv: ModalController;

  constructor( public _pickerCtrl: PickerController,
    public apiService: ApiService,
    public toastController: ToastController,
    public modalController: ModalController) {
      this.fechaSyst();
      this.setHoy();
      console.log(this.formato);
      this.apiService.recuperarDatosUsuario(localStorage.getItem('userLogged')).subscribe(data=>{
        this.lista = [this.apiService.usuarioLogueado];
        console.log(this.lista);
        }
        );
      this.usr_creacion = this.apiService.usuarioLogueado.runUsuario;

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
  cerrarModal() {

    this.modalController.dismiss({
      'dismissed': true
    });
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
      this.presentToastWithOptions('Sin resultados','La búsqueda no arrojó resultados.')
       this.mdl_curso = undefined;
        this.mdl_asignatura = '';
    }
    );    

  }

  onChange(selectedValue){
    console.log("Selected:",selectedValue);
    if(this.mostrarCurso){
      this.mostrarAsignatura=true;
    }
  }

  obtenerCursoApi(){
    if(this.mdl_nivel === undefined){
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
    }
    this.listaCursos=[];
    this.apiService.obtenerCursos(this.mdl_nivel).subscribe(data => {
      for(let elemento in data){
        this.listaCursos.push(data[elemento]);}
        console.log(this.listaCursos);
        this.mostrarCurso = true;
    }, err =>{
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
    })
    ;     

  }

  obtenerAsignaturaApi(){
    if(this.mdl_curso === undefined){
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
    }
    this.listaAsignatura =[];
    this.apiService.obtenerAsignatura(this.mdl_curso).subscribe(data =>{
      for(let elemento in data){
        this.listaAsignatura.push(data[elemento]); 
        console.log(this.listaAsignatura)
        
      }
      
      // console.log(this.id_curso);
    }, err =>{
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.');
    })
  }

  obtenerLeccionario(){
    if(this.mdl_asignatura === undefined){
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
    }else{
      this.listaLeccionario=[];
      this.formato;

      this.apiService.obtenerLeccionario(this.mdl_asignatura, this.formato).subscribe(data=>{
        console.log(data);
        for(let elemento in data){
          this.listaLeccionario.push(data[elemento]);
          console.log(this.listaLeccionario);
          this.isEnabled=false;
        }
      },err =>{
        this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
        this.mdl_curso=undefined;
        this.mdl_asignatura='';
        this.mdl_nivel = undefined;
        this.mostrarCurso = false;
        this.mostrarAsignatura = false;
        this.isEnabled = true;
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

  async presentToast(header,message) {
    const toast = await this.toastController.create({
      position: 'bottom',
      message: message,
      duration: 3000
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
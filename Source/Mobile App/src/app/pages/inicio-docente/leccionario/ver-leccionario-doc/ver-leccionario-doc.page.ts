import { Component, OnInit, ViewChild } from '@angular/core';
import { PickerController, ModalController, ToastController, IonDatetime } from '@ionic/angular';
import { format, parseISO } from 'date-fns';
import { ApiService } from 'src/app/sevices/api.service';
import { Nivel } from 'src/app/interface/nivel';
import { Curso } from 'src/app/interface/curso';
import { Alumno } from 'src/app/interface/alumno';
import { Asistencia } from 'src/app/interface/asistencia';
import { Router } from '@angular/router';
import { Leccionario } from 'src/app/interface/leccionario';

@Component({
  selector: 'app-ver-leccionario-doc',
  templateUrl: './ver-leccionario-doc.page.html',
  styleUrls: ['./ver-leccionario-doc.page.scss'],
})
export class VerLeccionarioDocPage implements OnInit {

  runDocente: string;
  listaNivel: Nivel[] = [];
  listaCursos: Curso[] =[];
  listaAlumnos: Alumno[] = [];
  listaAsistencia: Asistencia[] =[];
  listaLeccionario: Leccionario[] = [];

  mdl_curso: any;
  mdl_asignatura:any;
  formato ='';
  cleanBack:boolean;
 
  lista: [{}];
  @ViewChild(ModalController,) modalhdv: ModalController;

 
  constructor(public _pickerCtrl: PickerController, 
    public modalController: ModalController,
    public apiService: ApiService,
    public toastController: ToastController,
    public router: Router) {
     }

  

  ngOnInit() {
    this.formato = localStorage.getItem('fecha');
    console.log('fecha formato:: '+localStorage.getItem('fecha'))

    this.mdl_asignatura = localStorage.getItem('idAsignatura');
    console.log('id asignatura mdl:: '+this.mdl_asignatura);
    // this.mdl_curso = localStorage.getItem('idCurso');
    // console.log('id curso:: '+localStorage.getItem('idCurso'))
  
  
  this.apiService.recuperarDatosUsuario(localStorage.getItem('userLogged')).subscribe(data=>{
    this.lista = [this.apiService.usuarioLogueado];
    // console.log(this.lista);
    this.runDocente = localStorage.getItem('userLogged');
    console.log(this.runDocente);
    
  }
  );
  
  this.obtenerLeccionario();
  }


  onChange(selectedValue){
    
    console.log("Selected:",selectedValue);
    
  }



  obtenerLeccionario(){
    if(this.mdl_asignatura === undefined){
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
    }else{
      this.listaLeccionario=[];
      this.apiService.obtenerLeccionario(this.mdl_asignatura, this.formato).subscribe(data=>{
      // this.apiService.obtenerLeccionario(this.mdl_asignatura, '04-07-2022').subscribe(data=>{
        console.log(data);
        
        for(let elemento in data){
          this.listaLeccionario.push(data[elemento]);
        }
        console.log(this.listaLeccionario);

      },err =>{
        this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
        this.router.navigate(['inicio-docente/leccionario']);
        // this.mdl_curso=undefined;
        // this.mdl_asignatura='';
        // this.mdl_nivel = undefined;
        // this.mostrarCurso = false;
        // this.mostrarAsignatura = false;
        // this.isEnabled = true;
      });   
    }
  }

  irInicioDocente(){
    this.router.navigate(['inicio-docente']).then(()=>{
      window.location.reload();
    });
  }

  atras(){
    this.router.navigate(['inicio-docente/leccionario']).then(()=>{
      window.location.reload();
    });
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


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
  selector: 'app-ver-asistencia-doc',
  templateUrl: './ver-asistencia-doc.page.html',
  styleUrls: ['./ver-asistencia-doc.page.scss'],
})
export class VerAsistenciaDocPage implements OnInit {
  runDocente: string;
  listaNivel: Nivel[] = [];
  listaCursos: Curso[] =[];
  listaAlumnos: Alumno[] = [];
  listaAsistencia: Asistencia[] =[];
  listaCurso: Curso[] = [];


  mdl_curso: any;
  formato ='';

 
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
    console.log('fecha storage:: '+localStorage.getItem('fecha'))
    console.log('fecha formato:: '+this.formato)
    this.mdl_curso = localStorage.getItem('idCurso');
    console.log('id curso:: '+localStorage.getItem('idCurso'))
    this.apiService.recuperarDatosUsuario(localStorage.getItem('userLogged')).subscribe(data=>{
      this.lista = [this.apiService.usuarioLogueado];
      // console.log(this.lista);
      this.runDocente = localStorage.getItem('userLogged');
      console.log(this.runDocente);
      
    }
    );
    this.obtenerAsistencia();
    this.infoCurso();
  }

  infoCurso(){
    this.listaCurso=[];
    this.apiService.obtenerInfoCursos(this.mdl_curso).subscribe(data=>{
      console.log(data);
      for(let elemento in data){
        this.listaCurso.push(data[elemento]);
      }
      
    })
  }

  onChange(selectedValue){
    
    console.log("Selected:",selectedValue);
    
  }



  obtenerAsistencia(){
    console.log(this.formato);
    
    if(this.mdl_curso === undefined){
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
    }else{
      
      this.listaAsistencia = []; 
      this.apiService.obtenerAsistencia(this.mdl_curso, this.formato).subscribe(data =>{
      // this.apiService.obtenerAsistencia(this.mdl_curso, '03-07-2022').subscribe(data =>{

        for(let elemento in data){
          this.listaAsistencia.push(data[elemento]);
        }
        console.log(this.listaAsistencia);
       

      },err =>{     
        this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
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

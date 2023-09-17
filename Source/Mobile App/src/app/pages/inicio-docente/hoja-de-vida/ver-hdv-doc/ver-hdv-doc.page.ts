import { Component, OnInit, ViewChild } from '@angular/core';
import { PickerController, ModalController, ToastController } from '@ionic/angular';
import { ApiService } from 'src/app/sevices/api.service';
import { Nivel } from 'src/app/interface/nivel';
import { Curso } from 'src/app/interface/curso';
import { Alumno } from 'src/app/interface/alumno';
import { Observacion } from 'src/app/interface/observacion';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ver-hdv-doc',
  templateUrl: './ver-hdv-doc.page.html',
  styleUrls: ['./ver-hdv-doc.page.scss'],
})
export class VerHdvDocPage implements OnInit {

  constructor(public _pickerCtrl: PickerController, 
    public modalController: ModalController,
    public apiService: ApiService,
    public toastController: ToastController,
    private router: Router) {
      
     }
     runDocente: string;
  listaNivel: Nivel[] = [];
  listaCursos: Curso[] =[];
  listaAlumnos: Alumno[] = [];
  listaObservacion: Observacion[] = [];
  mdl_curso: any;
  mdl_nivel: any;
  mdl_alumno: any;

  formato ='';
  
  lista: [{}];
  
  mostrarAlumno: boolean = true;
  mostrarCardObs: boolean = false;

  nivel:Nivel;

  isEnabled=false;
  formatoAlum ='';
  @ViewChild(ModalController,) modalhdv: ModalController;

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
    this.obtenerAlumnosApi();
    
  }


  onChangeAlumno(selectedValue){
    console.log("Selected:",selectedValue);
    this.mostrarCardObs = true;
    if(this.mostrarCardObs){
      this.obtenerObservacionApi();
    }
    // this.mostrarCurso = true;
    // if(this.mostrarCurso === true){
    //   this.mostrarAlumno = true;

    // }
  }
  onChange(selectedValue){
    console.log("Selected:",selectedValue);
    console.log(this.listaObservacion);
    
    // this.mostrarCurso = true;
    // if(this.mostrarCurso === true){
    //   this.mostrarAlumno = true;

    // }
  }


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
      // this.mostrarAlumno = true;
      
      
    }, err =>{
      this.presentToastWithOptions('Sin resultados','La búsqueda no arrojó resultados.');
      // this.mostrarAlumno = false;
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
      
    },err =>{      
      this.presentToastWithOptions('Sin resultados','La búsqueda no arrojó resultados.')
      this.mostrarAlumno = true;
      this.mostrarCardObs = false;
      this.mdl_alumno = '';
      
    });
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


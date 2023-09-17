import { Component, OnInit } from '@angular/core';
import { ToastController } from '@ionic/angular';
import { ApiService } from 'src/app/sevices/api.service';
import { Nivel } from 'src/app/interface/nivel';
import { Curso } from 'src/app/interface/curso';
import { Alumno } from 'src/app/interface/alumno';
import { Router } from '@angular/router';
import { Asignatura } from 'src/app/interface/asignatura';
import { Nota } from 'src/app/interface/nota';
import { WebElementCondition } from 'selenium-webdriver';


@Component({
  selector: 'app-mostrar-notas-doc',
  templateUrl: './mostrar-notas-doc.page.html',
  styleUrls: ['./mostrar-notas-doc.page.scss'],
})
export class MostrarNotasDocPage implements OnInit {

  runDocente: string;
  listaNivel: Nivel[] = [];
  listaCursos: Curso[] =[];
  listaAlumnos: Alumno[] = [];
  listaAsignatura: Asignatura[] = [];
  listaNotas: Nota[]=[];
  mdl_curso: any;
  mdl_nivel: any;
  mdl_alumno: any;
  mdl_asignatura: any;
  mdl_periodo: any;
  formato ='';
  lista: [{}];
  mostrarAlumno: boolean= true;
  mostrarPeriodo: boolean= false;
  mostrarNotas: boolean= true;

 
  mostrarAsignatura: boolean= true;
  mostrarCerrarModal: boolean= true;
  nivel:Nivel;
  formatoAsignatura: string = '';
  formatoAlum: number;
  formatoPeriodo: string = '';
  formatoAnio: number;
  isDisabledThis = true;
  isDisabledAll = true;
 
  listaPeriodo: Array<any> =[
    {
      semestre:'1',
    },
    {
      semestre:'2'
    }
  ]

  constructor(public apiService: ApiService,
    public toastController: ToastController,
    public router: Router) { }

  ngOnInit() {
    this.formato = localStorage.getItem('fecha');
    console.log('fecha formato:: '+localStorage.getItem('fecha'))

    this.mdl_asignatura = localStorage.getItem('idAsignatura');
    console.log('id asignatura mdl:: '+this.mdl_asignatura);
 
  
    this.apiService.recuperarDatosUsuario(localStorage.getItem('userLogged')).subscribe(data=>{
      this.lista = [this.apiService.usuarioLogueado];
      // console.log(this.lista);
      this.runDocente = localStorage.getItem('userLogged');
      console.log(this.runDocente);
      
    }
    );
    this.obtenerAlumnosApi();

  }

  obtenerAlumnosApi(){
    this.listaAlumnos =[];
    this.apiService.obtenerAlumnosAsignatura(this.mdl_asignatura).subscribe(data =>{
      for(let elemento in data){
        this.listaAlumnos.push(data[elemento]);
        console.log(data[elemento]);

        this.mdl_curso = data[elemento]['ID_CURSO'];
        
        
        // this.listaNotas = this.listaAlumnos; 
      }

      // console.log(this.listaNotas);
      // console.log(this.mdl_alumno);
      // console.log(data);
      // console.log(this.listaAlumnos);
      // this.mostrarAlumno=true;

    }, err =>{
      this.errorGenerico('Error','La búsqueda no arrojó resultados.');
    })
  }
  
  onChangeAlum(){
    this.mostrarPeriodo = true;
    this.mdl_periodo='';
  }
  
  onChangePer(){
    this.isDisabledThis = false;
    this.isDisabledAll = false;
    this.mostrarNotas = false;
  }

  estaAsignatura(){
    this.obtenerNotas();
  }
  todasAsignaturas(){
    this.obtenerNotasTodas();
  }

  mostrarNotasCard(){
    this.mostrarNotas=true;
    // this.isEnable=false;
  }
  
  obtenerNotas(){
    this.mostrarNotasCard();

    this.listaNotas = [];
    this.apiService.obtenerNotasAsignatura(this.mdl_alumno, this.mdl_asignatura, this.mdl_periodo).subscribe(data=>{
      console.log(data);
      for(let elemento in data){
        this.listaNotas.push(data[elemento]);
      }
      console.log(this.listaNotas);

    });

  }
  obtenerNotasTodas(){
    this.mostrarNotasCard();

    this.listaNotas = [];
    this.apiService.obtenerNotas(this.mdl_alumno, this.mdl_curso, this.mdl_periodo).subscribe(data=>{
      console.log(data);
      for(let elemento in data){
        this.listaNotas.push(data[elemento]);
      }
      console.log(this.listaNotas);

    });

  }

  irInicioDocente(){
    this.router.navigate(['inicio-docente']).then(()=>{
      window.location.reload();
    });
  }

  atras(){
    this.router.navigate(['inicio-docente/notas']);
    this.mdl_alumno='';
    this.mdl_periodo='';
    this.mostrarNotas=false;
  }

  refresh(){
    window.location.reload();
  }
  

  async errorGenerico(header, message) {
    const toast = await this.toastController.create({
      position: 'top',
      header: header,
      icon: 'close-circle',
      message: message,
      duration: 2000,
      color: 'danger'
    });
    toast.present();
  }
  async alertaConfirmacion(header, message) {
    const toast = await this.toastController.create({
      position: 'top',
      header: header,
      message: message,
      duration: 2000,
      color:'success',
      icon:'checkmark'
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

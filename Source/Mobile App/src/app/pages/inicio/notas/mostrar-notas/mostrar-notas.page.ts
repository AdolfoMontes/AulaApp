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
  selector: 'app-mostrar-notas',
  templateUrl: './mostrar-notas.page.html',
  styleUrls: ['./mostrar-notas.page.scss'],
})
export class MostrarNotasPage implements OnInit {

  listaNivel: Nivel[] = [];
  listaCursos: Curso[] =[];
  listaAlumnos: Alumno[] = [];
  listaAsignatura: Asignatura[] = [];
  listaNotas: Nota[]=[];
  mdl_curso: Curso;
  mdl_nivel: number;
  mdl_alumno: Alumno;
  mdl_asignatura: any;
  mdl_periodo: any;
  mostrarNivel: boolean= true;
  mostrarCurso: boolean= false;
  mostrarAlumno: boolean= false;
  mostrarAsignatura: boolean= false;
  mostrarPeriodo: boolean= false;
  mostrarNotas: boolean= false;
  mostrarCerrarModal: boolean= false;
  nivel:Nivel;
  formatoAsignatura: string = '';
  formatoAlum: number;
  formatoPeriodo: string = '';
  formatoAnio: number;
  isEnable=true;
 
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
    this.obtenerNIvelApi();
  }

  obtenerNIvelApi(){

    this.apiService.obtenerNiveles().subscribe(data => {
      for(let elemento in data){
        
        this.listaNivel.push(data[elemento]);
        // console.log(data);
        
      }
    });    
  }

  onChange(selectedValue){
    console.log("Selected:",selectedValue);
    this.mostrarCurso = true;
    if(this.mostrarCurso === true){
      this.mostrarAsignatura = true;
      // if(this.mostrarAsignatura){
      // }
      // this.mostrarAlumno = true;
      // this.mostrarPeriodo = true;
    }
    if(this.mostrarAlumno){
      this.mostrarPeriodo = true;  
    }
    
  }

  obtenerCursoApi(){
    this.listaCursos=[];
    this.apiService.obtenerCursos(this.mdl_nivel).subscribe(data => {
      for(let elemento in data){
        this.listaCursos.push(data[elemento]);}
    }, err =>{
      this.presentToastWithOptions('Sin resultados','La búsqueda no arrojó resultados.')
    })
    ;    

  }
  obtenerValor(valor){
    this.mdl_nivel = valor;
  }
  mostrarNotasCard(){
    this.mostrarNotas=true;
    this.isEnable=false;
  }
  

  obtenerAsignaturaApi(){
    
    this.listaAsignatura =[];
    this.apiService.obtenerAsignatura(this.mdl_curso).subscribe(data =>{
      for(let elemento in data){
        this.listaAsignatura.push(data[elemento]); 
        console.log(this.listaAsignatura);
        for(let atrib of this.listaAsignatura){
          console.log(atrib.ANIO);
          
          this.formatoAnio = atrib.ANIO;
        }
      
        // this.listaLeccionario = this.listaAsignatura;
        // for(let atrib of this.listaLeccionario){
          //   this.id_asignatura = atrib.ID_ASIGNATURA;
          //   console.log(atrib.ID_ASIGNATURA);      
          // }
          
        }
        
        // console.log(this.listaAsignatura);
      // console.log(this.id_curso);
     
    }, err =>{
      this.presentToastWithOptions('Sin resultados','La búsqueda no arrojó resultados.');
    })
    
    
  }
  
  obtenerAlumnosApi(){
    this.listaAlumnos =[];
    this.apiService.obtenerAlumnos(this.mdl_curso).subscribe(data =>{
      for(let elemento in data){
        this.listaAlumnos.push(data[elemento]);   
      }
      for(let atrib of this.listaAlumnos){
        console.log(atrib.RUN);
        console.log(atrib.RUNALUMNO);
        this.formatoAlum = atrib.RUN;
      }    
      console.log(data);
      // console.log(this.listaAlumnos);

      // this.apiService.listaAlumnos = this.listaAlumnos;

      this.mostrarAlumno=true;
      
    }, err =>{
      this.presentToastWithOptions('Sin resultados','La búsqueda no arrojó resultados.');
    })
  }

  obtenerNotas(){
    this.mostrarNotasCard();
    
    this.listaNotas = [];
    console.log(this.formatoAlum);
    console.log(this.mdl_curso);
    console.log(this.mdl_periodo);
    
    this.apiService.obtenerNotas(this.formatoAlum, this.mdl_curso, this.mdl_periodo).subscribe(data=>{
      console.log(data);
      for(let elemento in data){
        this.listaNotas.push(data[elemento]);
      }
      console.log(this.listaNotas);

    });

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

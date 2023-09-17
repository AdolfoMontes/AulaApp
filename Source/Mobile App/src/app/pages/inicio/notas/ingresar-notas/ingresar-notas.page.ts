import { Component, OnInit } from '@angular/core';
import { ToastController } from '@ionic/angular';
import { ApiService } from 'src/app/sevices/api.service';
import { Nivel } from 'src/app/interface/nivel';
import { Curso } from 'src/app/interface/curso';
import { Alumno } from 'src/app/interface/alumno';
import { Router } from '@angular/router';
import { Asignatura } from 'src/app/interface/asignatura';
import { Nota } from 'src/app/interface/nota';

@Component({
  selector: 'app-ingresar-notas',
  templateUrl: './ingresar-notas.page.html',
  styleUrls: ['./ingresar-notas.page.scss'],
})
export class IngresarNotasPage implements OnInit {

  listaNivel: Nivel[] = [];
  listaCursos: Curso[] =[];
  listaAlumnos: Alumno[] = [];
  listaAsignatura: Asignatura[] = [];
  listaNotas: Nota[]=[];
  mdl_curso: Curso;
  mdl_nivel: number;
  mdl_alumno: any;
  mdl_asignatura: any;
  mdl_periodo: any;
  mostrarNivel: boolean= true;
  mostrarCurso: boolean= false;
  mostrarAlumno: boolean= false;
  mostrarAsignatura: boolean= false;
  mostrarPeriodo: boolean= false;
  mostrarNotas: boolean= false;
  nivel:Nivel;
  formatoAsignatura: string = '';
  formatoAlum: number;
  formatoPeriodo: string = '';
  formatoAnio: number;
  isEnabled = true;
  listaPeriodo: Array<any> =[
    {
      semestre:'1',
    },
    {
      semestre:'2'
    }
  ]

  notasForm = {
    nota1:'',
    nota2:'',
    nota3:'',
    nota4:'',
    nota5:'',
    nota6:'',
    nota7:'',
    nota8:'',
    nota9:'',
    nota10:''
  }
  
  constructor(public apiService: ApiService,
    public toastController: ToastController,
    public router: Router) { }

  ngOnInit() {
    this.obtenerNIvelApi();
  }

  // maxDigitos():boolean{
  //   let pattern = /^\d+\.?\d{0,1}$/;
  //   let result = pattern.test(this.notasForm.nota1);
  //   if (!result) 
  //     this.notasForm.nota1 = this.old_price;
  //   else 
  //     this.old_price = this.notasForm.nota1;
  //   return result;
  // }

  maxDigitos(event): boolean
  {
    let pattern = /^\d\,?\d{0,1}$/;
    let result = pattern.test(event.key);
    if (this.notasForm.nota1 == null)
      return result;
    else
      return pattern.test(this.notasForm.nota1.toString() + event.key);
  }

  obtenerNIvelApi(){
        this.mdl_alumno =undefined;
        this.mdl_asignatura=undefined;
        this.mdl_curso=undefined;
        this.mdl_nivel=undefined;
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
    if(this.mostrarAlumno){
      this.mostrarPeriodo=true;
    }
    if(this.mostrarPeriodo){
      this.mostrarNotasCard;
    }
  }

  obtenerCursoApi(){
    this.listaCursos=[];
    if(this.mdl_nivel===undefined){
      this.errorGenerico('Error','La búsqueda no arrojó resultados.')
      this.mostrarCurso = false;
    }else{

      this.apiService.obtenerCursos(this.mdl_nivel).subscribe(data => {
        for(let elemento in data){
          this.listaCursos.push(data[elemento]);}
          this.mostrarCurso = true;
      }, err =>{
        this.errorGenerico('Error','La búsqueda no arrojó resultados.')
        this.mostrarCurso = false;
      })
      ;    
    }

  }
  obtenerValor(valor){
    this.mdl_nivel = valor;
  }
  mostrarNotasCard(){

    this.mostrarNotas=true;
    if(this.mostrarAlumno){
      this.isEnabled= false;
    }
    this.obtenerNotas();
    console.log(this.obtenerNotas());
    
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
        }
        console.log(this.listaAsignatura);
      // console.log(this.id_curso);
      this.mostrarAsignatura = true;
      
    }, err =>{
      this.errorGenerico('Error','La búsqueda no arrojó resultados.');
    })
    
  }
  obtenerAlumnosApi(){
    this.listaAlumnos =[];
    this.apiService.obtenerAlumnos(this.mdl_curso).subscribe(data =>{
      for(let elemento in data){
        this.listaAlumnos.push(data[elemento]);
        // this.listaNotas = this.listaAlumnos; 
      }

      // console.log(this.listaNotas);
      // console.log(this.mdl_alumno);
      // console.log(data);
      // console.log(this.listaAlumnos);
      this.mostrarAlumno=true;

    }, err =>{
      this.errorGenerico('Error','La búsqueda no arrojó resultados.');
    })
  }

  obtenerNotas(){
    this.apiService.obtenerNotas(this.mdl_alumno, this.mdl_curso, this.mdl_periodo).subscribe(data=>{
      console.log(data);
      for(let elemento in data){
        this.listaNotas.push(data[elemento]);
        if(this.mdl_asignatura===data[elemento].ID_ASIGNATURA){
          if(this.mdl_periodo==1){
            this.notasForm.nota1= data[elemento].N1;
            this.notasForm.nota2= data[elemento].N2;
            this.notasForm.nota3= data[elemento].N3;
            this.notasForm.nota4= data[elemento].N4;
            this.notasForm.nota5= data[elemento].N5;
            this.notasForm.nota6= data[elemento].N6;
            this.notasForm.nota7= data[elemento].N7;
            this.notasForm.nota8= data[elemento].N8;
            this.notasForm.nota9= data[elemento].N9;
            this.notasForm.nota10= data[elemento].N10;
          }else{
            this.notasForm.nota1= data[elemento].N11;
            this.notasForm.nota2= data[elemento].N12;
            this.notasForm.nota3= data[elemento].N13;
            this.notasForm.nota4= data[elemento].N14;
            this.notasForm.nota5= data[elemento].N15;
            this.notasForm.nota6= data[elemento].N16;
            this.notasForm.nota7= data[elemento].N17;
            this.notasForm.nota8= data[elemento].N18;
            this.notasForm.nota9= data[elemento].N19;
            this.notasForm.nota10= data[elemento].N20;

          }
        
          }
      }
      // console.log(this.listaNotas);
  
    });
  }

  ingresarNotas(){ 
    
    this.apiService.ingresarNotas(this.mdl_alumno, this.mdl_asignatura, this.formatoAnio, this.notasForm.nota1, this.notasForm.nota2, this.notasForm.nota3, this.notasForm.nota4, this.notasForm.nota5, this.notasForm.nota6, this.notasForm.nota7, this.notasForm.nota8, this.notasForm.nota9, this.notasForm.nota10, this.mdl_periodo).subscribe(data=>{
      console.log(data);
      if(data['outBinds']['resultado'] ==='-1'){
        this.errorGenerico('Error','No se pudo insertar correctamente');
      }else{
        console.log('se inserto');
        this.alertaConfirmacion('Éxito','Notas añadidas correctamente');
        this.notasForm.nota1='';
        this.notasForm.nota2='';
        this.notasForm.nota3='';
        this.notasForm.nota4='';
        this.notasForm.nota5='';
        this.notasForm.nota6='';
        this.notasForm.nota7='';
        this.notasForm.nota8='';
        this.notasForm.nota9='';
        this.notasForm.nota10='';
        this.mdl_periodo = '';
        this.mdl_alumno =undefined;
        this.mdl_asignatura=undefined;
        this.mdl_curso=undefined;
        // this.mdl_nivel=undefined;
        this.mostrarNotas=false;
        this.mostrarPeriodo=false;
        this.mostrarAlumno=false;
        this.mostrarAsignatura=false;
        this.mostrarCurso=false;
        this.mostrarNivel=true;

        this.router.navigate(['inicio/notas/ingresar-notas']);
      }
      
    })
      
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

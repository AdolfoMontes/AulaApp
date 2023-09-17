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
  selector: 'app-ingresar-notas-doc',
  templateUrl: './ingresar-notas-doc.page.html',
  styleUrls: ['./ingresar-notas-doc.page.scss'],
})
export class IngresarNotasDocPage implements OnInit {
  
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
  mdl_anio_asignatura:any;
  mdl_periodo: any;
  formato ='';
  lista: [{}];
  isDisabled = true;

  mostrarLimpiar: boolean = false;
  mostrarAlumno: boolean= true;
  mostrarPeriodo: boolean= false;
  mostrarNotas: boolean= false;
  nivel:Nivel;
  formatoAsignatura: string = '';
  formatoAlum: number;
  formatoPeriodo: string = '';
  formatoAnio: number;
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
    this.formato = localStorage.getItem('fecha');
    console.log('fecha formato:: '+localStorage.getItem('fecha'))

    this.mdl_asignatura = localStorage.getItem('idAsignatura');
    console.log('id asignatura mdl:: '+this.mdl_asignatura);
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

  obtenerAlumnosApi(){
    this.listaAlumnos =[];
    this.apiService.obtenerAlumnosAsignatura(this.mdl_asignatura).subscribe(data =>{
      for(let elemento in data){
        this.listaAlumnos.push(data[elemento]);
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

  obtenerNotasAsignatura(){     
    this.apiService.obtenerNotasAsignatura(this.mdl_alumno, this.mdl_asignatura, this.mdl_periodo).subscribe(data=>{
      console.log(data);
      for(let elemento in data){
        this.listaNotas.push(data[elemento]);
        // console.log('AÑO ASIGNATURA:' +data[elemento]['ANIO']);
        this.mdl_anio_asignatura =data[elemento]['ANIO'];
        
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
      // console.log(this.listaNotas);
  
    });
  }
  
  maxDigitos1(event): boolean
  {
    let pattern = /^\d\.?\d{0,1}$/;
    let result = pattern.test(event.key);
    if (this.notasForm.nota1 == null)
      return result;
    else
      return pattern.test(this.notasForm.nota1.toString() + event.key);
  }
  maxDigitos2(event): boolean
  {
    let pattern = /^\d\.?\d{0,1}$/;
    let result = pattern.test(event.key);
    if (this.notasForm.nota2 == null)
      return result;
    else
      return pattern.test(this.notasForm.nota2.toString() + event.key);
  }
  maxDigitos3(event): boolean
  {
    let pattern = /^\d\.?\d{0,1}$/;
    let result = pattern.test(event.key);
    if (this.notasForm.nota3 == null)
      return result;
    else
      return pattern.test(this.notasForm.nota3.toString() + event.key);
  }
  maxDigitos4(event): boolean
  {
    let pattern = /^\d\.?\d{0,1}$/;
    let result = pattern.test(event.key);
    if (this.notasForm.nota4== null)
      return result;
    else
      return pattern.test(this.notasForm.nota4.toString() + event.key);
  }
  maxDigitos5(event): boolean
  {
    let pattern = /^\d\.?\d{0,1}$/;
    let result = pattern.test(event.key);
    if (this.notasForm.nota5 == null)
      return result;
    else
      return pattern.test(this.notasForm.nota5.toString() + event.key);
  }
  maxDigitos6(event): boolean
  {
    let pattern = /^\d\.?\d{0,1}$/;
    let result = pattern.test(event.key);
    if (this.notasForm.nota6 == null)
      return result;
    else
      return pattern.test(this.notasForm.nota6.toString() + event.key);
  }
  maxDigitos7(event): boolean
  {
    let pattern = /^\d\.?\d{0,1}$/;
    let result = pattern.test(event.key);
    if (this.notasForm.nota7 == null)
      return result;
    else
      return pattern.test(this.notasForm.nota7.toString() + event.key);
  }
  maxDigitos8(event): boolean
  {
    // let pattern = /^\d\.?\d{0,1}$/;
    let pattern = /^\d\.?\d{0,1}$/;
    // let pattern = /^\d*(?:[.,]\d{1,2})?$/;
    let result = pattern.test(event.key);
    if (this.notasForm.nota8 == null)
      return result;
    else
      return pattern.test(this.notasForm.nota8.toString() + event.key);
  }
  maxDigitos9(event): boolean
  {
    let pattern = /^\d\.?\d{0,1}$/;
    let result = pattern.test(event.key);
    if (this.notasForm.nota9 == null)
      return result;
    else
      return pattern.test(this.notasForm.nota9.toString() + event.key);
  }
  maxDigitos10(event): boolean
  {
    let pattern = /^\d\.?\d{0,1}$/;
    let result = pattern.test(event.key);
    if (this.notasForm.nota10 == null)
      return result;
    else
      return pattern.test(this.notasForm.nota10.toString() + event.key);
  }

  onChangeAlum(selectedValue){
    console.log("Selected:",selectedValue);
    this.mostrarPeriodo = true;
    this.mdl_periodo ='';
  }
  onChangePer(selectedValue){
    console.log("Selected:",selectedValue);
    this.mostrarNotasCard();
    this.isDisabled= false;
  }
  


  mostrarNotasCard(){ 
    this.mostrarNotas=true;
    // if(this.mostrarAlumno){
    //   this.isEnabled= false;
    // }
    this.obtenerNotasAsignatura();
    this.mostrarLimpiar = true;

    // this.obtenerNotas();
    // console.log(this.obtenerNotas());
  }
  // ocultarNotasCard(){
  //   this.mostrarNotas=false;

  // }

  
  ingresarNotas(){ 
    if(this.mdl_alumno == '' && this.mdl_periodo == ''){
      this.errorGenerico('Error','Debe seleccionar un/a alumn@ y un período');
    }
    else{
      this.apiService.ingresarNotas(this.mdl_alumno, this.mdl_asignatura, this.mdl_anio_asignatura, this.notasForm.nota1, this.notasForm.nota2, this.notasForm.nota3, this.notasForm.nota4, this.notasForm.nota5, this.notasForm.nota6, this.notasForm.nota7, this.notasForm.nota8, this.notasForm.nota9, this.notasForm.nota10, this.mdl_periodo).subscribe(data=>{
        console.log(data);
        if(data['outBinds']['resultado'] ==='-1'){
          this.errorGenerico('Error','No se pudo insertar correctamente - Recuerde seleccionar un alumno y un período');
        }else{
          console.log('se inserto');
          this.alertaConfirmacion('Éxito','Notas añadidas correctamente');
          // this.ocultarNotasCard();
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
          this.mdl_alumno = '';
          this.mostrarPeriodo=false;
          this.mostrarNotas=false;
          this.isDisabled=true;
          this.mostrarLimpiar = false;
          // this.mdl_asignatura=undefined;
          // this.mdl_curso=undefined;
          // this.mdl_nivel=undefined;
          // this.mostrarAlumno=false;
          // this.mostrarAsignatura=false;
          // this.mostrarCurso=false;
          // this.mostrarNivel=true;
          
          // this.router.navigate(['inicio-docente/notas/ingresar-notas-doc']);
        }
        
      })
      
    }
      
  }
  limpiarNotas(){
    this.mostrarNotas= false;
    this.mdl_periodo = '';
    this.mdl_alumno = undefined;
  }

  irInicioDocente(){
    this.router.navigate(['inicio-docente']).then(()=>{
      window.location.reload();
    });
  }

  atras(){
    this.router.navigate(['inicio-docente/notas']);
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


  // maxDigitos():boolean{
  //   let pattern = /^\d+\.?\d{0,1}$/;
  //   let result = pattern.test(this.notasForm.nota1);
  //   if (!result) 
  //     this.notasForm.nota1 = this.old_price;
  //   else 
  //     this.old_price = this.notasForm.nota1;
  //   return result;
  // }


  // obtenerNIvelApi(){
  //       this.mdl_alumno =undefined;
  //       this.mdl_asignatura=undefined;
  //       this.mdl_curso=undefined;
  //       this.mdl_nivel=undefined;
  //   this.apiService.obtenerNiveles().subscribe(data => {
  //     for(let elemento in data){
        
  //       this.listaNivel.push(data[elemento]);
  //       console.log(data);
        
  //     }
  //   });    

  // }

 
  
  // obtenerAsignaturaApi(){
    
  //   this.listaAsignatura =[];
  //   this.apiService.obtenerAsignatura(this.mdl_curso).subscribe(data =>{
  //     for(let elemento in data){
  //       this.listaAsignatura.push(data[elemento]); 
  //       console.log(this.listaAsignatura);
  //         for(let atrib of this.listaAsignatura){
  //           console.log(atrib.ANIO);         
  //           this.formatoAnio = atrib.ANIO;
  //         }   
  //       }
  //       console.log(this.listaAsignatura);
  //     // console.log(this.id_curso);
  //     this.mostrarAsignatura = true;
      
  //   }, err =>{
  //     this.errorGenerico('Error','La búsqueda no arrojó resultados.');
  //   })
    
  // }

  // guardarAlumno(){
  //   console.log(this.mdl_alumno);
  //   localStorage.setItem('idAlumno', this.mdl_alumno); 
  // }
  // guardarPeriodo(){
  //   console.log(this.mdl_periodo);
  //   localStorage.setItem('periodo', this.mdl_periodo);

  // }

  
  // obtenerNotas(){     
  //   this.apiService.obtenerNotas(this.mdl_alumno, this.mdl_curso, this.mdl_periodo).subscribe(data=>{
  //     console.log(data);
  //     for(let elemento in data){
  //       this.listaNotas.push(data[elemento]);
  //       if(this.mdl_asignatura===data[elemento].ID_ASIGNATURA){
  //         if(this.mdl_periodo==1){
  //           this.notasForm.nota1= data[elemento].N1;
  //           this.notasForm.nota2= data[elemento].N2;
  //           this.notasForm.nota3= data[elemento].N3;
  //           this.notasForm.nota4= data[elemento].N4;
  //           this.notasForm.nota5= data[elemento].N5;
  //           this.notasForm.nota6= data[elemento].N6;
  //           this.notasForm.nota7= data[elemento].N7;
  //           this.notasForm.nota8= data[elemento].N8;
  //           this.notasForm.nota9= data[elemento].N9;
  //           this.notasForm.nota10= data[elemento].N10;
  //         }else{
  //           this.notasForm.nota1= data[elemento].N11;
  //           this.notasForm.nota2= data[elemento].N12;
  //           this.notasForm.nota3= data[elemento].N13;
  //           this.notasForm.nota4= data[elemento].N14;
  //           this.notasForm.nota5= data[elemento].N15;
  //           this.notasForm.nota6= data[elemento].N16;
  //           this.notasForm.nota7= data[elemento].N17;
  //           this.notasForm.nota8= data[elemento].N18;
  //           this.notasForm.nota9= data[elemento].N19;
  //           this.notasForm.nota10= data[elemento].N20;

  //         }
        
  //         }
  //     }
  //     // console.log(this.listaNotas);
  
  //   });
  // }

}

import { Component, Input, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { NavController, ToastController} from '@ionic/angular';
import { Asignatura } from 'src/app/interface/asignatura';
import { Curso } from 'src/app/interface/curso';
import { Nivel } from 'src/app/interface/nivel';
import { ApiService } from 'src/app/sevices/api.service';

@Component({
  selector: 'app-inicio-docente',
  templateUrl: './inicio-docente.page.html',
  styleUrls: ['./inicio-docente.page.scss'],
})
export class InicioDocentePage implements OnInit {

  constructor(private router: Router,
     private apiService: ApiService,
     private toastController: ToastController,
     private navController: NavController) { }
  listaNivel: Nivel[] = [];
  listaCursos: Curso[] =[];
  listaAsignatura: Asignatura[] = [];

  lista: [{}];
  mdl_curso: any;
  mdl_nivel: any;
  mdl_asignatura: any;
  mostrarCurso: boolean = true;
  mostrarAsignatura: boolean= true;
  runDocente: string;

  isDisableCursos: boolean= true;
  isDisableAsignaturas: boolean= true;

  mostrarLeccionario: any;
  mostrarNotas: any;
  mostrarAsistencia: any;
  mostrarHdv: any;

  flag: any; 
  ngOnInit() {
    localStorage.removeItem('idCurso');
    localStorage.removeItem('idAsignatura');
      this.apiService.recuperarDatosUsuario(localStorage.getItem('userLogged')).subscribe(data=>{
      this.lista = [this.apiService.usuarioLogueado];
      console.log(this.lista);
      
      this.runDocente = localStorage.getItem('userLogged');
      console.log(this.runDocente);

      // this.obtenerNivelesDocente();   
      
      // this.obtenerNIvelApi();
      this.obtenerCursosDocente();
      this.obtenerAsignaturasDocente();
    }
    );

  }

  //PERFIL USUARIO
  mostrarPerfilUsuario() {
    this.router.navigate(['inicio-docente/perfil-usuario'])
  }
  


  //FILTRO CURSOS DEL DOCENTE
  obtenerCursosDocente(){
    this.listaCursos=[];
    this.apiService.obtenerCursosDocente(this.runDocente).subscribe(data=>{
      console.log(data);
      for(let elemento in data){
        this.listaCursos.push(data[elemento]);
        // console.log(data[elemento]['ID_CURSO']);
        // console.log(data[elemento]['COMPUESTO']);
        
      }
      console.log(this.mdl_curso);
      
      console.log(this.listaCursos);
      
      
    })
  }
  
  //FILTRO ASINGNATURAS DEL DOCENTE
  obtenerAsignaturasDocente(){
    this.listaAsignatura=[];
    this.apiService.obtenerAsignaturasDocente(this.runDocente).subscribe(data=>{
      for(let elemento in data){
        
           this.listaAsignatura.push(data[elemento]);      
                
          // this.mdl_anio_asignatura = data[elemento].ANIO
            // this.listaNivel.push(data[elemento]['ID_NIVEL'])

            // this.listaNivel.push(data[elemento]);
            
          }
          console.log(this.listaAsignatura)
        }, err=>{
          this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
        }); 
  }

  onChangeCur(selectedValue){
    console.log("Selected:",selectedValue);
    console.log('mdl curso-> '+this.mdl_curso);
    
    // this.isDisableCursos=false;
    this.irCursos();
    // this.obtenerCursoDocente();
    
    
    // this.obtenerNivelesDocente(this.runDocente);
    // console.log(this.lista);
    
    // console.log('nivel-> '+this.mdl_nivel);
    // console.log('curso-> '+this.mdl_curso);
    // this.mdl_curso=undefined;
    // this.mdl_nivel=undefined;
    // this.mostrarCurso = true;
  }
  
  onChangeAsig(selectedValue){
    console.log("Selected:",selectedValue);
    console.log(this.mdl_asignatura);
    
    // this.isDisableAsignaturas=false;
    this.irAsignaturas();
    // this.isDisableCursos=false;
    
    // console.log('asignatura-> '+this.mdl_asignatura);
    // console.log('curso-> '+this.mdl_curso);
    
    // this.obtenerNivelesDocente(this.runDocente);
    // this.obtenerCursoDocente(this.runDocente, this.mdl_nivel);
    // console.log(this.lista);
    
    // console.log('nivel-> '+this.mdl_nivel);
    // console.log('curso-> '+this.mdl_curso);
    // this.mdl_curso=undefined;
    // this.mdl_nivel=undefined;
    // this.mostrarCurso = true;
  }

  irCursos(){
    this.flag=1;
    localStorage.setItem('flag', this.flag);
    console.log('flag'+localStorage.getItem('flag'));
    


    this.mostrarAsistencia = 1;
    this.mostrarLeccionario = 0;
    this.mostrarNotas = 0;
    this.mostrarHdv = 1;

    localStorage.setItem('mostrarLeccionario', this.mostrarLeccionario);
    console.log('mostrar leccionario:: '+localStorage.getItem('mostrarLeccionario'));
    localStorage.setItem('mostrarNotas', this.mostrarNotas);
    console.log('mostrar notas:: '+localStorage.getItem('mostrarNotas'));
    localStorage.setItem('mostrarAsistencia', this.mostrarAsistencia);
    console.log('mostrar asistencia:: '+localStorage.getItem('mostrarAsistencia'));
    localStorage.setItem('mostrarHdv', this.mostrarHdv);
    console.log('mostrar hdv:: '+localStorage.getItem('mostrarHdv'));
    
    
    localStorage.setItem('idCurso', this.mdl_curso);
    console.log('id curso LS:: '+localStorage.getItem('idCurso'));
    // console.log('id curso mdl:: '+this.mdl_curso);
    this.router.navigate(['inicio-docente/main-docente']);
    // this.navController.navigateRoot('inicio-docente/main-docente');
    
  }
  // limpiarCur(){

  // }
  
  irAsignaturas(){
    this.flag=0;
    localStorage.setItem('flag', this.flag);
    console.log('flag'+localStorage.getItem('flag'));

   
    this.mostrarAsistencia = 0;
    this.mostrarLeccionario = 1;
    this.mostrarNotas = 1;
    this.mostrarHdv = 0;
    
    localStorage.setItem('mostrarLeccionario', this.mostrarLeccionario);
    console.log('mostrar leccionario:: '+localStorage.getItem('mostrarLeccionario'));
    localStorage.setItem('mostrarNotas', this.mostrarNotas);
    console.log('mostrar notas:: '+localStorage.getItem('mostrarNotas'));
    localStorage.setItem('mostrarAsistencia', this.mostrarAsistencia);
    console.log('mostrar asistencia:: '+localStorage.getItem('mostrarAsistencia'));
    localStorage.setItem('idAsignatura', this.mdl_asignatura);
    console.log('id asignatura LS :: '+localStorage.getItem('idAsignatura'));
    console.log('id asignatura mdl:: '+this.mdl_asignatura);
    localStorage.setItem('mostrarHdv', this.mostrarHdv);
    console.log('mostrar hdv:: '+localStorage.getItem('mostrarHdv'));

    this.router.navigate(['inicio-docente/main-docente']);

  }

  refresh(){
    window.location.reload();
  }
  
  //FILTRO ASIGNATURAS DEL DOCENTE
  // obtenerAsignaturasDocenteCurso(){
  //   this.listaAsignatura=[];
  //   this.mdl_nivel='';
  //   this.apiService.obtenerAsignaturasDocenteCurso(this.runDocente, this.mdl_curso).subscribe(data=>{
  //     for(let elemento in data){
        
  //          this.listaAsignatura.push(data[elemento]);
  //           this.mdl_nivel= data[elemento]['ID_NIVEL'];
  //           // this.listaNivel.push(data[elemento]['ID_NIVEL'])

  //           // this.listaNivel.push(data[elemento]);
            
  //         }
  //         console.log(this.listaAsignatura)
  //       }, err=>{
  //         this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
  //       });  
    
  // }



  // obtenerAsignaturasDocenteCurso(){

  //   this.listaAsignatura=[];
  //   this.apiService.obtenerAsignaturasDocente(this.runDocente).subscribe(data=>{
  //     for(let elemento in data){
        
  //          this.listaAsignatura.push(data[elemento]);
    
  //           // this.listaNivel.push(data[elemento]['ID_NIVEL'])

  //           // this.listaNivel.push(data[elemento]);
            
  //         }
  //         console.log(this.listaAsignatura)
  //       }, err=>{
  //         this.presentToastWithOptions('Sin resultados','La búsqueda no arrojó resultados.')
  //       });  
    
  // }

  

  // obtenerAsignaturasDocenteNivel(){

  //   this.listaAsignatura=[];
  //   this.apiService.obtenerAsignaturasDocenteNivel(this.runDocente, this.mdl_nivel).subscribe(data=>{
  //     for(let elemento in data){
        
  //          this.listaAsignatura.push(data[elemento]);
    
  //           // this.listaNivel.push(data[elemento]['ID_NIVEL'])

  //           // this.listaNivel.push(data[elemento]);
            
  //         }
  //         console.log(this.listaAsignatura)
  //       }, err=>{
  //         this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
  //       });  
    
  // }
 

  

  
  
  // guardarDataCursos(){
  //   localStorage.setItem('idNivel', this.mdl_nivel);
  //   localStorage.setItem('idCurso', this.mdl_curso);
    
  //   console.log(this.mdl_curso['COMPUESTO']);
    
  //   console.log('id nivel:: '+localStorage.getItem('idNivel'));
  //   console.log('id curso:: '+localStorage.getItem('idCurso'));
    
  // }


  // irMenuDocente(){
    
  //   this.presentToastWithOptions('Bien ahí joven','ahora a modulos principales '+'id curso: '+this.mdl_curso+'id asignatura: '+this.mdl_asignatura+'id nivel: '+this.mdl_nivel);
  //   console.log(this.mdl_curso);
  //   console.log(this.mdl_asignatura);
  //   console.log(this.mdl_nivel);
  //   this.router.navigate(['inicio-docente/main-docente']);
    
  // }

  // obtenerValor(valor){
  //   this.mdl_nivel = valor;
  // }



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

  async presentToast(header, message) {
    const toast = await this.toastController.create({
      position: 'bottom',
      header: header,
      message: message,
      duration: 2000,
      color: 'success'
    });
    await toast.present();
  }

  async presentToastWithOptions(header, message) {
    const toast = await this.toastController.create({
      header: header,
      message: message,
      icon: 'checkmark',
      position: 'top',
      color:'success',
      duration: 2000
      
    });
    await toast.present();

    const { role } = await toast.onDidDismiss();
    console.log('onDidDismiss resolved with role', role);
  }
}

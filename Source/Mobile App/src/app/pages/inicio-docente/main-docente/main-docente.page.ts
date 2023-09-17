import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastController} from '@ionic/angular';
import { format, parseISO } from 'date-fns';
import { Asignatura } from 'src/app/interface/asignatura';
import { Curso } from 'src/app/interface/curso';
import { ApiService } from 'src/app/sevices/api.service';

@Component({
  selector: 'app-main-docente',
  templateUrl: './main-docente.page.html',
  styleUrls: ['./main-docente.page.scss'],
})
export class MainDocentePage implements OnInit {

  runDocente: string;
  mdl_nivel: any;
  mdl_curso: any;
  mdl_asignatura: any;
  infoAsignatura: Asignatura[] = [];
  listaCurso: Curso[] = [];

  mostrarLeccionario: boolean= false;
  mostrarLeccionarioNum: any;
  mostrarNotas: boolean= false;
  mostrarNotasNum: any;
  mostrarAsistencia: boolean= false;
  mostrarAsistenciaNum: any;
  mostrarHdv: boolean= false;
  mostrarHdvNum: any;

  mostrarLabelCurso:boolean= false;
  mostrarLabelAsignatura:boolean= false;

  flag:any;
  constructor(private router: Router,
          private apiService: ApiService,
          private toastController: ToastController) {
                
    this.mdl_curso = localStorage.getItem('idCurso');
    console.log('id curso:: '+localStorage.getItem('idCurso'));
    
    this.mdl_asignatura = localStorage.getItem('idAsignatura');
    console.log('id Asignatura:: '+localStorage.getItem('idAsignatura'));

    this.flag = localStorage.getItem('flag');

    if(this.flag==1){
      this.infoCurso();

    }else if(this.flag==0){
      
      this.obtenerInfoAsignatura();
    }

    this.mostrarLeccionarioNum =localStorage.getItem('mostrarLeccionario');
    this.mostrarNotasNum =localStorage.getItem('mostrarNotas');
    this.mostrarAsistenciaNum =localStorage.getItem('mostrarAsistencia');
    this.mostrarHdvNum =localStorage.getItem('mostrarHdv');
    
    console.log('mostrar leccionario:: '+localStorage.getItem('mostrarLeccionario'));
    console.log('mostrar notas:: '+localStorage.getItem('mostrarNotas'));
    console.log('mostrar asistencia:: '+localStorage.getItem('mostrarAsistencia'));
    console.log('mostrar hdv:: '+localStorage.getItem('mostrarHdv'));
    
    
    if(this.mostrarLeccionarioNum==1){
      this.mostrarLeccionario= true;
    }else{
      this.mostrarLeccionario= false;
    }

    if(this.mostrarNotasNum==1){
      this.mostrarNotas= true;
      
    }else{
      this.mostrarNotas= false;
    }

    if(this.mostrarAsistenciaNum==1){
      this.mostrarAsistencia=true;
    }else{
      this.mostrarAsistencia=false;
    }
    if(this.mostrarHdvNum==1){
      this.mostrarHdv=true;
    }else{
      this.mostrarHdv=false;
    }
    

    this.apiService.recuperarDatosUsuario(localStorage.getItem('userLogged')).subscribe(data=>{
      this.lista = [this.apiService.usuarioLogueado];
      // console.log(this.lista);
      this.runDocente = localStorage.getItem('userLogged');
      console.log(this.runDocente);
      }
      );      
           }

  lista: [{}];
  ngOnInit() {

      
  }

  infoCurso(){
    // this.listaCurso.splice(0,this.listaCurso.length);
    this.listaCurso=[];
    this.apiService.obtenerInfoCursos(this.mdl_curso).subscribe(data=>{
      console.log(data);
      for(let elemento in data){
        this.listaCurso.push(data[elemento]);
      }
      
    })
    this.mostrarLabelCurso = true;
  }

  obtenerInfoAsignatura(){
    this.infoAsignatura=[];
    this.apiService.obtenerInfoAsignatura(this.mdl_asignatura).subscribe(data=>{
      console.log(data);
      for(let elemento in data){
        this.infoAsignatura.push(data[elemento]);
      }
    })
    this.mostrarLabelAsignatura = true;
  }



  mostrarPerfilUsuario() {
    this.router.navigate(['inicio/perfil-usuario'])
  }

  irAsistencia(){
    this.router.navigate(['inicio-docente/asistencia'])
  }

  irLeccionario(){
    this.router.navigate(['inicio-docente/leccionario'])
  //   this.router.navigate(['inicio-docente/leccionario']).then(()=>{
  //   window.location.reload();
  // });
  }
  
  irHojaDeVida(){
    this.router.navigate(['inicio-docente/hoja-de-vida'])
  }

  irNotas(){
    this.router.navigate(['inicio-docente/notas'])
  }

  irHorarios(){
    this.router.navigate(['inicio-docente/horarios'])
  }

  irInicioDocente(){
    this.router.navigate(['inicio-docente']).then(()=>{
      window.location.reload();
    });
  }
  atras(){
    this.router.navigate(['inicio-docente']);
    // this.router.navigate(['inicio-docente']).then(()=>{
    //   window.location.reload();
    // });
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

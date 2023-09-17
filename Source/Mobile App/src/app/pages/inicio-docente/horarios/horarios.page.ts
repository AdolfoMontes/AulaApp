import { Component, OnInit } from '@angular/core';
import { ToastController } from '@ionic/angular';
import { ApiService } from 'src/app/sevices/api.service';
import { Nivel } from 'src/app/interface/nivel';
import { Curso } from 'src/app/interface/curso';
import { Horario } from 'src/app/interface/horario';
import { Router } from '@angular/router';

@Component({
  selector: 'app-horarios',
  templateUrl: './horarios.page.html',
  styleUrls: ['./horarios.page.scss'],
})
export class HorariosPage implements OnInit {
  
  mostrarHorario:boolean=false;

  listaNivel: Nivel[] = [];
  listaCursos: Curso[] =[];
  listaHorarios: Horario[] = [];
  mdl_curso: any;
  mdl_asignatura: any;
  runDocente: string;
  lista: [{}];

  mdl_nivel: any;
  nivel:Nivel;
  isEnable=true;

  constructor(public apiService: ApiService,
    public toastController: ToastController,
    public router: Router) { }

  ngOnInit() {
    this.mdl_curso = localStorage.getItem('idCurso');
    console.log('id curso:: '+localStorage.getItem('idCurso'));

    this.mdl_asignatura = localStorage.getItem('idAsignatura');
    console.log('id asignatura mdl:: '+this.mdl_asignatura);
    this.apiService.recuperarDatosUsuario(localStorage.getItem('userLogged')).subscribe(data=>{
      this.lista = [this.apiService.usuarioLogueado];
      // console.log(this.lista);
      this.runDocente = localStorage.getItem('userLogged');
      console.log(this.runDocente);
      
    }
    );

    if(this.mdl_asignatura== null){
      this.obtenerHorarioCurso();

    }else{
      this.obtenerHorarioAsignatura();
    }
    this.listarHorarios();
  }

   obtenerHorarioCurso(){
    if(this.mdl_curso === undefined){
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
    }else{
      this.listaHorarios = [];
      this.apiService.obtenerHorarioCurso(this.mdl_curso).subscribe(data => {
        for(let elemento in data){
          this.listaHorarios.push(data[elemento]);
        }
        this.mostrarHorario = true;

      },err =>{
        this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
        this.router.navigate(['inicio-docente/main-docente']);
        
        this.mostrarHorario = false;
      });

    }
  }
   obtenerHorarioAsignatura(){
    if(this.mdl_curso === undefined){
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
    }else{
      this.listaHorarios = [];
      this.apiService.obtenerHorarioAsignatura(this.mdl_asignatura).subscribe(data => {
        for(let elemento in data){
          this.listaHorarios.push(data[elemento]);
        }
        this.mostrarHorario = true;

      },err =>{
        this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.');
        this.router.navigate(['inicio-docente/main-docente']);
        
        this.mostrarHorario = false;
      });

    }
  }

  listarHorarios(){
    this.listaHorarios;
    console.log(this.listaHorarios);
    
   // this.listaAsignaturasH = this.objetoAsignatura
    
  }

  irInicioDocente(){
    this.router.navigate(['inicio-docente']).then(()=>{
      window.location.reload();
    });
  }

  atras(){
    this.router.navigate(['inicio-docente/main-docente']);
    
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
      duration:2500,
      color: 'danger',
      buttons: ['Ok']
    });
    await toast.present();

    const { role } = await toast.onDidDismiss();
    console.log('onDidDismiss resolved with role', role)
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
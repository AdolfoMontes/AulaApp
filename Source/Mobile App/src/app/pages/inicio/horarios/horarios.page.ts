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

  mostrarNivel: boolean=true; 
  mostrarCurso: boolean=false; 

  listaNivel: Nivel[] = [];
  listaCursos: Curso[] =[];
  listaHorarios: Horario[] = [];
  mdl_curso: Curso;
  mdl_nivel: any;
  nivel:Nivel;
  isEnable=true;

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
      }
    });    

  }

  onChange(selectedValue){
    this.mdl_curso = undefined;
    console.log("Selected:",selectedValue);
    // this.mostrarCurso = true;
  }

  obtenerCursoApi(){
    if(this.mdl_nivel === undefined){
      this.mostrarCurso = false;
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
    }else{
      this.listaCursos=[];
      this.apiService.obtenerCursos(this.mdl_nivel).subscribe(data => {
        for(let elemento in data){
          this.listaCursos.push(data[elemento]);
        }
        this.mostrarCurso = true;
        
      }, err =>{
        this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
        this.mdl_curso = undefined;
        this.mdl_nivel = undefined;
        this.mostrarCurso = false;
        
      });
    }
  }
  
  obtenerValor(valor){
    this.mdl_nivel = valor;
  }

  obtenerHorarioApi(){
    if(this.mdl_curso === undefined){
      this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
    }else{
      this.listaHorarios = [];
      this.apiService.obtenerHorarioCurso(this.mdl_curso).subscribe(data => {
        for(let elemento in data){
          this.listaHorarios.push(data[elemento]);
        }
        console.log(this.listaHorarios);
        console.log(this.mdl_curso);
        
        this.apiService.listaHorarios = this.listaHorarios;
        this.isEnable=false;
      },err =>{
        this.errorGenerico('Sin resultados','La búsqueda no arrojó resultados.')
        this.mdl_curso = undefined;
        this.mostrarCurso = false;
      });

    }
  }

  irHorarios(){
    if(this.listaHorarios.length <= 0){
      this.errorGenerico('Atención!','No se puede ver horario sin datos!')
    }else{
      this.router.navigate(['inicio/horarios/horario-selected']);

    }
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
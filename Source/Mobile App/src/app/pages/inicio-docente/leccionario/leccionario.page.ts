import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ToastController, IonDatetime } from '@ionic/angular';
import { format, parseISO } from 'date-fns';
import { Asignatura } from 'src/app/interface/asignatura';
import { ApiService } from 'src/app/sevices/api.service';

@Component({
  selector: 'app-leccionario',
  templateUrl: './leccionario.page.html',
  styleUrls: ['./leccionario.page.scss'],
})
export class LeccionarioPage implements OnInit {

  isDisableIn: boolean= true;
  isDisableVer: boolean= true;

  mostrarPickerFecha = false;
  dateValue = format(new Date(),  'yyyy-MM-dd');
  fechaSys = format(new Date(),  'yyyy-MM-dd');
  formato = '';
  @ViewChild(IonDatetime) datetime: IonDatetime;
  constructor(private router: Router,
              private toastController: ToastController) { }


  ngOnInit() {
    this.isDisableIn = true;
    this.isDisableVer = true;
    localStorage.removeItem('fecha');
    this.formato = format(parseISO(format(new Date(),  'yyyy-MM-dd')),'dd-MM-yyyy');
  }


  ingresarLeccionario(){
    this.router.navigate(['/inicio-docente/leccionario/ingresar-leccionario-doc']);
  }
  verLeccionario(){
    this.router.navigate(['/inicio-docente/leccionario/ver-leccionario-doc']);
  }
  
  fechaSyst(){
    this.fechaSys = format(parseISO(format(new Date(),  'yyyy-MM-dd')), 'dd-MM-yyyy');
  }

  fechaCambiada(value) {
    if(this.datetime.value > this.fechaSys){
      this.errorGenerico('Error!','La fecha seleccionada no puede ser en el futuro!');
      this.mostrarPickerFecha = false;
      this.datetime.cancel(true);
      this.isDisableIn= true;
      this.isDisableVer= true;
    }else{
      
      // this.active=false;
      this.dateValue = value;
      this.formato = format(parseISO(value),'dd-MM-yyyy'); 
      // console.log(this.formato);
      
      this.mostrarPickerFecha = false;
      localStorage.setItem('fecha', this.formato);
      console.log(localStorage.getItem('fecha'));
      
    }
    // console.log(value);
    
  }
  onFocus(value){
    console.log(value);
    
  }

  cerrar() {
    this.datetime.cancel(true);
  }

  seleccionar() {
      if(this.datetime.value > this.fechaSys){
      this.errorGenerico('Error!','La fecha seleccionada no puede ser en el futuro!');
      this.mostrarPickerFecha = false;
      this.datetime.cancel(true);
      this.isDisableIn= true;
      this.isDisableVer= true;
      
    }else{      

      this.formato = this.datetime.value;
      this.formato = format(parseISO(format(new Date(),  'yyyy-MM-dd')), 'dd-MM-yyyy');
      console.log(this.formato);
      localStorage.setItem('fecha', this.formato);
      console.log(localStorage.getItem('fecha'));
      this.datetime.confirm(true);
      this.isDisableIn= false;
      this.isDisableVer= false;
    }
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
      duration:3500,
      color: 'danger',
      buttons: ['Ok'],
    });
    await toast.present();

    const { role } = await toast.onDidDismiss();
    console.log('onDidDismiss resolved with role', role)
}

}

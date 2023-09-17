import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ToastController, IonDatetime } from '@ionic/angular';
import { format, parseISO } from 'date-fns';
import { Asignatura } from 'src/app/interface/asignatura';
import { ApiService } from 'src/app/sevices/api.service';

@Component({
  selector: 'app-notas',
  templateUrl: './notas.page.html',
  styleUrls: ['./notas.page.scss'],
})
export class NotasPage implements OnInit {

  // mostrarPickerFecha = false;
  // dateValue = format(new Date(),  'yyyy-MM-dd');
  // fechaSys = format(new Date(),  'yyyy-MM-dd');
  // formato = '';
  // @ViewChild(IonDatetime) datetime: IonDatetime;
  constructor(private router: Router) { }


  ngOnInit() {

  }

  ingresarNotas(){
    this.router.navigate(['inicio-docente/notas/ingresar-notas-doc']);
  }

  verNotas(){
    this.router.navigate(['inicio-docente/notas/mostrar-notas-doc']).then(()=>{
      window.location.reload();
    });
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
  

}

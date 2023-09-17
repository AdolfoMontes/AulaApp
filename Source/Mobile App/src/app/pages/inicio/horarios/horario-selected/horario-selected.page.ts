import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Horario } from 'src/app/interface/horario';
import { ApiService } from 'src/app/sevices/api.service';

@Component({
  selector: 'app-horario-selected',
  templateUrl: './horario-selected.page.html',
  styleUrls: ['./horario-selected.page.scss'],
})
export class HorarioSelectedPage implements OnInit {

  listaHorarios: Horario[] = [];

    constructor(public apiService: ApiService,
      public router: Router) {
    this.listarHorarios();
    console.log(this.listaHorarios);
    
   }

  ngOnInit() {
  }

  listarHorarios(){
    this.listaHorarios = this.apiService.listaHorarios;
    console.log(this.listaHorarios);
    
   // this.listaAsignaturasH = this.objetoAsignatura
    
  }

  cerrarHorario(){
    this.router.navigate(['/inicio']);
  }

}
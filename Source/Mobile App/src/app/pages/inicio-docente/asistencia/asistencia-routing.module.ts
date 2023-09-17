import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AsistenciaPage } from './asistencia.page';

const routes: Routes = [
  {
    path: '',
    component: AsistenciaPage
  },
  {
    path: 'ingresar-asistencia-doc',
    loadChildren: () => import('./ingresar-asistencia-doc/ingresar-asistencia-doc.module').then( m => m.IngresarAsistenciaDocPageModule)
  },
  {
    path: 'ver-asistencia-doc',
    loadChildren: () => import('./ver-asistencia-doc/ver-asistencia-doc.module').then( m => m.VerAsistenciaDocPageModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AsistenciaPageRoutingModule {}

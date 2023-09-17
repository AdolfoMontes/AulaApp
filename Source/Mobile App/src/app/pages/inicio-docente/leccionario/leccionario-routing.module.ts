import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LeccionarioPage } from './leccionario.page';

const routes: Routes = [
  {
    path: '',
    component: LeccionarioPage
  },
  {
    path: 'ingresar-leccionario-doc',
    loadChildren: () => import('./ingresar-leccionario-doc/ingresar-leccionario-doc.module').then( m => m.IngresarLeccionarioDocPageModule)
  },
  {
    path: 'ver-leccionario-doc',
    loadChildren: () => import('./ver-leccionario-doc/ver-leccionario-doc.module').then( m => m.VerLeccionarioDocPageModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LeccionarioPageRoutingModule {}

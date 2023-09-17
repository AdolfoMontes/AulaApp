import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LeccionarioPage } from './leccionario.page';

const routes: Routes = [
  {
    path: '',
    component: LeccionarioPage
  },
  {
    path: 'ingresar-leccionario',
    loadChildren: () => import('./ingresar-leccionario/ingresar-leccionario.module').then( m => m.IngresarLeccionarioPageModule)
  },
  {
    path: 'ver-leccionario',
    loadChildren: () => import('./ver-leccionario/ver-leccionario.module').then( m => m.VerLeccionarioPageModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LeccionarioPageRoutingModule {}

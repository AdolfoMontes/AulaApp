import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NotasPage } from './notas.page';

const routes: Routes = [
  {
    path: '',
    component: NotasPage
  },
  {
    path: 'ingresar-notas-doc',
    loadChildren: () => import('./ingresar-notas-doc/ingresar-notas-doc.module').then( m => m.IngresarNotasDocPageModule)
  },
  {
    path: 'mostrar-notas-doc',
    loadChildren: () => import('./mostrar-notas-doc/mostrar-notas-doc.module').then( m => m.MostrarNotasDocPageModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class NotasPageRoutingModule {}

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { IngresarLeccionarioPage } from './ingresar-leccionario.page';

const routes: Routes = [
  {
    path: '',
    component: IngresarLeccionarioPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class IngresarLeccionarioPageRoutingModule {}

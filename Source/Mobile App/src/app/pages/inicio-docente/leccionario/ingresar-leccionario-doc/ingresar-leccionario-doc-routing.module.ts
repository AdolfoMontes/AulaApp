import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { IngresarLeccionarioDocPage } from './ingresar-leccionario-doc.page';

const routes: Routes = [
  {
    path: '',
    component: IngresarLeccionarioDocPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class IngresarLeccionarioDocPageRoutingModule {}

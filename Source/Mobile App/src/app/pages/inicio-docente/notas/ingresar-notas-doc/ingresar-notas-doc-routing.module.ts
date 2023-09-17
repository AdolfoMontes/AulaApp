import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { IngresarNotasDocPage } from './ingresar-notas-doc.page';

const routes: Routes = [
  {
    path: '',
    component: IngresarNotasDocPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class IngresarNotasDocPageRoutingModule {}

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { IngresarAsistenciaDocPage } from './ingresar-asistencia-doc.page';

const routes: Routes = [
  {
    path: '',
    component: IngresarAsistenciaDocPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class IngresarAsistenciaDocPageRoutingModule {}

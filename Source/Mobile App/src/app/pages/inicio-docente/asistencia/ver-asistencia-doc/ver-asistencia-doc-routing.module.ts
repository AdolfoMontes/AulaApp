import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { VerAsistenciaDocPage } from './ver-asistencia-doc.page';

const routes: Routes = [
  {
    path: '',
    component: VerAsistenciaDocPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class VerAsistenciaDocPageRoutingModule {}

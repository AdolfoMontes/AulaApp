import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { VerLeccionarioDocPage } from './ver-leccionario-doc.page';

const routes: Routes = [
  {
    path: '',
    component: VerLeccionarioDocPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class VerLeccionarioDocPageRoutingModule {}

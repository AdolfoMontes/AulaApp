import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { VerLeccionarioPage } from './ver-leccionario.page';

const routes: Routes = [
  {
    path: '',
    component: VerLeccionarioPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class VerLeccionarioPageRoutingModule {}

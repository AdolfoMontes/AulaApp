import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CambiarRecuperarPage } from './cambiar-recuperar.page';

const routes: Routes = [
  {
    path: '',
    component: CambiarRecuperarPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CambiarRecuperarPageRoutingModule {}

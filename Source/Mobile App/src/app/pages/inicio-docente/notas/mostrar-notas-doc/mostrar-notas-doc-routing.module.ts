import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MostrarNotasDocPage } from './mostrar-notas-doc.page';

const routes: Routes = [
  {
    path: '',
    component: MostrarNotasDocPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MostrarNotasDocPageRoutingModule {}

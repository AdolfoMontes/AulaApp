import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NuevaHdvDocPage } from './nueva-hdv-doc.page';

const routes: Routes = [
  {
    path: '',
    component: NuevaHdvDocPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class NuevaHdvDocPageRoutingModule {}

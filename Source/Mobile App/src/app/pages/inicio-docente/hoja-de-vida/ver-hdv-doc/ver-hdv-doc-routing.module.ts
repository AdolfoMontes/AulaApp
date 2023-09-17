import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { VerHdvDocPage } from './ver-hdv-doc.page';

const routes: Routes = [
  {
    path: '',
    component: VerHdvDocPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class VerHdvDocPageRoutingModule {}

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MainDocentePage } from './main-docente.page';

const routes: Routes = [
  {
    path: '',
    component: MainDocentePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MainDocentePageRoutingModule {}

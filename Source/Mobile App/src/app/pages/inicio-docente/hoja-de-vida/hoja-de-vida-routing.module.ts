import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HojaDeVidaPage } from './hoja-de-vida.page';

const routes: Routes = [
  {
    path: '',
    component: HojaDeVidaPage
  },
  {
    path: 'nueva-hdv-doc',
    loadChildren: () => import('./nueva-hdv-doc/nueva-hdv-doc.module').then( m => m.NuevaHdvDocPageModule)
  },
  {
    path: 'ver-hdv-doc',
    loadChildren: () => import('./ver-hdv-doc/ver-hdv-doc.module').then( m => m.VerHdvDocPageModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class HojaDeVidaPageRoutingModule {}

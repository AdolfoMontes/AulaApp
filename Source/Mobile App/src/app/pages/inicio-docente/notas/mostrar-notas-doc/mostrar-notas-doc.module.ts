import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { MostrarNotasDocPageRoutingModule } from './mostrar-notas-doc-routing.module';

import { MostrarNotasDocPage } from './mostrar-notas-doc.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    MostrarNotasDocPageRoutingModule
  ],
  declarations: [MostrarNotasDocPage]
})
export class MostrarNotasDocPageModule {}

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { IngresarNotasDocPageRoutingModule } from './ingresar-notas-doc-routing.module';

import { IngresarNotasDocPage } from './ingresar-notas-doc.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    IngresarNotasDocPageRoutingModule
  ],
  declarations: [IngresarNotasDocPage]
})
export class IngresarNotasDocPageModule {}

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { IngresarLeccionarioDocPageRoutingModule } from './ingresar-leccionario-doc-routing.module';

import { IngresarLeccionarioDocPage } from './ingresar-leccionario-doc.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    IngresarLeccionarioDocPageRoutingModule
  ],
  declarations: [IngresarLeccionarioDocPage]
})
export class IngresarLeccionarioDocPageModule {}

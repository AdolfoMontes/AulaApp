import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { IngresarAsistenciaDocPageRoutingModule } from './ingresar-asistencia-doc-routing.module';

import { IngresarAsistenciaDocPage } from './ingresar-asistencia-doc.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    IngresarAsistenciaDocPageRoutingModule
  ],
  declarations: [IngresarAsistenciaDocPage]
})
export class IngresarAsistenciaDocPageModule {}

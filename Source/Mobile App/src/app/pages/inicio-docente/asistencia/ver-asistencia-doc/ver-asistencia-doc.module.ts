import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { VerAsistenciaDocPageRoutingModule } from './ver-asistencia-doc-routing.module';

import { VerAsistenciaDocPage } from './ver-asistencia-doc.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    VerAsistenciaDocPageRoutingModule
  ],
  declarations: [VerAsistenciaDocPage]
})
export class VerAsistenciaDocPageModule {}

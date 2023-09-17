import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { VerLeccionarioDocPageRoutingModule } from './ver-leccionario-doc-routing.module';

import { VerLeccionarioDocPage } from './ver-leccionario-doc.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    VerLeccionarioDocPageRoutingModule
  ],
  declarations: [VerLeccionarioDocPage]
})
export class VerLeccionarioDocPageModule {}

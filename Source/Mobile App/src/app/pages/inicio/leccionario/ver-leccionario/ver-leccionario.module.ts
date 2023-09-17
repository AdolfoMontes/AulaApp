import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { VerLeccionarioPageRoutingModule } from './ver-leccionario-routing.module';

import { VerLeccionarioPage } from './ver-leccionario.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    VerLeccionarioPageRoutingModule
  ],
  declarations: [VerLeccionarioPage]
})
export class VerLeccionarioPageModule {}

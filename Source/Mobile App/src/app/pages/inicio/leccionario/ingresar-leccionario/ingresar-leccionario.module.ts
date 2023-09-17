import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { IngresarLeccionarioPageRoutingModule } from './ingresar-leccionario-routing.module';

import { IngresarLeccionarioPage } from './ingresar-leccionario.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    IngresarLeccionarioPageRoutingModule
  ],
  declarations: [IngresarLeccionarioPage]
})
export class IngresarLeccionarioPageModule {}

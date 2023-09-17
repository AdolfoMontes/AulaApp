import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { CambiarRecuperarPageRoutingModule } from './cambiar-recuperar-routing.module';

import { CambiarRecuperarPage } from './cambiar-recuperar.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CambiarRecuperarPageRoutingModule
  ],
  declarations: [CambiarRecuperarPage]
})
export class CambiarRecuperarPageModule {}

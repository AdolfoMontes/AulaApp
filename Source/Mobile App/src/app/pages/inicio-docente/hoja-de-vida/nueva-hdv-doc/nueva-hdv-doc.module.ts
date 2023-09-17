import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { NuevaHdvDocPageRoutingModule } from './nueva-hdv-doc-routing.module';

import { NuevaHdvDocPage } from './nueva-hdv-doc.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    NuevaHdvDocPageRoutingModule
  ],
  declarations: [NuevaHdvDocPage]
})
export class NuevaHdvDocPageModule {}

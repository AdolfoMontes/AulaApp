import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { VerHdvDocPageRoutingModule } from './ver-hdv-doc-routing.module';

import { VerHdvDocPage } from './ver-hdv-doc.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    VerHdvDocPageRoutingModule
  ],
  declarations: [VerHdvDocPage]
})
export class VerHdvDocPageModule {}

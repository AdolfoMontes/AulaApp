import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { MainDocentePageRoutingModule } from './main-docente-routing.module';

import { MainDocentePage } from './main-docente.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    MainDocentePageRoutingModule
  ],
  declarations: [MainDocentePage]
})
export class MainDocentePageModule {}

import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { IngresarAsistenciaDocPage } from './ingresar-asistencia-doc.page';

describe('IngresarAsistenciaDocPage', () => {
  let component: IngresarAsistenciaDocPage;
  let fixture: ComponentFixture<IngresarAsistenciaDocPage>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ IngresarAsistenciaDocPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(IngresarAsistenciaDocPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { IngresarLeccionarioDocPage } from './ingresar-leccionario-doc.page';

describe('IngresarLeccionarioDocPage', () => {
  let component: IngresarLeccionarioDocPage;
  let fixture: ComponentFixture<IngresarLeccionarioDocPage>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ IngresarLeccionarioDocPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(IngresarLeccionarioDocPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

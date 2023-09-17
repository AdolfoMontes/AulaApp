import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { VerLeccionarioDocPage } from './ver-leccionario-doc.page';

describe('VerLeccionarioDocPage', () => {
  let component: VerLeccionarioDocPage;
  let fixture: ComponentFixture<VerLeccionarioDocPage>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ VerLeccionarioDocPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(VerLeccionarioDocPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AleOneComponent } from './ale-one.component';

describe('AleOneComponent', () => {
  let component: AleOneComponent;
  let fixture: ComponentFixture<AleOneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AleOneComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AleOneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

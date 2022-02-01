import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AleThreeComponent } from './ale-three.component';

describe('AleThreeComponent', () => {
  let component: AleThreeComponent;
  let fixture: ComponentFixture<AleThreeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AleThreeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AleThreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

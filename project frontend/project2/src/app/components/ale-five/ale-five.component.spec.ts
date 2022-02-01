import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AleFiveComponent } from './ale-five.component';

describe('AleFiveComponent', () => {
  let component: AleFiveComponent;
  let fixture: ComponentFixture<AleFiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AleFiveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AleFiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

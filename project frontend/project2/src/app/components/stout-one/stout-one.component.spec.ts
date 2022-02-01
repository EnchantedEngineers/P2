import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StoutOneComponent } from './stout-one.component';

describe('StoutOneComponent', () => {
  let component: StoutOneComponent;
  let fixture: ComponentFixture<StoutOneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StoutOneComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StoutOneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StoutFiveComponent } from './stout-five.component';

describe('StoutFiveComponent', () => {
  let component: StoutFiveComponent;
  let fixture: ComponentFixture<StoutFiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StoutFiveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StoutFiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

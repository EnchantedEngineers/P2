import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StoutFourComponent } from './stout-four.component';

describe('StoutFourComponent', () => {
  let component: StoutFourComponent;
  let fixture: ComponentFixture<StoutFourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StoutFourComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StoutFourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

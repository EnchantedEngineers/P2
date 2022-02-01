import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StoutTwoComponent } from './stout-two.component';

describe('StoutTwoComponent', () => {
  let component: StoutTwoComponent;
  let fixture: ComponentFixture<StoutTwoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StoutTwoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StoutTwoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

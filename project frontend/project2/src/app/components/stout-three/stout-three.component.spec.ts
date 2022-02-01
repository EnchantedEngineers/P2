import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StoutThreeComponent } from './stout-three.component';

describe('StoutThreeComponent', () => {
  let component: StoutThreeComponent;
  let fixture: ComponentFixture<StoutThreeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StoutThreeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StoutThreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

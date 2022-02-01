import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AleFourComponent } from './ale-four.component';

describe('AleFourComponent', () => {
  let component: AleFourComponent;
  let fixture: ComponentFixture<AleFourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AleFourComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AleFourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AleTwoComponent } from './ale-two.component';

describe('AleTwoComponent', () => {
  let component: AleTwoComponent;
  let fixture: ComponentFixture<AleTwoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AleTwoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AleTwoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

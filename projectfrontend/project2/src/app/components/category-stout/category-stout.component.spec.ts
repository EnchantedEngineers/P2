import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryStoutComponent } from './category-stout.component';

describe('CategoryStoutComponent', () => {
  let component: CategoryStoutComponent;
  let fixture: ComponentFixture<CategoryStoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CategoryStoutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoryStoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

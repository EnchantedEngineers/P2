import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryAleComponent } from './category-ale.component';

describe('CategoryAleComponent', () => {
  let component: CategoryAleComponent;
  let fixture: ComponentFixture<CategoryAleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CategoryAleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoryAleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

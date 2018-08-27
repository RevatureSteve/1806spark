import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateReimbComponent } from './create-reimb.component';

describe('CreateReimbComponent', () => {
  let component: CreateReimbComponent;
  let fixture: ComponentFixture<CreateReimbComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateReimbComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateReimbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

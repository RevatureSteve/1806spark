import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewReimbursemetComponent } from './new-reimbursemet.component';

describe('NewReimbursemetComponent', () => {
  let component: NewReimbursemetComponent;
  let fixture: ComponentFixture<NewReimbursemetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewReimbursemetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewReimbursemetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

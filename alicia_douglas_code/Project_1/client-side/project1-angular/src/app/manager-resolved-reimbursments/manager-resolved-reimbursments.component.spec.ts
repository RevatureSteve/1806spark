import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerResolvedReimbursmentsComponent } from './manager-resolved-reimbursments.component';

describe('ManagerResolvedReimbursmentsComponent', () => {
  let component: ManagerResolvedReimbursmentsComponent;
  let fixture: ComponentFixture<ManagerResolvedReimbursmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerResolvedReimbursmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerResolvedReimbursmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

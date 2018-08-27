import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerrequestsbyidComponent } from './managerrequestsbyid.component';

describe('ManagerrequestsbyidComponent', () => {
  let component: ManagerrequestsbyidComponent;
  let fixture: ComponentFixture<ManagerrequestsbyidComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerrequestsbyidComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerrequestsbyidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

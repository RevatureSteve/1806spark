import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentReimbursementsComponent } from './agent-reimbursements.component';

describe('AgentReimbursementsComponent', () => {
  let component: AgentReimbursementsComponent;
  let fixture: ComponentFixture<AgentReimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentReimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

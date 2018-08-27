import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentMissionsComponent } from './agent-missions.component';

describe('AgentMissionsComponent', () => {
  let component: AgentMissionsComponent;
  let fixture: ComponentFixture<AgentMissionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentMissionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentMissionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

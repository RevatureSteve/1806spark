import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerViewRequestComponent } from './manager-view-request.component';

describe('ManagerViewRequestComponent', () => {
  let component: ManagerViewRequestComponent;
  let fixture: ComponentFixture<ManagerViewRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerViewRequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerViewRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

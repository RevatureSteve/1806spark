import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagernavbarComponent } from './managernavbar.component';

describe('ManagernavbarComponent', () => {
  let component: ManagernavbarComponent;
  let fixture: ComponentFixture<ManagernavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagernavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagernavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

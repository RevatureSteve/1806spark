import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerresolvedComponent } from './managerresolved.component';

describe('ManagerresolvedComponent', () => {
  let component: ManagerresolvedComponent;
  let fixture: ComponentFixture<ManagerresolvedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerresolvedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerresolvedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

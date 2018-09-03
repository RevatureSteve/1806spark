import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateUsersComponentComponent } from './update-users-component.component';

describe('UpdateUsersComponentComponent', () => {
  let component: UpdateUsersComponentComponent;
  let fixture: ComponentFixture<UpdateUsersComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateUsersComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateUsersComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

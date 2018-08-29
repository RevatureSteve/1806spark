import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashBoardBoxComponent } from './dash-board-box.component';

describe('DashBoardBoxComponent', () => {
  let component: DashBoardBoxComponent;
  let fixture: ComponentFixture<DashBoardBoxComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashBoardBoxComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashBoardBoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

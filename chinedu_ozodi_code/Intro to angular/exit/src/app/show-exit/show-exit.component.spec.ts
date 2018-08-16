import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowExitComponent } from './show-exit.component';

describe('ShowExitComponent', () => {
  let component: ShowExitComponent;
  let fixture: ComponentFixture<ShowExitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowExitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowExitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

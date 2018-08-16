import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BigBoxComponent } from './big-box.component';

describe('BigBoxComponent', () => {
  let component: BigBoxComponent;
  let fixture: ComponentFixture<BigBoxComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BigBoxComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BigBoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

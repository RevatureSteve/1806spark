import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeniedReimbInfoComponent } from './denied-reimb-info.component';

describe('DeniedReimbInfoComponent', () => {
  let component: DeniedReimbInfoComponent;
  let fixture: ComponentFixture<DeniedReimbInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeniedReimbInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeniedReimbInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LuigiComponent } from './luigi.component';

describe('LuigiComponent', () => {
  let component: LuigiComponent;
  let fixture: ComponentFixture<LuigiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LuigiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LuigiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

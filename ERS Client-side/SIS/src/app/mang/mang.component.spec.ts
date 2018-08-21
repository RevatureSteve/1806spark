import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MangComponent } from './mang.component';

describe('MangComponent', () => {
  let component: MangComponent;
  let fixture: ComponentFixture<MangComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MangComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MangComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

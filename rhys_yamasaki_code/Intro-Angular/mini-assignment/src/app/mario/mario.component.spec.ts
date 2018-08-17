import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MarioComponent } from './mario.component';

describe('MarioComponent', () => {
  let component: MarioComponent;
  let fixture: ComponentFixture<MarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

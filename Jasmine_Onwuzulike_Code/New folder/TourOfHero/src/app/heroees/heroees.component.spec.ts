import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeroeesComponent } from './heroees.component';

describe('HeroeesComponent', () => {
  let component: HeroeesComponent;
  let fixture: ComponentFixture<HeroeesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeroeesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeroeesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PokeBagComponent } from './poke-bag.component';

describe('PokeBagComponent', () => {
  let component: PokeBagComponent;
  let fixture: ComponentFixture<PokeBagComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PokeBagComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PokeBagComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

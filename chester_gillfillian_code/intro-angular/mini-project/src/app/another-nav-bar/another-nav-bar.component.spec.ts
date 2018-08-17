import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnotherNavBarComponent } from './another-nav-bar.component';

describe('AnotherNavBarComponent', () => {
  let component: AnotherNavBarComponent;
  let fixture: ComponentFixture<AnotherNavBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnotherNavBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnotherNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

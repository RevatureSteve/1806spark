import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerHomepageComponent } from './manager-homepage.component';

describe('ManagerHomepageComponent', () => {
  let component: ManagerHomepageComponent;
  let fixture: ComponentFixture<ManagerHomepageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerHomepageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

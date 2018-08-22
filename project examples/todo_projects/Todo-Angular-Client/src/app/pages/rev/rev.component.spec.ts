import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RevComponent } from './rev.component';

describe('RevComponent', () => {
  let component: RevComponent;
  let fixture: ComponentFixture<RevComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RevComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RevComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

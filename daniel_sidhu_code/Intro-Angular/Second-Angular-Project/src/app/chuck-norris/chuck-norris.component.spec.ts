import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChuckNorrisComponent } from './chuck-norris.component';

describe('ChuckNorrisComponent', () => {
  let component: ChuckNorrisComponent;
  let fixture: ComponentFixture<ChuckNorrisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChuckNorrisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChuckNorrisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

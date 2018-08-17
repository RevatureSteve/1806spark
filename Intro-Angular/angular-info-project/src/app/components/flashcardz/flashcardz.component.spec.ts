import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FlashcardzComponent } from './flashcardz.component';

describe('FlashcardzComponent', () => {
  let component: FlashcardzComponent;
  let fixture: ComponentFixture<FlashcardzComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FlashcardzComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FlashcardzComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

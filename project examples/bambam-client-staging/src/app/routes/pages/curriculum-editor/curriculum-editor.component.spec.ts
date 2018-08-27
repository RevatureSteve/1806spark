import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CurriculumEditorComponent } from './curriculum-editor.component';

describe('CurriculumEditorComponent', () => {
  let component: CurriculumEditorComponent;
  let fixture: ComponentFixture<CurriculumEditorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CurriculumEditorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CurriculumEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

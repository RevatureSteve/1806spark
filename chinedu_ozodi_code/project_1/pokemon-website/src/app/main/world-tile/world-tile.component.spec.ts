import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorldTileComponent } from './world-tile.component';

describe('WorldTileComponent', () => {
  let component: WorldTileComponent;
  let fixture: ComponentFixture<WorldTileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorldTileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorldTileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

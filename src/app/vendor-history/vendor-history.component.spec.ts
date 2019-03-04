import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorHistoryComponent } from './vendor-history.component';

describe('VendorHistoryComponent', () => {
  let component: VendorHistoryComponent;
  let fixture: ComponentFixture<VendorHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendorHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VendorHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

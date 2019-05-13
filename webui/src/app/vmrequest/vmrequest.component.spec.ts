import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VmrequestComponent } from './vmrequest.component';

describe('VmrequestComponent', () => {
  let component: VmrequestComponent;
  let fixture: ComponentFixture<VmrequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VmrequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VmrequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

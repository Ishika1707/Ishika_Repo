import { TestBed } from '@angular/core/testing';

import { VmrequestService } from './vmrequest.service';

describe('VmrequestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VmrequestService = TestBed.get(VmrequestService);
    expect(service).toBeTruthy();
  });
});

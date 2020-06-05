import { TestBed } from '@angular/core/testing';

import { JoblocService } from './jobloc.service';

describe('JoblocService', () => {
  let service: JoblocService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JoblocService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

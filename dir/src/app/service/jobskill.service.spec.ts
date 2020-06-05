import { TestBed } from '@angular/core/testing';

import { JobskillService } from './jobskill.service';

describe('JobskillService', () => {
  let service: JobskillService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JobskillService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {FormsModule} from '@angular/forms';



import { CreatejobComponent } from './createjob.component';

describe('CreatejobComponent', () => {
  let component: CreatejobComponent;
  let fixture: ComponentFixture<CreatejobComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreatejobComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatejobComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

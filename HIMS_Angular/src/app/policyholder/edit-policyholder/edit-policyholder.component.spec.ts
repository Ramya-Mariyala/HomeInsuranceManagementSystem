import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPolicyholderComponent } from './edit-policyholder.component';

describe('EditPolicyholderComponent', () => {
  let component: EditPolicyholderComponent;
  let fixture: ComponentFixture<EditPolicyholderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditPolicyholderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditPolicyholderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

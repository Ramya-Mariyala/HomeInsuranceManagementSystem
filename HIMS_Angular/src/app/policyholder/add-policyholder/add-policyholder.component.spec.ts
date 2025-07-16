import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPolicyholderComponent } from './add-policyholder.component';

describe('AddPolicyholderComponent', () => {
  let component: AddPolicyholderComponent;
  let fixture: ComponentFixture<AddPolicyholderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddPolicyholderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPolicyholderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListPolicyholderComponent } from './list-policyholder.component';

describe('ListPolicyholderComponent', () => {
  let component: ListPolicyholderComponent;
  let fixture: ComponentFixture<ListPolicyholderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListPolicyholderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListPolicyholderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

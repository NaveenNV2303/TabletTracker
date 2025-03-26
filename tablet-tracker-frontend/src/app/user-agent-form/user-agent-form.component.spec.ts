import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserAgentFormComponent } from './user-agent-form.component';

describe('UserAgentFormComponent', () => {
  let component: UserAgentFormComponent;
  let fixture: ComponentFixture<UserAgentFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserAgentFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserAgentFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

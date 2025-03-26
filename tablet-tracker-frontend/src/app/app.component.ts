import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TabletListComponent } from './tablet-list/tablet-list.component';
import { HttpClientModule } from '@angular/common/http';
import { UserAgentFormComponent } from './user-agent-form/user-agent-form.component';


@Component({
  selector: 'app-root',
  // imports: [RouterOutlet],
  imports: [CommonModule, TabletListComponent, UserAgentFormComponent, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {
  title = 'Tablet Frontend';
  isMobileMenuOpen = false;


  ngOnInit() {
  }

  toggleMobileMenu() {
    this.isMobileMenuOpen = !this.isMobileMenuOpen;
  }
  closeMobileMenu() {
    this.isMobileMenuOpen = false;
  }
}
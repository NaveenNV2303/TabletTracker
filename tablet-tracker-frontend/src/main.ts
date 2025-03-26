import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

bootstrapApplication(AppComponent, {
  providers: [
    { provide: HttpClientModule, useClass: HttpClientModule },
    { provide: FormsModule, useClass: FormsModule }, // Add FormsModule here
    { provide: CommonModule, useClass: CommonModule }, // Add CommonModule here
  ],
}).catch(err => console.error(err));
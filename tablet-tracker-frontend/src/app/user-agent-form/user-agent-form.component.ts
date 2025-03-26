import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-agent-form',
  imports: [CommonModule, FormsModule],
  templateUrl: './user-agent-form.component.html',
  styleUrl: './user-agent-form.component.css'
})
export class UserAgentFormComponent {
  userAgent: string = ''; // Variable to bind the input field
  message: string = '';   // To display success or error messages
  isSubmitting: boolean = false; // Track whether the form is being submitted

  constructor(private http: HttpClient) {}

  // Method to handle form submission
  submitUserAgent() {

    if (!this.userAgent) {
      this.message = 'Please enter a User-Agent string.';
      return;
    }
    this.isSubmitting = true;  // Set to true to indicate the form is being submitted
    const url = 'http://localhost:8080/api/user-agents/load-from-frontend';  // Backend API endpoint
    const userAgentStrings = this.userAgent.split('\n');
    console.log('userAgent:'+this.userAgent);
    console.log('userAgentStrings:'+userAgentStrings);
    
    // Loop through the array of User-Agent strings and send each one as a separate request
    userAgentStrings.forEach((userAgent) => {
    this.http.post<UserAgentResponse>(url, { userAgent }).subscribe(
        (response) => {
          console.log('message'+ this.message);
          this.message = `Successfully added User-Agent`;
        },
        (error) => {
          console.log('message:'+this.message);
          this.message = `Error saving User-Agent. Please try again with valid User-Agent.`;
        }
      );
    });

    this.userAgent = ''; // Clear the input field after successful submission
    this.isSubmitting = false;  // Reset the flag after the request completes
    
    setTimeout(() => {
      this.message = '';
      this.getAllData();
    }, 1500);
    // window.location.reload()
  }
  deleteAllData() {
    const url = 'http://localhost:8080/api/user-agents/delete-all';  // Backend delete API
    this.http.delete(url).subscribe(
      (response) => {
        this.message = 'All User-Agent data deleted successfully!';
        setTimeout(() => { this.message = ''; this.getAllData();}, 1500);
      },
      (error) => {
        this.message = 'Error deleting User-Agent data. Please try again.';
        setTimeout(() => { this.message = ''; }, 1500);
      }
    );
  }
  
  getAllData(){
    window.location.reload()
  }
  
}

export interface UserAgentResponse {
  message: string;
}

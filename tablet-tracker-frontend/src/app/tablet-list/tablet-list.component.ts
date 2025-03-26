import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-tablet-list',
  imports: [CommonModule],
  templateUrl: './tablet-list.component.html',
  styleUrl: './tablet-list.component.css'
})
export class TabletListComponent implements OnInit {
  devices: any[] = []; // Devices data fetched from the API

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getDevices();
  }

  // Fetch tablet data from the backend
  getDevices(): void {
    const apiUrl = 'http://localhost:8080/api/user-agents/tablets';
    this.http.get<any[]>(apiUrl).subscribe(
      (data) => {
        this.devices = data;
      },
      (error) => {
        console.error('Error fetching devices', error);
      }
    );
  }
}

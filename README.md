User-Agent Data Application

This web application iterates over the User-Agents provided and makes calls to the DeviceAtlas web service. It stores the response data in a normalized form in a database and provides a frontend to view the stored data, filtered to show tablet devices only and sorted by the operating system version (osVersion).


Features:

Responsive Design: The application is responsive and works seamlessly on mobile, tablet, and desktop.
Iterates over User-Agents: The app makes calls to the DeviceAtlas web service for each User-Agent.
Database Storage: Stores response data in a normalized form within a database.
Frontend to View Data: Provides a user-friendly interface to view the stored data, filter by tablet devices, and sort by operating system version.


Additional Features:

Get All Data: Displays all stored data.
Delete All Data: Allows users to delete all stored data.

Technology Used
This project leverages the following technologies:

Java: The backend of the application is built using Java, providing the core logic and functionality.

Spring Boot: A Java-based framework used to build the backend REST API for handling requests and interacting with the database.

Angular: The frontend is developed using Angular, a powerful JavaScript framework for building single-page applications (SPAs).

Tailwind CSS: Used for utility-first CSS styling, providing a clean and responsive design for the frontend.

PostgreSQL (NeonDB): The application uses PostgreSQL as the relational database to store the user-agent data in a normalized form. NeonDB provides a cloud-based instance of PostgreSQL, allowing for easy scaling and maintenance.

Docker
This project is containerized using Docker, ensuring that the application can run in any environment, whether it’s your local machine, a server, or in production. Docker helps in creating isolated containers for both frontend and backend, eliminating environment inconsistencies.





Installation Instructions
Prerequisites
Before you begin, ensure that you have Docker and Docker Compose installed on your system.

Running the Application
To run the application with Docker, follow these steps:

Clone the repository:
git clone https://github.com/your-username/your-repo.git
cd your-repo



Build the Docker images: Run the following command to build both the frontend and backend containers:

docker-compose build
<!-- Start the application: To start the containers and run the application: -->


docker-compose up
<!-- The backend will be available on http://localhost:8080, and the frontend will be available on http://localhost. -->
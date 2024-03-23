# taskJava
# Folklore Application
#### Welcome to the Folklore Application! This application allows you to manage folklore data efficiently.

# Introduction
The Folklore Application is designed to handle various folklore entries, including their titles, origin countries, descriptions, stories, and associated characters. It provides RESTful APIs for creating, retrieving, updating, and deleting folklore entries.

# Features
#### -> Create new folklore entries with detailed information.
#### -> Retrieve all folklore entries or a specific entry by ID.
#### -> Update existing folklore entries with modified details.
#### -> Delete folklore entries based on their ID.

# Technologies Used:
### Java 17
### Spring Boot 3.1.5
### Spring Data JPA
### H2 Database
### Gradle

# How to Use

### Clone the Repository:
##### git clone https://github.com/Mcmaniak/taskJava.git

### Build the Application:
#### cd folklore-application
#### ./gradlew build

### Run the Application:
#### ./gradlew bootRun
### Access the Application:
Once the application is running, you can access it at http://localhost:8080.

## Docker
#### Alternatively, you can run the application using Docker. Follow these steps:

### Build the Docker image:

#### docker build -t db -f src/Dockerfile .
### Run the Docker container:
#### docker run -p 8080:8080 folklore-app
Access the application in your web browser at http://localhost:8080.
##
### API Endpoints:
#### GET /folklores: Retrieve all folklore entries.
#### GET /folklores/{id}: Retrieve a specific folklore entry by ID.
#### POST /folklores: Create a new folklore entry.
#### PUT /folklores/{id}: Update an existing folklore entry.
#### DELETE /folklores/{id}: Delete a folklore entry.
##### Note: Replace {id} with the actual ID of the folklore entry.

## Sample Requests:
### To create a new folklore entry:
POST /folklores
##### {
##### "title": "Title of the folklore",
##### "originCountry": "Country of origin",
##### "description": "Description of the folklore",
##### "story": "The story of the folklore",
##### "characters": ["Character 1", "Character 2", ...]
#### }

### To update an existing folklore entry:
##### PUT /folklores/{id}
##### {
##### "title": "New title",
##### "originCountry": "New country",
##### "description": "New description",
##### "story": "New story",
##### "characters": ["New Character 1", "New Character 2", ...]
}

### To delete a folklore entry:
##### DELETE /folklores/{id}
##
## Testing:
#### You can test the APIs using tools like Postman or curl by sending requests to the above endpoints.
#
#### Contributing
###### Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or create a pull request.
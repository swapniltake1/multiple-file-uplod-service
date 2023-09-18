# Spring Boot multiple File Upload to Database

This is a Spring Boot application that demonstrates how to upload files to a MySQL database using Spring Data JPA. It includes a RESTful API for file uploads, database storage, and retrieval.

## Prerequisites

Before running this project, ensure you have the following prerequisites installed:

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL](https://dev.mysql.com/downloads/installer/) database server
- [Spring Boot](https://spring.io/projects/spring-boot)

## Getting Started

Follow these steps to get the project up and running:

1. Clone the repository:

   ```shell
   git clone https://github.com/swapniltake1/multiple-file-uplod-service.git
   cd spring-boot-file-upload
   ```

2. Configure the database settings in `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_database_username
   spring.datasource.password=your_database_password
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Build and run the project:

   ```shell
   mvn spring-boot:run
   ```

4. Access the application at `http://localhost:8080` in your web browser.

## Usage

- Upload files by making a POST request to `/upload-files`. Use the `files` parameter in the request to send one or more files.
- Retrieve uploaded files and their details using appropriate API endpoints.

## Endpoints

- `POST /upload-files`: Upload one or more files.
- `GET /files`: Retrieve a list of uploaded files.
- `GET /files/{id}`: Retrieve a specific uploaded file by ID.
- `GET /files/{id}/download`: Download a specific uploaded file.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

# Read Me First
- This application uses Java 17 and Spring Boot 3.3.1.
- This application was generated using https://start.spring.io/ with Spring Web dependencies.

# Getting Started
- Download and use any Java enabled IDE that you want.
- Using your IDE, download or git clone this application and open it. Open the folder **notetaking** as a project.
- The github repository for cloning this project is https://github.com/esoenclarence/OTA.git 
- Run this application using RestServiceApplication.java.

# To check if this application is working check the following endpoints
- for creating a new note: http://localhost:8888/notetaking/notes using the method POST supplied with raw JSON request body of the following example:
```  
{
  "title" : "this is the title",
  "note" : "this is the note"
}
```
- for retrieving all notes: http://localhost:8888/notetaking/notes using a GET Http method.
- for retrieving a particular note: http://localhost:8888/notetaking/notes/{id} using a GET Http method supplied with a numerical integer number on path variable id.
- for updating a note: http://localhost:8888/notetaking/notes using a PUT Http method supplied with raw JSON request body of the following example:
```  
{
  "title" : "updated title",
  "note" : "updated note"
}
```
- for deleting a note: http://localhost:8888/notetaking/notes/{id} using a DELETE Http method supplied with a numerical integer value for path variable id.

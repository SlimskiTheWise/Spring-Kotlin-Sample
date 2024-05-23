# Spring Boot / Kotlin Sample 

## Getting Started

There are two ways to start the application.

### Using Docker

1. Build Docker Image:
   
Execute the following command to build the Docker image:

```
docker build -t sample .
```

2. Run Docker Container:

Run the Docker container using the following command:

```
docker run -p 8080:8080 sample
```

### On Your Local Machine

To run the application locally, start the main method of the project.

Make sure that your local environment is compatible with the required versions of Gradle and OpenJDK.
```
src/main/kotlin/BackendAssignmentApplication.kt
```



## Testing

[Swagger Url](http://localhost:8080/swagger-ui/index.html#/)

Before accessing any APIs, you need to authenticate by logging in. If you don't have an account yet, please sign up first. Once you have signed up, you can log in to obtain an access token. Use this token to authorize your requests.

### Sign Up
To create an account, send a POST request to the /signup endpoint with the required user information. Upon successful registration, you will receive a confirmation message.
### Login
After signing up, you can log in to obtain an access token. Send a POST request to the /login endpoint with your credentials. Upon successful authentication, you will receive an access token in the response.

After attaching the generated token, you will successfully be logged in.  

<img width="819" alt="Screenshot 2024-05-10 at 4 28 51 PM" src="https://github.com/SlimskiTheWise/DNK-Backend-Assignment/assets/87960584/93ca23c8-84e9-4fe4-9b81-1b4ca479754b">

### Creating A Property
To ensure flexibility and maintainability, the property name is passed as a default value through the request body, facilitating future updates or modifications.
### Reading An Attached Exel File And Saving
Please use the property_id to save unit data from an Excel file. You'll find the property_id provided as a query string, which you obtained from the API mentioned earlier. Kindly follow the instructions to attach the Excel file as required. This ensures that the unit data is properly associated with the corresponding property.
### Fetching Unit List Data 
This feature is pretty straightforward—it simply retrieves all unit data from the server. However, to view the data, make sure you've followed all the steps mentioned earlier. This ensures you have the necessary access and context to interact with the retrieved unit information seamlessly.



 
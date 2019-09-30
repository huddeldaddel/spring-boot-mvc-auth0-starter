# Spring-Boot-MVC-Auth0-Starter
[![Build Status](https://dev.azure.com/huddeldaddel/huddeldaddel/_apis/build/status/huddeldaddel.mobbing-journal?branchName=master)](https://dev.azure.com/huddeldaddel/huddeldaddel/_build/latest?definitionId=4&branchName=master) 

## Contents

This project template contains an extended setup for a web development project based on:

*   Spring Boot
*   Thymeleaf
*   Kotlin
*   Maven

The project already contains a working integration of Auth0 for secure user management and is prepared for easy 
deployment on [Heroku](https://www.heroku.com). A sample configuration for an
[Azure Build Pipeline](https://azure.microsoft.com/en-en/services/devops/pipelines/) is contained as well.

## Configuration

The configuration is split in multiple parts. 

*   `application.properties` contains common properties that you'll rarely change.
*   `application-production.properties` contains additional settings and maps them to environment variables. This is 
     useful for deployment on Heroku.

The following properties should be set:

*   `com.auth0.callback`: Callback URL of your project - will look like `https://projectname.herokuapp.com/callback`. It
     has to be configured on Auth0, too.
*   `com.auth0.clientId`: Client-ID of your Auth0 configuration.
*   `com.auth0.clientSecret`: Client-Secret of your Auth0 configuration.
*   `com.auth0.domain`: Domain of your Auth0 configuration.
*   `spring.datasource.url`: JDBC URL of your database.
*   `spring.datasource.username`: Username to be used for the database login.
*   `spring.datasource.password`: Password to be used for the database login.

## Getting started locally

1.   Clone the repository
2.   Install a database (e.g. PostgreSQL)
3.   Create an account at [Auth0](https://auth0.com) and setup a new project. Specify http://localhost:3000/callback as 
     callback address for your project. 
4.   Create `application-default.properties` and copy the content of `application-production.properties` into it. Adjust
     the auth0 settings to the values that have been displayed at the end of the Auth0 project setup. Adjust the 
     datasource settings for usage with your database.

## Deploying on Heroku
 
1.   Create a new Heroku App that connects to your copy of this repository on Github.
2.   Add Add-Ons for Database (Heroku-PostgreSQL will do) and Logging
3.   Adjust `com.auth0.callback` of your `application-production.properties` to the  Callback URL of your project - e.g.
     `https://projectname.herokuapp.com/callback`
4.   Adjust the settings of your app to contain the Auth0 configuration values: `AUTH0_CLIENT_ID`, 
     `AUTH0_CLIENT_SECRET`, `AUTH0_DOMAIN`

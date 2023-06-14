# Github Client

Simple project Github Api. 

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Table of contents

* [General info] (#general-info)
* [Technologies] (#technologies)
* [Setup] (#setup)
* [Endpoint Demo] (#endpoint-demo)

## General info

Simple project created to show connect to Github Api. This project have only one main endpoint to get github user repositories.
If something goes wrong a simple exception handler was created. 

## Technologies

Project is created with:
* Quarkus 3.1.0.Final
* Design pattern - Builder
* Github Api - version 2022-11-28

## Setup

  You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

### Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Endpoint Demo

Project has 1 endpoint with Http method GET: http://your-domain/api/users/{name} 
We have to send request with the parameter: "name"  and header: "Accept", which specifies the desired response content type.

We get the following response (JSON) :
* [List of user repositories on success] (#list-of-user-repositories-on-success)
* [Error message with status when user non exist] (#error-message-with-status-when-user-non-exist)
* [Error message with status when we send header "application/xml"] (#error-message-with-status-when-we-send-header-application/xml)

### List of user repositories on success

URL: http://localhost:8080/api/users/BartekPiwowarczyk
Header: "application/json"

![Image list of repositories] (./images-readme/Screenshot-user-found.jpg)

### Error message with status when user non exist

URL: http://localhost:8080/api/users/nonexistUser
Header: "application/json"

![Image exception user not found] (./images-readme/Screenshot-user-not-found.jpg)

### Error message with status when we send header "application/xml"

URL: http://localhost:8080/api/users/BartekPiwowarczyk
Header: "application/xml"

![Image exception wrong header - content type] (./images-readme/Screenshot-wrong-header.jpg)



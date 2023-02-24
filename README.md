# Spring-Boot-Crud

Simple overview of use/purpose.

## Description

An in-depth paragraph about your project and overview of use.

## Getting Started
### Dependencies
* if you want to run locally you need Java 17 and Maven.
* To build and run image via docker you need to install docker CLI on your machine.

### Build docker image

inside the project path run:
```
docker build . -t io.felnyrius.app-jpa:0.0.1
```

### Run docker image

Run the below command in terminal
```
docker run -p 8080:8080 io.felnyrius.app-jpa:0.0.1
```
Test the program in postman/browser

http://localhost:8080/api/tests

### Run docker-compose (api + mySql)
To run app with sql database on docker:
1. Build the application via maven: mvn clean install
```
mvn clean install
```

2. in application properties change profile to:
```
spring.profiles.active=devSql
```
3. in root project directory type:
```
docker-compose up --build
```
This command will build the docker image from Dockerfile and then run docker compose
to run the api and sql database.
4. Test the program in postman/browser
   http://localhost:8000/api/tests


## Swagger Documentation
http://localhost:8080/swagger-ui/

## Help

Any advice for common problems or issues.
```
command to run if program contains helper info
```

## Authors

Contributor names and contact info

author@website.com or twitter

## Version History

* 0.2
    * Various bug fixes and optimizations
    * See [commit change]() or See [release history]()
* 0.0.1
    * Initial Release

## License

This project is licensed under the [NAME HERE] License - see the LICENSE.md file for details

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [PurpleBooth](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2)
* [dbader](https://github.com/dbader/readme-template)
* [zenorocha](https://gist.github.com/zenorocha/4526327)
* [fvcproductions](https://gist.github.com/fvcproductions/1bfc2d4aecb01a834b46)
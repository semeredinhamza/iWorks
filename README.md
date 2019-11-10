 Welcome to iWorks!
==================

This is a Java Google App Engine application.

Tecnologies used include: Java, JSP, CSS, Google App Engine, Maven, and Google Cloud SQL.

The Java source code is located in: src/main/java/iworks/
The front-end files are located in: src/main/webapp/
The test files are located in: src/test/java/iworks/

## Setup

    gcloud init
    gcloud auth application-default login

## Maven
### Running locally

    mvn appengine:run

### Deploying

    mvn appengine:deploy

## Testing

    mvn verify

As you add / modify the source code (`src/main/java/...`) it's very useful to add
[unit testing](https://cloud.google.com/appengine/docs/java/tools/localunittesting)
to (`src/main/test/...`).  The following resources are quite useful:

* [Junit4](http://junit.org/junit4/)
* [Mockito](http://mockito.org/)
* [Truth](http://google.github.io/truth/)


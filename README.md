# codecentric Netherlands - Prototype project #
[![Build Status](https://travis-ci.org/codecentric/slim-prototype.png)](https://travis-ci.org/codecentric/slim-prototype)

This repository is for prototype development within codecentric Netherlands.

== More information will follow soon ==

## Basic Information ##

### Structure ###
The project consists (for now) of two modules:
* pissalot-rest - Scala module that provides a RESTful JSON interface and implements all backend functionality
* pissalot-angular - AngularJS based front-end module for presenting all information

### Pissalot-REST module ###
This is a Scala module and uses SBT as build environment. For example to run the module locally in a Jetty
container, execute the following commands;
`$ sbt`
`> container:start`
To later stop the container;
`> container:stop`
`> exit`


### Pissalot-Angular module ###
AngularJS based front-end module that uses Karma and Jasmine for testing. Karma requires NodeJS / NPM to be installed.
Use the provided scripts in the 'scripts' directory to execute unit tests or e2e tests. Remember to execute NodeJS with
the provided 'web-server.js' script first, which will fire up a webserver to host all files.

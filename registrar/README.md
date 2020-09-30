# Registrar

A grails application to register people for course, e.g. due to Covid-19.

## Project forging

curl -s "https://get.sdkman.io" | bash
sdk install grails 4.0.4
curl -O start.grails.org/registrar.zip -d version=4.0.4


### Project generation

* https://start.grails.org/

### JDK problems

Do not use JDK14 but JDK11 after updating to Gradle 6.6.1.
This helps solving the problem shown [here](https://stackoverflow.com/questions/61289461/java-lang-noclassdeffounderror-could-not-initialize-class-org-codehaus-groovy-v)

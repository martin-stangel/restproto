JAX-RS / Swagger Demo 
======

This is a small Java project that showcases how to implement DRY - 
Don't Repeat Yourself principle, for definition of REST endpoint 
annotations in JAX-RS/Swagger projects. 

Used stack: Java 6, Jersey 2.17, Swagger 1.5.20

Example of usage:

```
mvnw jetty:run
... wait
curl -v -H "Accept: application/json" http://localhost:8680/accounts
curl -v -H "Accept: application/json" http://localhost:8680/accounts/3
curl -v -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d "{""id"": 3}" http://localhost:8680/accounts/3
```

Key findings:

* For JAX-RS: Method annotations in base classes are picked up by JAX-RS
if overridden method in the derived class has no JAX-RS 
annotations. Class annotations in base classes are always ignored. 
https://stackoverflow.com/questions/25916796/inheritance-with-jax-rs
* For Swagger: Method annotations of methods in base classes are 
picked up by Swagger unless the same annotation is used in overridden
method. 


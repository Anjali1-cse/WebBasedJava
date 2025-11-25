Spring REST: stand for Representational state Transfer
it is standard used for Representing state of resources on client side and managing the state  on server side.
it is one type of web Service(Restful web Service)



(java => Jakarta EE/Spring MVC)
                                                 Hdfc bank   (java)
Person-A                                             Person-B✔️
          presentation                                  |
                                               |--------|
 (java Classes)Business--> jar---------------->|--------|--|
                        |  (WEb)                           |
          persistence   |                               Person-C(java) AxisBank✔️
                        |
          Data Layer    |---web Service--------------✔️--->Person-D SBI (Dot NET) ❌         

          ICICbank      Banking

Web Service:
  it is softare system designed  to hava  Machine-to-Machine, inter-operable, commumication over the network.

  there are 2 type of web service:
  1.SOAP based(Simple object Access Protocal=HTTP+XML)
  2.Restful

  Restful Web Sevices: 
      As per the current trend,Restful web Sevices is most commonly used standard for building full stack application.
      It emphasizes on data of the application.

  1.Representational: the state of resources is Representated on client side in any format that is suitable to the client.
  there are many possible  formate but the most commonly used JSON( JAVA Script Object Notation)

  
  /createEmp{
    json
  }  |
     ⬇                 /getaLLEmps http REQ
  REST  Cient-----------------------------------> REST Impl.(REST API)-----| JDBC , HIB JPA
    Angular <--------------EMPs-----------------<------java                |
    Rest                   HTTP RES.                                       | 
    VueJS          Json<-------------------------------JAVA object-<------MYsql (DB)                 
    JavaScript   
    {  "empNo": 101...}

    2. State: the state of resource can be populate onthe sever side or even on client side depending upon the requirement.
       if client is requesting for the data, it is populated on server side and if it is sending data , it is populated on Client side itself.
    3. Transfer: the state populate on the one side needs to be made available on another side and that is possible by Transferring it.

Implementing REST:
Since REST is completely baesd upon HTTP semantics, it can be implemented using ant suitable technologies eg: java, DOT NET, Python, Node.js etc.

in java, there are several option eg:
Jersey Framework, Spring MVC and SPring BOOT

the most Popular option is Spring BOOT because it simplifies development by adding a layer of abstration.

eg: the front Controller i.e DispatcherServlet is auto-Configured.


Getting Started with SpringBoot:
 in order to Spring Boot, it is necessary to create Spring BooT  project. there are several options available ti create a SpringBoot project,
 but the most commonly used is Spring Initializer.

 it is web Interface that allows to configure project online and it is Accessible using URL: Start.Spring.io.


 Spring Boot API
Spring Boot API mainly provides two things
1) SpringBootApplication
2)SpringApplication

1) SpringBootApplication:-
it is an annotation that is to be applied at the class level.
it is a combination of three annotation
1. @Configuraton
2.@ ComponentScan
3.@EnableAutoConfiguration



2)SpringApplication
it is a class used tobootstrap the application
It provides s static run() method that is used to launch an embedded TOMCAT SERVER.
By default,the server get started on port 8080

Changing the port number
Since 8080 is the common port number, server fails to start if it is use. Therefore the standard practice is change it.
This is done  by making  entry into configuration file Application.Properties.

|-----------RestImpl                                          http(Get)
                htttp://locatHost:9080/doGreet                  /doGreet
             Rest client-------------------------------------->RestAPI                     
                 response<---------------------------------------|
Getting started with REST:
Rest resources are made Accessible to client against some url that is known as REST end point.
These REST end points are defined and configured
The actual implementation is provided using some method.
Once the method is defined it needs to be configured as a REST end point. This is done with help of  several annotations.
E.g. to configure and end point for accepting GET request, @GetMapping and in case of POST request, @PostMapping annotations are used.

Since REST implementation is completely based upon the data of the resource rather than view name it is necessary to intimate that the return value 
from the request handling method is the data and not the view name.
 This is done using @ResponseBody annotation 
This means if a combination of @Controller and @ResponseBody is used then always , data will be considered.                                                 
There is an alternative to this approach which simplifies the configuration instead of using 2 separate annotation, spring provides 
- a single annotation @RestController 
  it combines both the annotation and simplifies configuration.

Layered Architecture in REST:-
It is always a standard practice to decompose an application into several layers to achieve loose coupling , flexibility, modularity, and so on.
In the context of REST , the layered architecture mainly consist of three layers:
1.Controller Layer
2.Service Layer
3.DAO Layer


1.Controller Layer:-
It is the layer responsible for client interactions,
It accepts the response from client and send the response back.
It is taken care by  JAVA class annotated with @RestController annotation

2.Service Layer
It is the layer responsible for handling business logic if any.
It accepts the data coming from Controller layer and perform some operation based upon the requirement and further provides the processed data to the DAO layer.
It also accepts the data from DAO layer performs operations based upon the requirement and the further provides the processed data back to the Controller Layer.
It is taken care by a JAVA class annotated with @Service annotation


3.DAO Layer
It is the layer responsible  for handling persistency.
It interacts with database and performs necessary operations, typically CRUD operations.
It can be defined using a JAVA class and if so ,  the class is to be annotated using @Repository annotation.
However in many cases it is not required to be defined rather it is taken care by Spring framework itself.


                                                                    @RestController
Rest Client------------------>DispatcherServlet------------------->REST Controller
   ⬆--<-----------------------------⬆-----------<--------------------|    ⬇⬆
                                                                       @Service
                                                                         Service
                                                                           ⬇⬆
                                                                          @Repository
                                                                          DAO------------------>DB 

Interaction with DB:

In order to interact with db, there are several options available eg. JDBC,ORM like HIbernate and even JPA.
Even though, any of these option is used, developer has to write some code for handling data persistency.
 while working with any Business application, the entity type changes, ID type may change but thr overall logic for persistency is same.
 since the overall logic is same, it is taken away from developer and handled by framework itself.
 the only things to be specified is entity type and the ID type .
 This is made possible using an interface: JpaRepository and it belong to a module: Spring Data JPA.

configuring DB package Properties:
 spring data JPA NEEDS TO know the details about DB  configuration
 eg:- driver class, url, UID, pwd etc
 this is done by making entities in application.properties file. 

Package: example.spring.rest.data.jpa
│
├── [Main Class]
│   @SpringBootApplication (@Configuration)
│   SpringRestDataJpaProjectApplication
│   └── (Configuration Specific Class)
│
│
│   [Application Layers]
│
├── ➢ entity
│     └── Course
│
├── ➢ repo
│     └── CourseRepository (I)
│
├── ➢ service
│     └── CourseService
│
└── ➢ controller
      └── CourseController


Talend API Tester - Free Edition for testing api

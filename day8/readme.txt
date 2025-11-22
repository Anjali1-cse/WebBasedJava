Spring Framework:
      Spring is java based Framework meant for handling variouse aspects of application.
      Unlike Hibernate, it is not intented to do only one thing; rather it can handle several things.
spring Handles several functionalities through several modules.

Spring modules:
1. Spring Core 
2. Spring AOP 
3. Spring Data Access
4. Spring MVC
5. Spring REST 
6. Spring Security
7. Spring Cloud

1. Spring Core: It is module present at the base and all other modules are based upon 
 this  module.
 It handles core or  basic functionalities:
 1. Bean Management
 2. Dependency Injection

 2. Spring AOP : AOP stand for Aspect Oritented programming.
     It is set of principles or a programming pattern that allows to decouple(Separate)
     secondary concern from primary concerns.
     it bring 2 benefits:
     1.Modularity
     2.Reuseablity
     
     eg:

                      +-----------------------------+
                 |        Spring AOP           |
                 |  (Aspect Oriented Programming)
                 +-----------------------------+
                               |
                               v
        --------------------------------------------------
        |                 GOAL OF AOP                    |
        | Separate Secondary Concerns from Primary Logic |
        --------------------------------------------------

                          +------------------+
                          |     ASPECTS      |
                          | (Secondary Work) |
                          +------------------+
                           /        |        \
                          /         |         \
                         v          v          v
                +----------+ +-----------+ +----------+
                | Logging  | | Execution | | Security |
                |   Code   | |   Time    | |  Checks  |
                +----------+ +-----------+ +----------+
                         \         |         /
                          \        |        /
                           \       |       /
                            v      v      v
                     +------------------------+
                     |     BUSINESS LOGIC     |
                     |   (Primary Concern)    |
                     +------------------------+

Example (IRCTC)
---------------------------------------

Primary Concern: 
    makeReservation(), cancelReservation()

Secondary Concerns:
    - Record start time
    - Record end time
    - Logging
    - Security checks

Without AOP (Problem: Mixed Code)
---------------------------------------
makeReservation() {
    [secondary concern: start time]
    [primary concern: reservation code]
    [secondary concern: end time]
}

With AOP (Clean Separation)
---------------------------------------
Aspect: TimeLoggingAspect
    -> runs BEFORE and AFTER makeReservation()

Business Class: ReservationService
    -> contains ONLY reservation logic


     IRCTC

     makeReservation(){
     // =code  for recording start time of time ----->secondary concern
     //code for makinng reservation (primary Concern)
     // code  for recording end time of time ----->secondary concern
     }
     cancelReservation(){

     }

3. Spring Data Access: It allow to interact with DB 
                       it doesnot not implement its own logic for DB interact; rather it provides
                       hooks(Connectors)to interact with other persistence related technologies
                       Like JDBC, hibernate, JPA and so on.

4.Spring MVC: stand for Model-View-Controller
              it is a commonly used design pattern or architecture for building web application.
              Spring MVc is also meant for developing web application.

5. Spring REST: stand for Representation State Transfer 

  it is a standard meant for Representing resources on client side in the format that 
  is suitable to  the client, typically it is JSON i.e. Java Script Object Notation.
  Spring allow to building Restful resources using Spring REST module.

6. Spring Security: it used to secure resources within the application.
                   it mainly work at 2 levels:
                   1 Authentication
                   2. Authorization
7.Spring Cloud: it is used to interact with cloud baesd service.

Getting started  with Spring Core  functionalities.
 1. Bean Management
 2. Dependency Injection

1. Bean Management:
      Like Jakarta EE,Spring is also based upon Component Driven architecture.
       howeverin Jakarta EE , even  through Components Managed by container, they aloways
       need to be Dependent upon some API .
       EG. several implement class aloways extends HttpServlet.

Spring provide dual service
       it Managed the Component even through they are implement i.e (POJO)-plain old java object
 in order to get Managed the Component by spring. it need to be declared to the enviroment of spring.
 Any Component that is declared to the enviroment of spring is called as a bean or Spring bean.






 BEAN MANAGEMENT (Horizontal Diagram)
 =====================================================================================

   Java SE (Simple POJO)          |           SPRING (Manages POJO)         |       Jakarta EE (Dependent Component)
 ---------------------------------|-----------------------------------------|-----------------------------------------
   • Unmanaged                    |   • Managed by Spring Container         |   • Managed by Application Server
   • Independent                  |   • Still a POJO (no API dependency)    |   • Must extend framework API classes
   • Developer creates object     |   • Dependency Injection (IOC)          |   • Not a POJO (dependent class)
 ---------------------------------|-----------------------------------------|-----------------------------------------

   public class Book {            |   @Component                             |   public class BookServlet
       ...                        |   public class Book {                    |          extends HttpServlet {
   }                              |       ...                                |          ...
   Book b1 = new Book();          |   }// Spring creates Book bean           |   }// Container creates servlet
 ---------------------------------|-----------------------------------------|-----------------------------------------

     Unmanaged & Independent      ----------- Spring IOC ----------->   Managed & Dependent
 =====================================================================================

-------------------------------------------------------------------------------------

                   HORIZONTAL Class-to-Bean Representation
-------------------------------------------------------------------------------------

Java Class (Unmanaged)              |           Spring Environment (Managed Bean)
------------------------------------+---------------------------------------------------
public class MyClass {              |        +--------------------+
    ...                             |        |   Spring Bean      |
}                                   |        |    MyClass         |
                                    |        +--------------------+
UnManaged                           |             Managed (IOC)

-------------------------------------------------------------------------------------

Spring provides *dual advantage*:
1. **Manages components** (like Jakarta EE)
2. **Allows them to remain POJOs** (unlike Jakarta EE servlets/EJBs)

Any component declared inside the Spring environment (XML, annotations, Java config)
is called a **Spring Bean**.

-------------------------------------------------------------------------------------

2. Dependency Injection: It  is feature originally introduce by spring later on adopted by serval other technologies.
    the  beans register or declared to springs envirnoment may have dependencies
    Spring injects those dependencies into bean and return  the bean back to cilent program.
     this is known as Dependency Injection
Getting Started: 

1. Setup the Development Environment
      Jdk
      IDE (Eclicpse)
      Spring specific Libraries
    Since Spring is java based framework it provide its Libraries in form of several .class files which are bundled into several .jar files.
    therefore to get starded with Spring , it is necessary to install these .jar files.
    there  option  to install them
    1. manually
    2. using tool loke Maven, gradle etc.

2. Create an interface.
   Since Spring promotes Programming by interface, it is standard practice  to create an interface.
3. create an implement class  for that interface
4. Declear a bean of the implementation class type to the envirnoment of Spring.
   in order to declare a bean to the envirnoment of spring , there are 2 operation
   1. using XML : in case of XML, the file can hava any name , but convention , it is Spring-config.xml.
                  this file can be placed anywhere i.e. with the project or even outside the project , but  within the project  is recommended.
                  It can be placed anywhere within the project , but by convention it is to be placed under src/main/resources folder.

   2. Without using XML

5.write a client program(Main)
in order to load the bean using spring, first it is necessary to intimate spring about the location of configuration unit.
 if the relevant XML file is avilable outside the project, it is to located using an absolute path
 if it inside the project then it can be located using an absolute path as well ass relative path.
 Once the configuration unit is located, spring can use it futher for obtaining the bean.
 in order to obtain the bean, spring provide an interface ApplicationContext. 
 it has several implementation classes out of which one is frequently used :
 1. FileSystemXmlApplicationContext.  
 once the configuration unit is loaded, spring can obtain the bean againt Its ID.
 this is done using getBean() method.

Dependency Injection: the bean declared to spring envirnoment may have dependencies.
when a client program requests spring to get the bean, spring has to injects values into properties of that bean and return the same back to clinnt. 
this technologies is known as Dependency Injection.

in general, dependency Injection take places using 2 option
1.setter injection: spring injects values into the properties of the bean by invoking setter method.
2.constructor injection: spring injects values into the properties of the bean by invoking parameterized constructor method.
 in case of constructor injection, spring follows some algorithm for ordering.
 by default it uses top-bottom in xml and left to right in java
 in order the change constructor used index in constructor-algorithm

Bean declaration or configuration Without XML:
in modern java semantics, XML is not must preferred for any configuration as it is too lenghty and errro-prone.
Spring also provides an alternative to XML using following options:
   1.java based configuration.
   2. Pure annotation based configuration
both the option make use of annotationa however the configurations are different.

 1.java based configuration:
        the configuration unit is provided by defining a java class.
        this java class have any name; but convention it is SpringConig.
    once the class is defined, it is necessary to initmate Spring that the class is configuration specific class.
    this is done by annotation that class using @configuration annotation.

    once the configuration specific classs is defined, it can be used futher to declare bean
    in order to declare the bean, degine a method in sunch way that it returns an object of the bean that to be declared

    once the method is definedit is necessary to initmate Spring that the method is bean declare mathod @Bean annotation.
    by default the bean get registered in Spring envirnoment with an Id that is equal to the method name.
E.g. if the method name is doWelcome(), then the ID is also doWelcome().

Loading the Bean:
In order to load the bean declared using some annotation, Spring provides a class: AnnotationConfigApplicationContext.

Pure Annotation Based Configuration:
In case of Java based configuration, even though the beans are declared to Spring’s environment, still developer has to use new keyword for the bean declaration.

In this approach, beans are not declared using new keyword; rather they are declared using several stereo-type annotations.
They are instantiated using Java’s reflection semantics.
There are several stereo-type annotations available; but the most commonly used is @Component.
It is applied at the class level to mark that class as a component so that Spring manages it.

Once the class is annotated with @Component annotation, in order to get it picked by Spring, it is necessary to scan the package which provides that class.
This is done using @ComponentScan annotation.
It is to be applied at the configuration specific class level.

Java Based Configuration  Vs. Pure Annotation Based Configuration:
In case of 1st option, new keyword is required whereas in case of 2nd option, reflection semantics are used.

The 2nd option is useful if the beans are singleton and the bean specific classes are newly designed with full intention.

The 1st option is useful when the bean classes are legacy classes and multiple instances of that bean type are required.




    config        @componentScan                     first 
       |         @configuration                       @Component
       |-------->springAppCongig                      FirstComponent
       |
       |         @Component                         second
       |-------->ManagedComponent                      @Component
                                                            SecondComponent
                                                               second.child
                                                                  @Component
                                                                  SecondChildComponent
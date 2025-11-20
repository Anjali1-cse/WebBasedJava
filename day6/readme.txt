Java Framework:
In the context of java programming model, technologies are mainly divided into 2 categories:
1. Specification
2. Framework

Specification:
It is set of rules expected to be implemented by some 3rd party software.
Eg: Jakarta EE is Specification and it is implemented by 3rd party software called as Web Server and Application Server.

Framework:
It is partial solution used to address common problems.
It provides a partial implementation on the top of which further customizations can be done.
There are several Framework based on java technology available and each has its own significance.
Eg:
1. Struts (used to building web applications)
2. Tapestry (used to building web applications)
3. JSF (Jakarta Server Faces) - used to building web applications
4. JUnit (used for unit testing)
5. JMockit (used for mocking test-driven development)

Even though there are several Java-based Frameworks available, 2 of them are very popular and used frequently:
1. Hibernate
2. Spring

--------------------------------------------------------------------------------
1. Hibernate:
It is an open-source Java-based Framework meant for building Persistence Layer of an application.

User enter data/fetch <-------> Presentation Layer → HTML, CSS, JSP
                                       ↓      ↑
                                Business Layer → Java Classes
                                       ↓      ↑
                              Persistence Layer → JDBC, Hibernate
                                       ↓      ↑
                                 Data Layer(DB) → MySQL

Even though JDBC can be used to handle Persistence Layer, it has several challenges:
1. A lot of coding (Boiler-Plate Code)
2. Use of SQL is mandatory
3. No support for object modeling, requires extra efforts
4. No support for performance optimization, requires extra efforts

Hibernate can be used to overcome these challenges:
1. It handles data persistency using JDBC as underlying API.
2. Since it works on the top of JDBC, it is not a replacement to JDBC, rather
   it is an abstraction on the top of JDBC.

                   BEFORE HIBERNATE vs AFTER (USING) HIBERNATE
                      --------------------------------------------


   ============================         ================================
          BEFORE HIBERNATE                       SINCE HIBERNATE
   ============================         ================================

         Java Application                     Java Application
                 |                                    |
                 v                                    v
               JDBC                                Hibernate
                 |                                    |
                 v                                    v
             Database                              JDBC Driver
                                                    (internally)
                                                      |
                                                      v
                                                   Database


   ----------------------------         --------------------------------
   Flow:                                 Flow:
   Java App → JDBC → Database            Java App → Hibernate → JDBC → Database
   ----------------------------         --------------------------------
Notes:
- Before Hibernate, Java code interacts directly with JDBC (SQL queries).
- With Hibernate, Java app talks to Hibernate; Hibernate generates SQL and interacts with JDBC internally.

--------------------------------------------------------------------------------
Anatomy of Hibernate:
Hibernate is framework based upon ORM (Object to Relational Mapping).
ORM is mapping between domain-specific objects and relational Database tables.

Principles of ORM:
1. Automated Persistence
2. Full Support for Object Modeling
3. Full Support for Performance Optimization
4. Supports query language that works with classes & properties (not tables & columns)
5. Persistence on the basis of metadata

Other ORM Frameworks:
1. Toplink
2. EclipseLink
3. IBatis
4. etc.

--------------------------------------------------------------------------------
Hibernate Core API:
Core API belongs to package: org.hibernate.
It mainly provides:

1. Session:
   - Interface from org.hibernate
   - Light-weight object responsible for CRUD operations
   - Wrapper over JDBC connection

2. SessionFactory:
   - Interface from org.hibernate
   - Heavy-weight object used to produce Session
   - Recommended only 1 per application

3. Configuration:
   - Class from org.hibernate.cfg
   - Used to configure Hibernate based on metadata
   - Used to obtain SessionFactory

4. Transaction:
   - Interface from org.hibernate
   - Used to manage transactions ensuring Atomicity

5. Query:
   - Interface from org.hibernate.query
   - Used to perform querying operations

--------------------------------------------------------------------------------
Getting Started:

1. Setup Development Environment:
   → JDK  
   → Some RDBMS (MySQL)  
   → Some IDE (Eclipse)  
   → Hibernate Libraries (JARs)

Hibernate libraries are .class files packaged as multiple .jar files.
Download options:
1. Manually
2. Build tools (Maven / Gradle)

⇒ For Eclipse errors: window → preferences → XML → Download external resources.

--------------------------------------------------------------------------------
2. Provide an Entity Class:
   In the context of Hibernate, it is necessary to define a class of which an object is represented as a record into the DB table.
   Such a class is known as an Entity class.

   In Hibernate, a class whose object is represented as a DB record is called Entity class.

3. Provide Mapping Metadata:
   Hibernate handles data persistency based upon the mapping information about class-table, fields-columns etc.
   This is known as mapping metadata.
   There are 2 options available for providing mapping metadata:

   Two ways:
   1. XML (Project.hbm.xml)
   2. Annotations (JPA)
In case of XML, the name of the file can be anything; but by convention it is <<Entity-Class-Name>>.hbm.xml.
E.g., if the Entity class name is Project, then the file name is Project.hbm.xml.
This file must be placed within src/main/resources folder.


XML mapping file must be placed inside:
→ src/main/resources

--------------------------------------------------------------------------------
4. Provide Configuration Metadata:
Hibernate hides the code for DB connectivity from developer.
However, in order to connect to DB, Hibernate needs relevant information that is provided using configuration metadata.
There are 2 options available for providing configuration metadata

Two Approaches:
1. Declarative
   a. hibernate.properties
   b. hibernate.cfg.xml (default)
      In case of PROPERTIES file option, Hibernate refers to a file named as hibernate.properties.
      In case of XML file option, Hibernate by defaults refers to a file named as hibernate.cfg.xml.
      This file must be placed within src/main/resources folder.
2. Programmatic
   → Using methods of Configuration class

hibernate.cfg.xml MUST be inside:
→ src/main/resources

--------------------------------------------------------------------------------
5. Provide Main Class:(Class containing main() method)

   Hibernate Configuration:
   In order to configure Hibernate, Configuration class is used.
   When the object of Configuration class is created, Hibernate looks for a file: hibernate.properties.
   If found, Hibernate loads entries from that file.

     If the configuration specific entries are available in hibernate.cfg,xml file, it is necessary to intimate Hibernate about this.
     This is done by invoking configure() method.
     If the name of the XML file is different, then overloaded version of configure() method is used.
Once the configuration is done, it can be used further to build SessionFactory.


or
Use Configuration class to configure Hibernate.

If hibernate.cfg.xml exists:
→ call configure()

If XML name is different:
→ call overloaded configure("filename")

Then:
→ build SessionFactory

--------------------------------------------------------------------------------
============================== HIBERNATE DEVELOPMENT ENVIRONMENT ==============================

   ┌─────────────────────────────────────────────────────────────────────────────────────────┐
   │                                       JAVA (JDK)                                         │
   └─────────────────────────────────────────────────────────────────────────────────────────┘
                                   |
                                   v
   ┌─────────────────────────────────────────────────────────────────────────────────────────┐
   │                                           IDE                                            │
   │                            (Eclipse / IntelliJ / STS / VS Code)                          │
   └─────────────────────────────────────────────────────────────────────────────────────────┘
                                   |
                                   v
   ┌─────────────────────────────────────────────────────────────────────────────────────────┐
   │                               HIBERNATE LIBRARIES (JARs)                                 │
   │                     (Added through Maven → hibernate-core dependency)                    │
   └─────────────────────────────────────────────────────────────────────────────────────────┘
                                   |
                                   v
   ┌─────────────────────────────────────────────────────────────────────────────────────────┐
   │                                  PROJECT STRUCTURE                                       │
   │------------------------------------------------------------------------------------------│
   │ 1. ENTITY CLASS → example.entity.Project                                                 │
   │ 2. MAPPING METADATA → Project.hbm.xml  OR  JPA Annotations                               │
   │ 3. CONFIGURATION METADATA → hibernate.cfg.xml / properties / programmatic                │
   │ 4. MAIN CLASS → example.main.App                                                         │
   │ 5. UTILS → HibernateUtil (SessionFactory provider)                                       │
   └─────────────────────────────────────────────────────────────────────────────────────────┘
                                   |
                                   v
   ┌─────────────────────────────────────────────────────────────────────────────────────────┐
   │                                     DATABASE (MySQL)                                     │
   └─────────────────────────────────────────────────────────────────────────────────────────┘

==============================================================================================


--------------------------------------------------------------------------------
HIBERNATE ARCHITECTURE:

Java Application
   |
   v
Hibernate API (Configuration, SessionFactory, Session)
   |
   v
Hibernate Core (ORM, Mapping, Dialect)
   |
   v
JDBC (internally)
   |
   v
Database

--------------------------------------------------------------------------------
Providing Metadata Without XML:
In the context of Hibernate, metadata is of 2 types:
Two types of metadata:
1. Mapping Metadata  
2. Configuration Metadata  

Mapping Metadata alternatives:
→ XML  
→ Annotations

Annotations Types:
1. Hibernate Annotations
2. JPA Annotations (Recommended)

Hibernate Annotations:
These are the annotations provided by Hibernate of its own.

JPA:
Java Persistence API (Jakarta Persistence API)
It is a specification implemented by:
Hibernate, Toplink, EclipseLink, OpenJPA, etc.


JPA Annotations:
JPA stands for Jakarta Persistence API.
It is a specification i.e. Set of Rules and implemented by some ORM framework e.g. Hibernate, Toplink, IBatis, Eclipselink etc.
It allows to migrate from one ORM to another without making changes in the Java Code.

Main JPA Annotations:
1. @Entity (mandatory)
2. @Table (optional)
3. @Id (mandatory)
4. @Column (optional)
@Entity:
Used to mark the class as an Entity class.
It is mandatory.

@Table:
Used to map an entity class to the DB table.
It is optional. If omitted, it defaults to the unqualified name of the class.

@Id:
Used to declare a field of an entity class as an ID.
It is mandatory.

@Column:
Used to map a field to a column in the DB table.
It is optional. If omitted, it defaults to the field name.

In case of configuration metadata, Hibernate provides an alternative to XML and i.e. Programmatic Configuration.
It is done by using relevant methods of Configuration class.

--------------------------------------------------------------------------------
============================         ================================
           HIBERNATE                          SINCE JPA
============================         ================================

       Java Application                     Java Application
               |                                    |
               v                                    v
           Hibernate                               JPA
               |                                    |
               v                                    v
           JDBC Driver                           Any ORM
               |                             (Hibernate / EclipseLink /
               v                              TopLink / OpenJPA etc.)
            Database                               |
                                                   v
                                             JDBC Driver
                                                   |
                                                   v
                                                Database


----------------------------             --------------------------------
Flow:                                       Flow:
Java App → Hibernate → JDBC → Database     Java App → JPA → ORM → JDBC → Database
----------------------------             --------------------------------

--------------------------------------------------------------------------------
Example Package Structure:
example.entity → entity class  
example.main → main class  
example.utils → HibernateUtil  

--------------------------------------------------------------------------------
========================== HIBERNATE INTERNAL LAYERS ==========================

 Application Layer
 ─────────────────────────────────────────────────────────────────────────────
 |  Your Java Code (main, DAO, Services)                                      |
 ─────────────────────────────────────────────────────────────────────────────

 Hibernate Framework Layer
 ┌────────────────────────────────────────────────────────────────────────────┐
 │ Configuration          → Loads cfg.xml / properties                        │
 │ SessionFactory         → Heavy object, thread-safe                         │
 │ Session                → Light object, represents DB connection             │
 │ Transaction            → Manages commit/rollback                           │
 │ Query / HQL / Criteria → Fetching & querying data                          │
 └────────────────────────────────────────────────────────────────────────────┘

 Persistence / ORM Layer
 ┌────────────────────────────────────────────────────────────────────────────┐
 │ Mapping Files (.hbm.xml)                                                   │
 │ JPA Annotations (@Entity, @Id, @Table, @Column, etc.)                      │
 │ Hibernate Dialect (MySQL, ORACLE, PostgreSQL dialect)                      │
 │ Object-Relational Mapper (transforms Objects <--> Tables)                  │
 └────────────────────────────────────────────────────────────────────────────┘

 Underlying JDBC Layer
 ─────────────────────────────────────────────────────────────────────────────
 | JDBC Driver (MySQL, Oracle, PostgreSQL)                                    |
 ─────────────────────────────────────────────────────────────────────────────

 Database Layer
 ─────────────────────────────────────────────────────────────────────────────
 | MySQL, Oracle, PostgreSQL, H2, etc.                                        |
 ─────────────────────────────────────────────────────────────────────────────

===============================================================================


--------------------------------------------------------------------------------
============================== HIBERNATE FLOW =================================

                   ┌────────────────────────┐
                   │   Load Configuration    │
                   │  (hibernate.cfg.xml)    │
                   └────────────────────────┘
                               |
                               v
                   ┌────────────────────────┐
                   │   Build SessionFactory  │
                   └────────────────────────┘
                               |
                               v
                   ┌────────────────────────┐
                   │      Open Session       │
                   └────────────────────────┘
                               |
                               v
                   ┌────────────────────────┐
                   │     Begin Transaction   │
                   └────────────────────────┘
                               |
                               v
       ┌───────────CRUD Operation────────────┐
       │   save() / update() / delete()       │
       │   get() / load() / query()           │
       └──────────────────────────────────────┘
                               |
                               v
                   ┌────────────────────────┐
                   │   Hibernate Generates   │
                   │      SQL (internally)   │
                   └────────────────────────┘
                               |
                               v
                   ┌────────────────────────┐
                   │   JDBC Executes Query   │
                   └────────────────────────┘
                               |
                               v
                   ┌────────────────────────┐
                   │   Commit Transaction    │
                   └────────────────────────┘
                               |
                               v
                   ┌────────────────────────┐
                   │      Close Session      │
                   └────────────────────────┘

===============================================================================


--------------------------------------------------------------------------------
===================== OBJECT TO RELATIONAL MAPPING (ORM) =====================

 Java Class                          Database Table
 ───────────────────                 ───────────────────────────
 |   Project        |                |     PROJECTS              |
 |------------------|                |---------------------------|
 | int id;          |    maps to →   |  ID (PK, INTEGER)         |
 | String name;     |    maps to →   |  NAME (VARCHAR)           |
 | double cost;     |    maps to →   |  COST (DOUBLE)            |
 ───────────────────                 ───────────────────────────

===============================================================================

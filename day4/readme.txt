
http://localhost:9000/web-project/fitness_info.html

http://localhost:9000/web-project/getBmi?myName=anjali&myWeight=85&myHeight=155
myName,myWeight,myHeight:request Parameter name
anjali,85,155: - request Parameter value


Working with http Post request:
sometimes a client may want to send a sensitive or confidential information toword
sever eg user credentials, bank account Details and so on.

ideally this information to be hidden and ti is possible bt making a post request.
inorder to amake a POST request , use mathod ="pos" setting for<form> Tag in html.

in order to handle POST REQUEST override doPost() method in servlet implementation class.
HttpGet vs HttpPost
1. in case of get request, parameter are always appended to the URL whereas in case of 
POST , they are sent along with the page body.
2. there is a limitation on data transfer in case of GET request(8KB) whereas there 
no limitation in case of POST REQUEST.
3. there IS limitation on URL lenght in case of GET request(255chars) whereas there
is not limitation in case of POST request.

Collabration:
   when one component with in a web application interacts with another then that 
   process is known as Collabration.

it provide 2 benefits:
1.Modularity
2.Reusabily   

                                              displayStudent
                                              Servlet
                                                          

serarch_student.html|
                    |
 id-_____           |        /dosearch  
search              |--> serarch_student-------->StudentDao----->DB       
                    |     Servlet
                    |
                    | 


Implementing Collabration:  in order to to implement Collabration, servlet API provide
an interface:
RequestDispacher from jakarta.servlet package

in order to use RequestDispacher , it is necessary to obtain its reference which is possible
using request object.
 inorder to user RequestDispacher there are 2 method provided:
 1. forword(): methed forword the request to the next component and the next 
    component and the next component generate response back  to the client.
                           fwd
 client--------->servlet1--------->servlet2
     ^                               |
     |-------------------------------|                     

 2. include():method forward the request to the the next component , takes the response
 from that component,come back to previous component and the previous component 
 generate the response back to client

                          
                          
 client--------->servlet1--------->servlet2
     ^              ^              |
     |--------------|---------------|        

+--------------------------------------------------+
|               Servlet A (Caller)                 |
+--------------------------+-----------------------+
                           |
                           |  1) Receives Request
                           |     from Browser
                           v
               +-----------------------------+
               | Reads / Processes Request   |
               +-------------+---------------+
                             |
                             |  2) Forwards/Includes
                             |     Request to Another Servlet
                             |     using:
                             |     RequestDispatcher rd =
                             |       request.getRequestDispatcher("/ServletB");
                             |     rd.forward(request, response);
                             v
+--------------------------------------------------+
|               Servlet B (Target)                 |
+--------------------------+-----------------------+
                           |
                           | 3) Executes service()
                           |    doGet()/doPost()
                           v
               +-----------------------------+
               |   Generates Response        |
               +-------------+---------------+
                             |
                             | 4) Sends HTTP Response
                             v
+--------------------------------------------------+
|               Browser Displays Output             |
+--------------------------------------------------+


Session management:
  in web application most commonly used protcol is http
  http->Hypertext transfer protocol
  in general , a protocol is of 2 type
  1. stateless
  2. stateful

--->In case of a stateless protocol, the server does not maintain any
conversational state with the client.
It simply sends a response for each incoming request independently.
The server does not understand whether the same client is making the
request again or a different client is making it. 
Example: HTTP is a stateless protocol.

---->In case of a stateful protocol, the server maintains conversational
state across multiple requests of the same client.
The server can identify the client across multiple requests and can
remember previous interactions.
Example: FTP, TCP sessions behave statefully.

→ In a Web application; a client may have to make multiple for performing 
some coperation requests towards server Throughout all these request,
 a server has to maintain conversational state with the client

Since HTTP is a stateless protocol, by default the web Seuver cannot maintain 
the state with the client and therefore it is to be implemented programmatically 
using a mechanism known as Session (State) Management


Session management can be done using serval options:
1. URL Encoding
2. hidden fields
3. cookies
4. Servlet ->HttpSession


                      (Session Token / Cart)
                                     +---------+
                                     |  Token  |
                                     | (Cart)  |
                                     +---------+
                                          ^
                                          |
+------------------+      Request      +----------------------+
|                  | ----------------> |                      |
|      CLIENT      |                   |        SERVER        |
| (Browser/User)   | <---------------- | (Creates Session     |
+------------------+     Response      |   & Stores Token)    |
                                      +----------------------+
                                          |
                                          |
                                          v
                                 Session Storage


4. Servlet ->HttpSession:

                                     SESSION MANAGEMENT USING HttpSession
                     ------------------------------------

   +------------------+                               +----------------------+
   |                  |      Request (no session)      |                      |
   |      CLIENT      | -----------------------------> |        SERVER        |
   |   (Browser)      |                                |   Servlet Container  |
   +------------------+                                +----------------------+
                                                               |
                                                               | Creates
                                                               | new HttpSession
                                                               v
                                                        +----------------+
                                                        |  HttpSession   |
                                                        |  (Session ID)  |
                                                        +----------------+
                                                               |
                             Response (Set-Cookie: JSESSIONID) |
   +------------------+ <--------------------------------------+
   |                  |
   |      CLIENT      |  Stores JSESSIONID cookie
   |   (Browser)      |
   +------------------+
           |
           | Next Request (includes JSESSIONID cookie)
           v
   +------------------+      Request with Session ID     +----------------------+
   |      CLIENT      | -------------------------------> |        SERVER        |
   +------------------+                                  |  Finds same session  |
                                                         +----------------------+








counter.html|
            |-------->CounterServlet /doCont
(click btn) |             |
                          |
                          |  request.getSession()
                  token   |
            |<------------|
counter.html|
hitCount 1  |
(click btn) |  


Working with HttpSession:
inorder to implement session management, Servlet API provides an interface: 
HttpSession form the package: jakarta.servlet.http.

the object of type HttpSession is used to maintain conversational state along with
the client.

in order to use HttpSession, it is necessary to obtain its reference which is possible 
using requestobject.
->it provide a method getSession() that returns a reference of type:
  HttpSession.
  there 2 forms of getSession().
   1.getSession():--> it returns an existing session if avalable, otherwise create 
                       new one and returns the same.
            
   2. getSession(boolean):--> it behave exactly same as that of 1 st method if true
                       value is used.
                       incase of  false value, it returns the session only if it available
                       otherwise it does not create any new session and in that case it return null.
every time when a getSession() method is invoked , server(web Container) checks 
whether the client has any session associated or not
.
- this is usually done with the help of cookies.
- During the 1st request, since there is not any cookie coming from client towords
server decides to create a new sesssion.
- As soon as the session is created, server assigns a unique identify to that session 
which is known as session ID.
- futher, the server Stores the session ID and the corresponding session object is 
Map based collection.
- Then the server generate a cookie and stores that session ID into that cookie
and then it send that cookie  back to client  via response object.
- when the clent makes a sub-sequent request, along with the request it sends the 
same cookie back to server and server understand that the client has a session.
                          WORKING WITH HttpSession
                          -------------------------

   STEP 1: CLIENT MAKES FIRST REQUEST (NO COOKIE)

   +------------------+                       +-----------------------------+
   |                  |   Request (no cookie) |                             |
   |     CLIENT       | --------------------> |       SERVER / CONTAINER    |
   |   (Browser)      |                       |                             |
   +------------------+                       +-----------------------------+
                                                       |
                                                       | Server checks:
                                                       | request.getSession()
                                                       v
                                        No existing session → Create new session
                                                       |
                                                       v
                                            +------------------------+
                                            |     HttpSession        |
                                            |   (New Session Object) |
                                            +------------------------+
                                                       |
                                                       | Generate Session ID
                                                       |
                                                       | Store in server memory:
                                                       |   Map<sessionId, sessionObject>
                                                       v
                                            +------------------------+
                                            |  Session ID (e.g. 7A3F)|
                                            +------------------------+
                                                       |
                                                       | Create Cookie: JSESSIONID=7A3F
                                                       | Send cookie to client in response
                                                       v
   +------------------+  <------------------------------+
   |                  |        Response (Set-Cookie)    
   |     CLIENT       |    Stores JSESSIONID cookie     
   |   (Browser)      |
   +------------------+


   STEP 2: CLIENT MAKES NEXT REQUEST (COOKIE SENT)

   +------------------+                       +-----------------------------+
   |                  |  Request + Cookie     |                             |
   |     CLIENT       |  JSESSIONID=7A3F ---->|       SERVER / CONTAINER    |
   |   (Browser)      |                       |                             |
   +------------------+                       +-----------------------------+
                                                       |
                                                       | request.getSession()
                                                       | → Reads cookie
                                                       | → Finds session in Map
                                                       v
                                            +------------------------+
                                            |   Same HttpSession     |
                                            |   (Session continued)  |
                                            +------------------------+
                                                       |
                                                       v
                                      Server sends response → Client continues session

Using HttpSession: provides several method:
1.isNew(): return ->boolean indicating whether the session is new or not.
2. setAttribute() ->stores data into the session in the formn of name-value pair.
3.getAttribute()-> Loads data from the session based upon the its name.
4. setMaxInactiveInterval()-> specifies time interval in terms of seconds insuch a way
that client has to make a request towords server within that time in order to retain
the session
5.invalidate()->Forcefully terminates the session.

JSP stand for jakarta server pages.
JSP is web component that is used to extend the functionality of webserver.
it is a component that run on server side.
it can be used to generate dynamic web pages.

why jSP? 
In a web application , generally , the logic is 2 types:
1.Proceesing Logic
2.Presentation Logic

REQUEST
search------->servlet<----------Display  
Student                       Student

processing logic             Presentation logic
  ⬆️                               ⬆️
 web Developer                 web Designer   

when emphasize is more on Presentation rather than Processing, If it is to be
done using servlet, the use of java code is mandatory as servlets are defined 
 using a java class

 since JSP IS MORE closer to Html rather than java from coding 
 perspective, web Designer can design elegnt pages without writting a java code 
  and therefore insuch scenarios ,JSP are preferred.

life Cycle of JSP
like servlet,JSP life cycle consists of stages

1. Instatiation and Intalization
2. Service
3. Destroy
to handle  the life cycle there 3 methods inuse which are referred as life cycle 
method
1.jspInit()
2.jspService()
3.jspDestroy()

- when the JSP is requested for the 1st time, it is loaded by Web container.
- As soon as the loading is finished , it iscompiled and translated or coverted into 
servletis generated by web container itself and this class povides implementation
of life cycle methods .
- futher the container instantiates this classs and invokes jspInit() method. 
 - then it invoke _jspService() method.
 - when thw JSP is requested sub-sequent times, only  _jspService() method is called.\
 - when hte server is stopped ot the application is undeployed, web container invoke
 jspDestroy() method.

                         LIFE CYCLE OF JSP
                         ------------------

        CLIENT REQUESTS JSP FOR THE FIRST TIME
        ---------------------------------------

   +----------------------+                  +-----------------------------+
   |        CLIENT        |  Request (JSP)   |        WEB CONTAINER        |
   +----------------------+ ---------------->+-----------------------------+
                                                      |
                                                      | 1. Load JSP
                                                      v
                                           +-------------------------+
                                           |    Load JSP File        |
                                           +-------------------------+
                                                      |
                                                      | 2. Translate JSP → Servlet
                                                      v
                                           +-------------------------+
                                           |  Translate to Java file |
                                           |   (JSP → .java servlet) |
                                           +-------------------------+
                                                      |
                                                      | 3. Compile Java → Class
                                                      v
                                           +-------------------------+
                                           |   Compile .java to .class|
                                           |   (Generated Servlet)    |
                                           +-------------------------+
                                                      |
                                                      | 4. Instantiate Servlet
                                                      v
                                           +-------------------------+
                                           | Instantiate JSP Servlet |
                                           +-------------------------+
                                                      |
                                                      | 5. Call jspInit()
                                                      v
                                           +-------------------------+
                                           |       jspInit()         |
                                           +-------------------------+
                                                      |
                                                      | 6. Call _jspService()
                                                      v
                                           +-------------------------+
                                           |     _jspService()       |
                                           | (Handles client request)|
                                           +-------------------------+
                                                      |
                                                      | Response returned to client
                                                      v
   +----------------------+ <------------------------+
   |        CLIENT        |
   +----------------------+


        SUBSEQUENT REQUESTS
        ---------------------

   +----------------------+                  +-----------------------------+
   |        CLIENT        |  Request (JSP)   |        WEB CONTAINER        |
   +----------------------+ ---------------->+-----------------------------+
                                                      |
                                                      |  _jspService() only
                                                      v
                                           +-------------------------+
                                           |     _jspService()       |
                                           +-------------------------+


        SERVER SHUTDOWN / APP UNDEPLOY
        --------------------------------

                                                      |
                                                      |  Call jspDestroy()
                                                      v
                                           +-------------------------+
                                           |     jspDestroy()        |
                                           +-------------------------+

jSP File Structure:
file cantain folllowing:
  1. HTML Tags
  2. Any Valid Java Code.
  3. JSP Tags 

  JSP Tags:
  3 types:
  1.Directived
  2. Scripting Element
  3. Standard  Action

  1.Directived: are denoted using<%@.....%>
    they are 3 types.
      1. page : it used to confure JSP page.
                it provide several attributes
                 attributes: 
                    1.language:- default to- java and allow only value:"java"
                                 used to specify Scripting language of the page.
                    2. session:- used to specify whether the page participates in 
                                 session or not.
                                 it default to "true" and it means that the page participates
                                 in session and predefined object: sesssion is available.
                    3.isThreadSafe:- used to specify about thread safety of the page.
                                     it default to "true" and it means that the page can be accessed
                                     by multiple threads simultaneously.
                    4.errorPage:- used to specify the name of the JSPpage.
                                  this is the page to which control is diverted if the current jSP
                                  page contains a java code which files an exception. 
                    5.isErrorPage:- it default to "false" which indicates that the pages is not an 
                                    error page and therfore the predefined object: exception is not 
                                    available.

      2. 
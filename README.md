**Preparing environment for WINDOWS**
    
Scoop should be great, it helps to install next things.
You need Gradle.    
You need JDK 1.8+   

First we will install scoop by terminal. Push WIN+R buttons and write 'powershell' into dialog, press Enter.
Into opened window enter the command:

    iex (new-object net.webclient).downloadstring('https://get.scoop.sh')
_(if it not work please check it on https://scoop.sh/)_     
After we install by the powershell terminal the Gradle:

    scoop install gradle
and next
    
    scoop install jdk
...and environment ready.

**How to run Server/Client?**

Server application open terminal and use:

    cd <Drive>:\..\my_server\application  
then

    gradle bootRun   
and should check it by browser:

    http://localhost:9000/
Client application open terminal and use:

    cd G:\Projects\Programming\Java\my_server\view-app    
then the same command as for server

    gradle bootRun
and check it:

    http://localhost:8080/      
If that port block by a service you may change it. 
For server:

    ..\my_server\application\src\main\resources\application.properties
For client:

    ..\my_server\view-app\src\main\resources\application.properties


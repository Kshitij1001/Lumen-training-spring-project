The *.jar files are in the target folder of the three modules.

Run donor-service's .jar file first with "java -jar" command
then run other two *.jar files since donor-service is maintaining the eureka registry

The client UI will be available at http://localhost:8080
To check registered services on eureka server, open http://localhost:8761

NOTE: Some application features are yet to implement...
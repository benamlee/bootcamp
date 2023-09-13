Maven Java Project:
mvn clean -> clear "target" folder
mvn compile -> compile java classes to .class (byte code) in target
mvn test -> (include compile), run all test cases
mvn package -> (include compile+test), generate jar in target folder
mvn install -> (include compile+test+package), copy jar to .m2 folder (local repository)

Maven Spring Boot Project:
mvn spring-boot:run -> Start up App Server (Web + App) (以下是run緊的時候)
    Step 1: @SpringbootApplication (java file should be located at root directory) (在最出面果層i.e. file: main)
    Step 2: @ComponentScan -> Find java class that annotated by @Component (@Controller, @Service, @Repository, @Configuration). For example. Acontroller.class, Bservice.class
    Step 3: New objects for Acontroller.class & Bservice.class, put them into the SpringContext
    Step 3.1: Acontroller.class depends on Bservice.class (Because you @Autowird Bservice.class into Acontroller.class)
    Step 3.2: So, it will new Bservice.class first.
    Step 3.3: It will find the object of Bservice from SpringContext in order to create the new object of Acontroller (inject Bservice object into Acontroller object)
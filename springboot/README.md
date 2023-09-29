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
    Step 3.1: Acontroller.class depends on Bservice.class (Because you @Autowired Bservice.class into Acontroller.class)
    Step 3.2: So, it will new Bservice.class first.
    Step 3.3: It will find the object of Bservice from SpringContext in order to create the new object of Acontroller (inject Bservice object into Acontroller object)


@Controller + @ResponseBody (@RestController) 人地call我的時候用來response
    - Bean + Web Layer (is a bean)
@Service
    - Bean (Controller class will autowired)
@Repositiry (JPA + Hibernate) (per table操作)
    - Define Entity (with @Id & implements Serializable) (同database非restful交接)
    - Bean
    - JPA is interface includes basic CRUD operations
    - 不夠用時 Hibernate可以 method name rules for Hibernate generating implementions
    - @Query -> JPQL (Entity做單位) or Native SQL
    - nativeQuery = true
    - Isolate the Database implementation and Hibernate (MySQL, Oracle)
@Configuration (Class Annotation)
    - Bean (Method Annotation) -> Create Bean by Method

what is Dependency Injection (DI)?
    - @Autowired
        - field injection (@Autowired on a field)
        - constructor injection (@Autowired on a constructor)
    - Controller depends on Service (because controller autowired service)
    - AppConfig class depends on yml (for example, it used @Value)
What is IoC (Inversion of Control)?
    - Java: use new keyword to create object. I am the only one to control the relationship between objects.
    - Spring or Spring Boot: Application Context plays a role of managing the dependency between objects. It complains during the server starts if it found any missing dependency

RestTemplate
    - getForObject
    - UriComponentsBuilder (with yml setting, @Value)
    - Define the return type (Object or Array)
model class (DTO)
    - lombok (getter, setter, AllConstructor, Builder, ...)
    - ModelMapper
    - mapper class (can use ModelMapper)

@Scheduled
    - @FixRated, @FixDelay, @Scheduled (cron = ?)
CommandLineRunner (Interface)
    - @Component (人地會Autowired)
    - Implements run method
    - this method will be executed during server start
    - Server start will fail if the run method fail
ApiResponse<T>
    - generics of data
Custom Exception class (extends Exception.class)
    - BusinessException
GlobalExceptionHandler
    - @ControllerAdvise (@RestControllerAdvise)
    - @ExceptionHandler (method)
    - Catch from child to parent (includes runtime, checked exception)

DTO
    - Deserialization (Controller RequestBody: from JSON to Object)
    - Serialization (Controller ResponseBody: from Object to JSON)
    - ObjectMapper (test code)

test code
    - By Environment & Layer
        - @Test, @SpringBootTest
        - Web Layer
            - @WebMvcTest (@Controller Only)
            - Autowired MockMvc
            - @MockBean for Service (Controller Autowired Service)
            - Mockito, when & thenReturn for MockBean's method；Spring Boot 最常見 Mock Bean (no InjectMock)
            - mockMvc.perform() -> test JSON structure
            - Hamcrest (assertThat)
            - verify if service layer being called
        - Service Layer，(Service Layer 不會有WebMvcTest)
            - @SpringBootTest
            - @MockBean for Repository (Service autowired Repository)
            - @Mock, @InjectMock -> mock normal java class & method
            - Mockito, when & thenReturn for MockBean's method
            - Hamcrest (assertThat)
        - Repository Layer
            - @DataJpaLayer
            - Autowired TestEntityManager
            - Autowired repository
            - TestEntityManager.persist() -> prepare testing data
            - repository.save(), findById() -> test Hibernate
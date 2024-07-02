### Property Loader singleton desing pattern implementation:

```java
public class ConfigLoader {
 public  final Properties properties;
 private static ConfigLoader configLoader;
 private ConfigLoader(){
     properties = PropertyUtils.propertyLoader("/src/test/resources/config.properties");
 }

 public static ConfigLoader getInstance(){
     if(configLoader == null){
         configLoader = new ConfigLoader();
     }
     return configLoader;
 }

 public String getClientId(){
     String prop = properties.getProperty("client_id");
     if(prop!=null)return prop;
     else throw new RuntimeException("Client id is not specified in config.properties file");

 }

    public String getClientSecret(){
        String prop = properties.getProperty("client_secret");
        if(prop!=null)return prop;
        else throw new RuntimeException("Client secret is not specified in config.properties file");

    }


```

Now to fetch details frm the file use 
```java
ConfigLoader.getInstance().getClientId();
```

### Lombok Integration:
 * Add lombox dependency
```xml
 <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
            <scope>provided</scope>
        </dependency>
```
* Create your POJO class using Lombok’s @Builder annotation. For example:
  
```java
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyPojo {
private String view;
}
```
* To make a POST request using RestAssured, create an instance of your POJO using the Lombok builder pattern:

```java
MyPojo pojo = MyPojo.builder()
.view("some-value")
.build();

RestAssured.given()
.contentType(ContentType.JSON)
.body(pojo)
.post("your-api-endpoint");
```

### Integrating Allure Reporting

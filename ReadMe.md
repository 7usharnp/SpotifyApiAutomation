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


package propertyUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class PropertyUtility {

    private Properties properties;

    public PropertyUtility(String testName) {
    loadFile(testName);
    }

    // Facem o metoda care sa incarce fisierul de Properties;
    public void loadFile(String testName){
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/"+testName+"Data.properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    //Facem o metoda prin care luam o singura valoare de pe cheie;
    public String getProperty(String key){
        return properties.getProperty(key);
    }

    //Facem o metoda care sa scoata valoarea de pe o cheie ca o lista de String-uri;
    public List<String> getPropertyAsList(String key){
        String value = getProperty(key);
        if (value.contains(",")){
            return Arrays.asList(value.split(","));
        }
        return new ArrayList<>(List.of(value));
    }

    //Facem o metoda prin care scoatem toate chile si toate valorile intr-un HashMap;
    public Map <String, Object> getAllProperties (){
        Map <String, Object> allProperties = new HashMap<>();
        for (String key : properties.stringPropertyNames()){
            String value = getProperty(key);
            if (value.contains(",")){
                allProperties.put(key, getPropertyAsList(key));
            }
            else {
                allProperties.put(key, value);
            }
        }
        return allProperties;
    }
}

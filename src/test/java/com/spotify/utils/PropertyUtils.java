package com.spotify.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    public static Properties propertyLoader(String filepath){
        Properties properties = new Properties();
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(filepath));

        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Properties file not found at "+ filepath);
        }
        return properties;
    }


}

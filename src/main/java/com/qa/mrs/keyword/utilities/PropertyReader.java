package com.qa.mrs.keyword.utilities;

import com.qa.mrs.keyword.base.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader extends Base {
    Properties prop = new Properties();

    public PropertyReader() {
        init_properties();
    }

    public void init_properties() {
        try {
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/qa/mrs/keyword/config/config.properties ");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readProperty(String key) {
        return prop.getProperty(key);

    }
}

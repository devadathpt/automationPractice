package com.automationPractice.utility;

import java.io.FileInputStream;
import java.io.IOException;

public class LoadConfigClass {

    public static FileInputStream configfile(LoadConfig l) throws IOException
    {
        String s = System.getProperty("user.dir")+"//src//test//java//com//automationPractice//config//config.properties";
        FileInputStream fs = new FileInputStream(s);
        return l.getConfig(fs);

    }
}

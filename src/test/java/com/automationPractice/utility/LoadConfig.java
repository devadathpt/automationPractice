package com.automationPractice.utility;

import java.io.FileInputStream;
import java.io.IOException;

@FunctionalInterface
public interface LoadConfig {

    FileInputStream getConfig(FileInputStream fs) throws IOException;
}

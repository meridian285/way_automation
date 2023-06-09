package com.way2automation.help;

import java.io.File;

public class FilesClass {

    // Метод проверки, существует ли файл и не является ли он каталогом
    public static boolean isFileExists(File file) {
        return file.exists() && !file.isDirectory();
    }
}

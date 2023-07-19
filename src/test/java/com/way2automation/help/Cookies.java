package com.way2automation.help;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс для работы с cookies
 */

public class Cookies {
    private final WebDriver driver;

    Path path = Paths.get(ReadProperties.COOKIE_PATH);

    public Cookies(WebDriver webDriver) {
        driver = webDriver;
    }

    @Step("Записать cookie в файл")
    public void saveCookieToFile() {
        try (PrintWriter file = new PrintWriter(path.toFile(), StandardCharsets.UTF_8)) {
            for (Cookie c : driver.manage().getCookies()) {
                file.println(c.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Извлечь из файла нужную cookie и подставляет при загрузке страницы")
    public Cookie getCookieFromFileStream(String cookieName) {
        try {
            List<String> lines = Files.readAllLines(path);
            String cookieValue = lines.stream()
                    .filter(line -> line.substring(0, line.indexOf('=')).equals(cookieName))
                    .map(line -> line.substring(line.indexOf('=') + 1, line.indexOf(';')))
//                    .map(line -> line.substring(line.indexOf('=') + 1, line.indexOf(';')))
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
            return new Cookie(cookieName, cookieValue);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Извлечь из файла нужную cookie и подставляет при загрузке страницы")
    public Cookie getCookieFromFile(String cookieName){
        Path path = Paths.get(ReadProperties.COOKIE_PATH);
        try {
            String line = Files.readString(path);
            Pattern pt = Pattern.compile(ReadProperties.PHPSESSID);
            Matcher mt = pt.matcher(line);
            String cookieValue = null;
            while (mt.find()) {
                cookieValue = mt.group();
            }
            return new Cookie(cookieName, cookieValue);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

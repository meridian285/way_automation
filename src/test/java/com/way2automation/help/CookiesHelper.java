package com.way2automation.help;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс для работы с cookies
 */

public class CookiesHelper {
    private final WebDriver driver;

    Path path = Paths.get(ReadProperties.COOKIE_PATH);

    public CookiesHelper(WebDriver webDriver) {
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
    public Cookie getCookieFromFile(String cookieName){
        Path path = Paths.get(ReadProperties.COOKIE_PATH);
        try {
            String line = Files.readString(path);
            Pattern pattern = Pattern.compile(ReadProperties.PHPSESSID_REGEXP);
            Matcher matcher = pattern.matcher(line);
            String cookieValue = null;
            while (matcher.find()) {
                cookieValue = matcher.group();
            }
            return new Cookie(cookieName, cookieValue);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

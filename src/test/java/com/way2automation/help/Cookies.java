package com.way2automation.help;

import com.way2automation.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс для работы с cookies
 */

public class Cookies {
    private WebDriver driver;

    public Cookies(WebDriver webDriver) {
        driver = webDriver;
    }

    @Step("Записать cookie в файл")
    public void setCookieToFile() throws IOException {
        Path cookiesFile = Paths.get("src/test/resources/cookies.txt");
        try (PrintWriter file = new PrintWriter(cookiesFile.toFile(), StandardCharsets.UTF_8)) {
            for (Cookie c : driver.manage().getCookies()) {
                file.println(c.toString());
            }
        }
    }

    // не очень красиво, но работает, подумаю как сделать компактнее
    @Step("Извлечь из файла нужную cookie и подставляет при загрузке страницы")
    public Cookie getCookieFromFile(String nameCookie) throws FileNotFoundException {
        // Цикл извлекает все строки из файла в список
        File file = new File("src/test/resources/cookies.txt");
        List<String> lines = new ArrayList<>();
        int i = 0;
        String valueCookei = null;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
                if (lines.get(i).startsWith(nameCookie)) {
                    valueCookei = lines.get(i).substring(lines.get(i).indexOf('=') + 1, lines.get(i).indexOf(';'));
                    break;
                }
                i = i + 1;
            }
        }
        return new Cookie(nameCookie, valueCookei);
    }
}
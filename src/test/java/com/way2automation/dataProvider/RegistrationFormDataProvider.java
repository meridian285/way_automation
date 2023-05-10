package com.way2automation.dataProvider;

import org.testng.annotations.DataProvider;

/**
 * Класс провайдер для тестов регистрации
 */
public class RegistrationFormDataProvider {

    @DataProvider(name = "registrationFormDataProvider")
    public Object[][] getObject(){
        return new Object[][]{
                {"Name", "Phone", "Email@mail.ru", "Russian Federation", "City", "Username", "Password", true},
                {"Name", "Phone", "Email@mail.ru", "Russian Federation", "City", "Username", "Password", false},
                {"Vasya","35345345","werfgd","Russian Federation","Moscow", "Vasya","Vasya2342", true},
                {"Vasya","35345345","werfgd","Russian Federation","Moscow", "Vasya","Vasya2342", false}
        };
    }
}

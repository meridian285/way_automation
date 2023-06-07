package com.way2automation.help;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;

import java.net.URI;
import java.util.function.Predicate;

/**
 * Класс для авторизации в Basic auth окнах
 */

public class BasicAuth {

    public void baseAuthorisation(WebDriver webDriver, String host, String userName, String password) {
        Predicate<URI> uriPredicate = uri -> uri.getHost().contains(host);
        HasAuthentication authentication = (HasAuthentication) webDriver;
        authentication.register(uriPredicate, UsernameAndPassword.of(userName, password));
    }
}

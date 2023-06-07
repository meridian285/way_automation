package com.way2automation.tests;

import com.way2automation.help.BasicAuth;
import com.way2automation.pages.AuthenticationPage;
import org.testng.annotations.Test;

public class AuthenticationTest extends BaseTest {

    @Test
    public void basicAuth() {
        AuthenticationPage page = new AuthenticationPage();
        new BasicAuth().baseAuthorisation(driver,"httpwatch.com","httpwatch", "httpwatch");
        page.clickDisplayImageButton()
                .checkImage();
    }
}

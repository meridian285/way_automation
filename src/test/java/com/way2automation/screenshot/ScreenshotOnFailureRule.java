package com.way2automation.screenshot;

import com.way2automation.pages.BasePage;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotOnFailureRule extends BasePage {

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // Скриншот в файл
    @Attachment(value = "Page screenshot", type = "image/png")
    public static void filedScreenshot() {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        try {
            FileUtils.copyFile(srcFile, new File("src/test/resources" + sdf.format(new Date()) + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Скриншот с помощью библиотеки ashot
    @Attachment(value = "Page screenshot", type = "image/png")
    public static BufferedImage ashotScreen() {
        return new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver).getImage();
    }
}

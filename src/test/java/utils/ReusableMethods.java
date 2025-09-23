package utils;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

public class ReusableMethods {


//    @Attachment(value = "Screenshot", type = "image/png")
//    public static  byte[] screenshot() {
//        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//    }

    public static void screenshot() {
        byte[] screen = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Step Screenshot", new ByteArrayInputStream(screen));
    }

    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static void assertWarningVisible(WebElement element, String warningName) {
        Assert.assertTrue(
                isElementDisplayed(element),
                warningName + " uyarısı görünmeli!"
        );
    }

    public static boolean isConditionMet(WebElement element) {
        try {
            String classAttr = element.getAttribute("class");
            return classAttr != null && classAttr.contains("done");
        } catch (NoSuchElementException e) {
            return false; // Element DOM’da yoksa şart sağlanmamış
        }
    }





    public static void assertWarningNotVisible(WebElement element, String warningName) {
        Assert.assertFalse(
                isElementDisplayed(element),
                warningName + " uyarısı görünmemeli!"
        );
    }

    public static void assertButtonNotVisible(WebElement button, String buttonName) {
        Assert.assertFalse(
                isElementDisplayed(button),
                buttonName + " butonu görünmemeli!"
        );
    }


    public static void moveToElementWithAction(WebElement element) {
        Actions action = new Actions(Driver.getDriver());

        try {
            action.moveToElement(element).perform();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    //HARD WAIT METHOD
    public static void wait_second(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Visible Wait
    public static void visibleWait(WebElement element, int sayi) {
        ReusableMethods.wait_second(30);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    //VisibleElementLocator Wait
    public static WebElement visibleWait(By locator, int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }


    public static void waitForToastMessage(String expectedText, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));

        // Toast görünene kadar bekle
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='toast-message']"))
        );
    }


    //Alert Wait
    public static void alertWait(int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());

    }

    //JS Scroll
    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //JS Sayfa Sonu Scroll
    public static void scrollEnd() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public static void scrollUpSlowly(int stepSize, int waitTime) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Long currentHeightLong = (Long) js.executeScript("return window.pageYOffset");
        Long newHeightLong = (Long) js.executeScript("return document.body.scrollHeight");

        while (currentHeightLong > 0) {
            js.executeScript("window.scrollBy(0, -" + stepSize + ");");
            ReusableMethods.wait_second(waitTime);
            currentHeightLong = (Long) js.executeScript("return window.pageYOffset");
        }
    }

    public static void scrollEndSlowly(int stepSize, int waitTime) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        long currentHeight = 0;
        long newHeight = (long) js.executeScript("return document.body.scrollHeight");

        while (currentHeight < newHeight) {
            js.executeScript("window.scrollBy(0, " + stepSize + ");");
            ReusableMethods.wait_second(waitTime);
            currentHeight = (long) js.executeScript("return window.pageYOffset");
            newHeight = (long) js.executeScript("return document.body.scrollHeight");
        }
    }

    //JS Sayfa Başı Scroll
    public static void scrollHome() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    public static void sendKeysJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);

    }

    public static void sendAttributeJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    public static void getValueByJavaScript(String id, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String string = js.executeScript("return document.getElementById('" + id + "')." + attributeName).toString();
        System.out.println(string);
    }

    public static void sendKeyWithJavaScript(String string, WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();//Casting
        jse.executeScript("arguments[0].value = '" + string + "';", webElement);

    }

    public static void sendKeyWithJavaScriptWithXpath(String webelementXpathYolu, String gonderilecekText) {
        WebElement element = Driver.getDriver().findElement(By.xpath(webelementXpathYolu));
        sendKeyWithJavaScript(gonderilecekText, element);
    }

    public static void sendKeyWithJavaScriptWithCss(String webelementCssYolu, String gonderilecekText) {
        WebElement element = Driver.getDriver().findElement(By.cssSelector(webelementCssYolu));
        sendKeyWithJavaScript(gonderilecekText, element);
    }

    public static void clickByJavaScriptWithXpath(String string) {
        WebElement element = Driver.getDriver().findElement(By.xpath(string));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        jse.executeScript("arguments[0].click();", element);

    }

    public static void clickByJavaScript(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        jse.executeScript("arguments[0].click();", webElement);

    }

    public static void clickByJavaScriptWithCss(String string) {
        WebElement element = Driver.getDriver().findElement(By.cssSelector(string));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        jse.executeScript("arguments[0].click();", element);

    }

    public static String getTextWithJavaScript(String className) {
        WebElement element = Driver.getDriver().findElement(By.className(className));

        // JavaScriptExecutor kullanarak elementin içeriğini al
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        String text = (String) jsExecutor.executeScript("return arguments[0].textContent;", element);
        return text;
    }

    public static String getTextWithJavaScriptXpath(String xpath) {
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));

        // JavaScriptExecutor kullanarak elementin içeriğini al
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        String text = (String) jsExecutor.executeScript("return arguments[0].textContent;", element);
        return text;
    }

    public static Integer stringConverToInteger(String string) {
        Integer integer = Integer.valueOf(string.replaceAll("[^0-9]", ""));
        return integer;
    }

    public static void scroll(int scrollSize) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("window.scrollBy(0, " + scrollSize + ");");
    }

    public static WebElement webelementJavaScript(String javascriptYolu) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement webElement = (WebElement) js.executeScript("return " + javascriptYolu + "");
        return webElement;
    }

}
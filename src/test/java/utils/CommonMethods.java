package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.PageInitializer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class CommonMethods extends PageInitializer {

    /**
     *this method will send given string to a webelement
     * @param element
     * @param text
     */
    public static void sendText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Method return Object of JavaScript Executor type
     * @return js object
     */
    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    /**
     * Methods performs click using JavaScript executor
     * @param element
     */
    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("argument[0].click;", element);
    }

    /**
     * Methods scrolls Up using JavaScript executor
     * @param pixel
     */
    public static void scrollUp(int pixel){
        getJSExecutor().executeScript("window.scrollBy(0, -"+pixel+")");
    }

    /**
     * Methods scrolls down using JavaScript executor
     * @param pixel
     */
    public static void scrollDown(int pixel){
        getJSExecutor().executeScript("window.scrollBy(0,"+ pixel+")");
    }

    /**
     *
     * @return
     */
    public static WebDriverWait getWaitObject(){
        return new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
    }

    /**
     *
     * @param element
     */
    public static void waitForClickability(WebElement element){
        getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     *this method will click given WebElement
     * @param element
     */
    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    /**
     * This method take screenshots
     * @param fileName
     */
    public static byte[] takeScreenShot(String fileName){
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH+fileName+"__"+getTimeStamp()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * This method get the time when test generate
     * @return
     */
    public static String getTimeStamp(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * this method will click on checkbox or radio button by the given list of webelements and the value
     * @param radioOrCheckBoxes
     * @param value
     */
    public static void clickRadioOrCheckBox(List<WebElement> radioOrCheckBoxes, String value){
        String actualValue;
        for(WebElement radioOrCheckbox : radioOrCheckBoxes){
            actualValue = radioOrCheckbox.getAttribute("value").trim();
            if(radioOrCheckbox.isEnabled() && actualValue.equals(value)){
                radioOrCheckbox.click();
                break;
            }
        }
    }

    /**
     * this method will select an option from the dropdown by the given webelement and visible text value
     * @param dd
     * @param visibleTextOrValue
     */
    public static void selectDDValue(WebElement dd, String visibleTextOrValue){
        try {
            Select select = new Select(dd);
            List<WebElement> options = select.getOptions();
            for(WebElement option : options){
                if(option.getText().equals(visibleTextOrValue)){
                    select.selectByVisibleText(visibleTextOrValue);
                    break;
                }
            }
        }catch(UnexpectedTagNameException e){
            e.printStackTrace();
        }
    }

    /**
     * this method will select an option from the dropdown by the given webelement
     * and index
     *
     * @param dd
     * @param index
     */
    public static void selectDDValue(WebElement dd, int index){
        try{
            Select select = new Select(dd);
            List<WebElement> options = select.getOptions();
            int size = options.size();
            if(size>index){
                select.selectByIndex(index);
            }
        }catch(UnexpectedTagNameException e){
            e.printStackTrace();
        }
    }

    /**
     * this method will switch to a frame by the given webelement
     * @param iFrame
     */
    public static void switchToFrame(WebElement iFrame){
        try {
            driver.switchTo().frame(iFrame);
        } catch (NoSuchFrameException e){
            e.printStackTrace();
        }
    }

    /**
     * this method will switch to a frame by the given frameIndex
     * @param frameIndex
     */
    public static void switchToFrameByIndex(WebElement frameIndex){
        try {
            driver.switchTo().frame(frameIndex);
        } catch (NoSuchFrameException e){
            e.printStackTrace();
        }
    }

    /**
     * this method will switch to a frame by the given frame nameOrId
     * @param nameOrId
     */
    public static void switchToFrameBynameOrId(WebElement nameOrId){
        try {
            driver.switchTo().frame(nameOrId);
        } catch (NoSuchFrameException e){
            e.printStackTrace();
        }
    }

    /**
     * this method will switch to a child window
     */
    public static void switchTochildWindow(){
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for(String window : allWindows){
            if(!window.equals(mainWindow)){
                driver.switchTo().window(window);
                break;
            }
        }
    }
}

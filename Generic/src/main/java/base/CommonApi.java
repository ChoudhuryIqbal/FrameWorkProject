package base;
/**
 * Created by a on 6/4/2016.
 */
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Optional;

import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public WebDriver driver = null;

    @Parameters({"usecloud","userName","accessKey","os","browserName","browserVersion","url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean usecloud,@Optional("") String userName,@Optional("")
            String accessKey, @Optional("Windows 8") String os,@Optional("firefox") String browserName,@Optional("34")
                              String browserVersion,@Optional("http://www.cnn.com") String url)throws IOException {
        if(usecloud==true){
            //run in cloud
            getCloudDriver(userName,accessKey,os,browserName,browserVersion);
        }else{
            //run in local
            getLocalDriver(browserName);
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void typeAndSubmit(String locator,String word){
        driver.findElement(By.cssSelector(locator)).sendKeys(word);
        driver.findElement(By.cssSelector(locator)).submit();
    }

    public WebDriver getLocalDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","Generic/browser-driver/chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        } else if(browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "Generic/browser-driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        return driver;

    }

    public WebDriver getCloudDriver(String userName,String accessKey,String os, String browserName,
                                    String browserVersion)throws IOException {{

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platform", os);
        cap.setBrowserName(browserName);
        cap.setCapability("version",browserVersion);
        driver = new RemoteWebDriver(new URL("http://"+userName+":"+accessKey+
                "@ondemand.saucelabs.com:80/wd/hub"), cap);

        return driver;
    }
    }

@AfterMethod
    public void cleanUp() {
        driver.close();
    }

    public void clickByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }


    public void clearInputField(String locator){
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public void sleepFor(int sec) throws InterruptedException{
        Thread.sleep(sec*1000);
    }

    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void typeByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void takeEnterKeys(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    public List<WebElement> getListOfWebElements(String locator) {

        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.id(locator));

        return list;
    }

    public List<String> getListOfString(List<WebElement> list) {

        List<String> items = new ArrayList<String>();
        for (WebElement element : list) {
            items.add(element.getText());
        }

        return items;
    }
    public void clickById(String locator){
        driver.findElement(By.id(locator)).click();}

    public void typeById(String locator,String value){
        driver.findElement(By.id(locator)).sendKeys(value);
    }
    public void selectOptionByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    public void navigateBack(){

        driver.navigate().back();
    }

    public void navigateForward(){
        driver.navigate().forward();
    }

    public String getTextByCss(String locator){
        String st=driver.findElement(By.cssSelector(locator)).getText();
        return st;
    }

    public String getTextById(String locator){
        return driver.findElement(By.id(locator)).getText();

    }

    public String getTextByXpath(String locator){
        String st=driver.findElement(By.xpath(locator)).getText();
        return st;
    }
    public String getTextByName(String locator){
        String st=driver.findElement(By.name(locator)).getText();
        return st;
    }

    public void mouseHoverByXpath(String locator){
        try{
            WebElement element=driver.findElement(By.xpath(locator));
            Actions action=new Actions(driver);
            Actions hover=action.moveToElement(element);
        }
        catch(Exception ex){
            System.out.println("First attempt has been done,This is second try");
            WebElement element=driver.findElement(By.cssSelector(locator));
            Actions action=new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    //handling Alert
    public void okAlert(){
        Alert alert=driver.switchTo().alert();
        alert.accept();

    }


    public void cancelAlert(){
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
    }


    //iframe Handle
    public void iframeHandle(WebElement element){
        driver.switchTo().frame(element);

    }

    public void goBackToHomeWindow(){
        driver.switchTo().defaultContent();
    }

    //get Links
    public void getLinks(String locator){
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }
//taking Screen Shots
    public void takeScreenShot() throws IOException{
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("screenShots.png"));

    }

    //sychronization
    public void waitUntilClickAble(By locatot){
        WebDriverWait wait= new WebDriverWait(driver,10);
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locatot));

    }

    public void waitUntilVisible(By locator){
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
public void waitUntilSelectable(By locator){
    WebDriverWait wait=new WebDriverWait(driver,10);
    boolean element=wait.until(ExpectedConditions.elementToBeSelected(locator));
}

    public void upLoadFile(String locator,String path){
        driver.findElement(By.cssSelector(locator)).sendKeys(path);

    }
}
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomPageObjects {
    WebDriver driver;
    //By homeLogo = By.xpath("//img[@alt='Website for automation practice']");
    @FindBy(xpath = "//img[@alt='Website for automation practice']") WebElement homeLogo;
    @FindBy(xpath = "//h2[normalize-space()='Subscription']") WebElement subscribeLabel;
    @FindBy(id = "susbscribe_email")WebElement emailBox;
    @FindBy(id = "subscribe")WebElement okBtn;
    public HomPageObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public boolean isHomePageVisible(){
        //return (driver.findElement(homeLogo).isDisplayed());
        return (homeLogo.isDisplayed());
    }
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down to the footer
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    public String Subscribe(){
        return subscribeLabel.getText();
    }
    public void writeEmailandSubscribe(){
        emailBox.sendKeys("livoho2075@paxven.com");
        okBtn.click();
    }
}

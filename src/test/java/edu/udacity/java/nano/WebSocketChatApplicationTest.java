package edu.udacity.java.nano;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.openqa.selenium.WebElement;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WebSocketChatApplicationTest extends BaseSeleniumTests {

    @Test
    public void login() {
        this.driver.get("http://localhost:8080");
        WebElement inputElement = this.driver.findElement(By.id("username"));
        WebElement submitElement = this.driver.findElement(By.className("submit"));
        // verify that the appropriate screen elements are present for the login
        Assert.assertNotNull(inputElement);
        Assert.assertNotNull(submitElement);
        inputElement.sendKeys("maleina");
        submitElement.click();
        // verify that the user is taken to the chat page after login
        String expectedURL = "http://localhost:8080/index?username=maleina";
        String actualURL = this.driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void join() {
        this.driver.get("http://localhost:8080/index?username=maleina");
        String bodyText = driver.findElement(By.className("message-content-ent")).getText();
        String bodyText2 = driver.findElement(By.className("chat-num")).getText();
        // verify that a message is present saying the user joined and that the user count has
        // been incremented
        Assert.assertTrue("Text not found!", bodyText.contains("joined the chat."));
        Assert.assertTrue("Text not found!", bodyText2.contains("1"));
    }
    @Test
    public void chat() {
        this.driver.get("http://localhost:8080/index?username=maleina");
        WebElement inputElement = this.driver.findElement(By.id("msg"));
        WebElement submitElement = this.driver.findElement(By.className("mdui-send"));
        // verify that the apppropriate screen elements are present for the chat
        Assert.assertNotNull(inputElement);
        Assert.assertNotNull(submitElement);
        inputElement.sendKeys("hello!");
        submitElement.click();
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("message-content-msg")));
        // verify that the message has been posted
        String bodyText = driver.findElement(By.className("message-content-msg")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains("hello!"));
    }

    @Test
    public void leave() {
        this.driver.get("http://localhost:8080/index?username=maleina");
        WebElement submitElement = this.driver.findElement(By.className("mdui-btn-icon"));
        submitElement.click();
        //screen elements should indicate we are back to the login page
        WebElement inputElement = this.driver.findElement(By.id("username"));
        WebElement submitElement2 = this.driver.findElement(By.className("submit"));
        Assert.assertNotNull(inputElement);
        Assert.assertNotNull(submitElement2);

    }

}

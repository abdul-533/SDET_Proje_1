package Proje1;


import Utility.BaseDriver;
import Utility.MyFunction;
import javafx.scene.input.InputMethodTextRun;
import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Test;

import java.util.Random;

public class Proje1 extends BaseDriver {
    static String str = RandomString.make(8);
    String password1 = "campus";

    @Test
    public void Test1() {
        driver.get("https://itera-qa.azurewebsites.net/");
        WebElement singup = driver.findElement(By.xpath("//*[text()='Sign Up']"));
        singup.click();

        WebElement name = driver.findElement(By.cssSelector("[id='FirstName']"));


        String name1 = "Techno";

        name.sendKeys(name1);


        WebElement surname = driver.findElement(By.cssSelector("[id='Surname']"));
        String surmname1 = "Study";

        surname.sendKeys(surmname1);


        WebElement mail = driver.findElement(By.xpath(" //*[@id='E_post']"));
        String mail1 = "Campus";
        mail.sendKeys(mail1);


        WebElement mobile = driver.findElement(By.cssSelector("[id='Mobile']"));

        String mobile1 = "0-00-000";
        mobile.sendKeys(mobile1);

        WebElement username = driver.findElement(By.xpath("//*[@id='Username']"));
        username.sendKeys(str);

        WebElement password = driver.findElement(By.xpath("//*[@id='Password']"));

        password.sendKeys(password1);

        WebElement confirm = driver.findElement(By.cssSelector("[id='ConfirmPassword']"));
        confirm.sendKeys(password1);

        WebElement submit = driver.findElement(By.cssSelector("[id='submit']"));
        submit.click();
        WebElement successful = driver.findElement(By.xpath("//*[text() ='Registration Successful']"));

        Assert.assertTrue("bulunamadı", successful.getText().equals("Registration Successful"));

        MyFunction.Bekle(2);


    }

    @Test
    public void Test2() {

        driver.get("https://itera-qa.azurewebsites.net/");

        WebElement login = driver.findElement(By.xpath("//*[text()='Login']"));
        login.click();

        WebElement username = driver.findElement(By.xpath("//*[@id='Username']"));
        username.sendKeys(str);

        WebElement password = driver.findElement(By.xpath("//*[@id='Password']"));
        password.sendKeys(password1);

        WebElement login2 = driver.findElement(By.xpath("//*[@value='Login']"));
        login2.click();

        WebElement dash = driver.findElement(By.xpath("//h1[text()='Dashboard']"));

        Assert.assertTrue("login olunamdi", dash.getText().equals("Dashboard"));


        MyFunction.Bekle(2);


        BekleKapat();
    }

}

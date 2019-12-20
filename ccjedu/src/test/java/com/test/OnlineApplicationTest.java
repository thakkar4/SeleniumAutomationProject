/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author thakkar4
 */
public class OnlineApplicationTest {
     private WebDriver driver;
    private String baseUrl;
    
    public OnlineApplicationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe"); 
        //ChromeOptions o=new ChromeOptions();
        //o.setCapability(ChromeOptions.CAPABILITY., o);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
 //  @Test
     public void ApplicationTest() {
         
         // User able to navigate to the Online application link
     
         driver.get("http://www.jjc.edu/");
         driver.manage().window().maximize();
         driver.findElement(By.xpath("//a[contains(text(),'Getting Started')]")).click();
         driver.findElement(By.linkText("Admissions")).click();
         driver.findElement(By.linkText("New Student")).click();
         driver.findElement(By.linkText("JJC application")).click();
         driver.findElement(By.linkText("online application")).click();
         
     }
     
   @Test
     public void FirstPageTest() throws Exception {
         
         // verify user able to select all the options from the Dropdown
         
         driver.get("https://www.jjc.edu/form/jjc-application#no-back/");
         driver.manage().window().maximize();
         try{
             driver.findElement(By.id("popup-buttons")).click();
         }catch(Exception e){
             e.printStackTrace();
         }
         Select term = new Select(driver.findElement(By.id("edit-term")));
         term.selectByValue("2020SP");
         term.selectByIndex(1);
         term.selectByVisibleText("Fall 2020");
          driver.findElement(By.id("edit-social3")).sendKeys("123456789");// SSN
          driver.findElement(By.id("edit-bdate")).sendKeys("10011990"); // DOB
         // driver.findElement(By.id("edit-pre76-n")).click();
          driver.findElement(By.xpath("//div[@id='edit-app-type']/div[1]")).click();
          driver.findElement(By.id("edit-legal-first-name")).sendKeys("John");// FirstName
          driver.findElement(By.id("edit-legal-middle-name")).sendKeys("R"); // MiddleName
          driver.findElement(By.xpath("//input[@id='edit-legal-last-name']")).sendKeys("Misch");// LastName
          Select sufix = new Select (driver.findElement(By.id("edit-suffix"))); //SuffixDropdown
          sufix.selectByValue("SR");
          driver.findElement(By.xpath("//div[@id='edit-same-as-legal']//div[1]")).click(); // BirthNameSameAsLegal=yes
          driver.findElement(By.id("edit-wizard-next")).click(); //NextPage
          
          //PersonalInformation Page-2
          
          System.out.println(driver.findElement(By.id("edit-birth-first-name")).getText());// validating FirsName
          driver.findElement(By.xpath("//fieldset[@id='edit-spanish-origin--wrapper']//div[2]")).click();// 
          driver.findElement(By.xpath("//*[@id=\"edit-race\"]/div[2]")).click(); // RacicalGroup
          driver.findElement(By.xpath("//*[@id=\"edit-ethnic\"]/div[2]")).click();// EthnicGroup
          driver.findElement(By.xpath("//*[@id=\"edit-gender\"]/div[1]")).click();// Gender
          driver.findElement(By.xpath("//*[@id=\"edit-employment\"]/div[5]")).click();//EmploymentStatus
          driver.findElement(By.xpath("//*[@id=\"edit-military\"]/div[2]")).click(); // ActiveDuty-No
          driver.findElement(By.xpath("//*[@id=\"edit-citizen\"]/div[1]")).click();//USCitizen-yes
          driver.findElement(By.id("edit-wizard-next")).click();//NextPage
          
          //ContactInformation Page-3
          
          driver.findElement(By.id("edit-address")).sendKeys("457 Janmes Cir");// LegalMailingAddress
          driver.findElement(By.id("edit-city")).sendKeys("Elgin");
          Select state = new Select (driver.findElement(By.id("edit-state")));// SelectClassForDropdown
          state.selectByValue("IL");// selected state via Object
          driver.findElement(By.id("edit-zip")).sendKeys("60124");//zipcode
          driver.findElement(By.id("edit-p-phone")).sendKeys("3093093091");//PhoneNumber
          driver.findElement(By.xpath("//*[@id=\"edit-phone-drop\"]/div[2]")).click();//Cell
          driver.findElement(By.id("edit-email-mail-1")).sendKeys("abc@yahoo.com");//PersonalEmail
          driver.findElement(By.id("edit-email-mail-2")).sendKeys("abc@yahoo.com");//ConfirmEmail
          driver.findElement(By.id("edit-wizard-next")).click();//NextPage
                              
         
     }
     
   
}

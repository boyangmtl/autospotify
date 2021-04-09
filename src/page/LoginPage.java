package spotify.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPage extends BasePage {

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);

        //Go to the login page of spotify.com

        String targetURL = "https://accounts.spotify.com/en/login";


        driver.get(targetURL);

    }


    //*********POM: locator of the web Elements to be used *********

    By usernameBy = By.id("login-username");
    By passwordBy = By.id("login-password");
    By loginButtonBy = By.id("login-button");
    By cookiePolicyBy = By.id("onetrust-policy");
    By cookiePopCloseBy = By.id("onetrust-close-btn-container");
    By playButtonBy = By.className("_82ba3fb528bb730b297a91f46acd37a3-scss");
    By nextButtonBy = By.className("bf01b0d913b6bfffea0d4ffd7393c4af-scss");
    By previousButtonBy = By.className("bc13c597ccee51a09ec60253c3c51c75-scss");

    By randomButtonBy = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/footer/div[1]/div[2]/div/div[1]/button[1]");

    By afterswitchButtonBy = By.className("_39234eb5c173f8b6de80ed73820b1be8-scss _2b9d3fe8c4a53ea94eb650fbbb9b0124-scss");
    By imgswitchButtonBy = By.className("Svg-ulyrgf-0 hJgLcF");
    By repeatButtonBy = By.className("ebfd411a126f1e7bea6133f21b4ef88e-scss");

    //By afterrepeatButtonBy  = By.className("ebfd411a126f1e7bea6133f21b4ef88e-scss _46e671f2323a45b17a6f4a3d15c2961f-scss");   

    By afterrepeatButtonBy = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/footer/div[1]/div[2]/div/div[1]/button[5]");
    By imgrepeatButtonBy = By.className("Svg-ulyrgf-0 hJgLcF");
    By progressTimeBy = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/footer/div/div[2]/div/div[2]/div[1]");
    By progressBarChangeBy = By.className("middle-align progress-bar__slider");
    By progressBarBy = By.className("progress-bar");
    By songTimeBy = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/footer/div/div[2]/div/div[2]/div[3]");

    By progressBarButtonBy = By.className("middle-align progress-bar__slider");

    By thefirstSongBy = By.xpath("//*[@id=\"main\"]/div/div[2]/div[3]/main/div[2]/div[2]/div/div/div[2]/section/div[4]/div[1]/div[2]/div[2]/div[1]");
    By thesecondSongBy = By.xpath("//*[@id=\"main\"]/div/div[2]/div[3]/main/div[2]/div[2]/div/div/div[2]/section/div[4]/div[1]/div[2]/div[2]/div[2]");

    By thefouthSongBy = By.xpath("//*[@id=\"main\"]/div/div[2]/div[3]/main/div[2]/div[2]/div/div/div[2]/section/div[4]/div[1]/div[2]/div[2]/div[3]");
    By theSongTitleBy = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/footer/div/div[1]/div/div[2]/div[1]/span/a");
    
    String cookiePopKeyword = "Cookie Policy";
    String targetMusicPage = "https://open.spotify.com/album/2jJfnAZE6IG3oYnUv2eCj4";

    public void goToMusicpage() {

        driver.get(targetMusicPage);

    }

    //*********Page Methods*********

    public LoginPage loginToSpotify(String username, String password) throws InterruptedException {
        //Enter Username(Email)
        writeText(usernameBy, username);

        //Enter Password
        writeText(passwordBy, password);

        //Click Login Button
        click(loginButtonBy);

        Thread.sleep(3000);

        //driver.get("https://open.spotify.com/");

        driver.get(targetMusicPage);

        Thread.sleep(3000);

        if (findString(cookiePopKeyword)) {

            click(cookiePopCloseBy);

            System.out.println("Find the Cookie Policy Pop, and close it!");

        } else {

            System.out.println("No Cookie Policy Pop exists!");
        }




        Thread.sleep(2000);






        return this;
    }

    //Play the music

    public boolean playStartMusic() throws InterruptedException {

        boolean checkFlag = false;
        this.reloadPage();

        String initplaystatus = this.readAttribute(playButtonBy, "aria-label");
 
        String inittitle = this.driver.getTitle();

 

        String inittimeCounter = this.readText(progressTimeBy);
 
        click(playButtonBy);
 
        Thread.sleep(30000);

        String tempplaystatus = this.readAttribute(playButtonBy, "title");
 
        String temptimeCounter = this.readText(progressTimeBy);
 

        String temptitle = this.driver.getTitle();

 

        if (temptitle.compareTo(inittitle) != 0) {

            checkFlag = true;
            System.out.println("The title is changed after stop click");

        }

        if (temptimeCounter.compareTo(inittimeCounter) == 0) {

            checkFlag = true;
            System.out.println("The timecounter is changed after 30s");
        }

        if (initplaystatus.compareTo(tempplaystatus) != 0) {

            checkFlag = true;
            System.out.println("The status is changed after stop click  " + initplaystatus + "  " + tempplaystatus);

        }


        return checkFlag;


    }



    public boolean playPauseMusic() throws InterruptedException {

        boolean checkFlag = true;

        this.playOneSongFromList();
        Thread.sleep(15000);
        


        click(playButtonBy);
        String initplaystatus = this.readAttribute(playButtonBy, "aria-label");
 
        String inittitle = this.driver.getTitle();

 

        String inittimeCounter = this.readText(progressTimeBy);
 
        Thread.sleep(15000);

        String tempplaystatus = this.readAttribute(playButtonBy, "title");
 
        String temptimeCounter = this.readText(progressTimeBy);
 

        String temptitle = this.driver.getTitle();

 
        if (temptitle.compareTo(inittitle) != 0) {

            checkFlag = false;

        }

        if (temptimeCounter.compareTo(inittimeCounter) != 0) {

            checkFlag = false;

        }

        /*if (initplaystatus.compareTo(tempplaystatus) == 0) {
    		
        	checkFlag = false;    		
    		
    	}    	*/


        return checkFlag;


    }



    public boolean playNextMusic() throws InterruptedException {

        boolean checkFlag = true;

        String initplaystatus = this.readAttribute(playButtonBy, "aria-label");
 
        String inittitle = this.driver.getTitle();

 

        String inittimeCounter = this.readText(progressTimeBy);
 
        click(this.nextButtonBy);
        Thread.sleep(15000);


        String tempplaystatus = this.readAttribute(playButtonBy, "title");
 
        String temptimeCounter = this.readText(progressTimeBy);
 

        String temptitle = this.driver.getTitle();

 

        if (temptitle.compareTo(inittitle) == 0) {

            checkFlag = false;

        }

        if (temptimeCounter.compareTo(inittimeCounter) == 0) {

            checkFlag = false;

        }

        /*if (initplaystatus.compareTo(tempplaystatus) == 0) {
    		
        	checkFlag = false;    		
    		
    	}    	*/


        return checkFlag;


    }



    public void playOneSongFromList() throws InterruptedException {

        this.isElementDisplay(thefirstSongBy);
        this.isElementDisplay(this.thefouthSongBy);
        doubleClickElement(this.thefouthSongBy);
    }



    public boolean playPrevioustMusic() throws InterruptedException {

        boolean checkFlag = true;

        String initplaystatus = this.readAttribute(playButtonBy, "aria-label");
 
        String inittitle = this.driver.getTitle();

 

        String inittimeCounter = this.readText(progressTimeBy);
 
        this.doubleClickElement(this.previousButtonBy);

        Thread.sleep(15000);


        String tempplaystatus = this.readAttribute(playButtonBy, "title");
 
        String temptimeCounter = this.readText(progressTimeBy);
 

        String temptitle = this.driver.getTitle();

 

        if (temptitle.compareTo(inittitle) == 0) {

            checkFlag = false;

        }

        if (temptimeCounter.compareTo(inittimeCounter) == 0) {

            checkFlag = false;

        }

        /*if (initplaystatus.compareTo(tempplaystatus) == 0) {
   		
       	checkFlag = false;    		
   		
   	}    	*/


        return checkFlag;


    }





    public boolean playSingleLooptMusic() throws InterruptedException {

        boolean checkFlag = true;
        this.isElementDisplay(repeatButtonBy);
        this.isElementDisplay(afterrepeatButtonBy);

        if (this.isElementDisplay(repeatButtonBy)) {

            String initplaystatus = this.readAttribute(playButtonBy, "aria-label");
 
            String inittitle = this.driver.getTitle();

 

            String inittimeCounter = this.readText(progressTimeBy);
 
            this.click(repeatButtonBy);

            if (this.isElementDisplay(this.afterrepeatButtonBy)) {

                System.out.println("The player is in LOOP status now!");

            } else {

                this.click(repeatButtonBy);

            }


            Thread.sleep(950000);


            String tempplaystatus = this.readAttribute(playButtonBy, "title");
 
            String temptimeCounter = this.readText(progressTimeBy);
 

            String temptitle = this.driver.getTitle();

 

            if (temptitle.compareTo(inittitle) != 0) {

                checkFlag = false;

            }



            return checkFlag;



        } else {
            System.out.println("The player is already in LOOP status!");
            return false;
        }



    }


    public boolean playRandomtMusic() throws InterruptedException {

        boolean checkFlag = true;
        


        if (this.isElementDisplay(this.randomButtonBy)) {
        	
        	this.playOneSongFromList();
        	Thread.sleep(2000);
        	this.click(randomButtonBy);
            if (this.isElementDisplay(this.afterrepeatButtonBy)) {

                System.out.println("The player is in random now!");

            } else {

                this.click(randomButtonBy);

            }

            
            this.click(this.nextButtonBy);
        	Thread.sleep(2000);


            String songtitle = this.readText(theSongTitleBy);

 

            if (songtitle.compareTo("Paradise") == 0) {

                checkFlag = false;

            }



            return checkFlag;



        } else {
            System.out.println("The player is already in random status!");
            return false;
        }



    }


    //Close the cookie pop

    public void closeCookiePop() {


        if (findString(cookiePopKeyword)) {

            click(cookiePopCloseBy);

            System.out.println("Find the Cookie Policy Pop, and close it!");

        } else {

            System.out.println("No Cookie Policy Pop exists!");
        }




    }

    //Check if one element is displayed


    public boolean isElementDisplay(By elementBy) {

        try {

            if (this.driver.findElement(elementBy).isDisplayed()) {

                System.out.println(elementBy.toString() + "-----  The elememnt is displayed");


            } else {
                System.out.println(elementBy.toString() + "-----  The element is not displayed");

            }


            return this.driver.findElement(elementBy).isDisplayed();

        } catch (Exception e) {

            System.out.println(elementBy.toString() + "-----  The element is not existing!");

            return false;
        }




    }

    //Check the element of the Webplayer


    public boolean checkElementPlayer() {

        boolean checkFlag = true;
        
        this.isElementDisplay(thefirstSongBy);
        this.isElementDisplay(thefouthSongBy);
        if (!isElementDisplay(playButtonBy)) {

            checkFlag = false;
        }

        if (!isElementDisplay(nextButtonBy)) {

            checkFlag = false;
        }
        if (!isElementDisplay(previousButtonBy)) {

            checkFlag = false;
        }
        if (!isElementDisplay(randomButtonBy)) {

            checkFlag = false;
        }
        if (!isElementDisplay(repeatButtonBy)) {

            checkFlag = false;
        }
        if (!isElementDisplay(progressTimeBy)) {

            checkFlag = false;
        }
        if (!isElementDisplay(progressBarBy)) {

            checkFlag = false;
        }


        if (checkFlag) {
            System.out.println("All the mandtory element of the WebPlayer is displayed well!");
        }

        return checkFlag;
    }



    public String getSubUtilSimple(String soap, String rgex) {

        Pattern pattern = Pattern.compile(rgex);

        Matcher m = pattern.matcher(soap);


        while (m.find()) {
            return m.group(1);
        }
        return "";


    }


 
}

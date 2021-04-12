package spotify.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import spotify.page.*;

import java.util.*;

public class TestSpotify extends BaseTest {

    @Test(priority = 0, description = "Login the spotify page with user's account")

    public void LoginPageUserNamePassword() throws InterruptedException {



        //*************WebPlayer PAGE Login*************



        String keywordCheck = "TestSpotifyWebPlayer";



        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginToSpotify("xxxxxxxxxxxxxxx", "xxxxxxxxxxxx");


        Thread.sleep(3000);


        //To check the page is at the Webpalyer with user's name and login successful

        Assert.assertEquals(loginPage.findString(keywordCheck), true);
        Thread.sleep(2000);

    }


    @Test(priority = 1, description = "Check the element of Webplayer UI")

    public void checkWebPlayerUI() throws InterruptedException {



        //*************Check WebPlayer*************
        LoginPage webPlayerPage = new LoginPage(driver);

        webPlayerPage.goToMusicpage();
        // Close the cookie pop page. 
        webPlayerPage.closeCookiePop();
        // Check the mandatory element of UI of the Webplayer

        Assert.assertEquals(webPlayerPage.checkElementPlayer(), true);

    

    }

    @Test(priority = 2, description = "Check the function of play ", enabled = true)

    public void checkWebPlayerPlay() throws InterruptedException {



        //*************Check WebPlayer*************
        LoginPage webPlayerPage = new LoginPage(driver);

        webPlayerPage.goToMusicpage();
        // Close the cookie pop page. 
        webPlayerPage.closeCookiePop();
        //webPlayerPage.playStartMusic(); 

        System.out.println("Test the Play start function");
        Assert.assertEquals(webPlayerPage.playStartMusic(), true);

        Thread.sleep(5000);
        //webPlayerPage.playPauseMusic(); 



        System.out.println("Test the Play Pause function");
        Assert.assertEquals(webPlayerPage.playPauseMusic(), true);

        //Thread.sleep(100000);

    }


    @Test(priority = 3, description = "Check the function of Next Function ", enabled = true)

    public void checkWebPlayerNext() throws InterruptedException {



        //*************Check WebPlayer*************
        LoginPage webPlayerPage = new LoginPage(driver);

        webPlayerPage.goToMusicpage();
        // Close the cookie pop page. 
        webPlayerPage.closeCookiePop();

        //Firstly start the music 

        webPlayerPage.playStartMusic();

        Thread.sleep(5000);

        //Check the next Function; 

        System.out.println("Test the Play Next function");
        Assert.assertEquals(webPlayerPage.playNextMusic(), true);

    }





    @Test(priority = 4, description = "Check the function of Previous Function ")

    public void checkWebPlayerPrevious() throws InterruptedException {



        //*************Check WebPlayer*************
        LoginPage webPlayerPage = new LoginPage(driver);

        webPlayerPage.goToMusicpage();
        // Close the cookie pop page. 
        webPlayerPage.closeCookiePop();

        //Firstly start the music 

        webPlayerPage.playOneSongFromList();

        Thread.sleep(5000);

        //Check the next Function; 

        System.out.println("Test the Play Previous function");
        Assert.assertEquals(webPlayerPage.playNextMusic(), true);

    }


    @Test(priority = 5, description = "Check the function of single loop ", enabled = true)

    public void checkWebPlayerSingleLoop() throws InterruptedException {



        //*************Check WebPlayer*************
        LoginPage webPlayerPage = new LoginPage(driver);

        webPlayerPage.goToMusicpage();
        // Close the cookie pop page. 
        webPlayerPage.closeCookiePop();

        //Firstly start the music 

        webPlayerPage.playOneSongFromList();

        Thread.sleep(5000);

  
        System.out.println("Test the Play Single Loop function");
        Assert.assertEquals(webPlayerPage.playSingleLooptMusic(), true);

    }
    @Test(priority = 6, description = "Check the function of random song ", enabled = true)

    public void checkWebPlayerRandomSong() throws InterruptedException {



        //*************Check WebPlayer*************
        LoginPage webPlayerPage = new LoginPage(driver);

        webPlayerPage.goToMusicpage();
        // Close the cookie pop page. 
        webPlayerPage.closeCookiePop();

        //Firstly start the music 

        webPlayerPage.playOneSongFromList();

        Thread.sleep(5000);

  
        System.out.println("Test the Play Random song function");
        Assert.assertEquals(webPlayerPage.playRandomtMusic(), true);

    }
}

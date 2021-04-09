The script is to test the webplayer of spotify.com with GEO:  Canada and Language eng.

The automation testing suites only support English Language.

Config your local Java, which supports Selenium 3, Chrome's driver and TestNG.

In file BaseTest.java  Line 18:  specify the path of your local chrome driver.

        System.setProperty("webdriver.chrome.driver", "D:\\java-selenium-lib\\chromedriver.exe");

In file TestSpotify.java     Line 31:   the testing account/password.

    loginPage.loginToSpotify("xxxxxx", "xxxxxxxxx");
    
   
   There are seven cases to check the function of the webplayer.
   
   ![image](https://user-images.githubusercontent.com/82223084/114209775-04eab200-992d-11eb-96da-98651832b2a0.png)


package factoryDevices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidCloud implements IDevice{
    @Override
    public AppiumDriver create() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "jesusarze_Otm9fN");
        caps.setCapability("browserstack.key", "TJtHHXq98eQqoad42Nsy");

        // Set URL of the application under test
        caps.setCapability("app", "bs://10cbe18a883f54e9ffff409c41fa9c3926babc06");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "When Do Project");
        caps.setCapability("build", "1.0");
        caps.setCapability("name", "WhenDo");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver;
        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            driver = new AndroidDriver<AndroidElement>(
                    new URL("http://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        // Write your test case statements here

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();

        return null;
    }
}

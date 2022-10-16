package appiumControl;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class TextBox extends AppiumControl{
    public TextBox(By locator) {
        super(locator);
    }

    public void setText (String value) throws MalformedURLException {
        this.findControl();
        this.control.clear();
        this.control.sendKeys(value);
    }
}

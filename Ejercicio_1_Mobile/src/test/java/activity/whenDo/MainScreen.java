package activity.whenDo;

import appiumControl.Button;
import appiumControl.Label;
import appiumControl.ViewGroup;
import org.openqa.selenium.By;

public class MainScreen {
    public Button addNoteButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));
    public ViewGroup viewItem = new ViewGroup(By.xpath("//android.widget.ListView[@resource-id='com.vrproductiveapps.whendo:id/notesList']/android.view.ViewGroup[1]"));

    public MainScreen () {}

    public boolean isNoteDisplayed (String title) {
        Label note = new Label(By.xpath("//android.widget.TextView[@text='"+ title +"']"));
        return note.isControlDisplayed();
    }
}

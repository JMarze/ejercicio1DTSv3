package activity.whenDo;

import appiumControl.Button;
import appiumControl.TextBox;
import org.openqa.selenium.By;

public class CreateNoteForm {
    public TextBox titleTextBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public TextBox noteTextBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
    public Button saveButton = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));
    public Button deleteButton = new Button(By.id("com.vrproductiveapps.whendo:id/deleteItem"));
    public Button confirmButton = new Button(By.id("android:id/button1"));
}

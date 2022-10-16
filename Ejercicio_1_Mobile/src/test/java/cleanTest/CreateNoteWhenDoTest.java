package cleanTest;

import activity.whenDo.CreateNoteForm;
import activity.whenDo.MainScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

import java.net.MalformedURLException;

public class CreateNoteWhenDoTest {
    MainScreen mainScreen = new MainScreen();
    CreateNoteForm createNoteForm = new CreateNoteForm();

    @Test
    public void verifyCreateNewNote () throws MalformedURLException {
        /*
         * CREACIÓN
         */
        String title = "Nueva nota";
        String note = "Esta es una nota";

        mainScreen.addNoteButton.click();
        createNoteForm.titleTextBox.setText(title);
        createNoteForm.noteTextBox.setText(note);
        createNoteForm.saveButton.click();

        // Verificación
        Assertions.assertTrue(mainScreen.isNoteDisplayed(title), "ERROR, La nota no ha sido creada...");

        /*
         * EDICIÓN
         */
        title = "Nota Editada";
        note = "Esta es una nota editada";

        mainScreen.viewItem.click();
        createNoteForm.titleTextBox.setText(title);
        createNoteForm.noteTextBox.setText(note);
        createNoteForm.saveButton.click();

        // Verificación
        Assertions.assertTrue(mainScreen.isNoteDisplayed(title), "ERROR, La nota no ha sido editada...");

        /*
         * ELIMINACIÓN
         */
        mainScreen.viewItem.click();
        createNoteForm.deleteButton.click();
        createNoteForm.confirmButton.click();

        // Verificación
        Assertions.assertFalse(mainScreen.isNoteDisplayed(title), "ERROR, La nota no ha sido eliminada...");
    }

    @AfterEach
    public void closeApp () throws MalformedURLException {
        Session.getInstance().closeApp();
    }
}

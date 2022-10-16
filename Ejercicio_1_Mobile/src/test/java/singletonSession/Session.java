package singletonSession;

import factoryDevices.FactoryDevice;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public class Session {
    // Atributo del mismo tipo
    private static Session session = null;
    private AppiumDriver driver;
    // Constructor privado
    private Session () throws MalformedURLException {
        driver = FactoryDevice.make("android").create();
    }
    // Método estático público para acceder a
    // la instancia única
    public static Session getInstance() throws MalformedURLException {
        if (session == null) {
            session = new Session();
        }
        return session;
    }

    public void closeApp () {
        driver.quit();
        session = null;
    }

    public AppiumDriver getDriver () {
        return driver;
    }
}

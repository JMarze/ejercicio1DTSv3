package factoryDevices;

import java.util.Locale;

public class FactoryDevice {
    public static  IDevice make (String typeDevice) {
        IDevice device;
        switch (typeDevice.toLowerCase()) {
            case "android":
                device = new Android();
                break;
            case "ios":
                device = new IOs();
                break;
            default:
                device = new AndroidCloud();
                break;
        }
        return device;
    }
}

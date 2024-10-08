package helper;

public class BrowserUtils {
    public static void navigateTo (String url) {
        Logger.log("Navigate to " + url);
        DriverUtils.driver.get().get(url);
    }

    public static void maximize() {
        Logger.log("Maximize browser");
        DriverUtils.driver.get().manage().window().maximize();
    }

    public static void close() {
        Logger.log("Close browser");
        DriverUtils.driver.get().quit();
    }

}

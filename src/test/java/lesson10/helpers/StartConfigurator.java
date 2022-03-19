package lesson10.helpers;

public class StartConfigurator {
    public static String getBrowser() {

        return System.getProperty("browser", "chrome");// Supported values: "chrome", "firefox", "ie", "opera", "edge"
    }

    public static String getBrowserVersion() {

        return System.getProperty("version");
    }


    public static String getRemoteURL() {
        return System.getProperty("remoteURL", "https://" + getLogin() + ":"
                + getPassword() + "@selenoid.autotests.cloud/wd/hub");
    }

    public static String getLogin() {
        return System.getProperty("login", "user1");
    }

    public static String getPassword() {
        return System.getProperty("password", "1234");
    }

}

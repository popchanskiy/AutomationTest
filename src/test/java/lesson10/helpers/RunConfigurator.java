package lesson10.helpers;

public class RunConfigurator {
    public static String getBrowser() {

        return System.getProperty("browser", "chrome");// Supported values: "chrome", "firefox", "ie", "opera", "edge"
    }

    public static String getBrowserVersion() {
        String version = getBrowser();
        switch (version) {
            case "opera":
                return System.getProperty("version", "76.0");
            case "firefox":
                return System.getProperty("version", "88.0");

            case "chrome":
                return System.getProperty("version", "90.0");
        }
        return "";
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

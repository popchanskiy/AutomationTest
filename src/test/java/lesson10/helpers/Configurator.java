package lesson10.helpers;

public class Configurator {
    public static String getBrowser() {

        return System.getProperty("browser", "chrome");// Supported values: "chrome", "firefox", "ie", "opera", "edge"
    }

    public static String getBrowserVersion() {

        return System.getProperty("version");
    }


    public static String getURL() {
        return System.getProperty("URL",  "@selenoid.autotests.cloud/wd/hub");
    }
    public static String getRemoteURL() {
        return System.getProperty("remoteURL", "https://" + getRemoteURLLogin() + ":"
                + getRemoteURLPassword() + getURL());
    }

    public static String getRemoteURLLogin() {
        return System.getProperty("remoteURLLogin", "user1");
    }

    public static String getRemoteURLPassword() {
        return System.getProperty("remoteURLPassword",
                "1234");
    }

    /*public static String getLogin() {
        return System.getProperty("login", "user1");
    }

    public static String getPassword() {
        return System.getProperty("password", "1234");
    }*/

}

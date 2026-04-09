package creational.singleton;
public class Settings {
    private static Settings instance;
    private String server = "https://api.notify.ua";

    private Settings() {}

    public static synchronized Settings getInstance() {
        if (instance == null) instance = new Settings();
        return instance;
    }

    public String getServer() {
        return server;
    }
}
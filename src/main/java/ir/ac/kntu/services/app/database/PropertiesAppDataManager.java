package ir.ac.kntu.services.app.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesAppDataManager implements AppDataManager {
    private static final String DEFAULT_VALUE = "not_set";

    @Override
    public AppInfo getAppInfo() {
        try(InputStream input = PropertiesAppDataManager.class.getResourceAsStream("/app/app_info.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            String version = properties.getProperty("version", DEFAULT_VALUE);
            long build = Long.parseLong(properties.getProperty("build", "0"));
            String repo = properties.getProperty("repo", DEFAULT_VALUE);
            return new AppInfo(version, repo, build);
        } catch (IOException exception) {
            exception.printStackTrace();
            return new AppInfo(DEFAULT_VALUE, DEFAULT_VALUE, 0);
        }
    }
}

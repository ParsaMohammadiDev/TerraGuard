package ir.ac.kntu.services.app.database;

public class AppInfo {
    private String version;
    private String repo;
    private long build;

    public AppInfo(String version, String repo, long build) {
        this.version = version;
        this.repo = repo;
        this.build = build;
    }

    public String getVersion() {
        return version;
    }

    public String getRepo() {
        return repo;
    }

    public long getBuild() {
        return build;
    }
}

package ir.ac.kntu.game.difficulties;

public class DifficultyFactory {
    public GameDifficulty getEasyDifficulty() {
        return new Easy();
    }

    public GameDifficulty getMediumDifficulty() {
        return new Medium();
    }

    public GameDifficulty getHardDifficulty() {
        return new Hard();
    }
}
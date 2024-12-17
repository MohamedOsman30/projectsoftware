package projectsoftt.quiz;

public class Score {

    private static Score instance;
    private int score;

    private Score() {
    }

    public static Score getInstance() {
        if (instance == null) {
            instance = new Score();
        }
        return instance;
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
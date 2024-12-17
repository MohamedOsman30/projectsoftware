package projectsoftt.quiz;

public abstract class Question {
    private String text;

    public Question() {
        this.text = ""; 
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public abstract void addQuestion();
    public abstract void displayQuestion();
}

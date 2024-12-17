package projectsoftt.quiz;

public class QuestionFactory {
    private static TrueFalseQuestion trueFalseQuestionInstance;
    private static MultipleChoiceQuestion multipleChoiceQuestionInstance;

    public static Question createQuestion(String type) {
        switch (type) {
            case "True/False":
                if (trueFalseQuestionInstance == null) {
                    trueFalseQuestionInstance = new TrueFalseQuestion();
                }
                return trueFalseQuestionInstance;

            case "Multiple Choice":
                if (multipleChoiceQuestionInstance == null) {
                    multipleChoiceQuestionInstance = new MultipleChoiceQuestion();
                }
                return multipleChoiceQuestionInstance;

            default:
                throw new IllegalArgumentException("Invalid question type: " + type);
        }
    }
}

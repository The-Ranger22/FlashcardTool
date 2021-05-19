package ft.model;

/**
 * @author Levi Schanding
 * @version 0.1
 */
public class Flashcard {

    private String question;
    private String answer;

    Flashcard(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion(){
        return question;
    }

    /**
     * @param question
     */
    public void setQuestion(String question){
        this.question = question;
    }


    public String getAnswer(){
        return answer;
    }

    /**
     * @param answer
     */
    public void setAnswer(String answer){
        this.answer = answer;
    }

    @Override
    public String toString(){
        return String.format("%s : %s", question, answer);
    }
}

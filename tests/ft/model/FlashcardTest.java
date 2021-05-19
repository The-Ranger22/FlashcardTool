package ft.model;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FlashcardTest {
    private static final String QUESTION = "Q";
    private static final String ANSWER = "A";
    private static Flashcard flashcard;

    @Before
    public void createFlashcard(){
        flashcard = (new FlashcardDeck("d")).addEntry(QUESTION, ANSWER);
    }

    @Test
    public void getQuestion(){
        assertEquals(flashcard.getQuestion(), QUESTION);
    }

    @Test
    public void getAnswer() {
        assertEquals(flashcard.getAnswer(), ANSWER);
    }

    @Test
    public void setQuestion() {
        flashcard.setQuestion("QUESTION");
        assertEquals(flashcard.getQuestion(), "QUESTION");
    }

    @Test
    public void setAnswer() {
        flashcard.setAnswer("ANSWER");
        assertEquals(flashcard.getAnswer(), "ANSWER");
    }
}
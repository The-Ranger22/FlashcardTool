package ft.model;

import org.junit.Before;
import org.junit.Test;


import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * @author Levi Schanding
 * @version 0.1
 */
public class FlashcardDeckTest {
    private static final String DECK_NAME = "deck";
    private static final int DECK_SIZE = 10;
    private static FlashcardDeck deck = new FlashcardDeck(DECK_NAME);


    @Before
    public void populateDeck(){
        for (int i = 1; i <= DECK_SIZE; i++){
            deck.addEntry(String.format("Q%d", i), String.format("A%d", i));
        }
    }


    @Test
    public void randomizeDeck(){
        FlashcardDeck oDeck = new FlashcardDeck("OriginalOrder");
        for (Flashcard fc : deck.getFlashcards()){
            oDeck.addEntry(fc);
        }
        deck.randomize();
        assertFalse(Arrays.equals(deck.getFlashcards(), oDeck.getFlashcards()));
    }

    @Test
    public void mergeDeck(){
        FlashcardDeck anotherDeck = new FlashcardDeck("Deck2");
        for (int i = DECK_SIZE + 1; i <= DECK_SIZE + 10; i++){
            anotherDeck.addEntry(String.format("Q%d", i), String.format("A%d", i));
        }
        assertNotNull(deck.mergeDeck(anotherDeck));
        System.out.println("mergeDeck: Not null");
        assertEquals(deck.count(), DECK_SIZE + anotherDeck.count());
        System.out.println("mergeDeck: Size is correct");
    }

    @Test
    public void addEntry(){
        deck.clear();
        assertNotNull(deck.addEntry("Q", "A"));
        assertEquals(deck.count(), 1);
    }

    @Test
    public void deleteEntry() {
        deck.clear();
        for(int i = 0; i < 3; i++){
            deck.addEntry(String.format("Q%d", i), String.format("A%d", i));
        }
        int deckSize = deck.count();
        deck.deleteEntry(deck.getEntry(deck.count() - 1));
        assertEquals(deck.count(), deckSize - 1);
    }

    @Test (expected = NoSuchElementException.class)
    public void deleteEntryNoSuchElement(){
        deck.deleteEntry(new Flashcard("", ""));
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void deleteEntryIndexOutOfBounds(){
        deck.deleteEntry(-1);
    }

    @Test
    public void getEntry() {
        assertNotNull(deck.getEntry(0));
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void getEntryIndexOutOfBounds(){
        deck.getEntry(-1);
    }

    @Test
    public void getFlashcards() {
        assertNotNull(deck.getFlashcards());
    }

    @Test
    public void getDeckName() {
        deck.setDeckName(DECK_NAME);
        assertEquals(deck.getDeckName(), DECK_NAME);
    }

    @Test
    public void setDeckName() {
        deck.setDeckName("DECK");
        assertEquals(deck.getDeckName(), "DECK");
    }

    @Test
    public void count(){
        assertEquals(deck.count(), DECK_SIZE);
    }

    @Test
    public void clear() {
        deck.clear();
        assertEquals(deck.count(), 0);
    }


}
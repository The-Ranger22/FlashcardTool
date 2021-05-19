package ft.model;
import java.util.LinkedList;
import java.util.Random;
import java.util.Arrays;
import java.util.NoSuchElementException;
/**
 * @author Levi Schanding
 * @version 0.1
 */
public class FlashcardDeck {
    /**
     *
     */

    private LinkedList<Flashcard> deck = new LinkedList<>();
    /**
     *
     */
    private String deckName;

    public FlashcardDeck(){}
    /**
     * @param deckName the name of the flashcard deck.
     */
    public FlashcardDeck(String deckName){
        this.deckName = deckName;
    }

    /**
     * Randomizes the contents of the deck by randomly removing elements from the deck linkedlist and adding them to an array.
     * The array is then added back to deck. Time Complexity : nlog(n/2).
     */
    public void randomize(){
        Flashcard[] randomizedDeck = new Flashcard[deck.size()];
        Random rand = new Random(); //TODO: Make thread safe
        for (int i = 0; i < randomizedDeck.length; i++){
            randomizedDeck[i] = deck.remove(rand.nextInt(deck.size()));
        }
        deck.addAll(Arrays.asList(randomizedDeck));
    }

    /**
     * Combines two or more decks into one.
     * @param decks the decks to be folded into the deck invoking the method.
     */
    public FlashcardDeck mergeDeck(FlashcardDeck... decks){
        for (FlashcardDeck cardDeck : decks) {
            deck.addAll(Arrays.asList(cardDeck.getFlashcards()));
        }
        return this;
    }

    /**
     * Creates a Flashcard object and adds it to the deck.
     * @param question a string representation of the flashcard question.
     * @param answer a string representation of the answer to the flashcard question.
     * @return the flashcard that was just created.
     */
    public Flashcard addEntry(String question, String answer){
        Flashcard fc;
        deck.add(fc = new Flashcard(question, answer));
        return fc;
    }

    public Flashcard addEntry(Flashcard flashcard){
        deck.add(flashcard);
        return flashcard;
    }

    /**
     * Removes the specified card from the deck.
     * @param flashcard the item to be removed.
     * @return The flashcard that was removed.
     */

    public Flashcard deleteEntry(Flashcard flashcard) throws NoSuchElementException{
        if (!deck.remove(flashcard)) throw new NoSuchElementException();
        return flashcard;
    }

    public Flashcard deleteEntry(int index) throws NoSuchElementException, IndexOutOfBoundsException{
        return deck.remove(index);
    }


    public Flashcard getEntry(int index) throws IndexOutOfBoundsException{
        return deck.get(index);
    }


    /**
     *
     * @return the contents of the LinkedList, deck, as an array.
     */
    public Flashcard[] getFlashcards(){

        Flashcard[] flashcards = new Flashcard[deck.size()];
        for (int i = 0; i < deck.size(); i++){
            flashcards[i] = deck.get(i);
        }
        return flashcards;
    }

    /**
     * @return the name of the FlashcardDeck instance.
     */
    public String getDeckName(){
        return deckName;
    }

    /**
     * Sets the name of the FlashcardDeck instance.
     * @param deckName the new name of the FlashcardDeck instance.
     */
    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    /**
     * Returns the number of cards currently in the deck.
     * @return the size of the deck.
     */
    public int count(){
        return deck.size();
    }

    /**
     * Clears the LinkedList that is used to store all the cards.
     */
    public void clear(){
        deck.clear();
    }





}

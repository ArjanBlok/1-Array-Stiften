
import com.sun.org.apache.bcel.internal.Constants;
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Arjan
 */
public class Deck {

    Card[] cardArray;

    /**
     * Constructor
     */
    Deck() {
        cardArray = new Card[0];
    }

    /**
     * Vult de array met 52 kaarten: 2,3 ... ,10,V,B,K,A van klaveren, schoppen,
     * harten en ruiten.
     */
    public void fillDeck() {
        cardArray = new Card[52];

        for (int i = 0; i < 52; i++) {
            cardArray[i] = new Card(i);
        }
    }

    /**
     * Zoals gezegd is dit spel een beetje vreemd. Bijvoorbeeld: spelers kunnen
     * kaarten toevoegen aan het deck. Hierdoor kan het aantal kaarten groter
     * worden dan 52.
     *
     * @param card een Kaart
     * @param index Op positie
     */
    public void insertAt(Card card, int index) {
        if (index > cardArray.length) {
            cardArray = Arrays.copyOf(cardArray, index);
        }
        cardArray[index] = card;
    }

    /**
     * Kaarten kunnen ook verwijderd worden uit het deck. delete Haalt de kaart
     * met een bepaalde index er uit.
     *
     * Merk op: na delete is de array zo groot als het aantal elementen dat er
     * in zit.
     *
     * @param index
     */
    public void delete(int index) {
        cardArray[index] = null;
        Card[] newCardArray = new Card[index - 1];
        int iNew = 0;
        for (int iOld = 0; iOld < cardArray.length; iOld++) {
            if (cardArray[iOld] != null) {
                newCardArray[iNew] = cardArray[iOld];
                iNew++;
            }
        }
        cardArray = newCardArray;
    }

    /**
     * Schud alle kaarten zodat de volgorde 'willekeurig' is. Hiervoor is het
     * toegestaan de Java Random generator te gebruiken.
     *
     */
    public void shuffle() {
        Random rand = new Random();
        int elementCount = cardArray.length;
        // 60 swaps
        for (int i = 0; i < 75; i++) {
            int randomIntC1 = rand.nextInt(elementCount);
            int randomIntC2 = rand.nextInt(elementCount);
            Card tempCard = cardArray[randomIntC1];
            //Hussel
            cardArray[randomIntC1] = cardArray[randomIntC2];
            cardArray[randomIntC2] = tempCard;
        }
    }

    /**
     * Een gegeven kaart moet worden opgezocht in de array, en de index ervan
     * moet als return worden teruggegeven. Zie [Hubbard p.30]
     *
     * @param card de kaart die gezocht wordt
     * @return De index van de gevonden kaart
     */
    public int sequentialSearch(Card card) {
        for (int i = 0; i < cardArray.length; i++) {
            if (cardArray[i].number == card.number && cardArray[i].suit == card.suit) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Legt de kaarten op volgorde. We nemen aan dat een deck op volgorde ligt,
     * als de volgorde hetzelfde is als na {@link #fillDeck()}
     */
    public void sort() {
        Arrays.sort(cardArray);
    }

    /**
     * Een bepaalde kaart moet worden opgezocht in de gesorteerde array op de
     * binary search manier zoals besproken in [Hubbart p.31].
     *
     * @param card de kaart die gezocht wordt
     * @return De index van de gevonden kaart
     */
    public int binarySearch(Card card) {
        sort();
        int low = 0;
        int high = cardArray.length;
        while (0 < cardArray.length) {
            int i = (low + high) / 2;
            int iCompareResult;
            iCompareResult = cardArray[i].compareTo(card);

            if (iCompareResult == 0) {
                return i;
            } else if (iCompareResult < 0) {
                low = i + 1;
            } else {
                high = i;
            }
        }
        return -1;
    }

    /**
     * Pretty-print het deck.
     */
    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < cardArray.length; i++) {
            str += cardArray[i] + "\r\n";
        }
        return str;

    }
}

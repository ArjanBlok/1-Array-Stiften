/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arjan
 */
public class Card implements Comparable<Card> {

    public Card(int i) {
        int cardID = i % 13;
        switch (cardID) {
            case 0:
                this.number = EnumNumber.Aas;
                break;
            case 1:
                this.number = EnumNumber.Two;
                break;
            case 2:
                this.number = EnumNumber.Three;
                break;
            case 3:
                this.number = EnumNumber.Four;
                break;
            case 4:
                this.number = EnumNumber.Five;
                break;
            case 5:
                this.number = EnumNumber.Six;
                break;
            case 6:
                this.number = EnumNumber.Seven;
                break;
            case 7:
                this.number = EnumNumber.Eight;
                break;
            case 8:
                this.number = EnumNumber.Nine;
                break;
            case 9:
                this.number = EnumNumber.Ten;
                break;
            case 10:
                this.number = EnumNumber.Boer;
                break;
            case 11:
                this.number = EnumNumber.Koning;
                break;
            case 12:
                this.number = EnumNumber.Koning;
                break;
        }
        switch (i / 13) {
            case 0:
                this.suit = EnumSuit.Harten;
                break;
            case 1:
                this.suit = EnumSuit.Klaver;
                break;
            case 2:
                this.suit = EnumSuit.Ruiten;
                break;
            case 3:
                this.suit = EnumSuit.Schoppen;
                break;
        }

    }

    private int fromCardtoCardID() {
        int returnInt = 0;

        switch (number) {
            case Aas:
                returnInt = 0;
                break;
            case Two:
                returnInt = 1;
                break;
            case Three:
                returnInt = 2;
                break;
            case Four:
                returnInt = 3;
                break;
            case Five:
                returnInt = 4;
                break;
            case Six:
                returnInt = 5;
                break;
            case Seven:
                returnInt = 6;
                break;
            case Eight:
                returnInt = 7;
                break;
            case Nine:
                returnInt = 8;
                break;
            case Ten:
                returnInt = 9;
                break;
            case Boer:
                returnInt = 10;
                break;
            case Vrouw:
                returnInt = 11;
                break;
            case Koning:
                returnInt = 12;
                break;
        }

          switch (suit) {
            case Harten:
                break;
            case Klaver:
                returnInt += 13;
                break;
            case Ruiten:
                returnInt += 26;
                break;
            case Schoppen:
                returnInt += 39;
                break;
        }

        return returnInt;
    }

    public Card(EnumSuit suit, EnumNumber number) {
        this.suit = suit;
        this.number = number;
    }
    /**
     * Klaver, Schoppen, Harten of Ruiten Hoeft niet persé van type Object te
     * zijn, vul zelf in
     */
    EnumSuit suit;

    /**
     * 2,3,4,5,6,7,8,9,10,b,v,k,a Hoeft niet persé van type Object te zijn, vul
     * zelf in
     */
    EnumNumber number;

    /**
     * Pretty-print deze Card als string
     */
    public String toString() {
        return number.toString() + " van " + suit.toString();
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.fromCardtoCardID(), o.fromCardtoCardID());
    }
}

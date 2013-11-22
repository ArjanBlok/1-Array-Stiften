/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Arjan
 */
public class App {
           public static void main(String[] args) {
                Deck deck = new Deck();
                deck.fillDeck();
                deck.shuffle();
                
                Card card = new Card(/*Bijvoorbeeld. Harten Aas */);
                int testIndex = 30;
                deck.insertAt(card, testIndex);
                System.out.print("Sequential search ...");
                int foundIndex = deck.sequentialSearch(card);
                System.out.println((foundIndex == testIndex)?"Win":"Fail");
                
                System.out.print("Binary search...");
                deck.sort();
                foundIndex = deck.binarySearch(card);
                System.out.println(foundIndex);

                
        }
}

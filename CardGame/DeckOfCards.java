
package CardGame;

import javax.swing.ImageIcon;

/******************************************************************************
*<pre>
* Class: DeckOfCards
* Description: This class is responsible for the game’s card images
* Date Created: February 8, 2017
* Author: Ian Etheridge
* Development: Shoreline Community College CS 143 for 
*	Project 2: 24 Point Card Game.
* Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
*	Mac osSierra (Version 10.12.2)
*</pre>
******************************************************************************/
public class DeckOfCards {
    
    //instantiates an ImageIcon Array fixed to the card deck length 
    private static ImageIcon[] cardlist = new ImageIcon[52];
    
    /******************************************************************************
    *<pre>
    * Class: DeckOfCards
    * Method: loadCards()
    * Description: This method assigns single card images to each index
    * 	of the instantiated card list Array. All 52 cards will be included.
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    public void loadCards(){ //loads cards into the cardList array
        for(int i = 1; i < 53; i++){
            cardlist[i - 1] = new ImageIcon("src/cardPictures/" + i + ".png");
        }
    }
   
    /******************************************************************************
    *<pre>
    * Class: DeckOfCards
    * Method: cardToGUI(int c)
    * Description: This method returns a card element from the card list
    *	Array assigned at the provided index.
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param c
     * @return 
    ******************************************************************************/
    public static ImageIcon cardToGUI(int c){
       return cardlist[c - 1];
    }

    /******************************************************************************
    *<pre>
    * Class: DeckOfCards
    * Method: cardValue(int c)
    * Description: returns the value of a given card number. Ace=1 thru
    *	King=13
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param c
     * @return 
    ******************************************************************************/
    public int cardValue(int c){
        if (c >= 1 && c < 5)
           return 1;
        if (c >= 5 && c < 9)
           return 2;
        if (c >= 9 && c < 13)
           return 3;
        if (c >= 13 && c < 17)
           return 4;
        if (c >= 17 && c < 21)
           return 5;
        if (c >= 21 && c < 25)
           return 6;
        if (c >= 25 && c < 29)
           return 7;
        if (c >= 29 && c < 33)
           return 8;
        if (c >= 33 && c < 37)
           return 9;
        if (c >= 37 && c < 41)
           return 10;
        if (c >= 41 && c < 45)
           return 11;
        if (c >= 45 && c < 49)
           return 12;
        return 13;
    }
    
}

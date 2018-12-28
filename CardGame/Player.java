
package CardGame;

/******************************************************************************
*<pre>
* Class: Player
* Description:  Child class to Person class. Instances create a 
*	Person object by inheritance with variables for total games played and
*	total amount of correct submissions. Also contains mutator
*	and accessor methods for these variables 
* Date Created: February 8, 2017
* Author: Ian Etheridge
* Development: Shoreline Community College CS 143 for Project 2
* Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
*	Mac osSierra (Version 10.12.2)
*</pre>
******************************************************************************/
public class Player extends Person{
    
    //instance variables, calls Person constructor
    //private Person person;
    private int totalGamesPlayed;
    private int amountCorrect;

    /******************************************************************************
    *<pre>
    * Class: Player
    * Constructor: Player, default constructor
    * Description:  Creates a Player object with name inheritance set to  
    *	"Special Guest" and total games played and amount correct set to zero.
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for Project 2
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    public Player() {
        super("Special Guest");
        totalGamesPlayed = 0;  //set to default values
        amountCorrect = 0;
    }
    
    /******************************************************************************
    *<pre>
    * Class: Player
    * Constructor: Player(String person, int totalGamesPlayed, 
    *   int amountCorrect), overloaded constructor #1
    * Description:  Creates a Player object accepting a String for name 
    *	inheritance and integer values for total games played and correct 
    *	submissions as parameters.
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for Project 2
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param person
     * @param totalGamesPlayed
     * @param amountCorrect
    ******************************************************************************/
    public Player(String person, int totalGamesPlayed, int amountCorrect) {
        super(person);
        this.totalGamesPlayed = totalGamesPlayed;
        this.amountCorrect = amountCorrect;
    }
    
    /******************************************************************************
    *<pre>
    * Class: Player
    * Constructor: Player(String [] s), overloaded #2
    * Description: Creates Player object as a String Array containing 
    *	name inheritance and amountCorrect and totalGamesPlayed
    * Date Created: February 20, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param s
    ******************************************************************************/
    public Player(String[] s){
        super(s[0]);
        this.amountCorrect = Integer.valueOf(s[1]);
        this.totalGamesPlayed = Integer.valueOf(s[2]);   
    }
    
    /******************************************************************************
    *<pre>
    * Class: Player
    * Method: getPercentageCorrect()
    * Description:  This method accesses the amountCorrect field and
    *	totalGamesPlayed field for an instance of the Player class 
    *	and divides them and multiplies by 100 to return the 
    *	percentage value of correct submissions. Returns a float. 
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for Project 2
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @return 
    ******************************************************************************/
    public float getPercentageCorrect(){
        return ((float)this.getAmountCorrect() / 
                this.getTotalGamesPlayed()) * 100;
    }
    
    /******************************************************************************
    *<pre>
    * Class: Player
    * Method: getTotalGamesPlayed()
    * Description:  Accessor method for the totalGamesPlayed data field.
    *   Returns an integer value.
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for Project 2
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @return 
    ******************************************************************************/
    public int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    /******************************************************************************
    *<pre>
    * Class: Player
    * Method: setTotalGamesPlayed(int totalGamesPlayed)
    * Description:  Mutator method for the totalGamesPlayed data field
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for Project 2
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param totalGamesPlayed
    ******************************************************************************/
    public void setTotalGamesPlayed(int totalGamesPlayed) {
        this.totalGamesPlayed = totalGamesPlayed;
    }

    /******************************************************************************
    *<pre>
    * Class: Player
    * Method: getAmountCorrect()
    * Description:  Accessor method for the amountCorrect data field.
    *	Returns an integer value.
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for Project 2
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @return 
    ******************************************************************************/
    public int getAmountCorrect() {
        return amountCorrect;
    }

    /******************************************************************************
    *<pre>
    * Class: Player
    * Method: setAmountCorrect(int amountCorrect)
    * Description:  Mutator method for the amountCorrect data field.
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for Project 2
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param amountCorrect
    ******************************************************************************/
    public void setAmountCorrect(int amountCorrect) {
        this.amountCorrect = amountCorrect;
    }

    /******************************************************************************
    *<pre>
    * Class: Player
    * Method: toString(), Override
    * Description:  Returns the instance data for a Player object
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for Project 2
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @return 
    * @Override
    ******************************************************************************/
    @Override
    public String toString() {
        return "Player{" + "person=" + super.getName() + ", totalGamesPlayed=" + 
                totalGamesPlayed + ", amountCorrect=" + amountCorrect + '}';
    }
}

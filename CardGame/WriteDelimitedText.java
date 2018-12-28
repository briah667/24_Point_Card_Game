
package CardGame;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/******************************************************************************
*<pre>
* Class: WriteDelimitedText
* Description: write contents of players ArrayList to text file using 
*	delimiters for data field separation. 
* Date Created: February  2017
* Author: Ian Etheridge
* Development: Shoreline Community College CS 143 for 
*	Project 2: 24 Point Card Game.
* Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
*	Mac osSierra (Version 10.12.2)
*</pre>
******************************************************************************/
public class WriteDelimitedText {
    
    private String fileName;
    private ArrayList<Player> players;
    
    /******************************************************************************
    *<pre>
    * Class: WriteDelimitedText
    * Constructor: WriteDelimitedText
    * Description: instantiates fileName and players ArrayList. 
    *	calls writeToFile.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param file
     * @param playerArray
    ******************************************************************************/
    public WriteDelimitedText(String file, ArrayList<Player> playerArray){
        this.fileName = file;
        this.players = playerArray;
        writeToFile();
    }
    
    /******************************************************************************
    *<pre>
    * Class: WriteDelimitedText
    * Method: writeToFile
    * Description: uses PrintWriter to write players ArrayList data to text 
    *	file using delimiters. Has exception handling for print errors. 
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    public void writeToFile(){
        try {
            PrintWriter output = new PrintWriter(fileName);
            //loop thru and write all Players data to file
            for (int i = 0; i < players.size(); i++) {
                Player uncleLord = players.get(i);
                String line = uncleLord.getName() + "|"
                        + uncleLord.getAmountCorrect() + "|"
                        + uncleLord.getTotalGamesPlayed()+  "\n";
                output.write(line);
            }
            output.close();
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, fileName +  "does not exist",
                "File input error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}

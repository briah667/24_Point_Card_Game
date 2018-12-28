
package CardGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/******************************************************************************
*<pre>
* Class: ReadDelimitedText
* Description: reads text from text file in package with different data
*	fields separated by a delimiter
* Date Created: February  2017
* Author: Ian Etheridge
* Development: Shoreline Community College CS 143 for 
*	Project 2: 24 Point Card Game.
* Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
*	Mac osSierra (Version 10.12.2)
*</pre>
******************************************************************************/
public class ReadDelimitedText {

    private final String fileName;
    private ArrayList<Player> players;
    
    /******************************************************************************
    *<pre>
    * Class: ReadDelimitedText
    * Constructor: ReadDelimitedText(String file)
    * Description: instantiates fileName from main GUI and calls 
    *	readfromFile.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param file
    ******************************************************************************/
    public ReadDelimitedText(String file){
        this.fileName =  file;
        this.players = new ArrayList<>();
        readFromFile();
    }
    
    /******************************************************************************
    *<pre>
    * Class: ReadDelimitedText
    * Method: readFromFile
    * Description: Uses FileReader and BufferedReader to read each line 
    *	of text file. Splits data from text file up to appropriate data fields 
    *	adding each set to a new Player object in players ArrayList.
    *   Contains exception handling for file read error.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    public void readFromFile() {
        try {
            FileReader inputFile = new FileReader(fileName);
            BufferedReader input = new BufferedReader(inputFile);
            //read the first line
            String line = input.readLine();
            //continue to read lines while there are lines to read
            while (line != null) {
                //new temp Player object built from text document contents
                Player someone = new Player();
                StringTokenizer token = new StringTokenizer(line, "|");
                while (token.hasMoreTokens()) {
                    someone.setName(token.nextToken());
                    someone.setAmountCorrect(Integer.parseInt(token.nextToken()));
                    someone.setTotalGamesPlayed(Integer.parseInt(token.nextToken()));
                }
                //add someone to the ArryaList 
                players.add(someone);
                //look for next line to read
                line = input.readLine();
            }
            //no more lines to read from text file, exit file
            input.close();
        } catch (FileNotFoundException exp) {
            //display error message regarding inability to locate file
            JOptionPane.showMessageDialog(null, fileName + " dose not exist",
                    "File Input Error", JOptionPane.WARNING_MESSAGE);
            exp.printStackTrace();
            //Add JFileChooser to find the file
        } catch (IOException exp) {
            //display error message regarding file contents
            JOptionPane.showMessageDialog(null, fileName + " is corrupt",
                    "File Input Error", JOptionPane.WARNING_MESSAGE);
            exp.printStackTrace();
        }
    }
    
    /******************************************************************************
    *<pre>
    * Class: ReadDelimitedText
    * Method: getPlayerArray
    * Description: returns players ArrayList 
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)  
    *</pre>
     * @return 
    ******************************************************************************/
    public ArrayList<Player> getPlayerArray(){
        return this.players;
    }
    
}

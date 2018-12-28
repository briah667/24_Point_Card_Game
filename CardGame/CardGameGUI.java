package CardGame;

import static CardGame.EvaluateExpression.closeEnough;
import static CardGame.EvaluateExpression.evaluate;
import static CardGame.EvaluateExpression.insertBlanks;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


/******************************************************************************
*<pre>
* Class: CardGameGUI
* Description: Main GUI driver for 24 Point Card Game project. 
* Date Created: February  2017
* Author: Ian Etheridge
* Development: Shoreline Community College CS 143 for 
*	Project 2: 24 Point Card Game.
* Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
*	Mac osSierra (Version 10.12.2)
*</pre>
******************************************************************************/
public class CardGameGUI extends javax.swing.JFrame {

    //source file
    private final String fileName = "src/CardGame/Players.txt";
    
    //instance ArrayLists and Stacks
    private ArrayList<Player> players;
    private ArrayList<Integer> operandsList = new ArrayList<Integer>();
    private Stack<Integer> operatorsStack = new Stack<Integer>();
    private Stack<Integer> operandsStack = new Stack<Integer>();
    private ArrayList<Integer> images;
    
    //these instances used for methods
    private int[] cardNumbers;
    private DeckOfCards cards;
    private Player currentPlayer;
    
    
    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Constructor: CardGameGUI
    * Description: Creates new Card Game form. Displays player info
    *	and the four cards in play. calls readFromFile to read data from
    *	text file.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    public CardGameGUI() {
        
        this.players = new ArrayList<Player>();
        this.images = new ArrayList<Integer>();
        this.cardNumbers = new int[4];
        this.cards = new DeckOfCards();
        
        // Read form an external text file and create an
        // ArrayList of player objects       
        readFromFile(fileName);
        
        
        initComponents();
        selectPlayer();        
        //set verify button as default
        this.getRootPane().setDefaultButton(this.verify);
        //centers the form at start.
        this.setLocationRelativeTo(null);
        shuffle();
        expression.requestFocus();
        
    }
    
    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Method: displayPlayerInfo
    * Description: gets the name and amount correct of the current player
    *	and displays it in the appropriate text box. Saves players 
    *	ArrayList to file when called.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    public void displayPlayerInfo(){
        String name = currentPlayer.getName();
        String amount = "" + currentPlayer.getAmountCorrect();
        displayName.setText(name);
        displayScore.setText(amount);
        savePlayers();
    }
    
    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Method: selectPlayer
    * Description: creates an instance of the PlayerDatabase class 
    *	passing to it the players ArrayList that is an instance of this
    *	class. Calls getSelectedPlayer to determine which player 
    *	the user selected for the game. Adds the player to the 
    *	ArrayLIst if the player is not found upon selection.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    private void selectPlayer(){
        
            PlayerDatabase selected = new PlayerDatabase(this.players);
        
            selected.setVisible(true);
            
            if(selected.getSelectedPlayer() != null){
                this.currentPlayer = selected.getSelectedPlayer();
                if(!players.contains(currentPlayer)){
                    players.add(currentPlayer);
                }
                displayPlayerInfo();
            }else if(this.currentPlayer == null){
                JOptionPane.showMessageDialog(null, "No Player Selected, exiting program", 
                    "Exit", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
                
            }
            
        }
    

    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Method: readFromFile
    * Description: reads from a text file and writes to the players ArrayList.
    *	The delimiter "|" is used to differentiate between player 
    *	object instance variables/fields.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param fileName
    ******************************************************************************/
    public void readFromFile(String fileName) {
        //this makes sure the ArrayList is clear before reading into it
        players.clear();
        ReadDelimitedText reader = new ReadDelimitedText(fileName);
        players = reader.getPlayerArray();
    }

    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Method: writeToFile
    * Description: Accepts the players ArrayList and writes to a text
    *	file by creating an instance of WrtieDelimitedText class.
    *   The delimiter "|" is used to differentiate between player 
    *	object instance variables/fields. 
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    private void writeToFile(String fileName, ArrayList<Player> players) {
        WriteDelimitedText writer = new WriteDelimitedText(fileName, players);
    }
    
    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Method: savePlayers
    * Description: Sends fileName String and players ArrayList to 
    *	writeToFile.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    public void savePlayers(){
        writeToFile(fileName, players);
    }
    
    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Method: cardDisplay
    * Description: Creates instance of the DeckOfCards class to use
    *	loadCards method. Creates instance of Random class to 
    *	assign four unique random cards from the deck and add 
    *	them to the cardNumbers array.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    private void cardDisplay(){
        DeckOfCards newShuffle = new DeckOfCards();
        newShuffle.loadCards();
        
        Random randomCard = new Random();
        
        for(int i = 0; i < 4; i++){
            int newCard = randomCard.nextInt(52) + 1;
            cardNumbers[i] = newCard;
            for(int j = 0; j < i; j++){
                if(cardNumbers[j] == cardNumbers[i]){
                    i--;
                    break;
                }
            }
        }
        
        for(int k = 0; k < 4; k++){
        images.add(k, newShuffle.cardValue(cardNumbers[k]));
        }   
    }
    
    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Method: shuffle
    * Description: Calls cardDisplay method then displays the four 
    *	randomly assigned cards from the array to the main GUI.
    *   Clears the expression text field every shuffle. 
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    public void shuffle(){
        cardDisplay();
        //set card images, save to Array
        card1.setIcon(DeckOfCards.cardToGUI(cardNumbers[0]));
        card2.setIcon(DeckOfCards.cardToGUI(cardNumbers[1]));
        card3.setIcon(DeckOfCards.cardToGUI(cardNumbers[2]));
        card4.setIcon(DeckOfCards.cardToGUI(cardNumbers[3]));  
        //clear the expression text field
        this.expression.setText(null);
        expression.requestFocus();
    }
    
    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Method: evaluateExpression
    * Description: Takes user input expression solution to the game and
    *	passes it to the evaluate method from the EvaluateExpression 
    *	class. If the solution is correct the players score and games 
    *	played count increases. If incorrect, just the games played
    *	value increases. Contains exception handling and message
    *	dialog JOptionPanes. Redisplays new player info. 
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)  
    *</pre>
    ******************************************************************************/
    public void evaluateExpression()throws NumberFormatException{
        String exp = this.expression.getText();
        
        if(exp != null && exp.length() > 0){
            
            try{
                double result = evaluate(exp);
                if(!validCards(exp)){ 
                    //if the numbers used in the expression are not the values 
                    //of the current cards on display
                    JOptionPane.showMessageDialog(null, "You may only use the current"
                            + "cards values to obtain 24. Further explanation of rules"
                            + "in 'About'.", 
                    "Invalid Entry", JOptionPane.INFORMATION_MESSAGE);
                    this.expression.setText("");
                    expression.requestFocus();
                }
                
                else if( closeEnough(result, 24)){
                    // == 24
                    //perform validation
                    //increase score and save players if validation is true
                    currentPlayer.setAmountCorrect(currentPlayer.getAmountCorrect() + 1);
                    currentPlayer.setTotalGamesPlayed(currentPlayer.getTotalGamesPlayed() + 1);
                    savePlayers();
                    displayPlayerInfo();
                    JOptionPane.showMessageDialog(null, "Correct!", 
                    "Result", JOptionPane.INFORMATION_MESSAGE);
                    this.expression.setText("");
                    shuffle();
                    expression.requestFocus();
                    
                }
                else if (result != 24){
                    
                    // != 24
                    currentPlayer.setTotalGamesPlayed(currentPlayer.getTotalGamesPlayed() + 1);
                    savePlayers();
                    displayPlayerInfo();
                    JOptionPane.showMessageDialog(null, "Incorrect", 
                    "Result", JOptionPane.INFORMATION_MESSAGE);
                    this.expression.setText("");
                    expression.requestFocus();
                }   
            } catch(EmptyStackException ex){ 
                //invalid expression entered, like +++ 
                JOptionPane.showMessageDialog(null, "Invalid Expression", 
                    "Input Error", JOptionPane.INFORMATION_MESSAGE);
                currentPlayer.setTotalGamesPlayed(currentPlayer.getTotalGamesPlayed() + 1);
                    savePlayers();
                    displayPlayerInfo();
                    this.expression.setText("");
                    expression.requestFocus();
                
            } catch (NumberFormatException ex) { //catches letters and unusable chars
                JOptionPane.showMessageDialog(null, "Invalid Expression", 
                    "Input Error", JOptionPane.INFORMATION_MESSAGE);
                currentPlayer.setTotalGamesPlayed(currentPlayer.getTotalGamesPlayed() + 1);
                    savePlayers();
                    displayPlayerInfo();
                    this.expression.setText("");
                    expression.requestFocus();
            }
            
        } else{ //if no expression is typed and Verify button is clicked
            JOptionPane.showMessageDialog(null, "Enter an expression", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            expression.requestFocus();
        }
        displayPlayerInfo(); 
    }
    
    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Method: validCards
    * Description: Validates that the user has used only the current 
    *	cards displayed values for the expression to obtain a result
    *	of 24. Calls insertBanks, creates instance of DeckOfCards class.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)  
    *</pre>
     * @param exp
     * @return 
    ******************************************************************************/
    public boolean validCards(String exp){
        //create instance of DeckofCards to use the cardValue method
        DeckOfCards cards = new DeckOfCards();
        
    
        //insert blanks around characters
        exp = insertBlanks(exp);
        
        //replace everything that is not a number with whitespace
        exp = exp.replaceAll("\\D+", " ");
        //send string to string array
        String[] numbersInExp = exp.split(" ");
        //isolate the numbers from expression into an ArrayList
        ArrayList<Integer> justTheNums = new ArrayList<>();
        for(String element : numbersInExp){
           if(!element.equals(" ") && !element.equals("")){
               justTheNums.add(Integer.parseInt(element));
           }
        }
        //get current cards into an ArrayList
        ArrayList<Integer> currentCards = new ArrayList<>();
        for(int i =0; i < cardNumbers.length; i++){
            currentCards.add(cards.cardValue(cardNumbers[i]));
        }
        //sort ArrayLists and return the boolean expressing if both 
        //ArrayLists contain the same numbers, i.e. the user used the
        //correct numbers cooresponding to the current cards of the game 
        Collections.sort(justTheNums);
        Collections.sort(currentCards);
        return justTheNums.equals(currentCards);
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardHolder = new javax.swing.JPanel();
        card1 = new javax.swing.JLabel();
        card2 = new javax.swing.JLabel();
        card3 = new javax.swing.JLabel();
        card4 = new javax.swing.JLabel();
        shuffle = new javax.swing.JButton();
        expression = new javax.swing.JTextField();
        verify = new javax.swing.JButton();
        enterAnExpression = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        topImageJLabel = new javax.swing.JLabel();
        playerName = new javax.swing.JLabel();
        playerScore = new javax.swing.JLabel();
        displayName = new javax.swing.JTextField();
        displayScore = new javax.swing.JTextField();
        playerDatabase = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cardGameJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        printJMenuItem = new javax.swing.JMenuItem();
        exitJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        cardHolder.setBackground(new java.awt.Color(204, 0, 0));
        cardHolder.setName("cardHolder"); // NOI18N

        card2.setName("card2"); // NOI18N

        javax.swing.GroupLayout cardHolderLayout = new javax.swing.GroupLayout(cardHolder);
        cardHolder.setLayout(cardHolderLayout);
        cardHolderLayout.setHorizontalGroup(
            cardHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardHolderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        cardHolderLayout.setVerticalGroup(
            cardHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardHolderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        shuffle.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        shuffle.setText("Shuffle");
        shuffle.setToolTipText("Draw four new cards");
        shuffle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shuffleActionPerformed(evt);
            }
        });

        expression.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        expression.setToolTipText("Type mathematical expression here");

        verify.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        verify.setText("Verify");
        verify.setToolTipText("Check your solution");
        verify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyActionPerformed(evt);
            }
        });

        enterAnExpression.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        enterAnExpression.setText("Enter an expression:");

        topImageJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CardGame/design-header.5b55f3d4.jpg"))); // NOI18N

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topImageJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topImageJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
        );

        playerName.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        playerName.setText("Player Name:");

        playerScore.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        playerScore.setText("Player Score:");

        displayName.setEditable(false);
        displayName.setBackground(new java.awt.Color(255, 255, 51));
        displayName.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        displayName.setToolTipText("Current player name");

        displayScore.setEditable(false);
        displayScore.setBackground(new java.awt.Color(255, 255, 51));
        displayScore.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        displayScore.setToolTipText("Current player total wins");

        playerDatabase.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        playerDatabase.setText("Player Database");
        playerDatabase.setToolTipText("Change player, check stats");
        playerDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerDatabaseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        jLabel1.setText("24-Point Card Game!!!");

        cardGameJMenuBar.setName("cardGameJMenuBar"); // NOI18N

        fileJMenu.setMnemonic('F');
        fileJMenu.setText("File");
        fileJMenu.setToolTipText("Print or Exit");
        fileJMenu.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N

        printJMenuItem.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        printJMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CardGame/print-icon.png"))); // NOI18N
        printJMenuItem.setMnemonic('P');
        printJMenuItem.setText("Print");
        printJMenuItem.setToolTipText("Print Displayed GUI");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);

        exitJMenuItem.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        exitJMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CardGame/Actions-application-exit-icon.png"))); // NOI18N
        exitJMenuItem.setMnemonic('X');
        exitJMenuItem.setText("Exit");
        exitJMenuItem.setToolTipText("Exit game, close program");
        exitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(exitJMenuItem);

        cardGameJMenuBar.add(fileJMenu);

        helpJMenu.setMnemonic('H');
        helpJMenu.setText("Help");
        helpJMenu.setToolTipText("Game rules and authorship info");
        helpJMenu.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N

        aboutJMenuItem.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        aboutJMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CardGame/FAQ-icon.png"))); // NOI18N
        aboutJMenuItem.setMnemonic('A');
        aboutJMenuItem.setToolTipText("Display information regarding purpose and author of this program.");
        aboutJMenuItem.setLabel("About/How To Play");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        cardGameJMenuBar.add(helpJMenu);

        setJMenuBar(cardGameJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(0, 47, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 525, Short.MAX_VALUE)
                            .addComponent(cardHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(enterAnExpression)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(expression, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(verify))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(shuffle)))
                        .addGap(0, 51, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(playerScore))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(playerName)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(displayScore, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(displayName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playerDatabase)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cardHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(shuffle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterAnExpression)
                    .addComponent(expression, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verify))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayScore, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerScore)
                    .addComponent(playerDatabase))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Method: verifyActionPerformed
    * Description: calls evaluateExpression method.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    private void verifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyActionPerformed
        // TODO add your handling code here:
        evaluateExpression();
    }//GEN-LAST:event_verifyActionPerformed

    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Method: aboutJMenuItemActionPerformed
    * Description: creates and displays the About form GUI.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
        //Display AboutJFrame
        About cardGameAbout = new About(this, true);
        cardGameAbout.setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed

    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Method: shuffleActionPerformed
    * Description: calls shuffle method.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    private void shuffleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shuffleActionPerformed
        // TODO add your handling code here:
        shuffle();
    }//GEN-LAST:event_shuffleActionPerformed

    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Method: playerDatabaseActionPerformed
    * Description: calls selectPlayer method.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1;  
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    private void playerDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerDatabaseActionPerformed
        // TODO add your handling code here:
        selectPlayer();
    }//GEN-LAST:event_playerDatabaseActionPerformed

    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Method: printJMenuItemActionPerformed
    * Description: Sends an image of the main GUI card game to 
    *	PrintUtilites class to be printed.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        // TODO add your handling code here:
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printJMenuItemActionPerformed

    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Method: exitJMenuItemActionPerformed
    * Description: Closes game GUI and stops the program.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    private void exitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJMenuItemActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitJMenuItemActionPerformed

    /******************************************************************************
    *<pre>
    * Class: CardGameGUI
    * Method: main
    * Description: main GUI driver. Gets this thing up and running!
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param args
    ******************************************************************************/
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CardGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CardGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CardGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CardGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CardGameGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JLabel card1;
    private javax.swing.JLabel card2;
    private javax.swing.JLabel card3;
    private javax.swing.JLabel card4;
    private javax.swing.JMenuBar cardGameJMenuBar;
    private javax.swing.JPanel cardHolder;
    private javax.swing.JTextField displayName;
    private javax.swing.JTextField displayScore;
    private javax.swing.JLabel enterAnExpression;
    private javax.swing.JMenuItem exitJMenuItem;
    private javax.swing.JTextField expression;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JPanel header;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton playerDatabase;
    private javax.swing.JLabel playerName;
    private javax.swing.JLabel playerScore;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JButton shuffle;
    private javax.swing.JLabel topImageJLabel;
    private javax.swing.JButton verify;
    // End of variables declaration//GEN-END:variables
}

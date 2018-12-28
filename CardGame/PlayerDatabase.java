
package CardGame;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/******************************************************************************
*<pre>
* Class: PlayerDatabase extends javax.swing.JDialog
* Description: GUI for displaying and selecting a Player from the 
*	players ArrayList. Also displays selected player game stats.
* Date Created: February  2017
* Author: Ian Etheridge
* Development: Shoreline Community College CS 143 for 
*	Project 2: 24 Point Card Game.
* Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
*	Mac osSierra (Version 10.12.2)
*</pre>
******************************************************************************/
public class PlayerDatabase extends javax.swing.JDialog {

    private Player selectedPlayer;
    ArrayList<Player> playersList;
    private final String fileName = "src/CardGame/Players.txt";
    
    /******************************************************************************
    *<pre>
    * Class: PlayerDatabase extends javax.swing.JDialog
    * Constructor: PlayerDatabase
    * Description: accepts ArrayList of Player objects from main GUI 
    *	to display on this separate GUI. Calls displayPlayers method.
    *	This also centers the GUI on the screen with exit button default
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param players
    ******************************************************************************/
    public PlayerDatabase(ArrayList<Player> players) {
       
        initComponents();
        this.setModal(true);
        this.getRootPane().setDefaultButton(addJButton);
        setLocationRelativeTo(null);
        
        this.playersList = players;
        displayPlayers();
    }

    public Player getSelectedPlayer() {
        return selectedPlayer;
    }
    
    /******************************************************************************
    *<pre>
    * Class: PlayerDatabase 
    * Method: insertionSort
    * Description: Sorts ArrayList Player in ascending
    * 	order by name. Uses the insertion sort algorithm which inserts player at
    * 	correct position and shuffles everyone else below that position.
    * Date Created: January 2017, for SCC CS143 Project 1
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143
    * 	Project 2, i24 Point Card Game
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param playersList
    ******************************************************************************/
    public void insertionSort(ArrayList<Player> playersList) {
        int i, j;
        for (i = 0; i < playersList.size(); i++) {
            Player temp = playersList.get(i);
            j = i - 1;
            while (j >= 0 && playersList.get(j).getName().
                    compareToIgnoreCase(temp.getName()) > 0) {
                playersList.set(j + 1, playersList.get(j));
                j--;
            }
            playersList.set(j + 1, temp);
        }
    }

    /******************************************************************************
    *<pre>
    * Class: PlayerDatabase extends javax.swing.JDialog
    * Method: displayPlayers
    * Description: calls insertionSort to sort the ArrayList of players then
    *	accesses the name data for each player and displays them in 
    *	the JList.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    private void displayPlayers() {
        int location = playersJList.getSelectedIndex();
        String[] playersNames = new String[this.playersList.size()];

        //sort players using insertion sort by names and display in JList
        insertionSort(playersList);
        
        //saves player names from ArrayList to  String Array
        for (int i = 0; i < playersList.size(); i++) {
            playersNames[i] = playersList.get(i).getName();
        }
        
        playersJList.setListData(playersNames);
        if (location < 0) {
            playersJList.setSelectedIndex(0);
        } else {
            playersJList.setSelectedIndex(location);
        }
    }
    
    /******************************************************************************
    *<pre>
    * Class: PlayerDatabase extends javax.swing.JDialog
    * Method: showPlayerData
    * Description: send the instance data of each player to the appropriate 
    *	JTextField for user display. Accepts integer for index of player
    *	in the List.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    private void showPlayerData(int index) {
        nameJTextField.setText(playersList.get(index).getName());
        correctJTextField.setText(
                Integer.toString(playersList.get(index).getAmountCorrect()));
        totalJTextField.setText( //continue on next line
                Integer.toString(playersList.get(index).getTotalGamesPlayed()));
        percentJTextField.setText(
                Integer.toString((int) playersList.get(index).getPercentageCorrect()));
    }
    
    /******************************************************************************
    *<pre>
    * Class: PlayerDatabase extends javax.swing.JDialog
    * Method: isValidName
    * Description: restricts new player names to be of 12 chars or less
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param name
     * @return 
    ******************************************************************************/
    public boolean isValidName(String name){
        return name.length() <= 12 && name.length() > 0;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playerDisplayJScrollPane = new javax.swing.JScrollPane();
        playersJList = new javax.swing.JList<>();
        headerJLabel = new javax.swing.JLabel();
        titleJLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nameJLabel = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        correctJLabel = new javax.swing.JLabel();
        correctJTextField = new javax.swing.JTextField();
        totalJLabel = new javax.swing.JLabel();
        totalJTextField = new javax.swing.JTextField();
        percentLabel = new javax.swing.JLabel();
        percentJTextField = new javax.swing.JTextField();
        controlPanel = new javax.swing.JPanel();
        deleteJButton = new javax.swing.JButton();
        addJButton = new javax.swing.JButton();
        selectJButton = new javax.swing.JButton();
        exitJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        playersJList.setBackground(new java.awt.Color(204, 0, 0));
        playersJList.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        playersJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        playersJList.setSelectionBackground(new java.awt.Color(255, 255, 51));
        playersJList.setSelectionForeground(new java.awt.Color(0, 0, 0));
        playersJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                playersJListValueChanged(evt);
            }
        });
        playerDisplayJScrollPane.setViewportView(playersJList);

        headerJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CardGame/design-header.5b55f3d4.jpg"))); // NOI18N
        headerJLabel.setText("jLabel1");

        titleJLabel.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        titleJLabel.setText("Player Database");

        jPanel1.setLayout(new java.awt.GridLayout(4, 2));

        nameJLabel.setBackground(new java.awt.Color(255, 255, 255));
        nameJLabel.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        nameJLabel.setText("Player Name:");
        jPanel1.add(nameJLabel);

        nameJTextField.setEditable(false);
        nameJTextField.setBackground(new java.awt.Color(255, 255, 51));
        nameJTextField.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        nameJTextField.setToolTipText("Selected player's name");
        jPanel1.add(nameJTextField);

        correctJLabel.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        correctJLabel.setText("Amount Correct:");
        jPanel1.add(correctJLabel);

        correctJTextField.setEditable(false);
        correctJTextField.setBackground(new java.awt.Color(255, 255, 51));
        correctJTextField.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        correctJTextField.setToolTipText("Total wins");
        jPanel1.add(correctJTextField);

        totalJLabel.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        totalJLabel.setText("Amount Played:");
        jPanel1.add(totalJLabel);

        totalJTextField.setEditable(false);
        totalJTextField.setBackground(new java.awt.Color(255, 255, 51));
        totalJTextField.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        totalJTextField.setToolTipText("Total attempts");
        jPanel1.add(totalJTextField);

        percentLabel.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        percentLabel.setText("Percent Correct:");
        jPanel1.add(percentLabel);

        percentJTextField.setEditable(false);
        percentJTextField.setBackground(new java.awt.Color(255, 255, 51));
        percentJTextField.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        percentJTextField.setToolTipText("wins/attempts");
        jPanel1.add(percentJTextField);

        controlPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        controlPanel.setMinimumSize(new java.awt.Dimension(299, 45));
        controlPanel.setName("controlPanel"); // NOI18N
        controlPanel.setLayout(new java.awt.GridLayout(1, 5, 5, 5));

        deleteJButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteJButton.setFont(new java.awt.Font("Trajan Pro", 2, 18)); // NOI18N
        deleteJButton.setText("Delete");
        deleteJButton.setToolTipText("Delete Selected Player");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });
        controlPanel.add(deleteJButton);

        addJButton.setBackground(new java.awt.Color(255, 255, 255));
        addJButton.setFont(new java.awt.Font("Trajan Pro", 2, 18)); // NOI18N
        addJButton.setMnemonic('A');
        addJButton.setText("Add");
        addJButton.setToolTipText("Add a new player to the game.");
        addJButton.setMinimumSize(new java.awt.Dimension(57, 45));
        addJButton.setName("addJButton"); // NOI18N
        addJButton.setPreferredSize(new java.awt.Dimension(57, 35));
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        controlPanel.add(addJButton);

        selectJButton.setBackground(new java.awt.Color(255, 255, 255));
        selectJButton.setFont(new java.awt.Font("Trajan Pro", 2, 18)); // NOI18N
        selectJButton.setMnemonic('E');
        selectJButton.setText("Select");
        selectJButton.setToolTipText("Select highlighted player for the game.");
        selectJButton.setName("selectJButton"); // NOI18N
        selectJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectJButtonActionPerformed(evt);
            }
        });
        controlPanel.add(selectJButton);

        exitJButton.setBackground(new java.awt.Color(255, 255, 255));
        exitJButton.setFont(new java.awt.Font("Trajan Pro", 2, 18)); // NOI18N
        exitJButton.setMnemonic('x');
        exitJButton.setText("Exit");
        exitJButton.setToolTipText("Close player database.");
        exitJButton.setName("exitJButton"); // NOI18N
        exitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJButtonActionPerformed(evt);
            }
        });
        controlPanel.add(exitJButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(titleJLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(playerDisplayJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(headerJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerDisplayJScrollPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /******************************************************************************
    *<pre>
    * Class: PlayerDatabase extends javax.swing.JDialog
    * Method: addJButtonActionPerformed
    * Description: displays a JOptionPane to enter the name of a new
    *	player. Contains exception handling for name submission.
    *	If new player name validated, starts game with the new player.
    *   Closes PlayerDatabase GUI.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        String playerName = JOptionPane.showInputDialog(this, "New Player Name:",
                "Enter A Valid Name:", JOptionPane.PLAIN_MESSAGE);
        if(playerName == null){
            JOptionPane.showMessageDialog(null, "No name typed", 
                    "New player not created", JOptionPane.INFORMATION_MESSAGE);
        } else if (isValidName(playerName)){
            
            this.selectedPlayer = new Player(playerName, 0, 0);
            
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid name typed. Use less than 13 chracters.", 
                    "New player not created", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_addJButtonActionPerformed

    /******************************************************************************
    *<pre>
    * Class: PlayerDatabase extends javax.swing.JDialog
    * Method: selectJButtonActionPerformed
    * Description: the selected player in the JList is loaded into the game.
    *	Closes the PlayerDatabase GUI.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    private void selectJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectJButtonActionPerformed
        selectedPlayer = playersList.get(playersJList.getSelectedIndex());
        this.dispose();  
    }//GEN-LAST:event_selectJButtonActionPerformed

    /******************************************************************************
    *<pre>
    * Class: PlayerDatabase extends javax.swing.JDialog
    * Method: exitJButtonActionPerformed
    * Description: closes GUI
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    private void exitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJButtonActionPerformed
        // End  program
        //needs exception for exiting at first load up
        //when the main GUI has not been generated and the exit button 
        //is hit from PlayerDatabase the program crashes. 
        selectedPlayer = null;
        this.dispose();
    }//GEN-LAST:event_exitJButtonActionPerformed

    /******************************************************************************
    *<pre>
    * Class: PlayerDatabase extends javax.swing.JDialog
    * Method: playersJListValueChanged
    * Description: tracks List selected index. Prevents IndexOutOfBounds
    *   Displays Player data
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    private void playersJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_playersJListValueChanged
        int index = (playersJList.getSelectedIndex());
        if (index == -1) {
            index = 0;
        }
        showPlayerData(index);
    }//GEN-LAST:event_playersJListValueChanged

    
    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        // Delete selected player
        int index = playersJList.getSelectedIndex();
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this player?",
                "Delete Player", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            playersList.remove(index);
            displayPlayers();
            writeToFile(fileName, playersList);
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
    }//GEN-LAST:event_deleteJButtonActionPerformed
    private void writeToFile(String fileName, ArrayList<Player> players) {
        WriteDelimitedText writer = new WriteDelimitedText(fileName, players);
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JLabel correctJLabel;
    private javax.swing.JTextField correctJTextField;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JButton exitJButton;
    private javax.swing.JLabel headerJLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTextField percentJTextField;
    private javax.swing.JLabel percentLabel;
    private javax.swing.JScrollPane playerDisplayJScrollPane;
    private javax.swing.JList<String> playersJList;
    private javax.swing.JButton selectJButton;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JLabel totalJLabel;
    private javax.swing.JTextField totalJTextField;
    // End of variables declaration//GEN-END:variables
}

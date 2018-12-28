
package CardGame;

/******************************************************************************
*<pre>
* Class: About
* Description: Provides background on program authorship, intention
*	game rules, and application operation.
* Date Created: February 8, 2017
* Author: Ian Etheridge
* Development: Shoreline Community College CS 143 for 
*	Project 2: 24 Point Card Game.
* Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
*	Mac osSierra (Version 10.12.2)
*</pre>
******************************************************************************/
public class About extends javax.swing.JDialog {

    /******************************************************************************
    *<pre>
    * Class: About
    * Constructor: About, Default
    * Description: Creates and displays the About GUI, centered on
    *	the screen.
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    public About(java.awt.Frame parent, boolean modal) {
        initComponents();
        this.getRootPane().setDefaultButton(exitJButton);
        this.aboutJTextArea.setCaretPosition(0);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerJPanel = new javax.swing.JPanel();
        headerImageJLabel = new javax.swing.JLabel();
        titleJLabel = new javax.swing.JLabel();
        aboutJScrollPane = new javax.swing.JScrollPane();
        aboutJTextArea = new javax.swing.JTextArea();
        exitJButton = new javax.swing.JButton();
        dateNameJTextArea = new javax.swing.JTextField();
        platformJTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        headerImageJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CardGame/design-header.5b55f3d4.jpg"))); // NOI18N

        javax.swing.GroupLayout headerJPanelLayout = new javax.swing.GroupLayout(headerJPanel);
        headerJPanel.setLayout(headerJPanelLayout);
        headerJPanelLayout.setHorizontalGroup(
            headerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerImageJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        headerJPanelLayout.setVerticalGroup(
            headerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerImageJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        titleJLabel.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        titleJLabel.setText("About This Game:");

        aboutJTextArea.setEditable(false);
        aboutJTextArea.setColumns(20);
        aboutJTextArea.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        aboutJTextArea.setRows(5);
        aboutJTextArea.setText("Welcome to the 24-Point Card game! \n\nThis game will test your wit on connecting a mathematical expression with a given selection of four cards.\n\nHere’s the rules:\n\n*Four cards are dealt to the user\n\n*The user represents each card with a numerical value 1-13\n\n*Aces equal 1, cards 2 through 10 are just that, Jacks through Kings are 11 through 13\n\n*The user attempts to create a mathematical expression using these four card values \nand addition, subtraction, division, multiplication and parenthesis:  +  -  /  *  (  )\n\n*The expression must equal 24 to win that round. \n\n*Each submission counts towards total games played, correct submissions add one to games won.\n\n*Some combinations of cards are impossible to create a mathematical result of 24,\n so the user may click the shuffle button to be dealt a new set of four cards without penalty.\n\nAdditional Information:\n\n*To change players, add a new player and see player stats, open the Player Database\nby clicking the corresponding button. \n\n*There are also options in the top menu bar for printing and exiting the program.\n\nPhoto Credits:\n\nThe two photos used in this program were found with e Google image search and used \nwithout permission, but here is where they came from:\n\n(Intro/Splash screen): Globe Views dream interpretation website\n http://globe-views.com/dreams/card.html I didn’t check much of this page out but the picture \nI used is given at the bottom of this article about card playing in dreams and what that might \nbe symbolic for in someone’s life.\n\n(Main 4 card header): The World Of Playing Cards website http://www.wopc.co.uk/cards/design\nThat site has some really interesting and old pictures of old card desk.\n\n(Menu Icons): http://www.iconarchive.com/\nThis website has a ton of open source icons available in many dimensions from large to super tiny!\n\nAuthorship:\n\nThis program was written by Ian Etheridge in February 2017 for Shoreline Community\nCollege’s Computer Science 143 class Project 2. The main focus was to get experience using\nArrayLists and Stacks data structures. And it’s kind of fun!");
        aboutJTextArea.setWrapStyleWord(true);
        aboutJScrollPane.setViewportView(aboutJTextArea);

        exitJButton.setBackground(new java.awt.Color(204, 255, 204));
        exitJButton.setFont(new java.awt.Font("Trajan Pro", 2, 18)); // NOI18N
        exitJButton.setMnemonic('x');
        exitJButton.setText("Exit");
        exitJButton.setToolTipText("Exit and close program");
        exitJButton.setName("exitJButton"); // NOI18N
        exitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJButtonActionPerformed(evt);
            }
        });

        dateNameJTextArea.setEditable(false);
        dateNameJTextArea.setBackground(new java.awt.Color(255, 255, 51));
        dateNameJTextArea.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        dateNameJTextArea.setText("2017 Ian Etheridge");
        dateNameJTextArea.setName("dateNameJTextArea"); // NOI18N
        dateNameJTextArea.setSelectionColor(new java.awt.Color(102, 255, 102));

        platformJTextField.setEditable(false);
        platformJTextField.setBackground(new java.awt.Color(255, 255, 51));
        platformJTextField.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        platformJTextField.setText("Platform: JAVA jdk1.8.0_60; NetBeans IDE 8.1; Mac osSierra (Version 10.12.2)");
        platformJTextField.setSelectionColor(new java.awt.Color(102, 255, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(headerJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(aboutJScrollPane)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateNameJTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(platformJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(titleJLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(exitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(aboutJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(dateNameJTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(platformJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /******************************************************************************
    *<pre>
    * Class: About
    * Method: exitJButtonActionPerformed
    * Description: closes the About GUI
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    private void exitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJButtonActionPerformed
        // End  program
        this.dispose();
    }//GEN-LAST:event_exitJButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane aboutJScrollPane;
    private javax.swing.JTextArea aboutJTextArea;
    private javax.swing.JTextField dateNameJTextArea;
    private javax.swing.JButton exitJButton;
    private javax.swing.JLabel headerImageJLabel;
    private javax.swing.JPanel headerJPanel;
    private javax.swing.JTextField platformJTextField;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
}

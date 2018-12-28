package CardGame;

import java.util.*; //import all from util

/******************************************************************************
*<pre>
* Class: EvaluateExpression
* Description: Evaluates a submitted expression from 24 point card 
*	game by separating operand and operators into two stacks.
* Date Created: February  2017
* Author: Ian Etheridge
* Development: Shoreline Community College CS 143 for 
*	Project 2: 24 Point Card Game.
* Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
*	Mac osSierra (Version 10.12.2)
*</pre>
******************************************************************************/
public class EvaluateExpression {

    
    /******************************************************************************
    *<pre>
    * Class: EvaluateExpression
    * Method: evaluate, throws EmptyStackException
    * Description: Evaluates a submitted expression from 24 point card 
    *	game by separating operand and operators into two stacks.
    *	Calls insertBlanks and processAnOperator. 
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param expression
     * @return 
     * @throws CardGame.EmptyStackException
    ******************************************************************************/
    public static int evaluate(String expression) throws EmptyStackException{
        //create two stacks, an operand and operator
        GenericStack<Integer> operand = new GenericStack<>();
        GenericStack<Character> operator = new GenericStack<>();
        
        //insert blanks around (, ), +, -, *, /
        expression = insertBlanks(expression);
        //extract operands and operators
        //phase 1: scanning of tokens
        String[] tokens = expression.split(" ");
        for(String token : tokens){
            if(token.length() == 0){ //blank space
                continue; //skip remaing block and examine next token
            }
            else if((token.charAt(0) == '+') || (token.charAt(0) == '-')) {
                //process all +, - in the stack
                while(!operator.isEmpty() && 
                        (operator.peek() == '+' ||
                         operator.peek() == '-' ||
                         operator.peek() == '*' ||
                         operator.peek() == '/' 
                        )
                     )
                {
                    processAnOperator(operand, operator);
                }
                //push the result of this operation onto the  operator stack
                operator.push(token.charAt(0));
                
            }
            else if((token.charAt(0) == '*') || (token.charAt(0) == '/')){
                //process all *, /
                 while(!operator.isEmpty() && 
                        (operator.peek() == '+' ||
                         operator.peek() == '-' ||
                         operator.peek() == '*' ||
                         operator.peek() == '/' 
                        )
                     )
                {
                    processAnOperator(operand, operator);
                }
                //push the result of this operation onto the  operator stack
                operator.push(token.charAt(0));
            }
            else if(token.charAt(0) == '('){
                operator.push('('); //push'(' onto operator stack
            }
            else if(token.charAt(0) == ')'){
                //process all the operators in the stack until another '('
                while(operator.peek() != '('){
                    processAnOperator(operand, operator);
                }
                operator.pop(); //pop '('
            }
            else{
                //push operand onto the stack
                operand.push(new Integer(token));
            }
                                
        }//end for 
        //process phase 2: process the remaining operators on the stack
        while(!operator.isEmpty()){
            processAnOperator(operand, operator);
        }
        //return the answer that remains in the operand stack
        return operand.pop();
    } //end evaluate method
    
    /******************************************************************************
    *<pre>
    * Class: EvaluateExpression
    * Method: insertBlanks
    * Description: called by evaluate, inserts blank strings between 
    *	operands and operators as necessary for separating operands
    *	and operators into the appropriate stack
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param s
     * @return 
    ******************************************************************************/
    public static String insertBlanks(String s){
        String result = "";
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == ')' ||
               s.charAt(i) == '+' || s.charAt(i) == '-' ||
               s.charAt(i) == '*' || s.charAt(i) == '/' )
                result += " " + s.charAt(i) + " ";
            else
               result += s.charAt(i);
        }
        return result;
    }//end insert blanks
    
    /******************************************************************************
    *<pre>
    * Class: EvaluateExpression
    * Method: processAnOperator
    * Description: called by evaluate, takes an operator from the stack 
    *	and apply it on the operands in the operand stack. Contains use of
    *   an infinite loop for exception handling purposes. 
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param operand
     * @param operator
     * @throws CardGame.EmptyStackException
    ******************************************************************************/
    public static void processAnOperator(GenericStack<Integer> operand, 
                                        GenericStack<Character> operator)
                                        throws EmptyStackException{
        char op = operator.pop();
        int op1 = operand.pop();
        int op2 = operand.pop();
        if(op == '+')
            operand.push(op2 + op1); //add operands
        else if(op == '-')
            operand.push(op2 - op1); //subtract
        else if(op == '*')
            operand.push(op2 * op1); //multiply
        else if(op == '/')
            operand.push(op2 / op1); //divide
        else{
            /*this line is an infinite loop condition that will be triggered if
            * the input expression contains more than one sequential operator
            *throwing an EmptyStackException, which is caught by evaluate*/
            while(true) operand.pop(); 
        }
            
    }
    
    /******************************************************************************
    *<pre>
    * Class: EvaluateExpression
    * Method: closeEnough
    * Description: used to compare two double values to determine if 
    *	they are the same value.
    * Date Created: February  2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param one
     * @param two
     * @return 
    ******************************************************************************/
    public static boolean closeEnough(double one, double two){
        double epsion = 0.000001;
        return Math.abs(one - two) < epsion;
    }
}

package CardGame;

/******************************************************************************
*<pre>
* Class: GenericStack
* Description:  Encapsulates the stack ADT and provides operations 
*	for manipulating stacks. Used for operands and operators 
*	during 24 Point Card game answer submission evaluations.
* Date Created: February 8, 2017
* Author: Ian Etheridge
* Development: Shoreline Community College CS 143 for 
*	Project 2: 24 Point Card Game.
* Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
*	Mac osSierra (Version 10.12.2)
*</pre>
 * @param <E>
******************************************************************************/
public class GenericStack<E> 
{
    //instance of class GenericStack
    //creates new ArrayList
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    /******************************************************************************
    *<pre>
    * Class: GenericStack
    * Method: getSize()
    * Description: Accessor method for size of the instantiated ArrayList
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.    
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @return 
    ******************************************************************************/
    public int getSize() 
    {
        return list.size();
    }

    /******************************************************************************
    *<pre>
    * Class: GenericStack
    * Method: peek()
    * Description: Accessor method for returning the element at the top 
    *	of the stack, or last added object. Does not remove from stack.
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @return 
    ******************************************************************************/
    public E peek() throws EmptyStackException 
    {
        if(list.isEmpty()){
            //mostly for invalid expression submissions
            throw new EmptyStackException(); 
        }
        return list.get(getSize() - 1);
    }

    /******************************************************************************
    *<pre>
    * Class: GenericStack
    * Method: push(E o)
    * Description: Adds a new element to the stack.
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param o
    ******************************************************************************/
    public void push(E o) 
    {
        list.add(o);
    }

    /******************************************************************************
    *<pre>
    * Class: GenericStack
    * Method: pop()
    * Description: Returns and removes the most recently added element 
    *	on the stack.
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @return 
    ******************************************************************************/
    public E pop() throws EmptyStackException
    {
        if(list.isEmpty()){
            //mostly for invalid expression submissions
            throw new EmptyStackException();
        }
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    /******************************************************************************
    *<pre>
    * Class: GenericStack
    * Method: pop()
    * Description: Returns and removes the most recently added element 
    *	on the stack.
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @return 
    ******************************************************************************/
    public boolean isEmpty() 
    {
        return list.isEmpty();
    }

    /******************************************************************************
    *<pre>
    * Class: GenericStack
    * Method: toString()
    * Description: Returns the stack contents as a string
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for 
    *	Project 2: 24 Point Card Game.
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @return 
    ******************************************************************************/
    @Override
    public String toString() 
    {
        return "stack: " + list.toString();
    }
}

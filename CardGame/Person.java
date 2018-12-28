
package CardGame;

/******************************************************************************
*<pre>
* Class: Person
* Description:  Creates a Person object for 24 Point Card game.
*	Contains a single constructor with accessor/mutator methods
*	for Person object name and toString. Is called by Player class
*       during instanciations. 
* Date Created: February 8, 2017
* Author: Ian Etheridge
* Development: Shoreline Community College CS 143 for Project 2
* Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
*	Mac osSierra (Version 10.12.2)
*</pre>
******************************************************************************/
public class Person {

    //instance of Person class. Each Person object will onlyh carry a name
    //but is called by Player class for game stats
    private String name;

    /******************************************************************************
    *<pre>
    * Class: Person
    * Constructor: Person(String name) 
    * Description:  Creates a new Person object with passed name value
    *	Accepts a string for name data field. 
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for Project 2
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param name
    ******************************************************************************/
    public Person(String name) {
        this.name = name;
    }

    /******************************************************************************
    *<pre>
    * Class: Person
    * Constructor: Person(String name) 
    * Description:  Creates a new Person object with "Default" as name value
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for Project 2
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    public Person() {
        this.name = "Default";
    }

    /******************************************************************************
    *<pre>
    * Class: Person
    * Method: getName()
    * Description:  Accessor method for Player object name data field 
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for Project 2
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @return 
    ******************************************************************************/
    public String getName() {
        return name;
    }

    /******************************************************************************
    *<pre>
    * Class: Person
    * Method: setName(String name)
    * Description:  Mutator method for Player object name data field 
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for Project 2
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
     * @param name
    ******************************************************************************/
    public void setName(String name) {
        this.name = name;
    }

    /******************************************************************************
    *<pre>
    * Class: Person
    * Method: toString(), Overridden
    * Description:  returns name of Person object as String
    * Date Created: February 8, 2017
    * Author: Ian Etheridge
    * Development: Shoreline Community College CS 143 for Project 2
    * Platform: jdk1.8.0_60; NetBeans IDE 8.1; 
    *	Mac osSierra (Version 10.12.2)
    *</pre>
    ******************************************************************************/
    @Override
    public String toString() {
        return name;
    }
    
}

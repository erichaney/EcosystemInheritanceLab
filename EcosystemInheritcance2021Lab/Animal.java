import java.util.Random;

class Animal
{
    /*# TODO 9
     * Write the keyword "abstract" immediately before the class keyword above. This will  
     * declare that no one is allowed to make an object of this class directly. We only intend
     * to construct objects of the subclasses like Fox and Rabbit.
     * 
     * Also, add what is needed to make Animal inherit code from Organism.
     */

    /*# TODO 10
     * Declare the following field:
     * - hunger: an integer to determine whether the animal can eat or will remain alive
     */
    
    

    Animal(Ecosystem world, int x, int y, int hunger)
    {
        /*# TODO 11
         * The superclass requires a world, an x, and a y value to be constructed.
         * 
         * Pass these values as arguments to 'super()'
         * 
         * Set hunger to the passed in value.
         */
      
    }

    /**
     * The default move of an animal is to move one space randomly or to stay put.
     * 
     * The move may be horizontal, vertical, diagonal, or no change in location.
     * That means the animal's x and y coordinates may change by +1, 0, or -1.
     * However, the x and y coordinates may not be negative after the move and
     * an animal's x-coordinates must remain less than world.WIDTH and
     * an animal's y-coordinates must remain less than world.HEIGHT.
     */
    void move()
    {
        //First we need to randomly generate the changes in position (-1, 0, or +1) like this:
        Random r = new Random();
        int randomChangeInX = r.nextInt(3) - 1; 
        int randomChangeInY = r.nextInt(3) - 1; 

        /*# TODO 12
         * Update the Animal's x and y coordinates (this.x and this.y)
         * using the random numbers we just generated. Make sure an animal doesn't walk
         * off the boundaries of the world!
         * 
         * The horizontal boundaries of the world are 0 to world.WIDTH.
         * The vertical boundaries of the world are 0 to world.HEIGHT.
         */
        

    }

    /**
     * By default, an animal is hungry enough to eat if its hunger level rises above ???.
     * 
     * This method will usually be overridden in the subclasses. Larger animals
     * will typically grow hungrier than smaller animals without needing to eat.
     * 
     * @return True if the animal is hungry enough to eat, and false otherwise.
     */
    boolean isHungry()
    {
        /*# TODO 13
         * Decide on an integer value for what is "hungry enough" to eat. 
         * 
         * Replace the ??? in the blue documentation comment above with your chosen value so you
         * communicate this choice in the API.
         * 
         * Return true only if this.hunger is greater than or equal to the value you chose.
         */

        return false;
    }

    /**
     * By default, an animal has starved to death if its hunger level rises above ???.
     * 
     * This method will usually be overridden in the subclasses. Larger animals
     * will typically grow hungrier than smaller animals without dying.
     * 
     * @return True if the animal too hungry to remain alive, and false otherwise.
     */
    boolean hasStarvedToDeath()
    {
        /*# TODO 14
         * Decide on an integer value for what is "hungry enough" to die. 
         * Replace the question marks above with your chosen value so it will be documented.
         * 
         * Then change the implementation below to return true if this.hunger is greater
         * than or equal to the value you chose. 
         * 
         * Note: this method should not change the isAlive status.
         */

        return false;
    }

    /**
     * Returns true if the Animal can eat the given Organism.
     * 
     * By default, an animal can eat another living organism if it has the same location as it
     * and the other organism is not the same species (class) as it (eww... cannibalism).
     * Typically this method will be overridden by the subclass so that they will only eat
     * species that are considered prey. For example, objects of the Fox class will make sure
     * that otherOrg.getClass() == Rabbit.class. And objects of the Rabbit class will check
     * to see if otherOrg.getClass() == Grass.class.
     * 
     * @return True if this Animal is able to eat the given Organism, and false otherwise.
     */
    boolean canEat(Organism otherOrg)
    {
        /*# TODO 15
         * Return true if 'this' isAlive, otherOrg isAlive, this.hasSameLocationAs(otherOrg), and 
         * this.getClass() is not equal to otherOrg.getClass(). Otherwise return false.
         */
        
        return false;
    }

    /**
     * Restores ??? hunger points if this Animal is hungry and is able to eat another Organism at
     * its current location. The consumed organism will be killed.
     * 
     * Typically this method will be overridden in the subclasses where it may restore a different
     * amount of hunger based on the species of organism that is consumed.
     */
    void eat()
    {
        /*# TODO 16
         * Return early if this.isHungry() is false.
         */
        
        
        /*# TODO 17
         * Write a for loop to process each "org" in the array world.organisms. 
         * Inside the for loop you will check if this.canEat(org). If so, set org.isAlive to false,
         * subtract some amount from this.hunger, and return early.
         */
        
    }

    /**
     * Displays the species name along with its coordinates and hunger level.
     * 
     * This string of text will display whenever an object inheriting from this class
     * is passed into System.out.println(). For instance, printing a rabbit object will
     * display something like "Rabbit[5, 19](25)" instead of the memory location of the object.
     */
    public String toString() //# TODO 18: Uncomment this code
    {
        /*
        return super.toString() + "(" + this.hunger + ")";
        */
       return null;
    }
}

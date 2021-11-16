/**
 * Organism is an abstract class that all living creatures inherit their base code from.
 * 
 * All organisms have a reference to an Ecosystem that represents the shared world that 
 * they inhabit with one another. Organisms have a position (integer coordinates) within
 * this world and remain alive until they are eaten or die of some other cause.
 */
class Organism
{
    /*# TODO 1
     * Write the keyword "abstract" immediately before the "class" keyword above. 
     * This will ensure that no one is allowed to make an object of this class 
     * directly. We only intend to construct objects of the subclasses like Grass 
     * and Rabbit.
     */    
    
    /*# TODO 2
     * Add the required fields below.
     * 
     * All organisms have four fields:
     * - world: a reference to an Ecosystem (the shared world of all creatures)
     * - x, y : integer coordinates representing their position
     * - isAlive: a boolean status (determining whether the organism is drawn/updated)
     */


    /**
     * Constructor for Organisms.
     * 
     * Since Organism is an abstract class, this can never be called directly to make "Organism objects".
     * However, it is still convenient to have a constructor so that objects of the subclasses can be 
     * created more efficiently. 
     */
    Organism(Ecosystem world, int x, int y)
    {
        /*# TODO 3
         * Set this.world, this.x, and this.y to be equal to the given arguments: world, x, y.
         * Set isAlive to true.
         */
        
        
        
        /*# TODO 4
         * Throw an IllegalArgumentException if the x or y coordinates are less than zero, or if
         * the x or y coordinates are greater than the constants world.WIDTH or world.HEIGHT
         */
        
        
    }
    
    /**
     * Allows the organism to perform the actions it wishes to perform while the simulation is running.
     * 
     * Each distinct species must override this method to allow movement, eating, and any other survival 
     * strategies it knows how to perform during its turn.
     */
    abstract void update(); //# Nothing to do here.
    
    /**
     * Returns the grid-based distance between this organism and the other organism.
     * 
     * In the square grid used by Ecosystem, vertical, horizontal, and diagonal movements
     * are each considered 1 unit of distance. Therefore the "distance" between two organisms
     * will be the minimum number of moves between them rather than the usual Pythagorean distance.
     * 
     * @param otherOrg The other organism that this organism will measure the distance to.
     * @returns The grid-based distance between this organism and the other organism.
     */
    int getDistanceTo(Organism otherOrg) //# TODO 5: uncomment the code below:
    {
        /*
        int horizontalDistance = Math.abs(this.x - otherOrg.x);
        int verticalDistance = Math.abs(this.y - otherOrg.y);
        int diagonalShortcuts = Math.min(horizontalDistance, verticalDistance);
        
        return horizontalDistance + verticalDistance - diagonalShortcuts;
        */
       return 0;
    }
    
    /**
     * Returns true if the distance between this organism and the other organism is zero.
     * 
     * Two organisms have the same location if their coordinates are the same, or equivalently
     * if the distance between them is zero.
     * 
     * @return True if this organism has the same location as the other organism, and false otherwise.
     */
    boolean hasSameLocationAs(Organism otherOrg)
    {
        /*# TODO 6
         * Check to see whether the coordinates of this and otherOrg are the same. Alternatively,
         * check if this.getDistanceTo(otherOrg) is zero.
         * 
         */
        
        return false;
    }
    
    /**
     * Finds the nearest living organism of the given species to this organism or null if none can be found. 
     * 
     * For instance, a rabbit object might call this.getNearest(Grass.class) in its search for food,
     * this.getNearest(Fox.class) to sense if it is in danger, or this.getNearest(Rabbit.class) to search
     * for a mate. 
     * 
     * An object calling this method is guaranteed to NOT receive itself back as a return value!
     * 
     * @param species The class of the target species to search for.
     * @return The nearest living organism object matching the given species or null.
     */
    Organism getNearest(Class species)
    {
        /*# TODO 7
         * This method implements a "minimum search" strategy on an array.
         * 
         * Uncomment the code below and fill in the required checks:
         */
        
        /*
        Organism nearestSoFar = null;
        for (Organism org : world.organisms)
        {
            //# TODO 8
            //# Add an if statement in the space below that checks the following conditions simultaneously:
            //# Check if org is alive. 
            //# Check if 'this' is not equal to org. 
            //# Check if org.getClass() is equal to species 
            //# Check if distanceTo 'this' and org is less than the distanceTo nearestSoFar.
            //# If so, set nearestSoFar equal to org
            
            if(!this.equals(org) &&
            org.isAlive &&
            org.getClass() == species &&
            this.getDistanceTo(org) < this.getDistanceTo(nearestSoFar))
            {
                nearestSoFar = org;
            }
        }
        return nearestSoFar;
        */
        return null;
    }
    
    /**
     * Displays the species name along with its coordinates.
     * 
     * This string of text will display whenever an object inheriting from this class
     * is passed into System.out.println(). For instance, printing a grass object will
     * display something like "Grass[5, 19]" instead of the memory location of the object.
     */
    public String toString() //# TODO 8 Uncomment this code
    {
        /*
        return this.getClass().getName() + "[" + this.x + ", " + this.y + "]";
        */
        return null;
    }
    
}
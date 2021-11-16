class Rabbit
{
    //# TODO 23 Add what is needed to make Rabbit inherit its code from Animal
    /**
     * Constructs rabbit objects with an Ecosystem reference, coordinates, and a hunger level.
     */
    Rabbit(Ecosystem world, int x, int y, int hunger)
    {
        //# TODO 24 Pass the four arguments of this constructor to super()
    }

    boolean canEat(Organism otherOrg)
    {
        /*# TODO 25
         * Copy and paste the code from Animal's canEat method. 
         * Make one change: rabbits only eat organisms of the species 'Grass.class'
         */
        
        return false;
    } 
    
    /**
     * Updates the rabbit on its turn, allowing it to move, get hungrier, and possibly eat.
     * 
     */
    void update()
    {
        //# TODO 26 uncomment this code
        /*
        if (this.isAlive)
        {
            move();
            eat();
            this.hunger += 4;
            
            if (this.hasStarvedToDeath())
            {
                this.isAlive = false;
            }
        }
        */
    }
}

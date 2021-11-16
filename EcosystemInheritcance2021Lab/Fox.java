class Fox
{
    //# TODO 19: Add what is needed to make Fox inherit its code from Animal
    
    /**
     * Constructs fox objects with an Ecosystem reference, coordinates, and a hunger level.
     */
    Fox(Ecosystem world, int x, int y, int hunger)
    {
        //# TODO 20: Pass the four arguments of this constructor to super()
    }
    
    boolean canEat(Organism otherOrg)
    {
        /*# TODO 21
         * Copy and paste the code from Animal's canEat method. 
         * Make one change: foxes only eat organisms of the species 'Rabbit.class'
         */
        
        return false;
    } 
    
    /**
     * Updates the fox on its turn, allowing it to move, get hungrier, and possibly eat.
     * 
     */
    void update()
    {
        //# TODO 22 Uncomment this code
        /*
        if (this.isAlive)
        {
            move();
            eat();
            this.hunger += 4; //# TODO: change this value if you want.
           
            if (this.hasStarvedToDeath())
            {
                this.isAlive = false;
            }
        }
        */
    }
}

import java.util.Random;

class Ecosystem
{
    Organism[] organisms;

    final int WIDTH = 20;
    final int HEIGHT = 20;
    int simulationSteps = 0;

    // Feel free to set your own starting populations:
    int grassPop = 200; 
    int rabbitPop = 40;
    int foxPop = 5;
    
    /**
     * The constructor for Ecosystem, which creates and initializes the array of organisms
     * with different species.
     * 
     * Each organism is created with a random position within the boundaries of the world.
     * All animals are given a random starting hunger value.
     */
    Ecosystem()
    {
        //# TODO 30 Uncomment this code
        /*
        Random r = new Random();

        int totalPop = grassPop + rabbitPop + foxPop;
        organisms = new Organism[totalPop];  // Creates the organisms array 
        for (int i = 0; i < organisms.length; i++) //Fills the array with different species:
        {
            int randomX = r.nextInt(WIDTH);
            int randomY = r.nextInt(HEIGHT);
            int randomHunger = r.nextInt(20);

            if (i < grassPop)
            {
                organisms[i] = new Grass(this, randomX, randomY);
            }
            else if (i < grassPop + rabbitPop)
            {
                organisms[i] = new Rabbit(this, randomX, randomY, randomHunger); 
            }
            else if (i < grassPop + rabbitPop + foxPop) 
            {
                organisms[i] = new Fox(this, randomX, randomY, randomHunger);
            }

        }
        */
    }

    /**
     * Runs a single step of the ecosystem simulation.
     * 
     * This calls the update() method of each organism. Every species is expected to override the
     * update() method 
     */
    void advanceSimulation()
    {
        //# TODO 31 Uncomment this code
        /*
        for (Organism o : organisms)
        {
            if (o.isAlive)
            {
                o.update();
            }
        }
        simulationSteps++;
        */
    }

    /**
     * Runs the ecosystem simulation continuously until all animals die :(
     * 
     * Used for testing purposes. This prints to the console, rather than displaying a graphical
     * user interface. This can print in a detailed mode showing the states of all organisms, or a
     * summary mode showing only the global statistics.
     * 
     * @param details Toggle to true to show the state of all living organisms
     */
    void runSimulation(boolean details)
    {
        while (hasLivingAnimals())
        {
            advanceSimulation();
            
            if (details)
            {
                printDetailed();
            }
            else
            {
                printSummary();
            }
        }
    }

    /**
     * Re-counts the populations of all species in the ecosystem.
     * 
     * The method only counts living organisms and will update the totals of each 
     * species population (rabbitPop, grassPop, etc.).
     */
    void takeCensus()
    {
        /*# TODO 32
         * Set each population to 0 and then count the species in a for loop over the organisms
         * array: "for (Organism org : organisms) ..."
         * 
         * Make sure to count only living organisms. 
         * 
         * You can get the most specific class of an object by using the .getClass() method. 
         * For example, org.getClass() == Fox.class will only evaluate to true if "org" was 
         * originally created with the Fox() constructor.
         */
        
    }

    /**
     * Determines whether there are any living animals in the ecosystem.
     * 
     * @return True if there are any living animals in the ecosystem, and false otherwise.
     */
    boolean hasLivingAnimals()
    {
        /*# TODO 33
         * Call takeCensus() to get the most up-to-date count of the species populations. 
         * Then return true if you see that there are any animals alive.
         */
        
        return true;
    }

    /**
     * Prints a high-level overview of the ecosystem's populations.
     * 
     * Used for testing purposes.
     */
    void printSummary()
    {
        takeCensus();
        int totalPop = rabbitPop + grassPop + foxPop;
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("Step: " + simulationSteps + "\tTotal population: " + totalPop);
        System.out.println("Grass: " + grassPop + "\tRabbits: " + rabbitPop + "\tFoxes: " + foxPop);
    }

    /**
     * Prints a detailed view of the ecosystem, showing the status of each living organism.
     * 
     * Used for testing purposes.
     * 
     * What gets displayed when each species is printed will depend on how that class has
     * overridden the toString() method inherited from Object.
     */
    void printDetailed()
    {
        //# TODO 34 uncomment this code
        /*
        printSummary();
        int numberPrinted = 0;
        for (Organism org : organisms)
        {
            if (org.isAlive)
            {
                if (numberPrinted % 5 == 0)
                {
                    System.out.println(); //linebreak
                }

                System.out.print(org + " ");
                numberPrinted++;
            }
        }
        */
    }
    
}

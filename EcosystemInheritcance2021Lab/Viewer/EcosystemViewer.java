//# TODO 35 Delete this package statement ONLY WHEN every other TODO item is completed.
package Viewer;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
/**
 * Implements a graphical user interface to view the current state of an ecosystem and manage its simulation.
 * 
 * This class inherits a vast amount of code from the JavaFX library "Application" which is not shown here.
 * The only method we need to override is start() which expects a "Stage" object that must be configured
 * with a "Scene" that represents the content of an application window (layout containers, buttons, drawing
 * areas, etc). We also use start() to construct our ecosystem and launch an animation process.
 */
public class EcosystemViewer extends Application
{
    /* NOTE:
     * You do not need to make any changes to this class. It is already configured.
     * 
     * If you would like to make experimental changes, duplicate the class so you can keep one stable
     * working copy.
     */
    final int CREATURE_SIZE = 25;    
    Animation ecosystemAnimation;
    Canvas myCanvas;
    GraphicsContext gc;
    Ecosystem world;
    Button play, pause, slow, medium, fast, restart;
    long animationRate = 400_000_000;

    public void start(Stage stage)
    {
        world = new Ecosystem();

        VBox vbox = new VBox();
        HBox buttons = new HBox();
        play = new Button("Play");
        pause = new Button("Pause");
        slow = new Button("Slow");
        medium = new Button("Medium");
        fast = new Button("Fast");
        restart = new Button("Restart");

        myCanvas = new Canvas((world.WIDTH + 1) * CREATURE_SIZE, 
            (world.HEIGHT + 1) * CREATURE_SIZE);
        gc = myCanvas.getGraphicsContext2D();

        buttons.getChildren().addAll(play, pause, slow, medium, fast, restart);
        vbox.getChildren().addAll(myCanvas, buttons);

        Scene scene = new Scene(vbox, myCanvas.getWidth(), 30 + myCanvas.getHeight());
        stage.setTitle("Ecosystem Viewer");
        stage.setScene(scene);
        stage.show();

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        ecosystemAnimation = new Animation();

        play.setOnAction(this::playAnimation);
        pause.setOnAction(this::pauseAnimation);
        slow.setOnAction(this::goSlow);
        medium.setOnAction(this::goMedium);
        fast.setOnAction(this::goFast);
        restart.setOnAction(this::restart);

        ecosystemAnimation.start();

    }

    private void playAnimation(ActionEvent e)
    {
        ecosystemAnimation.start();
    }

    private void pauseAnimation(ActionEvent e)
    {
        ecosystemAnimation.stop();
    }

    private void goSlow(ActionEvent e)
    {
        animationRate = 800_000_000;
    }

    private void goMedium(ActionEvent e)
    {
        animationRate = 400_000_000;
    }

    private void goFast(ActionEvent e)
    {
        animationRate = 50_000_000;
    }

    private void restart(ActionEvent e)
    {
        world = new Ecosystem();
    }

    /**
     * Draws one frame of the ecosystem using the current state of the world.
     * 
     * The dimensions of the grid and all coordinates must be scaled by the preferred size of a tile
     * in pixels, which is specified by the global variable CREATURE_SIZE. Only living organisms are 
     * rendered. Grass is represented by a green square. Rabbits are represented by white circles and
     * Foxes are represented by red circles. All animals have their current hunger status displayed on
     * their icon.
     */
    private void renderWorld()
    {
        eraseCanvas();
        
        //Draws each organism at the correct position in the window
        for (Organism o : world.organisms)
        {
            if (o.isAlive)
            {
                if (o.getClass() == Grass.class)
                {
                    Grass g = (Grass) o; //cast the organism to Grass.
                    renderGrass(g);
                }
                else if (o.getClass() == Rabbit.class)
                {
                    Rabbit r = (Rabbit) o;
                    renderAnimal(r, Color.WHITE, Color.BLACK);
                }
                else if (o.getClass() == Fox.class)
                {
                    Fox f = (Fox) o;
                    renderAnimal(f, Color.RED, Color.WHITE);
                }
            }
        }

    }
    
    /**
     * Draws a colored circle icon displaying the hunger level at the coordinates of the animal.
     * 
     * @param a The animal to render
     * @param fillColor The background color of the circle
     * @param textColor The color of the text displaying the hunger
     */
    private void renderAnimal(Animal a, Color fillColor, Color textColor) {
        gc.setFill(fillColor);
        int x = a.x * CREATURE_SIZE;
        int y = a.y * CREATURE_SIZE;
        
        //Draw icon
        gc.fillOval(x, y, CREATURE_SIZE, CREATURE_SIZE);
        gc.strokeOval(x, y, CREATURE_SIZE, CREATURE_SIZE);
        
        // Draw hunger text
        gc.setFill(textColor);
        gc.fillText(Integer.toString(a.hunger), 
        x + CREATURE_SIZE * 0.16, y + CREATURE_SIZE * 0.76);
    }
    
    /**
     * Draws a green square icon at the coordinates of the grass object.
     * 
     * @param g The grass object to render
     */
    private void renderGrass(Grass g) {
        gc.setFill(Color.GREEN);
        int x = g.x * CREATURE_SIZE;
        int y = g.y * CREATURE_SIZE;
        gc.fillRect(x, y, CREATURE_SIZE, CREATURE_SIZE);
    }
    
    /**
     * Draws a white rectangle over the entire viewing area to 'erase' previous drawings
     */
    private void eraseCanvas() {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, (1 + world.WIDTH) * CREATURE_SIZE , (1 + world.HEIGHT) * CREATURE_SIZE);
        gc.strokeRect(0, 0, (1+ world.WIDTH) * CREATURE_SIZE , (1 + world.HEIGHT) * CREATURE_SIZE);
    }

    /**
     * The inner class Animation manages the timing of the simulation speed and rendering.
     * 
     * It inherits code from the AnimationTimer JavaFX class. The only method
     * that we need to override is handle(), which expects to be given a time in nanoseconds.
     * Since handle() is called at ~60 frames per second, we can throttle the animation by 
     * skipping calls to renderWorld() if the elapsed time is shorter than our chosen animationRate.
     */
    class Animation extends AnimationTimer
    {
        private long lastUpdate = 0;
        public void handle(long now)
        {
            if (now - lastUpdate > animationRate) 
            {
                renderWorld();
                world.advanceSimulation();
                lastUpdate = now;
            }
        }
    }
}
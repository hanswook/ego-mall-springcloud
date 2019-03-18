# ego-mall-springcloud
ego商城项目，springboot+springcloud实现


package homework;// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP103 assignment.
// You may not distribute it in any other way without permission.

/* Code for XMUT103 - 2019T1, Assignment 1
 * Name:
 * Username:
 * ID:
 */

import java.io.File;
import java.util.*;

import ecs100.*;
import javafx.concurrent.Task;

/**
 * This class contains the main method of the program.
 * <p>
 * A SlideShow object represents the slideshow application and sets up the buttons in the UI.
 *
 * @author pondy
 */
public class SlideShow {

    public static final int LARGE_SIZE = 450;   // size of images during slide show
    public static final int SMALL_SIZE = 100;   // size of images when editing list
    public static final int GAP = 10;           // gap between images when editing
    public static final int COLUMNS = 6;        // Number of columns of thumbnails


    private List<String> images = new ArrayList<>(); //  List of image file names.

    private int currentImage = -1;     // index of currently selected image.
    // Should always be a valid index if there are any images

    private boolean showRunning;      // flag signalling whether the slideshow is running or not


    /**
     * Constructor
     */
    public SlideShow() {
        /*# YOUR CODE HERE */
        setupGUI();
    }

    /**
     * Initialises the UI window, and sets up the buttons.
     */
    public void setupGUI() {
        UI.initialise();

        UI.addButton("Run show", this::runShow);
        UI.addButton("Edit show", this::editShow);
        UI.addButton("add before", this::addBefore);
        UI.addButton("add after", this::addAfter);
        UI.addButton("move left", this::moveLeft);
        UI.addButton("move right", this::moveRight);
        UI.addButton("move to start", this::moveStart);
        UI.addButton("move to end", this::moveEnd);
        UI.addButton("remove", this::remove);
        UI.addButton("remove all", this::removeAll);
        UI.addButton("reverse", this::reverse);
        UI.addButton("shuffle", this::shuffle);
        UI.addButton("Testing", this::setTestList);
        UI.addButton("Quit", UI::quit);


        UI.setKeyListener(this::doKey);
        UI.setMouseListener(this::doMouse);
        UI.setDivider(0);
        UI.printMessage("Mouse must be over graphics pane to use the keys");

    }

    private void doMouse(String s, double v, double v1) {

    }

    private void shuffle() {

    }

    private void reverse() {

    }

    private void removeAll() {

    }

    private void remove() {

    }

    private void moveEnd() {

    }

    private void moveStart() {

    }

    private void moveRight() {
    }

    private void moveLeft() {
    }

    private void addAfter() {

    }

    private void addBefore() {

    }


    private String filePre = "F:\\homework\\SlideShow";

    private String getFilePath(String file) {
        return filePre + File.separator + file;
    }

    // RUNNING

    /**
     * As long as the show isn't already running, and there are some
     * images to show, start the show running from the currently selected image.
     * The show should keep running indefinitely, as long as the
     * showRunning field is still true.
     * Cycles through the images, going back to the start when it gets to the end.
     * The currentImage field should always contain the index of the current image.
     */
    private int showIndex = 0;

    public void runShow() {
        /*# YOUR CODE HERE */
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                showImage(showIndex);
                showIndex += 1;
                checkIndex();
            }
        }, 1000, 1000);


    }

    private void checkIndex() {
        if (showIndex >= images.size()) {
            showIndex = 0;
        }
    }

    private void showImage(int index) {
        UI.clearGraphics();
        UI.drawImage(getFilePath(images.get(index)), 100, 100, 400, 400);
    }

    /**
     * Stop the show by changing showRunning to false.
     * Redisplay the list of images, so they can be edited
     */
    public void editShow() {
        /*# YOUR CODE HERE */
        UIFileChooser.open();
    }


    /**
     * Display just the current slide if the show is running.
     * If the show is not running, display the list of images
     * (as thumbnails) highlighting the current image
     */
    private int currentIndex = 0;

    public void display() {
        /*# YOUR CODE HERE */
        UI.clearGraphics();
        for (int i = 0; i < images.size(); i++) {
            UI.drawImage(
                    getFilePath(images.get(i)),
                    i * 50, 0, 50, 50
            );
        }

        UI.drawRect(currentIndex * 50, 0, 50, 50);
    }


    // Other Methods (you will need quite a lot of additional methods).

    /*# YOUR CODE HERE */


    // More methods for the user interface: keys (and mouse, for challenge)

    /**
     * Interprets key presses.
     * works in both editing the list and in the slide show.
     */
    public void doKey(String key) {
        if (key.equals("Left") || key.equals("向左箭头")) goLeft();
        else if (key.equals("Right") || key.equals("向右箭头")) goRight();
        else if (key.equals("Home") || key.equals("向上箭头")) goStart();
        else if (key.equals("End") || key.equals("向下箭头")) goEnd();
    }

    private void goEnd() {

    }

    private void goStart() {

    }

    private void goRight() {
        currentIndex++;
        if (currentIndex >= images.size()) {
            currentIndex = images.size() - 1;
        }
        display();
    }

    private void goLeft() {
        currentIndex--;
        if (currentIndex < 0)
            currentIndex = 0;
        display();
    }


    /**
     * A method that adds a bunch of names to the list of images, for testing.
     */
    public void setTestList() {
        if (showRunning) return;
        String[] names = new String[]{"Atmosphere.jpg", "BachalpseeFlowers.jpg",
                "BoraBora.jpg", "Branch.jpg", "DesertHills.jpg",
                "DropsOfDew.jpg", "Earth_Apollo17.jpg",
                "Frame.jpg", "Galunggung.jpg", "HopetounFalls.jpg",
                "Palma.jpg", "Sky.jpg", "SoapBubble.jpg",
                "Sunrise.jpg", "Winter.jpg"};

        for (String name : names) {
            images.add(name);
        }
        currentImage = 0;
        display();
    }


    public static void main(String[] args) {
        new SlideShow();
    }

}

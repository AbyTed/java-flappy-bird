package mainApp;


import bossLevelManager.Boss;
import essentialGameObjects.Columns;
import essentialGameObjects.KeyHandler;
import essentialGameObjects.playerScript.PlayerMovement;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel implements Runnable {

    // Settings & Scale
    final int FPS = 60;
    public int screenY = 800;
    public int screenX = 500;




    // adding class to game screen
    KeyHandler keyH = new KeyHandler();
    PlayerMovement player = new PlayerMovement(keyH, this);
    Columns col = new Columns(this, player);
    Boss bossMan = new Boss(this);
    Thread thread = new Thread(this);

    GameScreen() {
        thread.start();
        this.setSize(screenX, screenY);//size of frame
        this.setVisible(true); // visibly
        this.setFocusable(true);// allows the game screen to receive keyboard inputs
        this.addKeyListener(keyH);




        }

    @Override
    public void run() {

        double nano;
        int count = 0;
        double nanoNeeded = 1_000_000_000/FPS;
        double delta = 0;
        double lastTime = System.nanoTime();

        // GameLoop running at 60 frames
        while(true){
            nano = System.nanoTime();
            delta += (nano - lastTime) / nanoNeeded;
            lastTime = nano;


            if (delta >= 1.0 ){

                update();


                repaint();

                count++;
                delta--;
            }
            if(count == 60){
                System.out.println("FPS = " + count);
                count = 0;
            }
        }
    }
    public void update(){
        player.update();
        col.update();

    }
    public void paintComponent (Graphics g) {

        super.paintComponent(g);
        // creating a Graphics2D
        Graphics2D g2 = (Graphics2D)g;
        col.draw(g2);
        player.draw(g2);


    }
}

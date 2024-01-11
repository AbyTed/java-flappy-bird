package essentialGameObjects.playerScript;

import essentialGameObjects.KeyHandler;
import mainApp.GameScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class PlayerMovement extends JPanel {
    // keyHandler
    KeyHandler keyH;
    public GameScreen gp;
    // World speeds and locations
    public int speed;
    public int playerX,playerY;
    // game mechanic numbers
    public int gravity;
    boolean coolDown;
    double coolDownNumber;
    // player
    public Rectangle r;
    // player image
    BufferedImage image,image2;


    public PlayerMovement(KeyHandler keyH,GameScreen gp){
        this.gp = gp;
        this.keyH = keyH;
        addKeyListener(this.keyH);
        startValue();
    }
    public void startValue(){

        speed = 10;
        playerX = 100;
        playerY = 200;
        gravity = 4;
        coolDownNumber = 0.0;
        coolDown = false;
        r = new Rectangle(playerX, playerY, 50, 50);


    }
    private void playerAnimations(){
        try{
            // adding image
            image = ImageIO.read(new File("C:\\Users\\mylig\\IdeaProjects\\OneShot\\src\\main\\java\\essentialGameObjects\\playerScript\\RocketBoy.png"));
            image2 = ImageIO.read(new File("C:\\Users\\mylig\\IdeaProjects\\OneShot\\src\\main\\java\\essentialGameObjects\\playerScript\\RocketBoy2.png"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void update(){
        // if keys pressed and player is below the top of the screen

        if(keyH.upPressed && playerY > 0){
            playerY -= speed;
            r.y = playerY;
            r.x = playerX;
            coolDown = true;


        }// if player is above the bottom of the screen then gravity works
        // 1/3 of 1 second is the cool down
        else if(playerY + 90 < gp.screenY){
            playerY += gravity;
            r.y = playerY;
            coolDownNumber += 1;

        }


    }




    public void draw(Graphics2D g2){

        playerAnimations();

        // drawing the player
        g2.setColor(Color.blue);

        if(keyH.upPressed){
            g2.drawImage(image,r.x,r.y,null);
        }else{
            g2.drawImage(image2,r.x,r.y,null);
        }


    }
}

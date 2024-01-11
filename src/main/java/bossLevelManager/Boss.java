package bossLevelManager;

import essentialGameObjects.KeyHandler;
import essentialGameObjects.playerScript.PlayerMovement;
import mainApp.GameScreen;

import java.awt.*;

public class Boss {
    Rectangle bossHitBox;
    GameScreen gp;
    KeyHandler keyH = new KeyHandler();
    PlayerMovement player = new PlayerMovement(keyH,gp);
    public Boss(GameScreen gp){
        this.gp = gp;
    }

    public void update(){

    }




    public void draw(Graphics2D g2){

    }
}

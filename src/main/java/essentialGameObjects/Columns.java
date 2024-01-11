package essentialGameObjects;

import essentialGameObjects.playerScript.PlayerMovement;
import mainApp.GameScreen;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Columns {
    int startX, startY;
    Rectangle topCol, bottomCol;
    GameScreen gp;
    PlayerMovement player;
    JLabel score = new JLabel("Score: 0");;
    JLabel deathNum = new JLabel("Deaths: 0");;
    int deathsNum = 0;
    int columnNum;
    boolean i;

    public Columns(GameScreen gp, PlayerMovement player){
        this.player = player;
        this.gp = gp;
        startValue();
    }
    private void startValue(){
        startX = gp.screenX;
        startY = 0;
        topCol = new Rectangle(startX, startY, 50,100);
        bottomCol = new Rectangle(startX, gp.screenY, 50,100);
        Random rand = new Random();
        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(gp.screenY/2);
        // top column height matching with bottom column y example: topCol.h = 200 and bottomCol.y = topCol.height + player.height
        topCol.height = rand_int1;
        bottomCol.y = rand_int1+160;

        bottomCol.height = gp.screenY - topCol.height;
        startX = gp.screenX;

        columnNum = 0;



        gp.add(score);

        gp.add(deathNum);




    }
    private void labelUpdate(int columnNum){
        columnNum += 1;
        String text = Integer.toString(columnNum);
        score.setText(null);
        score.setText("Score: " + text);
    }
    private void playAgain(){
        deathsNum += 1;
        player.startValue();
        String text = Integer.toString(deathsNum);
        deathNum.setText(null);
        deathNum.setText("Deaths: " + text);
        startValue();
        score.setText("Score: 0");





    }
    public void update(){
        startX -= 5;
        topCol.y = startY;
        topCol.x = startX;
        bottomCol.x = startX;
        if(startX < 0) {
            Random rand = new Random();

            // Generate random integers in range 0 to 999
            int rand_int1 = rand.nextInt(gp.screenY/2);

            // top column height matching with bottom column y example: topCol.h = 200 and bottomCol.y = topCol.height + player.height
            topCol.height = rand_int1;
            bottomCol.y = rand_int1+160;

            // calling method to update label

            labelUpdate(columnNum);
            columnNum += 1;// needs to run after we know that player didn't colloid


            bottomCol.height = gp.screenY - topCol.height;
            startX = gp.screenX;
        }


    }







    public void draw(Graphics2D g2){

        if(player.r.intersects(topCol) || player.r.intersects(bottomCol)){
            playAgain();


        }



        // Green Pipes
        g2.setColor(Color.GREEN);

        g2.fillRect(startX, startY, topCol.width, topCol.height);
        g2.fillRect(startX, bottomCol.y, topCol.width, bottomCol.height);
        g2.draw(bottomCol);
        g2.draw(topCol);





    }
}

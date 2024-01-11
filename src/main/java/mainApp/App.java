package mainApp;




import javax.swing.*;

public class App {
    public static void main( String[] args )
    {
        JFrame frame = new JFrame();

        GameScreen gameScreen = new GameScreen();


        frame.add(gameScreen);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(gameScreen.screenX,gameScreen.screenY);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocation(620, 0);

    }
}


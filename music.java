package RobotMiniGame;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class music implements Runnable{

    String filePath; 
    
    public music(String filePath) {
        this.filePath = filePath;
    }
        
    public void play(String filePath){
        
        File file = new File(filePath);

        try {
            FileInputStream fs = new FileInputStream(file);
            BufferedInputStream bi = new BufferedInputStream(fs);

            try {
                Player player = new Player(bi);
                player.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    


    @Override
    public void run() {
        play(filePath);
    }
    
    
}
    



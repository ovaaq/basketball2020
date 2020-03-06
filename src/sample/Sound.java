package sample;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import java.io.File;
import javafx.scene.media.AudioClip;

public class Sound {


        static File horn1 = new File("./src/sample/Buzzer.mp3");
        static File horn2 = new File("./src/sample/AirHorn.mp3");

        public static void playHorn1(int seconds){
                try {
                    AudioClip clip = new AudioClip(horn1.toURI().toString());

                        clip.play();

                } catch (MediaException e) {
                    System.out.println("File not found");

            }
        }

        public static void playHorn2(int seconds){
                try {
                    AudioClip clip = new AudioClip(horn2.toURI().toString());

                        clip.setCycleCount(seconds);
                        clip.play();



                } catch (MediaException e) {
                    System.out.println("File not found");
                }
            }


}

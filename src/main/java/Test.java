import com.habosa.javasnap.Snapchat;
import kotlin.Pair;
import me.jp78.AutoSnap.AutoSnap;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * This file was created by @author thejp for the use of
 * Jpsy. Please note, all rights to code are retained by
 * afore mentioned thejp unless otherwise stated.
 * File created: Tuesday, March, 2017
 */
public class Test
{

    private static String YOUR_SNAPCHAT_USERNAME;
    private static String YOUR_SNAPCHAT_PASSWORD;
    public static void main(String... args)
    {
        //Creates an Auto SNAP with the params: Snapchat instance, the image file, snap duration, how often to send the snap, the date to start or null for instant
        AutoSnap snapper = new AutoSnap(Snapchat.login(YOUR_SNAPCHAT_USERNAME,YOUR_SNAPCHAT_PASSWORD),new File("My_Dank_Image.png"),3,new Pair<>(5L, TimeUnit.HOURS),null);
        snapper.addRecipient("cool_username1");
        snapper.addRecipient("cool_username2");
        //So on and so forth
        snapper.start();
    }
}

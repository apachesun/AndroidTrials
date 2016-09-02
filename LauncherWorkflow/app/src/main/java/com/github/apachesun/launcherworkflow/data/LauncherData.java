package com.github.apachesun.launcherworkflow.data;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nathan on 8/30/2016.
 */
public class LauncherData {
    private final static String laucherFileName = "launcher.data";
    private final static String DATA_SPLASH = "splash";

    public static boolean isSplashDisplayed(Activity activity) {
        try {
            File lFile = new File(activity.getApplicationContext().getFilesDir(), laucherFileName);
            if (lFile.exists() == false) {
                Log.i(AppData.LOGTAGS.LAUNCHER, "launcher file does not exist");
                return false;
            } else {
                Set<String> dataSet = loadLauncherData(lFile);
                if (dataSet.contains(DATA_SPLASH))
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private static Set<String> loadLauncherData(File file) {
        Set<String> set = new HashSet<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null) {
                set.add(line.trim());
            }
            reader.close();
            Log.i(AppData.LOGTAGS.LAUNCHER, "loaded launcher data");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return set;
    }
    public static void logSplashCompleted(Context context) {
        try {
            File lFile = new File(context.getFilesDir(), laucherFileName);
            PrintStream ps = new PrintStream(new FileOutputStream(lFile, true));
            ps.println(DATA_SPLASH);
            ps.flush();
            ps.close();
            Log.i(AppData.LOGTAGS.LAUNCHER, "wrote splash to launcher data");
        } catch(Exception e) {
            e.printStackTrace();;
        }
    }
}

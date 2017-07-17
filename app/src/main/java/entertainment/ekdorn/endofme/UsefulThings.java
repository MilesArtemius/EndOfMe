package entertainment.ekdorn.endofme;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by User on 17.07.2017.
 */

public class UsefulThings {
    public static void configureWindow(AppCompatActivity app) {
        int mUIFlag = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

        app.getWindow().getDecorView().setSystemUiVisibility(mUIFlag);
        app.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //LayoutInflater inflater = LayoutInflater.from(this);
        //View view = inflater.inflate(R.layout.activity_main, null);
        //view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE);
        //setContentView(view);

    }
}

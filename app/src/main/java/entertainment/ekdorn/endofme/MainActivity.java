package entertainment.ekdorn.endofme;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UsefulThings.configureWindow(this);

        setContentView(R.layout.activity_load);
        runMain();
    }

    private void runMain() {
        Handler splashNew = new Handler();
        splashNew.postDelayed(() -> {
            startActivity(new Intent(getApplication(), TerminalActivity.class));
            finish();
        }, 3000);
    }
}
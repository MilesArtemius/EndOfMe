package entertainment.ekdorn.endofme;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout rootLayout = new RelativeLayout(this);

        rootLayout.setBackgroundColor(Color.YELLOW);

        ImageView iv = new ImageView(this);
        iv.setImageBitmap(UsefulThings.getBitmapFromDrawable(this, R.mipmap.ic_launcher_round));
        rootLayout.addView(iv);

        TextView console = new TextView(this);
        console.setBackgroundColor(Color.DKGRAY);
        console.setTextColor(Color.WHITE);
        console.setTextIsSelectable(false);
        console.setTypeface(null, Typeface.BOLD);
        console.setText("Sample Text");
        console.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        rootLayout.addView(console);

        UsefulThings.configureWindow(this, rootLayout);

        setContentView(rootLayout);
    }
}
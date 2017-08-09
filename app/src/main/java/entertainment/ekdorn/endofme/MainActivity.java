package entertainment.ekdorn.endofme;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import entertainment.ekdorn.endofme.Helpfuls.UsefulThings;

public class MainActivity extends AppCompatActivity {
    StoryReader reader;

    TextView console;
    RelativeLayout rootLayout;
    FrameLayout fragmentLayout;

    private void configureTextView() {
        RelativeLayout warp = new RelativeLayout(this);
        console = new TextView(this);
        console.setBackgroundColor(Color.DKGRAY);
        console.setTextColor(Color.WHITE);
        console.setTextIsSelectable(false);
        console.setTypeface(null, Typeface.BOLD);
        console.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        console.setId(R.id.console);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        warp.setLayoutParams(params);
        warp.addView(console);
        rootLayout.addView(warp);
    }

    private void configureSubTextView() {
        fragmentLayout = new FrameLayout(this);
        fragmentLayout.setBackgroundColor(Color.DKGRAY);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, console.getId());
        params.addRule(RelativeLayout.ALIGN_PARENT_START);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        fragmentLayout.setLayoutParams(params);
        fragmentLayout.setId(R.id.fragment);
        rootLayout.addView(fragmentLayout);
    }

    private void configureDialog() {
        RetainDialog mainDialog = new RetainDialog(this);
        mainDialog.getNewGameButton().setOnClickListener(v -> {
            reader = new StoryReader(rootLayout, MainActivity.this, getSupportFragmentManager());
            mainDialog.hide();
            reader.letTheStoryBegin();
        });


        mainDialog.getQuickModeCheckBox().setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                mainDialog.getQuickModeCheckBox().setText("Quick mode enabled");
            } else {
                mainDialog.getQuickModeCheckBox().setText("Quick mode disabled");
            }
        });
        mainDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rootLayout = new RelativeLayout(this);
        rootLayout.setBackgroundColor(Color.YELLOW);

        /*ImageView iv = new ImageView(this);
        iv.setImageBitmap(UsefulThings.getBitmapFromDrawable(this, R.mipmap.ic_launcher_round));
        rootLayout.addView(iv);*/

        configureTextView();
        configureSubTextView();

        UsefulThings.configureWindow(this, rootLayout);
        setContentView(rootLayout);

        configureDialog();
    }
}
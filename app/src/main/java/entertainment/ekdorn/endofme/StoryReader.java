package entertainment.ekdorn.endofme;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;

import entertainment.ekdorn.endofme.Helpfuls.OnDoubleClickListener;
import entertainment.ekdorn.endofme.Helpfuls.Story;
import entertainment.ekdorn.endofme.InputTypes.BasicInputType;
import entertainment.ekdorn.endofme.InputTypes.ButtonsInputType;
import entertainment.ekdorn.endofme.InputTypes.CheckInputType;
import entertainment.ekdorn.endofme.InputTypes.InputInputType;
import entertainment.ekdorn.endofme.TypeClasses.StoryNode;

/**
 * Created by User on 22.07.2017.
 */

public class StoryReader {
    RelativeLayout parent;
    Context context;
    FragmentManager manager;

    TextView console;

    public StoryReader(RelativeLayout root, Context context, FragmentManager manager) {
        this.parent = root;
        this.context = context;
        this.manager = manager;

        this.console = (TextView) root.findViewById(R.id.console);
    }

    public void letTheStoryBegin() {
        console.setText("");
        for (StoryNode node: Story.getInstance(context).getNodes()) {
            if (false) {
                writeNowToConsole("test", node);
            } else {
                writeLaterToConsole("test", node);
            }
        }
    }
    public void continueStory(double thisTreeSpotValue) {
        StoryNode node = Story.getInstance(context).getNodes().get(5);
        if (false) {
            writeNowToConsole("test", node);
        } else {
            writeLaterToConsole("test", node);
        }
    }

    public void writeNowToConsole(String add, StoryNode src) {

        console.append(add + "> ");

        Spannable word = new SpannableString(src.getStory());
        if ((src.isComputerSpeech().equals("loading")) || (src.isComputerSpeech().equals("computer"))) {
            word.setSpan(new ForegroundColorSpan(Color.BLUE), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            word.setSpan(new ForegroundColorSpan(Color.RED), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        showView(src.getView(), src.getViewModifiers());

        console.append(word + "\n");
    }

    public void writeLaterToConsole(String add, StoryNode src) {

        AsyncTask writer = new AsyncTask() {
            @Override
            protected void onPreExecute() {
                console.append(add + "> ");
            }

            @Override
            protected void onProgressUpdate(Object[] values) {
                console.append((String) values[0]);
            }

            @Override
            protected Object doInBackground(Object[] params) {
                Spannable word = new SpannableString(src.getStory());
                if ((src.isComputerSpeech().equals("loading")) || (src.isComputerSpeech().equals("computer"))) {
                    word.setSpan(new ForegroundColorSpan(Color.BLUE), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                } else {
                    word.setSpan(new ForegroundColorSpan(Color.RED), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                for (int i = 0; i < word.toString().toCharArray().length; i++) {
                    publishProgress(new StringBuilder().append(word.toString().toCharArray()[i]).toString());
                    if (word.toString().toCharArray()[i] != ' ') {
                        SystemClock.sleep(100);
                    }
                }
                if (src.isComputerSpeech().equals("loading")) {
                    for (int i = 0; i < 3; i++) {
                        SystemClock.sleep(500);
                        publishProgress(".");
                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                showView(src.getView(), src.getViewModifiers());

                console.append("\n");
            }
        };

        writer.execute();
    }

    public void showView(String view, HashMap<String, Double> modifiers) {
        switch (view) {
            case "buttons":
                Log.e("TAG", "showView: buttons");
                ButtonsInputType buttons = ButtonsInputType.newInstance(modifiers);
                manager.beginTransaction().replace(R.id.fragment, buttons).commitNow();
                break;
            case "input":
                Log.e("TAG", "showView: input");
                InputInputType input = new InputInputType();
                break;
            case "check":
                Log.e("TAG", "showView: check");
                CheckInputType check = new CheckInputType();
                break;
            default:
                BasicInputType basic = new BasicInputType();
                Log.e("TAG", "showView: def children count");
                manager.beginTransaction().replace(R.id.fragment, basic).commitNow();
                parent.findViewById(R.id.fragment).setOnClickListener(new OnDoubleClickListener() {
                    @Override
                    public void onDoubleClick(View v) {

                    }
                });
                break;
        }
        Log.e("TAG", "showView: OLALA");
    }
}
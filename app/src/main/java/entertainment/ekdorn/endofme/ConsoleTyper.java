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
import android.widget.FrameLayout;
import android.widget.TextView;

import entertainment.ekdorn.endofme.InputTypes.ButtonsInputType;
import entertainment.ekdorn.endofme.InputTypes.CheckInputType;
import entertainment.ekdorn.endofme.InputTypes.InputInputType;
import entertainment.ekdorn.endofme.InputTypes.BasicInputType;
import entertainment.ekdorn.endofme.TypeClasses.StoryNode;

/**
 * Created by User on 22.07.2017.
 */

public class ConsoleTyper {
    private TextView target;
    private StoryNode source;
    private FrameLayout frame;
    private FragmentManager frmg;

    public ConsoleTyper(TextView console, FragmentManager manager, FrameLayout nest) {
        this.target = console;
        this.frame = nest;
        this.frmg = manager;
    }

    public void writeNowToConsole(String add, StoryNode src) {
        this.source = src;

        target.append(add + "> ");

        Spannable word = new SpannableString(src.getStory());
        if ((src.isComputerSpeech().equals("loading")) || (src.isComputerSpeech().equals("computer"))) {
            word.setSpan(new ForegroundColorSpan(Color.BLUE), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            word.setSpan(new ForegroundColorSpan(Color.RED), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        showView(src.getView());

        target.append(word + "\n");
    }

    public void writeLaterToConsole(String add, StoryNode src) {
        this.source = src;

        AsyncTask writer = new AsyncTask() {
            @Override
            protected void onPreExecute() {
                target.append(add + "> ");
            }

            @Override
            protected void onProgressUpdate(Object[] values) {
                target.append((String) values[0]);
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
                showView(src.getView());

                target.append("\n");
            }
        };

        writer.execute();
    }

    public void showView(String view) {
        switch (view) {
            case "buttons":
                Log.e("TAG", "showView: buttons");
                ButtonsInputType buttons = new ButtonsInputType();
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
                Log.e("TAG", "showView: def");
                frmg.beginTransaction().replace(R.id.fragment, basic).commit();
                //frame.addView(basic.getView());
                break;
        }
        Log.e("TAG", "showView: OLALA");
    }
}
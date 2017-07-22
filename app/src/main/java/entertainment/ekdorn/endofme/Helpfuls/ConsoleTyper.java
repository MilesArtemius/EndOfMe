package entertainment.ekdorn.endofme.Helpfuls;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by User on 22.07.2017.
 */

public class ConsoleTyper {
    private TextView target;

    public ConsoleTyper(TextView console) {
        this.target = console;
    }

    public void writeNowToConsole(String add, String isByComputer, String text) {
        target.append(add + "> ");

        Spannable word = new SpannableString(text);
        if ((isByComputer.equals("loading")) || (isByComputer.equals("computer"))) {
            word.setSpan(new ForegroundColorSpan(Color.BLUE), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            word.setSpan(new ForegroundColorSpan(Color.RED), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        target.append(word + "\n");
    }

    public void writeLaterToConsole(String add, String isByComputer, String text) {
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
                Spannable word = new SpannableString(text);
                if ((isByComputer.equals("loading")) || (isByComputer.equals("computer"))) {
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
                if (isByComputer.equals("loading")) {
                    for (int i = 0; i < 3; i++) {
                        SystemClock.sleep(500);
                        publishProgress(".");
                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                target.append("\n");
            }
        };
        writer.execute();
    }
}
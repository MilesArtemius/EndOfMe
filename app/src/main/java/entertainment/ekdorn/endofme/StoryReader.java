package entertainment.ekdorn.endofme;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import entertainment.ekdorn.endofme.Helpfuls.Story;
import entertainment.ekdorn.endofme.TypeClasses.StoryNode;

/**
 * Created by User on 22.07.2017.
 */

public class StoryReader {
    RelativeLayout parent;
    ArrayList<StoryNode> story;

    TextView console;

    public StoryReader(RelativeLayout root, Context context) {
        this.parent = root;
        this.story = Story.getInstance(context).getNodes();

        this.console = (TextView) root.findViewById(R.id.console);
    }

    public void letTheStoryBegin() {
        console.setText("");
        for (StoryNode node: story) {
            writeToConsole("test", node.isComputerSpeech(), node.getStory());
        }
    }



    private void writeToConsole(String add, boolean isByComputer, String text) {
        console.append(add + "> ");

        Spannable word = new SpannableString(text);
        if (isByComputer) {
            word.setSpan(new ForegroundColorSpan(Color.BLUE), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            word.setSpan(new ForegroundColorSpan(Color.RED), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        console.append(word + "\n");
    }
}

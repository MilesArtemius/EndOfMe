package entertainment.ekdorn.endofme;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import entertainment.ekdorn.endofme.Helpfuls.ConsoleTyper;
import entertainment.ekdorn.endofme.Helpfuls.Story;
import entertainment.ekdorn.endofme.TypeClasses.StoryNode;

/**
 * Created by User on 22.07.2017.
 */

public class StoryReader {
    RelativeLayout parent;
    ArrayList<StoryNode> story;
    ConsoleTyper typer;

    TextView console;

    public StoryReader(RelativeLayout root, Context context) {
        this.parent = root;
        this.story = Story.getInstance(context).getNodes();

        this.console = (TextView) root.findViewById(R.id.console);
        this.typer = new ConsoleTyper(console);
    }

    public void letTheStoryBegin() {
        console.setText("");
        for (StoryNode node: story) {
            if (false) {
                typer.writeNowToConsole("test", node.isComputerSpeech(), node.getStory());
            } else {
                typer.writeLaterToConsole("test", node.isComputerSpeech(), node.getStory());
            }
        }
    }
}

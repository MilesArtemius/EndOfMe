package entertainment.ekdorn.endofme;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import entertainment.ekdorn.endofme.Helpfuls.Story;
import entertainment.ekdorn.endofme.TypeClasses.StoryNode;

/**
 * Created by User on 22.07.2017.
 */

public class StoryReader {
    RelativeLayout parent;
    ConsoleTyper typer;
    Context context;

    TextView console;

    public StoryReader(RelativeLayout root, Context context, FragmentManager manager) {
        this.parent = root;
        this.context = context;

        this.console = (TextView) root.findViewById(R.id.console);
        this.typer = new ConsoleTyper(console, manager, (FrameLayout) parent.findViewById(R.id.fragment));
    }

    public void letTheStoryBegin() {
        console.setText("");
        for (StoryNode node: Story.getInstance(context).getNodes()) {
            if (false) {
                typer.writeNowToConsole("test", node);
            } else {
                typer.writeLaterToConsole("test", node);
            }
        }
    }
    public void continueStory(double thisTreeSpotValue) {
        StoryNode node = Story.getInstance(context).getNodes().get(5);
        if (false) {
            typer.writeNowToConsole("test", node);
        } else {
            typer.writeLaterToConsole("test", node);
        }
    }
}

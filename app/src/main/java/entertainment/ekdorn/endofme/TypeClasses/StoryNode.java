package entertainment.ekdorn.endofme.TypeClasses;

import android.view.View;

import entertainment.ekdorn.endofme.InputTypes.SampleInputType;

/**
 * Created by User on 17.07.2017.
 */

public class  StoryNode {
    boolean computerSpeech;
    String story;
    double thisTreeValue;
    SampleInputType view;

    String indicator = "none";


    public boolean isComputerSpeech() {
        return computerSpeech;
    }

    public String getStory() {
        return story;
    }

    public double getThisTreeValue() {
        return thisTreeValue;
    }

    public SampleInputType getView() {
        return view;
    }

    public String getIndicator() {
        return indicator;
    }

    public StoryNode(boolean computerSpeech, String story, double thisTreeValue, String view, String indicator) {
        this.computerSpeech = computerSpeech;
        this.story = story;
        this.thisTreeValue = thisTreeValue;

        this.view = new SampleInputType();

        this.indicator = indicator;
    }
}

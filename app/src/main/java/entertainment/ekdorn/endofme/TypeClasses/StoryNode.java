package entertainment.ekdorn.endofme.TypeClasses;

import java.util.HashMap;

/**
 * Created by User on 17.07.2017.
 */

public class  StoryNode {
    String computerSpeech;
    String story;
    double thisTreeValue;
    String view;
    HashMap<String, Double> viewModifiers;

    String indicator = "none";


    public HashMap<String, Double> getViewModifiers() {
        return viewModifiers;
    }

    public String isComputerSpeech() {
        return computerSpeech;
    }

    public String getStory() {
        return story;
    }

    public double getThisTreeValue() {
        return thisTreeValue;
    }

    public String getView() {
        return view;
    }

    public String getIndicator() {
        return indicator;
    }

    public StoryNode(String computerSpeech, String story, double thisTreeValue, String view, HashMap<String, Double> viewModifiers, String indicator) {
        this.computerSpeech = computerSpeech;
        this.story = story;
        this.thisTreeValue = thisTreeValue;
        this.view = view;
        this.viewModifiers = viewModifiers;
        this.indicator = indicator;
    }
}

package entertainment.ekdorn.endofme.TypeClasses;

/**
 * Created by User on 17.07.2017.
 */

public class  StoryNode {
    String computerSpeech;
    String story;
    double thisTreeValue;
    String view;

    String indicator = "none";


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

    public StoryNode(String computerSpeech, String story, double thisTreeValue, String view, String indicator) {
        this.computerSpeech = computerSpeech;
        this.story = story;
        this.thisTreeValue = thisTreeValue;
        this.view = view;
        this.indicator = indicator;
    }
}

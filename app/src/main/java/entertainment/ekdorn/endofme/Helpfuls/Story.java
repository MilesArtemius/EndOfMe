package entertainment.ekdorn.endofme.Helpfuls;

import android.content.Context;
import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import entertainment.ekdorn.endofme.R;
import entertainment.ekdorn.endofme.TypeClasses.StoryNode;

/**
 * Created by User on 22.07.2017.
 */

public class Story {
    private static Story ourInstance;
    public ArrayList<StoryNode> nodes;

    public static Story getInstance(Context context) {
        if (ourInstance != null) {
            return ourInstance;
        } else {
            ourInstance = new Story(context);
            return ourInstance;
        }
    }

    public ArrayList<StoryNode> getNodes() {
        return nodes;
    }

    private Story(Context context) {
        this.nodes = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonObject source = parser.parse(new JsonReader(new InputStreamReader(context.getResources().openRawResource(R.raw.story_tree)))).getAsJsonObject();

        for (Map.Entry<String, JsonElement> leaf: source.entrySet()) {
            double thisTreeValue = Integer.parseInt(leaf.getKey());
            boolean computerSpeech = leaf.getValue().getAsJsonObject().get("computer").getAsBoolean();
            String story = leaf.getValue().getAsJsonObject().get("story").getAsString();
            String view = leaf.getValue().getAsJsonObject().get("input").getAsString();
            String indicator = leaf.getValue().getAsJsonObject().get("indicator").getAsString();

            Log.e("TAG", "Story: " + "\n" + thisTreeValue + "\n" + computerSpeech + "\n" + story + "\n" + view + "\n" + indicator);

            this.nodes.add(new StoryNode(computerSpeech, story, thisTreeValue, view, indicator));
        }
    }
}

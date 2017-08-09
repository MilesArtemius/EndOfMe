package entertainment.ekdorn.endofme.Helpfuls;

import android.content.Context;
import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
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
            String computerSpeech = leaf.getValue().getAsJsonObject().get("computer").getAsString();
            String story = leaf.getValue().getAsJsonObject().get("story").getAsString();
            String indicator = leaf.getValue().getAsJsonObject().get("indicator").getAsString();
            String view;
            HashMap<String, Double> modifier = new HashMap<>();
            if (leaf.getValue().getAsJsonObject().get("input").isJsonObject()) {
                view = leaf.getValue().getAsJsonObject().get("input").getAsJsonObject().get("view").getAsString();
                for (Map.Entry<String, JsonElement> mod: leaf.getValue().getAsJsonObject().get("input").getAsJsonObject().entrySet()) {
                    if (!mod.getKey().equals("view")) {
                        modifier.put(mod.getKey(), mod.getValue().getAsDouble());
                    }
                }
            } else {
                view = leaf.getValue().getAsJsonObject().get("input").getAsString();
            }

            Log.e("TAG", "Story: " + "\n" + thisTreeValue + "\n" + computerSpeech + "\n" + story + "\n" + view + "\n" + modifier.toString() + "\n" + indicator);

            this.nodes.add(new StoryNode(computerSpeech, story, thisTreeValue, view, modifier, indicator));
        }
    }
}

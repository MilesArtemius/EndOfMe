package entertainment.ekdorn.endofme.InputTypes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 08.08.2017.
 */

public class ButtonsInputType extends BasicInputType {
    ArrayList<Button> buttons;

    public static ButtonsInputType newInstance(HashMap<String, Double> buttons) {
        Bundle args = new Bundle();
        args.putSerializable("buttons", buttons);
        ButtonsInputType fragment = new ButtonsInputType();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buttons = new ArrayList<>();
        HashMap<String, Double> buttonSet = (HashMap<String, Double>) getArguments().get("buttons");
        for (Map.Entry<String, Double> buttonParameters: buttonSet.entrySet()) {
            Button button = new Button(getActivity());
            button.setText(buttonParameters.getKey());
            buttons.add(button);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout superL = (LinearLayout) super.onCreateView(inflater, container, savedInstanceState);
        superL.setOrientation(LinearLayout.VERTICAL);
        for (int i = 0; i <= buttons.size() - 1; i += 2) {
            LinearLayout layout = new LinearLayout(getActivity());
            layout.setOrientation(LinearLayout.HORIZONTAL);
            layout.setWeightSum(1);
            layout.addView(buttons.get(i));
            if (i != buttons.size() - 1) {
                layout.addView(buttons.get(i + 1));
                buttons.get(i+1).setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f));
                buttons.get(i).setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f));
            } else {
                buttons.get(i).setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
            }
            superL.addView(layout);
        }
        return superL;
    }
}
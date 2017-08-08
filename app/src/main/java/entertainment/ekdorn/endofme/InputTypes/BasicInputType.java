package entertainment.ekdorn.endofme.InputTypes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by User on 17.07.2017.
 */

public class BasicInputType extends Fragment {
    RelativeLayout cover;
    Button button;

    public static BasicInputType newInstance() {
        /*Bundle args = new Bundle();
        args.putString("urgent", UrgentMessage);
        args.putString("lol", type);
        args.putSerializable("name", name);
        args.putSerializable(ARG_CRIME_ID, child);
        args.putSerializable("trt", isAdmin);*/
        //BasicInputType fragment = new BasicInputType();
        //fragment.setArguments(args);
        //return fragment;
        //getArguments;
        return new BasicInputType();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cover = new RelativeLayout(getActivity());
        button = new Button(getActivity());
        Log.e("TAG", "onCreate: " + button);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        cover.addView(button);
        Log.e("TAG", "showView: defff");
        return cover;
    }
}

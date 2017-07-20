package entertainment.ekdorn.endofme;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;

/**
 * Created by User on 20.07.2017.
 */

public class MainDialog extends AlertDialog {

    protected MainDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View child = getLayoutInflater().inflate(R.layout.layout_dialog, null);

        UsefulThings.configureWindow((FragmentActivity) this.getOwnerActivity(), child);

        this.setContentView(child);
    }
}

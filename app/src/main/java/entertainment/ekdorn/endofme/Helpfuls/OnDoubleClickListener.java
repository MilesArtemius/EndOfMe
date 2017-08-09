package entertainment.ekdorn.endofme.Helpfuls;

import android.view.View;

/**
 * Created by User on 09.08.2017.
 */

public abstract class OnDoubleClickListener implements View.OnClickListener {

    private static final long DOUBLE_CLICK_TIME = 300;//milliseconds

    private long lastClickTime = 0;

    @Override
    public void onClick(View v) {
        long clickTime = System.currentTimeMillis();
        if (clickTime - lastClickTime < DOUBLE_CLICK_TIME){
            onDoubleClick(v);
        }
        lastClickTime = clickTime;
    }

    public abstract void onDoubleClick(View v);
}

package entertainment.ekdorn.endofme;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

import entertainment.ekdorn.endofme.Helpfuls.UsefulThings;

/**
 * Created by User on 20.07.2017.
 */

public class RetainDialog extends AlertDialog {
    View parent;

    public Button NewGameButton;
    public Button ContinueButton;
    public Button AuthorsButton;
    public Button AchievementsButton;

    public Button getNewGameButton() {
        return NewGameButton;
    }

    public Button getContinueButton() {
        return ContinueButton;
    }

    public Button getAuthorsButton() {
        return AuthorsButton;
    }

    public Button getAchievementsButton() {
        return AchievementsButton;
    }

    protected RetainDialog(@NonNull Context context) {
        super(context);
        parent = getLayoutInflater().inflate(R.layout.layout_dialog, null);
        NewGameButton = (Button) parent.findViewById(R.id.new_game_button);
        ContinueButton = (Button) parent.findViewById(R.id.continue_button);
        AuthorsButton = (Button) parent.findViewById(R.id.authors_and_developers_button);
        AchievementsButton = (Button) parent.findViewById(R.id.achievements_button);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UsefulThings.configureWindow((FragmentActivity) this.getOwnerActivity(), parent);

        this.setContentView(parent);
    }
}

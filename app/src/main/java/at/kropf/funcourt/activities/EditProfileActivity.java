package at.kropf.funcourt.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mobeta.android.dslv.DragSortListView;

import java.util.ArrayList;
import java.util.List;

import at.kropf.funcourt.R;
import at.kropf.funcourt.adapter.PositionAdapter;
import at.kropf.funcourt.application.App;
import at.kropf.funcourt.model.Position;
import at.kropf.funcourt.model.User;

/**
 * Created by Daniel on 27.08.17.
 */

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private final int SELECT_PHOTO = 1;

    private Button btnFootLeft;
    private Button btnFootRight;
    private Button btnFootBoth;

    private LinearLayout llAmateur;
    private LinearLayout llTeam;
    private LinearLayout llFormerTeam;

    private ImageView profileImage;
    private ImageView profileImageHolder;

    private PositionAdapter positionAdapter;

    private User currentUser;

    private TextView txtUsername;

    private User.Experience mExperience;
    private User.StrongFoot mStrongFoot;

    private DragSortListView.DropListener onDrop =
            new DragSortListView.DropListener() {
                @Override
                public void drop(int from, int to) {
                    Position position = positionAdapter.getItem(from);

                    positionAdapter.remove(position);
                    positionAdapter.insert(position, to);
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        currentUser = App.getCurrentUser();

        ((ScrollView) findViewById(R.id.mainScroll)).scrollTo(0, 0);

        btnFootLeft = (Button) findViewById(R.id.btnFootLeft);
        btnFootRight = (Button) findViewById(R.id.btnFootRight);
        btnFootBoth = (Button) findViewById(R.id.btnFootBoth);

        btnFootLeft.setOnClickListener(this);
        btnFootRight.setOnClickListener(this);
        btnFootBoth.setOnClickListener(this);

        llAmateur = (LinearLayout) findViewById(R.id.llAmateur);
        llTeam = (LinearLayout) findViewById(R.id.llTeam);
        llFormerTeam = (LinearLayout) findViewById(R.id.llFormerTeam);

        llAmateur.setOnClickListener(this);
        llTeam.setOnClickListener(this);
        llFormerTeam.setOnClickListener(this);

        profileImage = (ImageView) findViewById(R.id.profileImage);
        profileImageHolder = (ImageView) findViewById(R.id.profileImageHolder);
        profileImage.setOnClickListener(this);
        profileImageHolder.setOnClickListener(this);

        txtUsername = (TextView) findViewById(R.id.txtUsername);

        DragSortListView lv = (DragSortListView) findViewById(R.id.dragSortListView);
        lv.setDropListener(onDrop);
        List<Position> mPositions = new ArrayList<>();
        mPositions.add(new Position(0, "S", "Sturm"));
        mPositions.add(new Position(0, "M", "Mittelfeld"));
        mPositions.add(new Position(0, "V", "Verteidigung"));
        mPositions.add(new Position(0, "T", "Tor"));

        positionAdapter = new PositionAdapter(mPositions, this);

        lv.setAdapter(positionAdapter);

        findViewById(R.id.btnConfirm).setOnClickListener(this);

        showCurrentSettings();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFootLeft:
                resetFootButtons();
                mStrongFoot = User.StrongFoot.LEFT;
                btnFootLeft.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnFootLeft.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case R.id.btnFootRight:
                resetFootButtons();
                mStrongFoot = User.StrongFoot.RIGHT;
                btnFootRight.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnFootRight.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case R.id.btnFootBoth:
                resetFootButtons();
                mStrongFoot = User.StrongFoot.BOTH;
                btnFootBoth.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnFootBoth.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case R.id.llAmateur:
                mExperience = User.Experience.AMATEUR;
                ((ImageView) llAmateur.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_on);
                ((ImageView) llTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llFormerTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                break;
            case R.id.llTeam:
                mExperience = User.Experience.TEAM;
                ((ImageView) llAmateur.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_on);
                ((ImageView) llFormerTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                break;
            case R.id.llFormerTeam:
                mExperience = User.Experience.FORMER_TEAM;
                ((ImageView) llAmateur.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llFormerTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_on);
                break;
            case R.id.profileImage:
            case R.id.profileImageHolder:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
                break;
            case R.id.btnConfirm:
                App.getCurrentUser().setExperience(mExperience);
                App.getCurrentUser().setStrongFoot(mStrongFoot);

                App.getPreferences().setLoggedIn(true);
                startActivity(new Intent(EditProfileActivity.this, MainActivity.class));
                finish();
        }
    }

    private void resetFootButtons() {
        btnFootLeft.setBackground(getResources().getDrawable(R.drawable.bg_button_empty));
        btnFootLeft.setTextColor(getResources().getColor(R.color.white60));

        btnFootRight.setBackground(getResources().getDrawable(R.drawable.bg_button_empty));
        btnFootRight.setTextColor(getResources().getColor(R.color.white60));

        btnFootBoth.setBackground(getResources().getDrawable(R.drawable.bg_button_empty));
        btnFootBoth.setTextColor(getResources().getColor(R.color.white60));
    }
    private void showCurrentSettings() {
        showExperience();
        showStrongFoot();
        txtUsername.setText(currentUser.getUsername());
    }

    /**
     *
     * display experience from stored user.
     */
    private void showExperience() {
        switch (currentUser.getExperience()) {
            case AMATEUR:
                ((ImageView) llAmateur.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_on);
                ((ImageView) llTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llFormerTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                break;
            case TEAM:
                ((ImageView) llAmateur.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_on);
                ((ImageView) llFormerTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                break;
            case FORMER_TEAM:
                ((ImageView) llAmateur.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llFormerTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_on);
                break;
        }
    }

    private void showStrongFoot() {
        resetFootButtons();
        switch (currentUser.getStrongFoot()){
            case RIGHT:
                btnFootRight.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnFootRight.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case LEFT:
                btnFootLeft.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnFootLeft.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case BOTH:
                btnFootBoth.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnFootBoth.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
        }
    }
}

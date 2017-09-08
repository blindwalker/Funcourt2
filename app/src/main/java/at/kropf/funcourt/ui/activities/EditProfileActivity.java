/*
package at.kropf.funcourt.ui.activities;

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

import javax.inject.Inject;

import at.kropf.funcourt.R;
import at.kropf.funcourt.adapter.PositionAdapter;
import at.kropf.funcourt.application.Preferences;
import at.kropf.funcourt.application.SharedConstants;
import at.kropf.funcourt.db.model.PlayerPosition;
import at.kropf.funcourt.db.model.User;

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

    private int mExperience;
    private int mStrongFoot;

    @Inject
    Preferences preferences;

    private DragSortListView.DropListener onDrop =
            new DragSortListView.DropListener() {
                @Override
                public void drop(int from, int to) {
                    PlayerPosition position = positionAdapter.getItem(from);

                    positionAdapter.remove(position);
                    positionAdapter.insert(position, to);
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //TODO: get user from DB
        //currentUser = FuncourtApplication.getCurrentUser();

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

        //TODO: get player positions from DB

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
                mStrongFoot = SharedConstants.STRONG_FOOT_LEFT;
                btnFootLeft.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnFootLeft.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case R.id.btnFootRight:
                resetFootButtons();
                mStrongFoot = SharedConstants.STRONG_FOOT_RIGHT;
                btnFootRight.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnFootRight.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case R.id.btnFootBoth:
                resetFootButtons();
                mStrongFoot = SharedConstants.STRONG_FOOT_BOTH;
                btnFootBoth.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnFootBoth.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case R.id.llAmateur:
                mExperience = SharedConstants.EXPERIENCE_AMATEUR;
                ((ImageView) llAmateur.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_on);
                ((ImageView) llTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llFormerTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                break;
            case R.id.llTeam:
                mExperience = SharedConstants.EXPERIENCE_TEAM;
                ((ImageView) llAmateur.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_on);
                ((ImageView) llFormerTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                break;
            case R.id.llFormerTeam:
                mExperience = SharedConstants.EXPERIENCE_FORMER_TEAM;
                ((ImageView) llAmateur.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llFormerTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_on);
                break;
            case R.id.profileImage:
            case R.id.profileImageHolder:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image*/
/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
                break;
            case R.id.btnConfirm:
                //TODO: Write to DB
                */
/*
                FuncourtApplication.getCurrentUser().setExperience(mExperience);
                FuncourtApplication.getCurrentUser().setStrongFoot(mStrongFoot);
                *//*

                preferences.setLoggedIn(true);
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

    */
/**
     *
     * display experience from stored user.
     *//*

    private void showExperience() {
        switch (currentUser.getPlayerExperience()) {
            case SharedConstants.EXPERIENCE_AMATEUR:
                ((ImageView) llAmateur.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_on);
                ((ImageView) llTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llFormerTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                break;
            case SharedConstants.EXPERIENCE_TEAM:
                ((ImageView) llAmateur.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_on);
                ((ImageView) llFormerTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                break;
            case SharedConstants.EXPERIENCE_FORMER_TEAM:
                ((ImageView) llAmateur.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llFormerTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_on);
                break;
        }
    }

    private void showStrongFoot() {
        resetFootButtons();
        switch (currentUser.getStrongFoot()){
            case SharedConstants.STRONG_FOOT_RIGHT:
                btnFootRight.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnFootRight.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case SharedConstants.STRONG_FOOT_LEFT:
                btnFootLeft.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnFootLeft.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case SharedConstants.STRONG_FOOT_BOTH:
                btnFootBoth.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnFootBoth.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
        }
    }
}
*/

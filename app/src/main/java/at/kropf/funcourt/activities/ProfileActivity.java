package at.kropf.funcourt.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.mobeta.android.dslv.DragSortListView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import at.kropf.funcourt.R;
import at.kropf.funcourt.adapter.PositionAdapter;
import at.kropf.funcourt.model.Position;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

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

        ((ScrollView)findViewById(R.id.mainScroll)).scrollTo(0,0);

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFootLeft:
                resetFootButtons();
                btnFootLeft.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnFootLeft.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case R.id.btnFootRight:
                resetFootButtons();
                btnFootRight.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnFootRight.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case R.id.btnFootBoth:
                resetFootButtons();
                btnFootBoth.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                btnFootBoth.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case R.id.llAmateur:
                ((ImageView) llAmateur.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_on);
                ((ImageView) llTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llFormerTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                break;
            case R.id.llTeam:
                ((ImageView) llAmateur.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                ((ImageView) llTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_on);
                ((ImageView) llFormerTeam.findViewWithTag("radio")).setImageResource(R.drawable.ic_radio_off);
                break;
            case R.id.llFormerTeam:
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
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch (requestCode) {
            case SELECT_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        int targetWidth  = selectedImage.getWidth() /2; //change this to control the size
                        int targetHeight = selectedImage.getHeight() / 2 ;
                        Matrix matrix = new Matrix();
                        matrix.postScale(1f, 1f);
                        Bitmap resizedBitmap = Bitmap.createBitmap(selectedImage, 0, 0, targetWidth, targetHeight, matrix, true);

                        profileImage.setImageBitmap(resizedBitmap);
                        profileImage.setVisibility(View.VISIBLE);
                        profileImageHolder.setVisibility(View.GONE);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }
        }
    }
}


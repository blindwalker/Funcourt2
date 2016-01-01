package at.kropf.funcourt.activities;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import com.melnykov.fab.FloatingActionButton;

import at.kropf.funcourt.R;
import at.kropf.funcourt.adapter.EventAdapter;
import at.kropf.funcourt.adapter.LeagueSpinnerAdapter;
import at.kropf.funcourt.model.League;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        Spinner.OnItemSelectedListener {

    private Spinner leagueSpinner;
    private ListView eventList;
    private EventAdapter eventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.inflateHeaderView(R.layout.nav_header_main);

        //populate league spinner in navigation menu
        leagueSpinner = (Spinner) headerView.findViewById(R.id.leagueSpinner);
        leagueSpinner.setAdapter(new LeagueSpinnerAdapter(this, League.createDummyLeagueList(3, this)));
        leagueSpinner.setOnItemSelectedListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        eventList = (ListView) findViewById(R.id.eventList);
        eventAdapter = new EventAdapter(((League)leagueSpinner.getSelectedItem()), this);
        eventList.setAdapter(eventAdapter);

        fab.attachToListView(eventList);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_create) {

        } else if (id == R.id.nav_matchday) {

        } else if (id == R.id.nav_other_players) {

        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        eventAdapter = new EventAdapter(((League)leagueSpinner.getSelectedItem()), this);
        eventList.setAdapter(eventAdapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

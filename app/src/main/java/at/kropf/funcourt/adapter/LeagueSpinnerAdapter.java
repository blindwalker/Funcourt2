/*
package at.kropf.funcourt.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import at.kropf.funcourt.R;
import at.kropf.funcourt.db.model.League;
import at.kropf.funcourt.model.League;

public class LeagueSpinnerAdapter extends BaseAdapter {
    private List<League> leagueList = new ArrayList<>();
    private Activity context;

    public LeagueSpinnerAdapter(Activity context, List<League> leagueList) {
        this.context = context;
        this.leagueList = leagueList;
    }

    public void clear() {
        leagueList.clear();
    }

    public void addItem(League league) {
        leagueList.add(league);
    }

    public void addItems(List<League> leagues) {
        leagueList.addAll(leagues);
    }

    @Override
    public int getCount() {
        return leagueList.size();
    }

    @Override
    public Object getItem(int position) {
        return leagueList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getDropDownView(int position, View view, ViewGroup parent) {
        if (view == null || !view.getTag().toString().equals("DROPDOWN")) {
            view = context.getLayoutInflater().inflate(R.layout.spinner_item_league_dropdown, parent, false);
            view.setTag("DROPDOWN");
        }

        TextView textView = (TextView) view.findViewById(android.R.id.text1);
        textView.setText(getTitle(position));
        return view;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null || !view.getTag().toString().equals("NON_DROPDOWN")) {
            view = context.getLayoutInflater().inflate(R.layout.
                    spinner_item_league, parent, false);
            view.setTag("NON_DROPDOWN");
        }
        TextView textView = (TextView) view.findViewById(android.R.id.text1);
        textView.setText(getTitle(position));
        return view;
    }

    private String getTitle(int position) {
        return position >= 0 && position < leagueList.size() ? leagueList.get(position).getName() : "";
    }
}*/

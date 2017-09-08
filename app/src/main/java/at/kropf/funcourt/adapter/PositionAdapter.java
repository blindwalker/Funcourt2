/*
package at.kropf.funcourt.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import at.kropf.funcourt.R;
import at.kropf.funcourt.db.model.PlayerPosition;

*/
/**
 * Created by martinkropf on 30.12.15.
 *//*

public class PositionAdapter extends ArrayAdapter<PlayerPosition> {

    public PositionAdapter(List<PlayerPosition> positions, Context context) {
        super(context, R.layout.position_list_item, R.id.artist_name_textview, positions);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);

        if (v != convertView && v != null) {
            ViewHolder holder = new ViewHolder();

            TextView tv = (TextView) v.findViewById(R.id.artist_name_textview);
            holder.positionName = tv;

            v.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) v.getTag();
        String albums = getItem(position).getPositionName();

        switch (position) {
            case 0:
                ((LinearLayout)holder.positionName.getParent()).setBackgroundColor(getContext().getResources().getColor(R.color.colorAccent));
                holder.positionName.setTextColor(getContext().getResources().getColor(android.R.color.black));
                break;
            case 1:
                ((LinearLayout)holder.positionName.getParent()).setBackgroundColor(getContext().getResources().getColor(R.color.green1));
                holder.positionName.setTextColor(getContext().getResources().getColor(android.R.color.black));
                break;
            case 2:
                ((LinearLayout)holder.positionName.getParent()).setBackgroundColor(getContext().getResources().getColor(R.color.green2));
                holder.positionName.setTextColor(getContext().getResources().getColor(android.R.color.black));
                break;
            case 3:
                ((LinearLayout)holder.positionName.getParent()).setBackgroundColor(getContext().getResources().getColor(R.color.green3));
                holder.positionName.setTextColor(getContext().getResources().getColor(android.R.color.black));
                break;
        }

        holder.positionName.setText(albums);

        return v;
    }

    private class ViewHolder {
        public TextView positionName;
    }
}

*/

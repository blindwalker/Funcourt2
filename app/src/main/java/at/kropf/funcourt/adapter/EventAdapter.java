/*
package at.kropf.funcourt.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import at.kropf.funcourt.R;
import at.kropf.funcourt.db.model.Event;
import at.kropf.funcourt.db.model.League;
import at.kropf.funcourt.model.League;

public class EventAdapter extends ArrayAdapter<Event> {

    private Context mContext;
    private League league;

    public EventAdapter(League league, Context context) {
        super(context, R.layout.event_list_item, league.getEvents());
        this.mContext=context;
        this.league = league;
    }

    public View getView(int position, View v, ViewGroup parent) {
        ViewHolder holder;

        if(v==null){

            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            v = inflater.inflate(R.layout.event_list_item, parent, false);

            // well set up the ViewHolder
            holder = new ViewHolder();
            holder.eventImage = (ImageView) v.findViewById(R.id.eventImage);
            holder.leagueName = (TextView) v.findViewById(R.id.leagueName);
            holder.date = (TextView) v.findViewById(R.id.date);
            holder.month = (TextView) v.findViewById(R.id.month);
            holder.weekday = (TextView) v.findViewById(R.id.weekday);
            holder.time = (TextView) v.findViewById(R.id.time);
            holder.locationType = (TextView) v.findViewById(R.id.locationType);
            holder.address = (TextView) v.findViewById(R.id.address);
            holder.playerAmount = (TextView) v.findViewById(R.id.playerAmount);
            holder.dateSeperator = (View) v.findViewById(R.id.dateSeperator);
            holder.bottomSeperator = (View) v.findViewById(R.id.bottomSeperator);
            v.setTag(holder);

        }else{
            // we've just avoided calling findViewById() on resource everytime
            // just use the viewHolder
            holder = (ViewHolder) v.getTag();
        }

        Event currentEvent = getItem(position);

        switch (position) {
            case 0:
                holder.eventImage.setVisibility(View.VISIBLE);
                holder.eventImage.setImageBitmap(currentEvent.getEventLocation().getImage());
                holder.date.setTextColor(getContext().getResources().getColor(R.color.colorAccent));
                holder.month.setTextColor(getContext().getResources().getColor(R.color.colorAccent));
                holder.weekday.setTextColor(getContext().getResources().getColor(R.color.colorAccent));
                holder.time.setTextColor(getContext().getResources().getColor(R.color.colorAccent));
                holder.locationType.setTextColor(getContext().getResources().getColor(R.color.colorAccent));
                holder.playerAmount.setTextColor(getContext().getResources().getColor(R.color.colorAccent));
                holder.bottomSeperator.setBackgroundColor(getContext().getResources().getColor(R.color.colorAccent));
                holder.dateSeperator.setBackgroundColor(getContext().getResources().getColor(R.color.colorAccent));
                break;
            default:
                holder.eventImage.setVisibility(View.GONE);
                holder.date.setTextColor(getContext().getResources().getColor(android.R.color.white));
                holder.month.setTextColor(getContext().getResources().getColor(android.R.color.white));
                holder.weekday.setTextColor(getContext().getResources().getColor(android.R.color.white));
                holder.time.setTextColor(getContext().getResources().getColor(android.R.color.white));
                holder.locationType.setTextColor(getContext().getResources().getColor(android.R.color.white));
                holder.playerAmount.setTextColor(getContext().getResources().getColor(android.R.color.white));
                holder.bottomSeperator.setBackgroundColor(getContext().getResources().getColor(android.R.color.white));
                holder.dateSeperator.setBackgroundColor(getContext().getResources().getColor(android.R.color.white));
        }

        holder.leagueName.setText(league.getName());
        holder.date.setText(currentEvent.getDate().getDate()+"");
        //holder.month.setText(currentEvent.getDate().getMonth()+"");
        //holder.weekday.setText(currentEvent.getDate().getDay()+"");
        //holder.time.setText(currentEvent.getDate().getTime()+"");
        holder.locationType.setText(currentEvent.getLocation().getName());
        holder.playerAmount.setText(currentEvent.getPlayersCurrent()+"/"+currentEvent.getPlayersMax());

        return v;
    }

    private class ViewHolder {
        public ImageView eventImage;
        public TextView leagueName;
        public TextView date;
        public TextView month;
        public TextView weekday;
        public TextView address;
        public TextView time;
        public TextView playerAmount;
        public TextView locationType;
        public View dateSeperator;
        public View bottomSeperator;
    }
}

*/

package edu.yu.hackathon.yuscheduler;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 3/4/2016.
 */
public class CourseAdapter extends ArrayAdapter<Course> {
    private final Context context;
    private ArrayList<Course> values;

    public CourseAdapter(Context context,  ArrayList<Course> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.course_row_adapter, parent, false);

        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView prof = (TextView) rowView.findViewById(R.id.prof);

        title.setText(values.get(position).getTitle() + "      ");
        prof.setText(values.get(position).getProf() + "   ");

        return rowView;
    }

}
package edu.yu.hackathon.yuscheduler;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ScheduleMaker extends AppCompatActivity {

    EditText terms_editText;

    Boolean isYC;

    ListView list;

    TextView crn;
    TextView title;
    TextView prof;
    TextView day1;
    TextView day2;
    TextView time1;
    TextView time2;
    TextView credits;

    int totalCredits;

    Button info;
    CourseAdapter ada;
    ArrayList<Course> courses;


    Course selectedCourse;


    ArrayList <Course>chosenCourses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_maker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Button search = (Button)findViewById(R.id.search_button);

        terms_editText = (EditText) findViewById(R.id.search_terms);

        String school = getIntent().getStringExtra("ClassType");

        isYC = school.equals("YC");


        courses = new ArrayList<>();
        chosenCourses = new ArrayList<>();

        info = (Button) findViewById(R.id.infoButton);
        title = (TextView) findViewById(R.id.title);
        prof = (TextView) findViewById(R.id.prof);
        day1 = (TextView) findViewById(R.id.day1);
        day2 = (TextView) findViewById(R.id.day2);
        time1 = (TextView) findViewById(R.id.time1);
        time2 = (TextView) findViewById(R.id.time2);
        crn = (TextView) findViewById(R.id.crn);
        credits = (TextView) findViewById(R.id.credits);

        info.setVisibility(View.GONE);

        getCourses();

//        courses.add(new Course("Intro to com", "V Kelly"));
//        courses.add(new Course("Data Structures", "M Berban"));
//        courses.add(new Course("Alg", "M Breban"));


        ada = new CourseAdapter(this,courses);

        list = (ListView) findViewById(R.id.courses_list);

        list.setAdapter(ada);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("BLAH", "FACE");

                String terms = terms_editText.getText().toString();

                getCourses(terms);

                ada.notifyDataSetChanged();
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Course selected = courses.get(position);

                selectedCourse = selected;

                setupInfo(selected);

                info.setVisibility(View.VISIBLE);

                if(chosenCourses.contains(selected))
                    info.setText("DELETE COURSE");
                else
                    info.setText("ADD COURSE");
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().toString().equals("DELETE COURSE")){

                    String crnInfo = crn.getText().toString();


                    for (Iterator<Course> it = chosenCourses.iterator(); it.hasNext();) {
                        Course c = it.next();
                        if (c.getCrn().equals(crnInfo)) it.remove();
                    }

                    deleteButton();

                    clearInfo();
                }

                else
                {

                    if(!updateButton()){
                        Toast.makeText(getBaseContext(),"Conflict",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    chosenCourses.add(selectedCourse);

                    //Toast.makeText(getBaseContext(),selectedCourse.getTitle(), Toast.LENGTH_SHORT).show();


                    selectedCourse = null;

                    //updateButton();

                    clearInfo();
                }
            }
        });

        setSupportActionBar(toolbar);
    }

    protected void setupInfo(Course course){
        crn.setText(course.getCrn());
        title.setText(course.getTitle());
        prof.setText(course.getProf());
        day1.setText(course.getDay1());
        day2.setText(course.getDay2());
        time1.setText(course.getTime1start() +"-" + course.getTime1finish());
        time2.setText(course.getTime2start() + "-" + course.getTime2finish());
        credits.setText(course.getCredits());
    }

    protected void clearInfo(){
        info.setVisibility(View.GONE);

        crn.setText("");
        title.setText("");
        prof.setText("");
        day1.setText("");
        day2.setText("");
        time1.setText("");
        time2.setText("");
        credits.setText("");
    }

    protected void getCourses(){

        try {

            JSONObject obj = new JSONObject(loadJSONFromAsset());

            //get the courses into the array list

            for(int i=0;i<obj.names().length();i++){

                JSONObject dept = obj.getJSONObject(obj.names().getString(i));

                for(int j=0;j<dept.names().length();j++){
                    JSONObject courseJSON = dept.getJSONObject(dept.names().getString(j));

                    String credits = getValue(courseJSON, "credits");
                    String crn = getValue(courseJSON,"crn");
                    String crse = getValue(courseJSON,"crse");
                    String day1 = getValue(courseJSON,"day1");
                    String day2 = getValue(courseJSON,"day2");
                    String prof = getValue(courseJSON,"prof");
                    String time1finish = getValue(courseJSON,"time1finish");
                    String time1start = getValue(courseJSON,"time1start");
                    String time2finish = getValue(courseJSON,"time2finish");
                    String time2start = getValue(courseJSON,"time2start");
                    String title = getValue(courseJSON,"title");

                    Course course = new Course(credits, crn, crse, day1,
                                               day2, prof, time1finish,
                                               time1start, time2finish,
                                               time2start, title);

                    courses.add(course);
                }

            }


        } catch (JSONException e) {
            //e.printStackTrace();

        }
    }

    protected void getCourses(String terms){

        courses.clear();

        terms = terms.toLowerCase();

        try {

            JSONObject obj = new JSONObject(loadJSONFromAsset());

            //get the courses into the array list

            for(int i=0;i<obj.names().length();i++){

                JSONObject dept = obj.getJSONObject(obj.names().getString(i));

                for(int j=0;j<dept.names().length();j++){
                    JSONObject courseJSON = dept.getJSONObject(dept.names().getString(j));


                    String credits = getValue(courseJSON, "credits");
                    String crn = getValue(courseJSON,"crn");
                    String crse = getValue(courseJSON,"crse");
                    String day1 = getValue(courseJSON,"day1");
                    String day2 = getValue(courseJSON,"day2");
                    String prof = getValue(courseJSON,"prof");
                    String time1finish = getValue(courseJSON,"time1finish");
                    String time1start = getValue(courseJSON,"time1start");
                    String time2finish = getValue(courseJSON,"time2finish");
                    String time2start = getValue(courseJSON,"time2start");
                    String title = getValue(courseJSON,"title");

                    Course course = new Course(credits, crn, crse, day1,
                            day2, prof, time1finish,
                            time1start, time2finish,
                            time2start, title);

                    if(course.getTitle().toLowerCase().contains(terms) || course.getProf().toLowerCase().contains(terms) || (course.getCrn()).toLowerCase().contains(terms))
                        courses.add(course);
                }

            }


        } catch (JSONException e) {
            //e.printStackTrace();
            //return null;
        }

        //return courses;
    }

    protected String getValue(JSONObject course, String key){
    try{
        return (String)course.get(key);
    } catch (Exception e) {
        //e.printStackTrace();
        return "";
    }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = (isYC) ? this.getAssets().open("alt_yc_classes.json") : this.getAssets().open("alt_stern_classes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            //ex.printStackTrace();
            return null;
        }
        return json;
    }

    protected boolean updateButton() {

        String timeVal = selectedCourse.getTimeValue();
        String[] values = timeVal.split("_");

        for (String val : values) {
            String buttonID = "t" + val;

            int resID = getResources().getIdentifier(buttonID, "id", "edu.yu.hackathon.yuscheduler");

            final Button b = (Button) findViewById(resID);


            if(b!=null) {

                if(b.getText().toString().length() == 5){
                    return false;
                }

                b.setBackgroundColor(Color.GREEN);

                b.setText(selectedCourse.getCrn());


                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String crnInfo = b.getText().toString();

                        for (Iterator<Course> it = chosenCourses.iterator(); it.hasNext(); ) {
                            Course c = it.next();
                            if (c.getCrn().equals(crnInfo)) {
                                setupInfo(c);
                                selectedCourse = c;
                                info.setVisibility(View.VISIBLE);
                                info.setText("DELETE COURSE");
                            }

                        }

                    }
                });
            }
        }

        return true;
    }

    protected void deleteButton() {

        String timeVal = selectedCourse.getTimeValue();
        String[] values = timeVal.split("_");

        for (String val : values) {
            String buttonID = "t" + val;

            int resID = getResources().getIdentifier(buttonID, "id", "edu.yu.hackathon.yuscheduler");

            final Button b = (Button) findViewById(resID);
            if(b!=null) {
                b.setBackgroundColor(Color.LTGRAY);

                b.setText(val);

                b.setOnClickListener(null);
            }
        }
    }



}

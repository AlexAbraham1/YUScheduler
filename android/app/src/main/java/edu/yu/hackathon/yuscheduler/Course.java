package edu.yu.hackathon.yuscheduler;

/**
 * Created by alexabraham on 5/8/16.
 */
public class Course {

    private String credits;
    private String crn;
    private String crse;
    private String day1;
    private String day2;
    private String prof;
    private String time1finish;
    private String time1start;
    private String time2finish;
    private String time2start;
    private String title;
    private String timeValue;

    public Course(String credits, String crn, String crse, String day1, String day2, String prof, String time1finish, String time1start,
                  String time2finish,String time2start, String title){
        this.credits = credits;
        this.crn = crn;
        this.crse = crse;
        this.day1 = day1;
        this.day2 = day2;
        this.prof = prof;
        this.time1finish = time1finish;
        this.time1start = time1start;
        this.time2finish = time2finish;
        this.time2start = time2start;
        this.title = title;

        setTimeValue();

    }

    public String getTitle(){ return this.title;}

    public String getProf(){ return this.prof;}

    public String getDay1(){ return this.day1;}

    public String getCrn(){ return this.crn;}
    public String getDay2(){ return this.day2;}
    public String getCredits(){return this.credits;}
    public String getTime1finish(){return time1finish;}
    public String getTime1start(){return time1start;}
    public String getTime2finish(){ return time2finish;}
    public String getTime2start(){return time2start; }
    public String getTimeValue() {return timeValue;}

    private void setTimeValue() {

        char timeStart1 = time1start.charAt(0);
        char timeStart2 = time2start.length() > 0 ? time2start.charAt(0) : '0';
        timeValue +="_";
        if (day1.contains("M")){
            timeValue+= "2" + timeStart1 + "1";
        }

        timeValue +="_";

        if (day1.contains("T")){
            timeValue+= "3" + timeStart1 + "1";
        }

        timeValue +="_";

        if (day1.contains("W")){
            timeValue+= "4" + timeStart1 + "1";
        }

        timeValue +="_";

        if (day1.contains("R")){
            timeValue+= "5" + timeStart1 + "1";
        }

        if (day1.contains("F")){
            timeValue+= "6" + (timeStart1-8) + "1";
        }

        timeValue +="_";

        if (day2.contains("M")){
            timeValue+= "2" + timeStart2 + "1";
        }

        timeValue +="_";

        if(timeStart2=='0')
            return;

        if (day2.contains("T")){
            timeValue+= "3" + timeStart2 + "1";
        }

        if (day2.contains("W")){
            timeValue+= "4" + timeStart2 + "1";
        }

        timeValue +="_";

        if (day2.contains("R")){
            timeValue+= "5" + timeStart2 + "1";
        }
        timeValue +="_";

        if (day2.contains("F")){
            timeValue+= "6" + (timeStart2 -8) + "1";
        }

    }

}

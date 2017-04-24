package schedulink.schedulink;

import android.app.Application;

import com.alamkanak.weekview.WeekViewEvent;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

import schedulink.schedulink.weekview.Schedulink;

/**
 *
 */
public class Global extends Application {

    private Uzer mainUzer;
    private ArrayList<Schedulink> scheds;
    private Schedulink sched;
    private int newMonth;
    private int newYear;


    public Global() {
        this.mainUzer = new Uzer("Mike", "temp@email.com"); //temporary, remove later
        sched = new Schedulink();
        //Firebase.setAndroidContext(this);
    }

    public Uzer getMainUzer() {
        return mainUzer;
    }

    public void setMainUzer(Uzer mainUzer) {
        this.mainUzer = mainUzer;
    }

    public Schedulink getSched()
    {
        return sched;
    }

    public void setSched(Schedulink newGuy)
    {
        sched = newGuy;
    }

    public void FirebaseTest(){
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");
    }

    public void setTime(int inputMonth, int inputYear)
    {
        this.newMonth = inputMonth;
        this.newYear = inputYear;
    }

    public void addEventToSched(WeekViewEvent event)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
        sched.addEventToSchedulink(event);
    }

    public int getNewMonth(){return newMonth;}
    public int getNewYear(){return newYear;}
    public void addEventToSchedAuto(String eventName, String eventDescription)
    {
        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 5);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.DAY_OF_MONTH, 4);
        startTime.set(Calendar.MONTH, 1);
        startTime.set(Calendar.YEAR, 2017);
        Calendar endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 1);
        WeekViewEvent event = new WeekViewEvent(1, eventName, startTime, endTime);
        event.setLocation(eventDescription);
        event.setColor(-477870);
        sched.addEventToSchedulink(event);
    }

}

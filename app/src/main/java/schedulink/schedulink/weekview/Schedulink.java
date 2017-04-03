package schedulink.schedulink.weekview;


import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

/**
 * Created by Michael on 16-03-02.
 */
public class Schedulink {

    private Map<String, schedulink.schedulink.weekview.WeekViewEvent> eventsList;
    private ArrayList<WeekViewEvent> events;
    private Calendar startTime;
    private Calendar endTime;

    public Schedulink() {
        startTime = Calendar.getInstance();
        endTime = (Calendar) startTime.clone();
        events = new ArrayList<>();
    }

    public ArrayList<WeekViewEvent> getEventList(int month) {
        ArrayList<WeekViewEvent> eventsForMonth = new ArrayList<WeekViewEvent>();
        for (WeekViewEvent event:events)
        {
            if (event.getStartTime().getTime().getMonth() == month) {
                eventsForMonth.add(event);
            }
        }
        return eventsForMonth;
    }

    public void addEventToSchedulink(WeekViewEvent newEvent){
        events.add(newEvent);
    }

    public void removeEventFromSchedulink(WeekViewEvent eventToRemove){
        events.remove(eventToRemove);
    }

    public void initialize(int newMonth, int newYear)
    {
        if (events.isEmpty()){
            Calendar startTime = Calendar.getInstance();
            startTime.set(Calendar.HOUR_OF_DAY, 3);
            startTime.set(Calendar.MINUTE, 0);
            startTime.set(Calendar.MONTH, newMonth - 1);
            startTime.set(Calendar.YEAR, newYear);
            Calendar endTime = (Calendar) startTime.clone();
            endTime.add(Calendar.HOUR, 1);
            endTime.set(Calendar.MONTH, newMonth - 1);
            WeekViewEvent event = new WeekViewEvent(1, getEventTitle("First One"), startTime, endTime);
            //event.setColor(ContextCompat.getColor(context, R.color.event_color_03));
            event.setColor(-477870);
            events.add(event);
        }
/*
            "event":{
                "startTimeMin":0,
                "startTimeMon":3,
                "start"
            }*/
/**
        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 4);
        endTime.set(Calendar.MINUTE, 30);
        endTime.set(Calendar.MONTH, newMonth - 1);
        event = new WeekViewEvent(10, getEventTitle("Second"), startTime, endTime);
        //event.setColor(getResources().getColor(R.color.event_color_03));
        event.setColor(R.color.event_color_04);
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 4);
        startTime.set(Calendar.MINUTE, 20);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 5);
        endTime.set(Calendar.MINUTE, 0);
        event = new WeekViewEvent(10, getEventTitle("Third"), startTime, endTime);
        //event.setColor(getResources().getColor(R.color.event_color_03));
        event.setColor(getColor(context, R.color.event_color_04));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 5);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 2);
        endTime.set(Calendar.MONTH, newMonth - 1);
        event = new WeekViewEvent(2, getEventTitle("Fourth"), startTime, endTime);
        //event.setColor(getResources().getColor(R.color.event_color_03));
        event.setColor(getColor(this.getApplicationContext(), R.color.event_color_04));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 5);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth - 1);
        startTime.set(Calendar.YEAR, newYear);
        startTime.add(Calendar.DATE, 1);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        endTime.set(Calendar.MONTH, newMonth - 1);
        event = new WeekViewEvent(3, getEventTitle("Fifth"), startTime, endTime);
        //event.setColor(getResources().getColor(R.color.event_color_03));
        event.setColor(getColor(View.getContext() ,R.color.event_color_04));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 15);
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent(4, getEventTitle("Sixth"), startTime, endTime);
        //event.setColor(getResources().getColor(R.color.event_color_03));
        event.setColor(getColor(context, R.color.event_color_04));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 1);
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent(5, getEventTitle("Seventh"), startTime, endTime);
        //event.setColor(getResources().getColor(R.color.event_color_03));
        event.setColor(getColor(context, R.color.event_color_04));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, startTime.getActualMaximum(Calendar.DAY_OF_MONTH));
        startTime.set(Calendar.HOUR_OF_DAY, 15);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent(5, getEventTitle("Eighth"), startTime, endTime);
        //event.setColor(getResources().getColor(R.color.event_color_03));
        event.setColor(getColor(context, R.color.event_color_04));
        events.add(event);

        //AllDay event
        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 0);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 23);
        event = new WeekViewEvent(7, getEventTitle("Ninth"),null, startTime, endTime, true);
        //event.setColor(getResources().getColor(R.color.event_color_03));
        event.setColor(getColor(context, R.color.event_color_04));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 8);
        startTime.set(Calendar.HOUR_OF_DAY, 2);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.DAY_OF_MONTH, 10);
        endTime.set(Calendar.HOUR_OF_DAY, 23);
        event = new WeekViewEvent(8, getEventTitle("Tenth"),null, startTime, endTime, true);
        //event.setColor(getResources().getColor(R.color.event_color_03));
        event.setColor(getColor(context, R.color.event_color_04));
        events.add(event);

        // All day event until 00:00 next day
        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 10);
        startTime.set(Calendar.HOUR_OF_DAY, 0);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.SECOND, 0);
        startTime.set(Calendar.MILLISECOND, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.DAY_OF_MONTH, 11);
        event = new WeekViewEvent(8, getEventTitle("Eleventh"), null, startTime, endTime, true);
        //event.setColor(getResources().getColor(R.color.event_color_03));
        event.setColor(getColor(context, R.color.event_color_04));
        events.add(event);
 */
    }

    private String getEventTitle(String testName) {
        return "This is a test object (" + testName + ")";
    }
}

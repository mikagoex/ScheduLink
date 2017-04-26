package schedulink.schedulink;

import android.app.Application;

import com.alamkanak.weekview.WeekViewEvent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

import schedulink.schedulink.weekview.Schedulink;

/**
 *
 */
public class Global extends Application {

    private Uzer mainUzer;
    private String email;
    private ArrayList<Schedulink> scheds;
    private Schedulink sched;
    private int newMonth;
    private int newYear;
    private WeekViewEvent testEvent;
    private String pushedKey;
    private String nextIndex = "1";


    public Global() {
        this.mainUzer = new Uzer("Test", "temp@email.com"); //temporary, remove later
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

    public String getEmail(){return email;}

    public void setSched(Schedulink newGuy)
    {
        sched = newGuy;
    }

    public void setUser(String email){
        this.email = email;
    }

    public void setTime(int inputMonth, int inputYear)
    {
        this.newMonth = inputMonth;
        this.newYear = inputYear;
    }

//    public void importSchedule(final String ownerName){
//
//        final DatabaseReference events = FirebaseDatabase.getInstance().getReference("Events");
//        events.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Query allOwnersEvents = events.child(pushedKey).equalTo(ownerName);
//
//                allOwnersEvents.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        for (DataSnapshot post : dataSnapshot.getChildren()) {
//                            String nameRef = post.child("name").getValue(String.class);
//                        }
//                    }
//                    public void onCancelled(DatabaseError databaseError) {}
//                });
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {}
//        });
//    }

    public void addEventToSched(WeekViewEvent event)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();

//        DatabaseReference myRef = database.getReference();
//        event.setOwner(this.email);
//        myRef.child("Events").push().setValue(event);

        DatabaseReference myRef = database.getReference();
        DatabaseReference myNewRef = myRef.child("Events").push();
        this.pushedKey = myNewRef.getKey();
        myNewRef.setValue(event);

        getNextKey(myRef);

        DatabaseReference myCheatRef = myRef.child("Admin").child(nextIndex);
        myCheatRef.child("email").setValue(email);
        myCheatRef.child("key").setValue(pushedKey);


        //importSchedule("a@a.ca");
        sched.addEventToSchedulink(event);
    }

    private void getNextKey(DatabaseReference myRef){
        DatabaseReference passedRef = myRef;
        DatabaseReference test = myRef.child("Admin").child("count").child("current");
        ValueEventListener valueEvent = (new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String key = dataSnapshot.getValue(String.class);
                setKey(key);
                int value = Integer.parseInt(key);
                value++;
                setNextKey("" + value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                setKey("Error");
            }
        });
        test.addListenerForSingleValueEvent(valueEvent);
    }

    private void setKey(String key){nextIndex = key;}
    private void setNextKey(String key){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("Admin").child("count").child("current").setValue(key);
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

package schedulink.schedulink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alamkanak.weekview.WeekViewEvent;

import java.util.Calendar;

public class AddEvent extends AppCompatActivity {
    private EditText eventName;
    private EditText eventDescription;
    private EditText eventTime;
    private EditText eventDate;
    private Global global;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String timeString;

        int month = 0;
        int year = 0;
        int date = 0;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                timeString = null;
            } else {
                timeString = extras.getString("Time");
                month = extras.getInt("Month");
                year = extras.getInt("Year");
                date = extras.getInt("Day");
            }
        } else {
            timeString = (String) savedInstanceState.getSerializable("Time");
        }


        eventName = (EditText) findViewById(R.id.editText2);
        eventDescription = (EditText) findViewById(R.id.editText3);
        eventTime = (EditText) findViewById(R.id.editText);

        String[] timeList = timeString.split(":");
        if(Integer.parseInt(timeList[1]) < 15){timeList[1] = "00";}
        else{timeList[1] = "30";}
        timeString = timeList[0] + ":" + timeList[1];

        eventTime.setText(timeString);
        eventDate = (EditText) findViewById(R.id.editText4);
        eventDate.setText(date + "/" + month + "/" + year);

        Button addEvent = (Button) findViewById(R.id.createEvent);
        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createEvent();
                startActivity(new Intent(AddEvent.this, SchedulinkViewerActivity.class));
            }
        });

        Button goBack = (Button) findViewById(R.id.back_button);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddEvent.this, SchedulinkViewerActivity.class));
            }
        });
    }

    private void createEvent(){
        global=((Global)getApplicationContext());
        String fullDate = eventDate.getText().toString();
        String[] newDate = fullDate.split("/");
        String fullTime = eventTime.getText().toString();
        String[] newTime = fullTime.split(":");

        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(newTime[0]));
        startTime.set(Calendar.MINUTE, Integer.parseInt(newTime[1]));
        startTime.set(Calendar.DAY_OF_MONTH, Integer.parseInt(newDate[0]));
        startTime.set(Calendar.MONTH, Integer.parseInt(newDate[1]));
        startTime.set(Calendar.YEAR, Integer.parseInt(newDate[2]));
        Calendar endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 1);
        WeekViewEvent event = new WeekViewEvent(1, eventName.getText().toString(), startTime, endTime);
        event.setLocation(eventDescription.getText().toString());
        event.setColor(-477870);

        global.getUser();

        global.addEventToSched(event);
    }

}

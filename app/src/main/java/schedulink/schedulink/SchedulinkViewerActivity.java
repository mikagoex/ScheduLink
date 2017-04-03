package schedulink.schedulink;

import android.content.Intent;

import com.alamkanak.weekview.WeekViewEvent;

import java.util.List;

/**
 * A basic example of how to use week view library.
 * Created by Raquib-ul-Alam Kanak on 1/3/2014.
 * Website: http://alamkanak.github.io
 */
public class SchedulinkViewerActivity extends BaseActivity {

    private Global global;

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        // Populate the week view with some events.
        //Schedulink testSched = new Schedulink();
            global = ((Global) getApplicationContext());
            global.setTime(newMonth, newYear);
            return global.getSched().getEventList(newMonth);
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(SchedulinkViewerActivity.this, MainPageActivity.class));
    }

}

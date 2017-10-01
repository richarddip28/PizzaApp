package richard.dip;

import android.os.CountDownTimer;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Confirmation_Screen extends AppCompatActivity {

    TextView currentTime, guarenteedTime, countdown;
    SimpleDateFormat df;
    Calendar now, then;

    public void setTime(){


        currentTime = (TextView) findViewById(R.id.current_time);
        guarenteedTime = (TextView) findViewById(R.id.guarenteedtime);
        countdown = (TextView) findViewById(R.id.countdown);
        df = new SimpleDateFormat("hh:mm aa");

        now = Calendar.getInstance();
        then = Calendar.getInstance();
        then.add(Calendar.MINUTE, 30);


        currentTime.setText(df.format(now.getTime()));
        guarenteedTime.setText(df.format(then.getTime()));

        new CountDownTimer(1800000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                countdown.setText(""+String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                countdown.setText("done!");
            }
        }.start();



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation__screen);

        setTime();
    }
}

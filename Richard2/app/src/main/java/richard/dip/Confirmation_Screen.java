package richard.dip;

import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static android.R.attr.digits;
import static android.R.attr.order;

public class Confirmation_Screen extends AppCompatActivity {

    TextView currentTime, guarenteedTime, countdown, orderNumber;
    SimpleDateFormat df;
    Calendar now, then;
    Intent launch;
    Uri uri;

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

    public int getOrderNumber(){

        int max = (int) Math.pow(10,8) - 1;
        int min = (int) Math.pow(10,7);
        int range = max-min;
        Random r = new Random();
        int x = r.nextInt(range);
        int sendOrderNumber = x+min;
        return sendOrderNumber;

    }

    public void setOrderNumber(){

        orderNumber = (TextView) findViewById(R.id.order_final);
        orderNumber.setText(String.valueOf("#"+getOrderNumber()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation__screen);

        setTime();
        setOrderNumber();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){
            case R.id.help_click:
                uri = Uri.parse("https://github.com/richarddip28");
                launch = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(launch);
                return true;
            case R.id.dominos_click:
                uri = Uri.parse("https://www.dominos.ca/");
                launch = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(launch);
                return true;
            case R.id.richard_click:
                launch = new Intent();
                launch.setClassName("com.android.calculator2",
                        "com.android.calculator2.Calculator");
                startActivity(launch);
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }//end switch
    }//end onOptionsItemSelected
}

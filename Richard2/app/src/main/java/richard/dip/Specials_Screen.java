package richard.dip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Specials_Screen extends AppCompatActivity {

    ImageButton ibutton;
    Button button;
    Intent intent;

    public void toOrderScreen(View v){

        intent = new Intent(this, Order_Screen.class);
        startActivity(intent);
    }

    public void toDetailsScreen(View v){

        intent = new Intent(this, Details_Screen.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specials__screen);
    }
}

package richard.dip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Richard extends AppCompatActivity {

    Intent intent;

    public void nextButton(View v){

        intent = new Intent(this, Specials_Screen.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_richard);
    }
}

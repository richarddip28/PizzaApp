package richard.dip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Specials_Screen extends AppCompatActivity {

    Intent intent;
    double price;

    public void toOrderScreen(View v){

        intent = new Intent(this, Order_Screen.class);
        startActivity(intent);

    }

    public void toDetailsScreen(View v){

        intent = new Intent(this, Details_Screen.class);
        price = 14.99;


        intent.putExtra("sizeofpizza",getString(R.string.largepizza));
        intent.putExtra("doughofpizza",getString(R.string.whitedough));
        intent.putExtra("sauceofpizza",getString(R.string.tomatosauce));
        String[] list = {getString(R.string.pepperoni_topping), getString(R.string.chicken_topping),getString(R.string.tomatoes_topping), getString(R.string.basil_topping)};
        intent.putExtra("list",list);
        intent.putExtra("price", price);
        intent.putExtra("comments",getString(R.string.nocomment));
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specials__screen);
    }
}

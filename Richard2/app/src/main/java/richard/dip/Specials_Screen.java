package richard.dip;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Specials_Screen extends AppCompatActivity {

    Intent intent, launch;
    double price;
    Uri uri;

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

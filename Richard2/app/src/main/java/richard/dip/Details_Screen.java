package richard.dip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;

public class Details_Screen extends AppCompatActivity {

    String size_pizza,dough_pizza,sauce_pizza, comments;
    String[] list;
    TextView size, dough, sauce, topping_list, commentBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__screen);

        size_pizza = getIntent().getStringExtra("sizeofpizza");
        dough_pizza = getIntent().getStringExtra("doughofpizza");
        sauce_pizza = getIntent().getStringExtra("sauceofpizza");
        list = getIntent().getStringArrayExtra("list");
        comments = getIntent().getStringExtra("comments");

        size = (TextView) findViewById(R.id.size_of_pizza);
        dough = (TextView) findViewById(R.id.dough_of_pizza);
        sauce = (TextView) findViewById(R.id.sauce_of_pizza);
        topping_list = (TextView) findViewById(R.id.toppingList);
        commentBox = (TextView) findViewById(R.id.message_box);

        size.setText(size_pizza);
        dough.setText(dough_pizza);
        sauce.setText(sauce_pizza);
        topping_list.setText(Arrays.toString(list));
        commentBox.setText(comments);







    }
}

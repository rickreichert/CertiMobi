package projeto.certimobi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import projeto.certimobi.R;

public class Main extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LOG";
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt);
        txt.setOnClickListener(this);

        Intent it = new Intent(this, Login.class);
        startActivity(it);

    }


    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, Login.class);
        startActivity(it);
    }
}

package projeto.certimobi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;

import projeto.certimobi.R;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnEntrar = (Button) findViewById(R.id.entrarface);
        btnEntrar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, Menu.class);
        it.putExtra("vlr" , "foi");
        startActivity(it);
    }
}

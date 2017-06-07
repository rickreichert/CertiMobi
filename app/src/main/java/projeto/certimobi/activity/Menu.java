package projeto.certimobi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import projeto.certimobi.R;

public class Menu extends AppCompatActivity implements View.OnClickListener{

    private ImageButton btnPerfil, btnSimulado, btnStatus, btnOpcao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnPerfil   = (ImageButton) findViewById(R.id.btnPerfil);
        btnSimulado = (ImageButton) findViewById(R.id.btnSimulado);
        btnStatus   = (ImageButton) findViewById(R.id.btnStatus);
        btnOpcao    = (ImageButton) findViewById(R.id.btnOpcao);

        btnPerfil  .setOnClickListener(this);
        btnSimulado.setOnClickListener(this);
        btnStatus  .setOnClickListener(this);
        btnOpcao   .setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent it = null;

        switch (v.getId()) {
            case R.id.btnPerfil:
                it = new Intent(this, Perfil.class);
                startActivity(it);
                break;

            case R.id.btnSimulado:
                it = new Intent(this, Questao.class);
                startActivity(it);
                break;

            case R.id.btnStatus:
                it = new Intent(this, Login.class);
                startActivity(it);
                break;

            case R.id.btnOpcao:
                it = new Intent(this, Login.class);
                startActivity(it);
                break;
        }

    }
}

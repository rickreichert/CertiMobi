package projeto.certimobi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import projeto.certimobi.R;


public class Resultado extends AppCompatActivity implements View.OnClickListener{

    private Button btnConcluir;
    private TextView vlrAcerto, vlrErro, lblPorcento;
    private ProgressBar barraProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        btnConcluir   = (Button)      findViewById(R.id.btnConcluirFim);
        vlrAcerto     = (TextView)    findViewById(R.id.vlrAcertos);
        vlrErro       = (TextView)    findViewById(R.id.vlrErros);
        lblPorcento   = (TextView)    findViewById(R.id.porcento);
        barraProgress = (ProgressBar) findViewById(R.id.progressBar);

        btnConcluir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, Login.class);
        startActivity(it);
    }

}

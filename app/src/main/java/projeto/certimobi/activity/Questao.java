package projeto.certimobi.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import projeto.certimobi.R;
import projeto.certimobi.domain.QuestaoAlternativa;
import projeto.certimobi.util.QuestaoAPI;
import projeto.certimobi.util.QuestaoDes;
import projeto.certimobi.domain.Simulado;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Questao extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "LOG";
    private Button btnConfirmar;
    private TextView txtQuestao;
    private Simulado simulado;
    private RadioButton certo, errado;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao);

        simulado = new Simulado();

        progress = new ProgressDialog(this);
        progress.setMessage("Carregando Simulador");
        progress.show();

        Tarefa tarefa = new Tarefa();
        tarefa.execute(1);

        btnConfirmar = (Button)   findViewById(R.id.btnConfirmar);
        txtQuestao   = (TextView) findViewById(R.id.questao);
        certo        = (RadioButton) findViewById(R.id.certo);
        errado       = (RadioButton) findViewById(R.id.errado);

        btnConfirmar.setOnClickListener(this);

    }

    protected void onRestart(){
        super.onRestart();
        txtQuestao.setText(simulado.questoes.get(simulado.getPosi()).getDescricao());
        simulado.setPosi(
                simulado.getPosi() + 1
        );
    }

   @Override
    public void onClick(View v) {

       // switch (v.getId()) {
        //    case R.id.btnConfirmar:
        //        onRestart();
        //        break;

       // }
    }

    public Boolean verificaOpcao(){

        if (certo.isChecked()){
            return true;
        }else {
            return false;
        }
    }

    public void respostaQuestao(String r){

        Context contexto = getApplicationContext();
        int duracao = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(contexto, r,duracao);
        toast.show();

    }

    private class Tarefa extends AsyncTask<Integer, Void, Void> {


        @Override
        protected Void doInBackground(Integer... params) {

            Questao.this.progress.setMessage("Carregando Simulador...");

            Gson gson = new GsonBuilder().registerTypeAdapter(QuestaoAlternativa.class, new QuestaoDes()).create();

            Retrofit retrofit = new Retrofit
                    .Builder()
                    .baseUrl(QuestaoAPI.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            QuestaoAPI carAPI = retrofit.create(QuestaoAPI.class);

            Call<QuestaoAlternativa> callLuxury = carAPI.getLuxuryQuestao("CtrlLuxuryCar.php");

            callLuxury.enqueue(new Callback<QuestaoAlternativa>() {

                @Override
                public void onResponse(Call<QuestaoAlternativa> call, Response<QuestaoAlternativa> response) {
                    simulado.questoes = (List<QuestaoAlternativa>) response.body();
                    testeValor(simulado.questoes);
                }

                @Override
                public void onFailure(Call<QuestaoAlternativa> call, Throwable t) {
                    Log.e(TAG, "ERRO ---> "+ t.getMessage());
                    Context contexto = getApplicationContext();
                    int duracao = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(contexto,"Erro de Conexão",duracao);
                    toast.show();
                    finish();
                }
            });

            return null;
        }

        private void testeValor(List<QuestaoAlternativa> list){
            if (list == null){
                testeValor(list);
                Log.e(TAG,"RECURso");

            }else{
                Questao.this.progress.setMessage("Simulado Carregado");
                Questao.this.progress.dismiss();
                txtQuestao.setText(simulado.questoes.get(0).getDescricao());
            }
        }
    }
}

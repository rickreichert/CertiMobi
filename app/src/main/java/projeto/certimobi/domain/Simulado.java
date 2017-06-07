package projeto.certimobi.domain;

import java.util.List;

public class Simulado{

    public List<QuestaoAlternativa> questoes;
    private Integer acertos, posi;
    private Integer quantQuestao;


    public Simulado(){
        this.questoes = null;
        this.acertos= new Integer(0);
        this.quantQuestao = new Integer(0);
        this.posi = new Integer(0);
    }

    public void addQuestao(QuestaoAlternativa q){
        questoes.add(q);
        quantQuestao++;
    }

    /*public void verificaQuestao(Boolean v){
        if (questoes.get(posi).verificaResposta(v)){
            return "Você Acertou !";
        }else{
            return "Você Errou !";
        }
    }*/

    public List<QuestaoAlternativa> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<QuestaoAlternativa> questoes) {
        this.questoes = questoes;
    }

    public Integer getAcertos() {
        return acertos;
    }

    public void setAcertos(Integer acertos) {
        this.acertos = acertos;
    }

    public Integer getPosi() {
        return posi;
    }

    public void setPosi(Integer posi) {
        this.posi = posi;
    }

    public Integer getQuantQuestao() {
        return quantQuestao;
    }

    public void setQuantQuestao(Integer quantQuestao) {
        this.quantQuestao = quantQuestao;
    }
}

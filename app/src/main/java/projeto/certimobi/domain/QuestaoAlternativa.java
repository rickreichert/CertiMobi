package projeto.certimobi.domain;

public class QuestaoAlternativa{

    private int    id_alter;
    private int    id_quest;
    private int    id_colab;
    private int    id_cert;
    private String dificuldade;
    private int    pontos;
    private String descricao;


    public QuestaoAlternativa() {
    }

    public QuestaoAlternativa(int id_alter, int id_quest, int id_colab, int id_cert, String dificuldade, int pontos, String descricao){

        this.id_alter    = id_alter;
        this.id_quest    = id_quest;
        this.id_colab    = id_colab;
        this.id_cert     = id_cert;
        this.dificuldade = dificuldade;
        this.pontos      = pontos;
        this.descricao   = descricao;
    }

    public void setId_alter(int id_alter) {
        this.id_alter = id_alter;
    }

    public int getId_alter() { return id_alter; }

    public int getId_quest() {
        return id_quest;
    }

    public void setId_quest(int id_quest) {
        this.id_quest = id_quest;
    }

    public int getId_colab() {
        return id_colab;
    }

    public void setId_colab(int id_colab) {
        this.id_colab = id_colab;
    }

    public int getId_cert() {
        return id_cert;
    }

    public void setId_cert(int id_cert) {
        this.id_cert = id_cert;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
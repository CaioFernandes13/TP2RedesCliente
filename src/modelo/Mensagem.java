package modelo;

public class Mensagem {

    private String id;
    private String po;
    private String p2;
    private String gr;
    private String gp;
    private String fr;
    private String fp;
    private String p1;
    private String ne;
    private String Letra;

    /*
    formato de mensagem do Servidor para jogadores
    
    id : id do jogador da vez de jogar
    po : palavra oculta
    gr : ganhador da rodada 1 - player 1, 2 - player 2, 3 - empate, 0 ainda não acabou a rodada
    gp : ganhador da partida 1 - player 1, 2 - player 2, 3 - empate, 0 ainda não acabou a partida
    fr : fim da rodada
    fp : fim da partida
    p1 : pontuação jogador 1
    p2 : pontuação jogador 2
    ne : número de erros
    
    intercalodos pelo sinal de +
    id+po+gr+gp+fr+fp+p1+p2+ne
    
    foramto de mendagem dos jogadores pro servidor
     */
    public void decodificarMensagem(String msg) {
        String[] entrada = new String[10];
        entrada   = msg.split(" ");
        this.id = entrada[0];
        this.po = entrada[1];
        this.gr = entrada[2];
        this.gp = entrada[3];
        this.fr = entrada[4];
        this.fp = entrada[5];
        this.p1 = entrada[6];
        this.p2 = entrada[7];
        this.ne = entrada[8];
        this.Letra = entrada[9];
    }

    public String codificarMensagem(int id, String po, int gr, int gp, int fr, int fp, int p1, int p2, int ne, String letra) {
        this.id = String.valueOf(id);
        this.po = po;
        this.gr = String.valueOf(gr);
        this.gp = String.valueOf(gp);
        this.fr = String.valueOf(fr);
        this.fp = String.valueOf(fp);
        this.p1 = String.valueOf(p1);
        this.p2 = String.valueOf(p2);
        this.ne = String.valueOf(ne);
        this.Letra = letra;
        String codigo = " ";
        return id + codigo + po + codigo + gr + codigo + gp + codigo
                + fr + codigo + fp + codigo + p1 + codigo + p2 + codigo + ne + codigo + letra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    public String getGr() {
        return gr;
    }

    public void setGr(String gr) {
        this.gr = gr;
    }

    public String getGp() {
        return gp;
    }

    public void setGp(String gp) {
        this.gp = gp;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getFp() {
        return fp;
    }

    public void setFp(String fp) {
        this.fp = fp;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getNe() {
        return ne;
    }

    public void setNe(String ne) {
        this.ne = ne;
    }

    public String getLetra() {
        return Letra;
    }

    public void setLetra(String Letra) {
        this.Letra = Letra;
    }

}

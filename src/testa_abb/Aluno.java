// Ledón, 2016-2020.

package testa_abb;

public class Aluno implements Comparable<Aluno> {
    private String rgm, nome;
    private char sexo;
    private float media;

    public Aluno(String rgm, String nome, char sexo, float media) {
        this.rgm = rgm;
        this.nome = nome;
        this.sexo = sexo;
        this.media = media;
    }
    
    public String toString() {
        return rgm + " - " + nome + ", sexo: " + sexo + ", média: " + media;
    }

    public String getRgm() {
        return rgm;
    }

    public void setRgm(String rgm) {
        this.rgm = rgm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    @Override
    public int compareTo(Aluno outro) {  // comparamos os RGMs
        if(rgm.compareTo(outro.getRgm()) < 0)return -1;
        else if(rgm.compareTo(outro.getRgm()) == 0)return 0;
        else return  1;
    }
    
    /*
    @Override
    public int compareTo(Aluno outro) {  // nesta versão comparamos as médias
        if(media < outro.getMedia())return -1;
        else if(media == outro.getMedia())return 0;
        else return  1;
    }    
    */
    
}

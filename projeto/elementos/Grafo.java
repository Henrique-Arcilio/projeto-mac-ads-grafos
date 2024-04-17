package CriandoUmGrafo.projeto.elementos;

public class Grafo {
    private String nome;
    private int quantiaDeUsuarios;

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setQuantiaDeUsuarios(int quantia){
        quantiaDeUsuarios = quantia;
    }
    public int getQuantiaDeUsuarios(){
        return this.quantiaDeUsuarios;
    }
}

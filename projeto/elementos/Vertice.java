package CriandoUmGrafo.projeto.elementos;

import java.util.ArrayList;

public class Vertice {
    private String nome;
    private String senha;
    private ArrayList<Vertice> verticesIncidentes;

    public Vertice(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public ArrayList<Vertice> getVerticesIncidentes() {
        return verticesIncidentes;
    }
    public void setVerticesIncidentes(Vertice verticeIncidente) {
        this.verticesIncidentes.add(verticeIncidente);
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}

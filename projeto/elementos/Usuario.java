import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String senha;
    private ArrayList<Usuario>listaDeAmigos;

    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(){
        this.nome = nome;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void adicionarAmigo(String nomeAdicionar){

    }

    public boolean verificarExistenciaDeAmigo(nome){
        
    }
}

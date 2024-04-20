import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String senha;
    private ArrayList<Usuario>listaDeAmigos;

    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
        this.listaDeAmigos = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void adicionarAmigo(String nomeAdicionar){

        if (verificarExistenciaDeUsuario(nomeAdicionar)){
        }

    }

    public boolean verificarExistenciaDeUsuario(String nome) {
        for (Usuario usuario : Rede.getUsuariosDaRede().keySet()) {
            if (nome.equals(usuario.getNome())) {
                return true;
            }
        }
        return false;
    }
    
}

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String senha;
    private ArrayList<Usuario> listaDeAmigos = new ArrayList<Usuario>();

    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
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
        if (!(verificarExistenciaDeUsuario(nomeAdicionar) && verificarExistenciaDeAmizade(nomeAdicionar))){
            for (Usuario usuario : Rede.getUsuariosDaRede().values()){
                if (usuario.getNome().equals(nomeAdicionar)){
                    this.listaDeAmigos.add(usuario);
                    System.out.println("Amigo adicionado!");
                }
            }
        }
    }

    public void excluirAmigo(String nomeRemover){
        if (verificarExistenciaDeUsuario(nomeRemover) && verificarExistenciaDeAmizade(nomeRemover) == false){

        }
    }

    public boolean verificarExistenciaDeAmizade(String nome){
        for(Usuario amigo : listaDeAmigos){
            if (amigo.getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }

    public boolean verificarExistenciaDeUsuario(String nome) {
        for (Usuario usuario : Rede.getUsuariosDaRede().values()) {
            if (nome.equals(usuario.getNome())) {
                return true;
            }
        }
        return false;
    }

}
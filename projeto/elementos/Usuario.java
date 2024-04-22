import java.util.ArrayList;
import java.util.HashMap;

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

    public ArrayList<Usuario> getListaDeAmigos(){
        return this.listaDeAmigos;
    }

    public void adicionarAmigo(String nomeAdicionar){
        if (!(verificarExistenciaDeAmizade(nomeAdicionar)) && verificarExistenciaDeUsuario(nomeAdicionar)){
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

    public ArrayList<Integer> listarAmigosPorIndex(){
        
        ArrayList<Integer> listaDeAmigosPorIndex = new ArrayList<Integer>();
        HashMap<Integer, Usuario> usuariosDaRede = Rede.getUsuariosDaRede();

        if(listaDeAmigos.size() > 0){
            for(Usuario amigo : listaDeAmigos){
                for(Integer index : usuariosDaRede.keySet()){
                    if(usuariosDaRede.get(index).equals(amigo)){
                        listaDeAmigosPorIndex.add(index);
                    }
                }
            }
        }
        return listaDeAmigosPorIndex;
    }
        
}
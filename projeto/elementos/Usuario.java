import java.util.ArrayList;
import java.util.Map;

public class Usuario {
    private static String nome;
    private String senha;
    private ArrayList<Usuario>listaDeAmigos;

    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
        this.listaDeAmigos = new ArrayList<>();
    }

    public static String getNome(){
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

    /**
     * @param nomeAdicionar
     */

    public void adicionarAmigo(String nomeAdicionar){

        if (verificarExistenciaDeAmigo(nomeAdicionar)){
            listaDeAmigos.add(String nomeAdicionar)
        }

    }

    public boolean verificarExistenciaDeAmigo(String nome) {
        for (Map.Entry<Usuario, Integer> entry : Rede.getUsuariosDaRede().entrySet()) {
            Usuario usuario = entry.getKey();
            if (nome.equals(usuario.getNome())) {
                return true;
            }
        }
        return false;
    }
      
}

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String senha;
    private Integer idUsuario;
    private ArrayList<Usuario> listaDeAmigos = new ArrayList<Usuario>();

    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }

    public void adicionarAmigo(String nomeAdicionar){
        if (!(verificarExistenciaDeAmizade(nomeAdicionar)) && verificarExistenciaDeUsuario(nomeAdicionar) != null){
            for (Usuario usuario : Rede.getUsuariosDaRede().values()){
                if (usuario.getNome().equals(nomeAdicionar)){
                    this.listaDeAmigos.add(usuario);
                }
            }
        }
    }

    public void excluirAmigo(String nomeRemover){
        Usuario usuarioExcluido = verificarExistenciaDeUsuario(nomeRemover);
        if (verificarExistenciaDeAmizade(nomeRemover) && usuarioExcluido != null ){
            for(Usuario usuario : this.listaDeAmigos){
                if(usuario.getNome().equals(usuarioExcluido.getNome())){
                    listaDeAmigos.remove(usuario);
                }
            }
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

    public Usuario verificarExistenciaDeUsuario(String nome) {
        for (Usuario usuario : Rede.getUsuariosDaRede().values()) {
            if (nome.equals(usuario.getNome())) {
                return usuario;
            }
        }
        return null;
    }
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
}
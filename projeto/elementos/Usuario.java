import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String senha;
    private Integer idUsuario;
    private ArrayList<Usuario> listaDeSeguindo = new ArrayList<Usuario>();

    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }

    public void seguirUsuario(String nome){
        if (!(isSeguido(nome)) && verificarExistenciaDeUsuario(nome) != null){
            for (Usuario usuario : Rede.getUsuariosDaRede().values()){
                if (usuario.getNome().equals(nome)){
                    this.listaDeSeguindo.add(usuario);
                    usuario.seguirUsuario(this.nome);
                }
            }
        }
    }

    public void pararDeSeguir(String nomeDoUsuario){
        Usuario usuarioSeguido = verificarExistenciaDeUsuario(nomeDoUsuario);
        if (isSeguido(nomeDoUsuario) && usuarioSeguido != null ){
            for(Usuario usuario : this.listaDeSeguindo){
                if(usuario.getNome().equals(usuarioSeguido.getNome())){
                    listaDeSeguindo.remove(usuario);
                }
            }
        }
    }

    public boolean isSeguido(String nomeDoUsuario){
        for(Usuario seguidor : listaDeSeguindo){
            if (seguidor.getNome().equals(nomeDoUsuario)){
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

    public ArrayList<Usuario> getListaDeSeguindo(){
        return this.listaDeSeguindo;
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Rede {
  
    private static HashMap<Integer, Usuario> usuariosDaRede = new HashMap<Integer, Usuario>();

    public static Usuario cadastrarUsuario() throws Exception{

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Digite seu novo nome de login: ");
            String nome = scanner.nextLine();

            if (nome.length() < 2 ||  nome.length() > 30){
                throw new Exception("Seu login deve ter de 2 à 30 caracteres");
            }

            if(usuariosDaRede.size() > 0){
                for(Usuario usuario : usuariosDaRede.values()){
                    if(usuario.getNome().equals(nome)){
                        throw new Exception(usuario.getNome() + " já existe, tente novamente");
                    }
                }
            }

            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            if((senha.length() < 8 ||  senha.length() > 30)){
                throw new Exception("A senha precisa ter de 8 à 30 caracteres");
            }

            Usuario usuario = new Usuario(nome, senha);
            Integer idUsuario = usuariosDaRede.size();
            usuario.setIdUsuario(idUsuario);
            usuariosDaRede.put(idUsuario, usuario);

            System.out.println("Seu cadrasto foi criado com sucesso");
            return usuario;
        }
    }

    public static Usuario validarLogin(String nome, String senha){
        for(Usuario usuario : usuariosDaRede.values()){
            if(usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)){
                return usuario;
            }
        }
        return null;
    }

    public static HashMap<String, Integer> recomendarAmigos(Usuario usuario){

        int[][] matriz = MatrizAdjacencia.criarMatriz();
        Integer idUsuarioAlvo = usuario.getIdUsuario();
        HashMap<String, Integer> AmigosRecomendaveis = new HashMap<String, Integer>();

        int numAmigosComuns = 0;    
        
        for(int i = 0; i < matriz.length; i++){

            if(idUsuarioAlvo != null && matriz[i][idUsuarioAlvo] == 0 && i != idUsuarioAlvo){

               Usuario usuarioNaoAmigo = usuariosDaRede.get(i);
               ArrayList<Usuario> listaDeAmigosDoOutro = usuarioNaoAmigo.getListaDeAmigos();

               if(listaDeAmigosDoOutro.size() > 0){
                    for(Usuario amigo : listaDeAmigosDoOutro){
                            if(matriz[amigo.getIdUsuario()][idUsuarioAlvo] == 1){
                                numAmigosComuns += 1;
                            }
                    } 
                    AmigosRecomendaveis.put(usuarioNaoAmigo.getNome(), numAmigosComuns);
                    numAmigosComuns = 0;
                }
            }
        }
        return AmigosRecomendaveis;
    }

    public static HashMap<Integer, Usuario> getUsuariosDaRede() {
        return usuariosDaRede;
    }
}
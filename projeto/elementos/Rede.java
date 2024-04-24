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
                Exception NomeInvalido = new Exception("Seu login deve ter de 2 à 30 caracteres");
                throw NomeInvalido;
            }

            if(usuariosDaRede.size() > 0){
                for(Usuario usuario : usuariosDaRede.values()){
                    if(usuario.getNome().equals(nome)){
                        Exception NomeExistente = new Exception(usuario.getNome() + " já existe, tente novamente");
                        throw NomeExistente;
                    }
                }
            }

            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            if((senha.length() < 8 ||  senha.length() > 30)){
                Exception SenhaInvalida = new Exception("A senha precisa ter de 8 à 30 caracteres");
                throw SenhaInvalida;
            }

            Usuario usuario = new Usuario(nome, senha);
            usuariosDaRede.put(usuariosDaRede.size(), usuario);

            System.out.println("Seu cadrasto foi criado com sucesso");
            return usuario;
        }
    }

    public static boolean validarLogin(String nome, String senha){
        for(Usuario usuario : usuariosDaRede.values()){
            if(usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)){
                    return true;
                }
        }
        return false;
    }

    public static HashMap<String, Integer> recomendarAmigos(Usuario usuario){

        int[][] matriz = MatrizAdjacencia.criarMatriz();
        Integer indexUsuarioAlvo = null;

        HashMap<String, Integer> AmigosRecomendaveis = new HashMap<String, Integer>();
        for (int index : usuariosDaRede.keySet()){
            if(usuario.equals(usuariosDaRede.get(index))){
                indexUsuarioAlvo = index;
                break;
            }
         
        }
        int numAmigosComuns = 0;    
        for(int i = 0; i < matriz.length; i++){

            if(indexUsuarioAlvo != null && matriz[i][indexUsuarioAlvo] == 0 && i != indexUsuarioAlvo){

               Usuario usuarioNaoAmigo = usuariosDaRede.get(i);

               ArrayList<Integer> listaDeAmigosDoOutro = usuarioNaoAmigo.listarAmigosPorIndex();

               if(listaDeAmigosDoOutro.size() > 0){
                    for(Integer index : listaDeAmigosDoOutro){
                            if(matriz[index][indexUsuarioAlvo] == 1){
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
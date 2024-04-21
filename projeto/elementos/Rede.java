import java.util.HashMap;
import java.util.Scanner;

public class Rede {
  
    private static HashMap<Usuario, Integer> usuariosDaRede = new HashMap<Usuario, Integer>();

    public static void cadastrarUsuario() throws Exception{
        
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Digite seu novo nome de login: ");
            String nome = scanner.nextLine();

            if (nome.length() < 2 ||  nome.length() > 30){
                Exception NomeInvalido = new Exception("Seu login deve ter de 2 à 30 caracteres");
                throw NomeInvalido;
            }

            if(usuariosDaRede.size() > 0){
                for(Usuario usuario : usuariosDaRede.keySet()){
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
            usuariosDaRede.put(usuario, usuariosDaRede.size());

            System.out.println("Seu cadrasto foi criado com sucesso");
            break;
        }
    }

    public static boolean validarLogin(String nome, String senha){
        for(Usuario usuario : usuariosDaRede.keySet()){
            if(usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)){
                    return true;
                }
        }
        return false;
    }

    public static void recomendarAmigos(){

    }

    public static HashMap<Usuario, Integer> getUsuariosDaRede() {
        return usuariosDaRede;
    }
}
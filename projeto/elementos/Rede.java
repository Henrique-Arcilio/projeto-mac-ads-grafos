import java.util.HashMap;
import java.util.Scanner;

public class Rede {
  
    private static HashMap<Usuario, Integer> usuariosDaRede = new HashMap<Usuario, Integer>();

    public void cadastrarUsuario() throws Exception{
        
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Digite seu novo nome de login: ");
            String nome = scanner.nextLine();

            if (nome.equals("") ||  nome == null){
                Exception NomeInvalido = new Exception("Você deve digitar um nome válido.");
                throw NomeInvalido;
            }

            if(usuariosDaRede.size() > 0){
                for(Usuario usuario : usuariosDaRede.keySet()){
                    if(usuario.getNome().equals(nome)){
                        System.out.printf("Usuário %s já existe. Tente novamente.", usuario.getNome());
                        Exception NomeExistente = new Exception("Nome já existe");
                        throw NomeExistente;
                    }
                }
            }
            
            System.out.print("Digite sua senha: ");
            String senha = scanner.next();

            Usuario usuario = new Usuario(nome, senha);
            usuariosDaRede.put(usuario, usuariosDaRede.size());
            System.out.println("Seu cadrasto foi criado com sucesso");
            break;
        }
    

    }

    public boolean validarLogin(String nome, String senha){
        for(Usuario usuario : usuariosDaRede.keySet()){
            if(usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)){
                    return true;
                }
        }
        return false;
    }

    public void recomendarAmigos(){

    }

    public static HashMap<Usuario, Integer> getUsuariosDaRede() {
    return usuariosDaRede;
    }
}
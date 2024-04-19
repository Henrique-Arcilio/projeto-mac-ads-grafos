import java.util.HashMap;
import java.util.Scanner;

public class Rede {
  
    private HashMap<Usuario, Integer> usuariosDaRede = new HashMap<Usuario, Integer>();

    public void cadastarUsuario() throws Exception{
        
        Scanner scanner = new Scanner(System.in);
        boolean valido = false;

        while(valido == false)
            System.out.print("Digite seu novo nome de login: ");
            String nome = scanner.nextLine();

            if ("".equals(nome) ||  nome == null){
                Exception NomeInvalido = new Exception("Você deve digitar um nome válido.");
                throw NomeInvalido;
            }

            if(usuariosDaRede.size() > 0){
                for(Usuario usuario : usuariosDaRede.keySet()){
                    if(usuario.getNome().equals(nome)){
                        System.out.printf("Usuário %s já existe. Tente novamente.", usuario.getNome());
                        break;
                    }
                }
            }
            valido = true;
    
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        
        Usuario usuario = new Usuario(nome, senha);
        usuariosDaRede.put(usuario, usuariosDaRede.size());

        System.out.println("Seu cadrasto foi criado com sucesso");
        scanner.close();
    }

    public void fazerLoginDoUsuario(){

    }

    public void recomendarAmigos(){

    }
}
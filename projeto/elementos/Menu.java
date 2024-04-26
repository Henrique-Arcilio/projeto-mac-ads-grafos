import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    public void run(Usuario usuario){
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            mostrarMenu();
            String nome;
            escolha = scanner.nextInt();

            switch (escolha) {
                case 0:
                    mostrarMenuInicial();
                    break;
                case 1:
                    System.out.println("--- Adicionar amigo ---");
                    System.out.print("Digite o nome para adicionar: ");
                    nome = scanner.next();
                    usuario.adicionarAmigo(nome);
                    break;
                case 2:
                    System.out.println("--- Remover amigo ---");
                    System.out.print("Digite o nome do amigo que você deseja remover: ");
                    nome = scanner.next();
                    usuario.excluirAmigo(nome);
                    break;
                case 3:

                    System.out.println("--- Amigos Recomendados ---");

                    HashMap<String, Integer> listaDeRecomendados = Rede.recomendarAmigos(usuario);
                    for (Map.Entry<String, Integer> entry : listaDeRecomendados.entrySet()) {
                        String amigo = entry.getKey();
                        Integer amigosEmComum = entry.getValue();
                        System.out.println("Amigo: " + amigo + ", Quantidade de amigos em comum: " + amigosEmComum);
                    }

                    break;
                case 4:
                    System.out.println("--- Lista de Amigos ---");
                    ArrayList<Usuario> listaDeAmigos = usuario.getListaDeAmigos();
                    for (Usuario usuarioMostrar : listaDeAmigos) {
                        System.out.println(usuarioMostrar.getNome());
                    }
                    System.out.println();
                    break;
            }
        } while (escolha != 0);

        scanner.close();
    }

    public void mostrarMenu(){

        System.out.println("""
            ---- Menu ----
            0- Sair
            1- Adicionar amigo
            2- Remover amigo
            3- Recomendar amigo
            4- Exibir lista de amigos
            5- Conversar com amigo
            Digite o numero correspondente a sua escolha: """);
    }

    public static void mostrarMenuInicial(){
        Scanner scanner = new Scanner(System.in);
        int escolha;
        String login, senha;

        System.out.print("""
            ---- Bem vindo(a)! ----
            1- Logar com uma conta ja existente"
            2- Cadastrar uma nova conta
            Digite o numero correspondente a sua escolha: """);

        escolha = scanner.nextInt();
    
        switch (escolha) {
            case 1:
                System.out.println("---- Logar ----");
                System.out.println("Digite seu nome de usuario: ");
                login = scanner.next();
                System.out.println("Digite a sua senha: ");
                senha = scanner.next();
                Usuario usuario = Rede.validarLogin(login, senha);
                
                if(usuario != null){
                    System.out.println("Seu cadastro foi criado.");
                    Menu menu = new Menu();
                    menu.run(usuario);
                } else {
                    mostrarMenuInicial();}
                break;
            case 2:
                while (true) {
                    try {
                        Usuario usuarioCadastrar = Rede.cadastrarUsuario();
                        Menu menu = new Menu();
                        menu.run(usuarioCadastrar);
                        break;
                    } catch (Exception e) {
                        System.out.println("Ocorreu um erro ao cadastrar o usuário: " + e.getMessage());
                        
                    }
                }
                
                break;
            default:
                mostrarMenuInicial();
                break;
        }
    }
}

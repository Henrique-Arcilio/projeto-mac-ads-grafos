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
                case 1:
                    System.out.println("--- Adicionar amigo ---");
                    System.out.println("Digite o nome para adicionar: ");
                    nome = scanner.next();
                    usuario.adicionarAmigo(nome);
                    break;
                case 2:
                    System.out.println("--- Remover amigo ---");
                    System.out.println("Digite o nome do amigo que você deseja remover: ");
                    nome = scanner.nextLine();
                    usuario.excluirAmigo(nome);
                    break;
                case 3:
                    System.out.println("--- Recomendar amigo ---");
                    HashMap<String, Integer> listaDeRecomendados = Rede.recomendarAmigos(usuario);
                    for (Map.Entry<String, Integer> entry : listaDeRecomendados.entrySet()) {
                        String amigo = entry.getKey();
                        Integer amigosEmComum = entry.getValue();
                        System.out.println("Amigo: " + amigo + ", Quantidade de amigos em comum: " + amigosEmComum);
                    }

                    break;
                case 4:
                    System.out.println("--- Exibir lista de amigos ---");
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
        System.out.println("---- Menu ----");
        System.out.println("0- Sair"); // quando ele sair, tem que ir para a tela de login / cadastrar
        System.out.println("1- Adicionar amigo");
        System.out.println("2- Remover amigo");
        System.out.println("3- Recomendar amigo");
        System.out.println("4- Exibir lista de amigos");
        System.out.println("5- Conversar com amigo");
        System.out.print("Digite o numero correspondente a sua escolha: ");
    }

    public static void mostrarMenuInicial(){
        Scanner scanner = new Scanner(System.in);
        int escolhaLogin;
        String login;
        String senha;

        System.out.println("---- Bem vindo(a)! ----");
        System.out.println("1- Logar com uma conta ja existente");
        System.out.println("2- Cadastrar uma nova conta");
        System.out.println();
        System.out.print("Digite o numero correspondente a sua escolha: ");
        escolhaLogin = scanner.nextInt();
    
        switch (escolhaLogin) {
            case 1:
                System.out.println("---- Logar ----");
                System.out.println("Digite seu nome de usuario: ");
                login = scanner.next();
                System.out.println("Digite a sua senha: ");
                senha = scanner.next();
                Usuario usuario = Rede.validarLogin(login, senha);
                
                if(usuario != null){
                    Menu menu = new Menu();
                    menu.run(usuario);
                } else {mostrarMenuInicial();}
                break;
            case 2:
                try {
                    Usuario usuarioCadastrar = Rede.cadastrarUsuario();
                    Menu menu = new Menu();
                    menu.run(usuarioCadastrar);
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro ao cadastrar o usuário: " + e.getMessage());
                }
                break;
            default:
                mostrarMenuInicial();
                break;
        }
    }
}

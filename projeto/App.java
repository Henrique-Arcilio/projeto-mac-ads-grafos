import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        try {
            MatrizAdjacencia matriz = new MatrizAdjacencia();
            Rede.cadastrarUsuario();
            System.out.println(Rede.getUsuariosDaRede().entrySet());
            Rede.cadastrarUsuario();
            System.out.println(Rede.getUsuariosDaRede().entrySet());
            Rede.cadastrarUsuario();
            System.out.println(Rede.getUsuariosDaRede().entrySet());
            Rede.cadastrarUsuario();
            System.out.println(Rede.getUsuariosDaRede().entrySet());
            Rede.cadastrarUsuario();
            System.out.println(Rede.getUsuariosDaRede().entrySet());
            Rede.cadastrarUsuario();
            System.out.println(Rede.getUsuariosDaRede().entrySet());

            Rede.getUsuariosDaRede().get(0).adicionarAmigo("jonas");
            Rede.getUsuariosDaRede().get(0).adicionarAmigo("kleber");
            Rede.getUsuariosDaRede().get(0).adicionarAmigo("chico");
            Rede.getUsuariosDaRede().get(1).adicionarAmigo("jonas");
            Rede.getUsuariosDaRede().get(1).adicionarAmigo("kleber");
            Rede.getUsuariosDaRede().get(1).adicionarAmigo("chico");
            Rede.getUsuariosDaRede().get(5).adicionarAmigo("kleber");
            Usuario user = Rede.getUsuariosDaRede().get(0);
            System.out.println(Rede.recomendarAmigos(user));

            int [][] matriza = matriz.criarMatriz();
            for (int i = 0; i < matriza.length; i++) {
                for (int j = 0; j < matriza[i].length; j++) {
                    System.out.print(matriza[i][j] + " ");
                }
                System.out.println(); // Pula para a próxima linha após imprimir uma linha completa
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
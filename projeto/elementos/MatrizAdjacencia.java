import java.util.HashMap;

public class MatrizAdjacencia {

    public static int[][] criarMatriz(){
        
        HashMap<Integer, Usuario> listaUsuarios = Rede.getUsuariosDaRede();
        int quantia = listaUsuarios.size();
        int[][] matriz = new int[quantia][quantia];

        for(int i = 0; i < quantia; i++){
            for(int j = 0; j < quantia; j++){
                Usuario usuario = listaUsuarios.get(i);
                Usuario amigo = listaUsuarios.get(j);
                if((usuario.verificarExistenciaDeAmizade(amigo.getNome()))){
                    matriz[j][i] = 1;
                }
                else{
                    matriz[j][i] = 0;
                } 
            }
        }
        return matriz;
    }
}
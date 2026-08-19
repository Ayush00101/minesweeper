import java.util.Arrays;

public class flood_fill{
    public static int[][] two_d(int[] arr,int side){
        int row = side;
        int[][] array = new int[side][side];
        int var_counter = 0;

        for(int i = 0;i<side;i+=1){
            for(int j = 0;j<side;j+=1){
                array[i][j] = arr[var_counter];
                var_counter+=1;
            }
        }
        return array;
    }

    public static int[] one_d(int[][] arr,int side){
        int row = side;
        int[] array = new int[side*side];
        int var_counter = 0;

        for(int i = 0;i<side;i+=1){
            for(int j = 0;j<side;j+=1){
                array[var_counter] = arr[i][j];
                var_counter+=1;
            }
        }
        return array;
    }

    public static int[][] flood(int x,int y,int side,int[][] array){
        if(array[x][y]==0){
            dfs(x, y, side, array);
        }
        return array;
    }

    private static void dfs(int x,int y,int side,int[][] array){
        if(x<0 || y >= side || y < 0 || x >= side || array[x][y] != 0){
            return;
        }

        array[x][y] = 100;

        dfs(x-1, y, side, array);
        dfs(x+1, y, side, array);
        dfs(x,y+1, side, array);
        dfs(x, y-1, side, array);
        
    }
    public static void main(){
        int[] plot = fisher_yates.first(9);
        int[][] board2d = two_d(plot, 9);

        flood(0, 8, 9, board2d);
        int[] board = one_d(board2d, 9);
        System.err.println(Arrays.toString(board));

    }
}
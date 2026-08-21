import java.util.*;

public class flood_fill{
    public static int[][] two_d(int[] arr,int side){
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
        if(x < 0 || y >= side || y < 0 || x >= side || array[x][y] != 0){
            return;
        }

       array[x][y] = 9;

        dfs(x-1, y, side, array);
        dfs(x+1, y, side, array);
        dfs(x,y+1, side, array);
        dfs(x, y-1, side, array);
    }

    // public static void main(){

    //     int[] boards = fisher_yates.first(10);
    //     int[][] board2d = board.current_element_mines(boards);

    //     System.out.println();

    //     for(int i = 0;i<10;i+=1){
    //         for(int j = 0;j<10;j+=1){
    //             if(j==0){
    //                 System.out.printf("%d ",i);
    //             }
    //             if(board2d[i][j] == -1){
    //                 System.out.printf("[b] ");
    //             }
    //             else{
    //                 System.out.printf("[%d] ",board2d[i][j]);
    //             }
    //         }
    //     System.out.println();
    //     }

    //     Scanner sc = new Scanner(System.in);
    //     int x = sc.nextInt();
    //     int y = sc.nextInt();
    //     flood(x,y, 10, board2d);

    //     for(int i = 0;i<10;i+=1){
    //         for(int j = 0;j<10;j+=1){
    //             if(j==0){
    //                 System.out.printf("%d ",i);
    //             }
    //             if(board2d[i][j] == -1){
    //                 System.out.printf("[b] ");
    //             }
    //             else{
    //                 System.out.printf("[%d] ",board2d[i][j]);
    //             }
    //         }
    //     System.out.println();
    //     }


    // }
}
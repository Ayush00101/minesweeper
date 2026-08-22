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

    public static int seenElement(int x,int y,int size){
        int coords = (size*x)+y;
        return coords;
    }

    public static int[][] flood(int x,int y,int side,int[][] array,int[] seen){
        seen[seenElement(x, y, side)] = 1;
        if(array[x][y]==0){
            dfs(x, y, side, array,seen);
        }
        return array;
    }

    public static void adjacentSpaces(int[] seen,int i,int j){

        for(int r = -1;r<=1;r+=1){
            for(int c = -1;c<=1;c+=1){
                if(r == 0 && c == 0){
                    continue;
                }
                if(i+r >= 0 && j+c < 10 && j+c >= 0 && i+r < 10){
                    seen[seenElement(i+r, j+c, 10)] = 1;
                }
            }
        }
    }

    private static void dfs(int x,int y,int side,int[][] array,int[] seen){
        if(x < 0 || y >= side || y < 0 || x >= side || array[x][y] != 0){
            return;
        }

        array[x][y] = 9;
        seen[seenElement(x, y, side)] = 1;          //adding elements to the seen list
        adjacentSpaces(seen, x, y);

        dfs(x-1, y, side, array,seen);
        dfs(x+1, y, side, array,seen);
        dfs(x,y+1, side, array,seen);
        dfs(x, y-1, side, array,seen);
    }
}
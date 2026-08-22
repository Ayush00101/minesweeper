import java.util.*;

public class fisher_yates{                                              //Shuffles the first 10 mines into the whole array
    public static int[] shuffle_mines(int[] board){
        Random rand = new Random();
        int len = board.length;
        for(int i = len-1;i>=0;i-=1){
            int pos = rand.nextInt(i+1);
            int temp = board[i];
            board[i] = board[pos];
            board[pos] = temp;
        }
        return board;

    }

    public static int[] first(int side){
        int x = side;
        int y = side;
        int[] board = new int[x*y];
        int mine_counter=0;
        for(int i = 0;i<x*y;i+=1){
            if(mine_counter<10){
                board[i] = -1;
                mine_counter+=1;
            }
            else{
                board[i] = 0;
            }
        }
        return shuffle_mines(board);
    }

}
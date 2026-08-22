public class full_board {

    public static int[][] current_element_mines(){

        int[] board = fisher_yates.first(10);
        int[][] d2 = flood_fill.two_d(board, 10);

        for(int i = 0;i<10;i+=1){
            for(int j = 0;j<10;j+=1){
                if(d2[i][j] == -1){
                    continue;
                }
                int val = 0;
                for(int r = -1;r<=1;r+=1){
                    for(int c = -1;c<=1;c+=1){
                        if(r == 0 && c == 0){
                            continue;
                        }
                        if(i+r >= 0 && j+c < 10 && j+c >= 0 && i+r < 10){
                            if(d2[i+r][j+c] == -1){
                                val+=1;
                            }
                        }
                    }
                }
                d2[i][j] = val;
            }
        }
        return d2;
    }

}

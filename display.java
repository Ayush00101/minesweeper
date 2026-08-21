public class display {
    public static void show_coordinates(int side){

        int counter = 0;
        System.out.print("  ");
        for(int i = 0;i<(side*4)-2;i+=1){
            if((i-1)%4==0 || i-1 == 0){
                System.out.print(counter);
                counter+=1;
            }
            else{
                System.out.print(" ");
            }
        }

        System.out.println();
    }

    public static void gameEnd(int[] b,int side){
        System.out.print("\033[H\033[2J");       //Clears the screen
        System.out.flush();
        System.out.println("\n--------------Game Over--------------\n");
        show_coordinates(side);
        int[][] board = flood_fill.two_d(b, side);
        
        for(int i = 0;i<side;i+=1){
            for(int j = 0;j<side;j+=1){
                int val = board[i][j];
                if(j==0){
                    System.out.printf("%d ",i);
                }
                if(val == 0 || val == 9){
                    System.out.print("[ ] ");
                    continue;
                }
                if(val == -1){
                    System.out.print("[B] ");
                }
                else{
                    System.out.printf("[X] ");
                }
            }
            System.out.println();
        }
    }

    public static void show_board(int[] b,int side){

        System.out.println("\n--------------Minesweeper--------------\n");
        show_coordinates(side);
        int[][] board = flood_fill.two_d(b, side);
        
        for(int i = 0;i<side;i+=1){
            for(int j = 0;j<side;j+=1){

                int point = board[i][j];
                if(j==0){
                    System.out.printf("%d ",i);
                }
                if(point == 9){
                    System.out.print("[ ] ");
                }
                else{
                    if(point == 0 || point == -1){
                        System.out.printf("[X] ");
                    }
                    else{
                        System.out.printf("[%d] ",board[i][j]);
                    }
                }

            }
            System.out.println();
        }
    }
}

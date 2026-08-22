public class display {
    
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";


    public static void show_coordinates(int side){

        int counter = 0;
        System.out.print("  ");
        for(int i = 0;i<(side*4)-2;i+=1){
            if((i-1)%4==0 || i-1 == 0){
                System.out.print(GREEN + counter + RESET);
                counter+=1;
            }
            else{
                System.out.print(" ");
            }
        }

        System.out.println();
    }

    public static void gameEnd(int[] b,int side,int[] seen){
        System.out.print("\033[H\033[2J");       //Clears the screen
        System.out.flush();
        System.out.println("\n" + RED + "--------------Game Over--------------" + RESET + "\n");
        show_coordinates(side);
        int[][] board = flood_fill.two_d(b, side);
        
        for(int i = 0;i<side;i+=1){
            for(int j = 0;j<side;j+=1){
                int val = board[i][j];
                if(j==0){
                    System.out.print(GREEN + i + RESET + " ");
                }
                if(val == 9 && seen[flood_fill.seenElement(i, j,side)] == 1){
                    System.out.print(CYAN + "[ ] " + RESET);
                    continue;
                }
                if(val == -1){
                    System.out.print(RED + "[B] " + RESET);
                    continue;
                }
                if(seen[flood_fill.seenElement(i, j,side)] == 1){
                    System.out.print(GREEN + "[" + board[i][j] + "] " + RESET);
                }
                else{
                    System.out.print(BLUE + "[X] " + RESET);
                }
            }
            System.out.println();
        }
    }

    public static void show_board(int[] b,int side,int[] seen){

        System.out.println("\n" + MAGENTA + "--------------Minesweeper--------------" + RESET + "\n");
        show_coordinates(side);
        int[][] board = flood_fill.two_d(b, side);
        
        for(int i = 0;i<side;i+=1){
            for(int j = 0;j<side;j+=1){

                int point = board[i][j];
                if(j==0){
                    System.out.print(GREEN + i + RESET + " ");
                }
                if(point == 9 && seen[flood_fill.seenElement(i, j, side)] == 1){
                    System.out.print(CYAN + "[ ] " + RESET);
                }
                else{
                    if(point == 0 || point == -1){
                        System.out.print(BLUE + "[X] " + RESET);
                    }
                    else if(seen[flood_fill.seenElement(i, j, side)] == 1){
                        System.out.print(GREEN + "[" + board[i][j] + "] " + RESET);
                    }
                    else{
                        System.out.print(BLUE + "[X] " + RESET);
                    }
                }

            }
            System.out.println();
        }
    }
}

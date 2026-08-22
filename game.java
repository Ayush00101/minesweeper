import java.util.*;

class generate_board{
    int x;
    int y;
    int[] board = new int[x*y];
    int[] seen = new int[x*y];
    
    void show_coordinates(int side){

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

    generate_board(int x,int y){
        System.out.println("\n" + "\u001B[35m" + "--------------Minesweeper--------------" + "\u001B[0m" + "\n");
        this.x = x;
        this.y = y;
        this.seen = new int[x*y];
        show_coordinates(x);  //Generates the y coodinates


        this.board = flood_fill.one_d(full_board.current_element_mines(),10);            //BOARD FINALLY DEFINED GLOBALLY WITH

        for(int i = 0;i<x;i+=1){
            for(int j = 0;j<y;j+=1){
                if(j==0){
                    System.out.printf("%d ",i);
                }
                System.out.printf("[X] ");
            }
        System.out.println();
        }

    }

    // void show_board(){
    //     for(int i = 0;i<x;i+=1){
    //         for(int j = 0;j<y;j+=1){
    //             System.out.print("[ ]");
    //         }
    //     System.out.println();
    //     }
    // }
}

class mineplay extends generate_board{
    mineplay(int x,int y){
        super(x, y);
    }

    void fisrtClick(int x,int y){
        
    }
}

class game{

    public static int isBomb(int x,int y,int[] board,int size){

        if(board[(size*x)+y] != 0){
            return 1;
        }
        return 0;
        
    }

    public static int[] reroll(int side,int x,int y){
        int[] board = flood_fill.one_d(full_board.current_element_mines(),10);
        // System.out.println("Bomb or number found\n" + Arrays.toString(board));
        int bomb = isBomb(x, y, board, 10);
        if(bomb == 1){
            // System.out.println("Bomb or number found\n" + Arrays.toString(board));
            return reroll(side, x, y);
        }
        return board;
    }
    
    public static int gameWon(int[] seen){
        int len = 0;
        for(int i : seen){
            if(i == 1){
                len += 1;
            }
        }
        return len;
    }

    public static void main(String[] args) throws InterruptedException{

        boolean game = true;
        generate_board b1 = new generate_board(10,10);   //Prints out the blank board for the first time only
        System.out.println();
        int total_valid_tiles = 90;
        int current_valid_tiles = 0;
        

        Scanner sc = new Scanner(System.in);  //Finding the first clicking coordinates

        System.out.print("Coordinates: ");
        String pos = sc.nextLine();
        String[] coords = pos.split(",");
        int x = Integer.parseInt(coords[0]);
        int y = Integer.parseInt(coords[1]);

        int bomb = isBomb(x, y, b1.board, 10);
        if(bomb == 1){
            b1.board = reroll(10, x, y);
        }

        int[][] box =  flood_fill.flood(x, y, 10, flood_fill.two_d(b1.board,10),b1.seen);
        b1.board = flood_fill.one_d(box, 10);

        System.out.print("\033[H\033[2J");       //Clears the screen
        System.out.flush();

        display.show_board(b1.board, 10,b1.seen);
        System.out.println();

        while(game && current_valid_tiles != total_valid_tiles){                                        //Playing the game in loop until the player clicks a mine
            System.out.print("\nCoordinates: ");
            pos = sc.nextLine();
            coords = pos.split(",");
            x = Integer.parseInt(coords[0]);
            y = Integer.parseInt(coords[1]);

            box =  flood_fill.flood(x, y, 10, flood_fill.two_d(b1.board,10),b1.seen);
            b1.board = flood_fill.one_d(box, 10);

            System.out.print("\033[H\033[2J");       //Clears the screen
            System.out.flush();

            if(b1.board[(10*x)+y] == -1){
                game = false;
                display.gameEnd(b1.board, 10,b1.seen);
                break;
            }
            if(gameWon(b1.seen) == total_valid_tiles){
                display.show_board(b1.board, 10,b1.seen);
                System.out.println("\nGame Finished!");
                break;
            }

            display.show_board(b1.board, 10,b1.seen);
            System.out.println();


            
        }

        sc.close();
    }
}
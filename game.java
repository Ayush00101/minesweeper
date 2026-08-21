import java.util.*;

class generate_board{
    int x;
    int y;
    int[] board = new int[x*y];
    
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
        System.out.println("\n----------Minesweeper----------\n");
        this.x = x;
        this.y = y;

        show_coordinates(x);  //Generates the y coodinates

        this.board = fisher_yates.first(x);            //BOARD FINALLY DEFINED GLOBALLY WITH

        for(int i = 0;i<x;i+=1){
            for(int j = 0;j<y;j+=1){
                if(j==0){
                    System.out.printf("%d ",i);
                }
                System.out.printf("[ ] ");
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
        int[] board = fisher_yates.first(side);
        if(isBomb(x, y, board, 10) == 1){
            reroll(side, x, y);
        }
        return board;
    }
    
    public static void main(String[] args) throws InterruptedException{

        boolean game = true;
        generate_board b1 = new generate_board(10,10);   //Prints out the blank board for the first time only
        System.out.println();
        int total_valid_tiles = 84;
        int current_valid_tiles = 0;
        

        Scanner sc = new Scanner(System.in);  //Finding the first clicking coordinates

        System.out.print("Coordinates: ");
        String pos = sc.nextLine();
        String[] coords = pos.split(",");
        int x = Integer.parseInt(coords[0]);
        int y = Integer.parseInt(coords[1]);

        int bomb = isBomb(x, y, b1.board, 10);

        if(bomb == 1){
            // System.out.println("Bomb found shuffling again");
            b1.board = reroll(10, x, y);
        }


        while(game && current_valid_tiles != total_valid_tiles){                                        //Playing the game in loop until the player clicks a mine
            System.out.print("Coordinates: ");
            pos = sc.nextLine();
            coords = pos.split(",");
        }

        sc.close();
    }
}
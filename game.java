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
                System.err.print(" ");
            }
        }

        System.err.println();
    }

    generate_board(int x,int y){
        System.err.println("\n----------Minesweeper----------\n");
        this.x = x;
        this.y = y;

        show_coordinates(x);  //Generates the y coodinates

        int[] board = fisher_yates.first(x);            //BOARD FINALLY DEFINED GLOBALLY WITH

        for(int i = 0;i<x;i+=1){
            for(int j = 0;j<y;j+=1){
                if(j==0){
                    System.err.printf("%d ",i);
                }
                System.err.print("[ ] ");
            }
        System.err.println();
        }
    }

    // void show_board(){
    //     for(int i = 0;i<x;i+=1){
    //         for(int j = 0;j<y;j+=1){
    //             System.err.print("[ ]");
    //         }
    //     System.err.println();
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
    public static void main(String[] args) throws InterruptedException{

        boolean game = true;
        generate_board b1 = new generate_board(9,9);   //Prints out the blank board for the first time only
        System.err.println();

        Scanner sc = new Scanner(System.in);  //Finding the first clicking coordinates
        System.out.print("Coordinates: ");
        String pos = sc.nextLine();
        String[] coords = pos.split(",");

        while(game){                                        //Playing the game in loop until the player clicks a mine
            System.out.print("Coordinates: ");
            pos = sc.nextLine();
            coords = pos.split(",");
        }
        sc.close();
    }
}
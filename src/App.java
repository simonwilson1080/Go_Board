import java.util.Scanner;

public class App {

    static String[][] board = new String[9][9];

    static void printGoBoard(String[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == null){
                    board[i][j] = "+";
                    System.out.print(" + ");
                }
                else if(board[i][j] == "o"){
                    System.out.print(" o ");
                }
                else if(board[i][j] == "@"){
                    System.out.print(" @ ");
                }
                else{
                    board[i][j] = "+";
                    System.out.print(" + ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        boolean playing = true;
        int turnCount = 0;
        Scanner scn = new Scanner(System.in);

        while(playing) {
            printGoBoard(board);
            System.out.print("Enter X coordinates:");
            int x = scn.nextInt();
            System.out.print("Enter Y coordinates:");
            int y = scn.nextInt();

            String temp = board[y][x];
            //ⵔ⬤⚪⚫

            if(turnCount % 2 == 0){
                switch (temp) { 
                case "+":
                    board[y-1][x-1] = "o";
                    turnCount++;
                    break;
                case "o":
                    System.out.print("Invalid Placement");
                    break;
                case "@":
                    System.out.print("Invalid Placement");
                    break;
                default:
                    break;
                }
            }
            else if(turnCount % 2 != 0) {
                switch (temp) { 
                case "+":
                    board[y-1][x-1] = "@";
                    turnCount++;
                    break;
                case "o":
                    System.out.print("Invalid Placement");
                    break;
                case "@":
                    System.out.print("Invalid Placement");
                    break;
                default:
                    break;
                }
            
            }
        
        }
        scn.close();
    }
}

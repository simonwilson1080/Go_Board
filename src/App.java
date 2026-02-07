/*********************************************************
 * Compilation: javac App.java
 * Execution:   java App.java
 * 
 * A simple GO Board
*********************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class App {

    static String[][] board = new String[9][9];
    static String[][] gui_board = {
        {null, null, null, null, null, null, null, null, null},
        {null, null, "O", "O", "O", null, null, null, null},
        {null, null, "O", "@", "O", null, null, null, null},
        {null, null, "O", "@", "O", null, null, null, null},
        {null, null, null, "O", null, "@", null, null, null},
        {null, null, null, null, null, "@", null, null, null},
        {null, null, null, null, null, "@", null, null, null},
        {null, null, null, null, null, "@", null, null, null},
        {null, null, null, null, null, null, null, null, null},
    };
    static int GAP = 30;
    static int MARGIN = 10;

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

    static void showUI(String[][] args) throws Exception {

        JFrame frame = new JFrame("Go");
        frame.setSize(GAP * gui_board.length, (GAP+2) * gui_board.length);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().setBackground("green");

        frame.add(new Component() {
            public void paint(Graphics g) {

                //Board
                g.setColor(Color.BLACK);
                for (int i = 0; i < gui_board.length; i++) {
                    g.drawLine(MARGIN, MARGIN + i * GAP, MARGIN + (gui_board.length-1) * GAP, MARGIN + i * GAP);
                    g.drawLine(MARGIN + i * GAP, MARGIN, MARGIN + i * GAP, MARGIN + (gui_board.length-1) * GAP);
                }

                //Stones
                for (int x = 0; x < gui_board.length; x++) {
                    for (int y = 0; y < gui_board.length; y++) {
                        if (gui_board[x][y] != null) {
                            g.setColor(gui_board[x][y] == "@" ? Color.BLACK : Color.WHITE);
                            g.fillOval(MARGIN + x * GAP - 12, MARGIN + y * GAP - 12, 24, 24);
                            g.setColor(Color.BLACK);
                            g.drawOval(MARGIN + x * GAP - 12, MARGIN + y * GAP - 12, 24, 24);
                        }
                    }
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {

        showUI(gui_board);

        boolean playing = true;
        boolean turn = true;
        Scanner scn = new Scanner(System.in);

        while(playing) {
            printGoBoard(board);
                if(turn == true) {
                    System.out.println("Whites Turn");
                }
                else if(turn == false) {
                    System.out.println("Blacks Turn");
                }
            System.out.print("Enter X coordinates:");
            int x = scn.nextInt();
            System.out.print("Enter Y coordinates:");
            int y = scn.nextInt();

            String temp = board[y-1][x-1];
            //ⵔ⬤⚪⚫

            if(turn == true) {
                switch (temp) { 
                case "+":
                    board[y-1][x-1] = "o";
                    turn = !turn;
                    break;
                case "o":
                    System.out.println("INVALID PLACEMENT - Try Again");
                    break;
                case "@":
                    System.out.println("INVALID PLACEMENT - Try Again");
                    break;
                default:
                    break;
                }
            }
            else if(turn == false) {
                switch (temp) { 
                case "+":
                    board[y-1][x-1] = "@";
                    turn = !turn;
                    break;
                case "o":
                    System.out.println("INVALID PLACEMENT - Try Again");
                    break;
                case "@":
                    System.out.println("INVALID PLACEMENT - Try Again");
                    break;
                default:
                    break;
                }
            
            }
        
        }
        scn.close();
    }
}

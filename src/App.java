/*********************************************************
 * Author: Simon Wilson
 * 
 * A simple GO Board
*********************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class App {

    static String[][] board = new String[9][9];

    static int GAP = 30;
    static int MARGIN = 10;
    static boolean blackTurn = true;

    //printing out CLI GO Board
    static void printGoBoard(String[][] board) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[i][j] == null){
                    System.out.print(" + ");
                }
                else if (board[i][j] == "o"){
                    System.out.print(" o ");
                }
                else if (board[i][j] == "@"){
                    System.out.print(" @ ");
                }
                else{
                    System.out.print(" + ");
                }
            }
            System.out.println();
        }
    }

    static void showUI(String[][] args) throws Exception {

        JFrame frame = new JFrame("Simon's Green GO Board");
        frame.setSize(GAP * board.length, (GAP+2) * board.length);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new java.awt.Color(123, 150, 84));

        //Mouse interaction
        frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int x = Math.round((float) (e.getX() - MARGIN) / GAP);
                int y = Math.round((float) (e.getY() - MARGIN - frame.getInsets().top) / GAP);

                if (x >= 0 && x < board.length && y >= 0 && y < board.length && board[x][y] == null) {
                    board[x][y] = blackTurn ? "@" : "o";
                    blackTurn = !blackTurn;
                    frame.repaint();
                }
            }
        });

        frame.add(new Component() {
            public void paint(Graphics g) {

                //Grid
                g.setColor(Color.BLACK);
                for (int i = 0; i < board.length; i++) {
                    g.drawLine(MARGIN, MARGIN + i * GAP, MARGIN + (board.length-1) * GAP, MARGIN + i * GAP);
                    g.drawLine(MARGIN + i * GAP, MARGIN, MARGIN + i * GAP, MARGIN + (board.length-1) * GAP);
                }

                //Stones
                for (int x = 0; x < board.length; x++) {
                    for (int y = 0; y < board.length; y++) {
                        if (board[x][y] != null) {
                            g.setColor(board[x][y] == "@" ? Color.BLACK : Color.WHITE);
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

        // Calls function for GUI
        showUI(board);

        /**********************************************************
        * CLI LOGIC 
        boolean playing = true;
        boolean turn = true;
        boolean valid = true;
        int x = 1;
        int y = 1;
        Scanner scn = new Scanner(System.in);


        while (playing) {
            printGoBoard(board);

            if (turn == true) System.out.println("Whites Turn");
            else if (turn == false) System.out.println("Blacks Turn");

            System.out.print("Enter X coordinates:");
            x = scn.nextInt();
            System.out.print("Enter Y coordinates:");
            y = scn.nextInt();

            String temp = board[y-1][x-1];
            //ⵔ⬤⚪⚫

            if (turn == true) {
                switch (temp) { 
                case null:
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
            else if (turn == false) {
                switch (temp) { 
                case null:
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
        ************************************************************************/
    }
}

package main;

import pieces.Knight;
import pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board extends JPanel {

    public int tileSize= 85; // rozmiar pojedynczego pola szachowncy
    int cols = 8; // liczba kolumn szachownicy
    int rows = 8; // liczba wierszy szachownicy

    ArrayList<Piece> pieceList = new ArrayList<>(); // lista przechowuje wszystkie figury na planszy

    public Piece selectedPiece;

    Input input = new Input(this);

    public Board (){
        this.setPreferredSize(new Dimension(cols * tileSize, rows * tileSize));
        this.addMouseListener(input);
        this.addMouseMotionListener(input);

    addPieces(); // dodanie figur do listy
    }

    public Piece getPiece(int col, int row){

        for(Piece piece : pieceList){
            if(piece.col == col && piece.row == row){
                return piece;
            }
        }

      return null;
    }

    public void makeMove(Move move){

        move.piece.col = move.newCol;
        move.piece.row = move.newRow;
        move.piece.xPos = move.newCol * tileSize;
        move.piece.yPos = move.newRow * tileSize;

        capture(move);
    }

    public void capture(Move move){

        pieceList.remove(move.capture);

    }
    public boolean isValidMove(Move move){
        if(sameTeam(move.piece, move.capture)){

            return false;
        }


        return true;
    }

    public boolean sameTeam(Piece p1, Piece p2) {
        if(p1 == null || p2 == null) {
            return false;
        }

        return p1.isWhite == p2.isWhite;
    }

    public void addPieces(){
        // dodawanie figur na plansze
    pieceList.add(new Knight(this, 1, 3, true));
        pieceList.add(new Knight(this, 0, 3, true));
        pieceList.add(new Knight(this, 3, 3, true));
        pieceList.add(new Knight(this, 2, 3, true));
        pieceList.add(new Knight(this, 4, 3, true));
        pieceList.add(new Knight(this, 5, 3, false));
        pieceList.add(new Knight(this, 6, 3, false));
        pieceList.add(new Knight(this, 7, 3, false));
        pieceList.add(new Knight(this, 1, 1, false));




    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        // petla rysuje pola szachoniwcy
    for(int r= 0; r < rows; r++)
        for(int c= 0; c<cols; c++)
        {
            g2d.setColor((c+r) %2== 0 ? Color.white : Color.blue); // bialy/czarwony w zaleznosci od pozycji pola
            g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize); // narysowanie prostokata ktory polem szachownicy
        }

    //rysowanie figur na planszy
    for(Piece piece : pieceList){
        piece.paint(g2d);
    }



    }



}

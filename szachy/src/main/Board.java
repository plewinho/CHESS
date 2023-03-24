package main;

import pieces.Knight;
import pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board extends JPanel {

    public int tileSize= 85;
    int cols = 8;
    int rows = 8;

    ArrayList<Piece> pieceList = new ArrayList<>();

    public Board (){
        this.setPreferredSize(new Dimension(cols * tileSize, rows * tileSize));
    addPieces();
    }

    public void addPieces(){
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
    for(int r= 0; r < rows; r++)
        for(int c= 0; c<cols; c++)
        {
            g2d.setColor((c+r) %2== 0 ? Color.white : Color.red);
            g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);
        }

    for(Piece piece : pieceList){
        piece.paint(g2d);
    }



    }



}

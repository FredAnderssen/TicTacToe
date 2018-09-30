package com.OMD;

public class Board {


    private int _colSize;
    private int _rowSize;
    private char _board[][];

    Board(int col, int row) {
        _colSize = col;
        _rowSize = row;
        _board = new char[_colSize][_rowSize];
        clearBoard();
    }

    public int getBoardRow() {
        return _rowSize;
    }

    public int getBoardCol() {
        return _colSize;
    }

    public char getBoardCoords(int r, int c) {
        return _board[r][c];
    }

    public void setPiece( int r, int c, char markup) {
        _board[r][c] = markup;
    }

    private void clearBoard() {
        for (int i = 0; i < _colSize; i++) {
            for (int j = 0; j < _rowSize ; j++) {
                _board[i][j] = ' ';
            }
        }
    }

    public int getBoardsize() {
        return _rowSize;
    }

    public boolean changedBoard() {
       return true;
    }



}

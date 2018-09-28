package com.OMD;

import java.util.ArrayList;

public class GameEngine {

    private Player _player;
    private Board _board;

    private int _currentPlayer = 0;
    private int _nrOfBoards;
    private int _nrOfPlayers;
    private boolean _isOnline;
    private ArrayList<Player> _playerList;


    GameEngine(int r, int c, int nrPlayers, boolean isOnline, String markers) {
        _board = new Board(r, c);
        _isOnline = isOnline;
        _nrOfPlayers = nrPlayers;
        _playerList = new ArrayList<Player>();
        createPlayers(nrPlayers, markers);
    }

    public ArrayList<Player> getPlaylist() {
        return _playerList;
    }

    public boolean getIsOnline() {
        return _isOnline;
    }

    public void setPieceInBoard(int r, int c, char markup) {
       _board.setPiece(r, c, markup);
    }

    private void createPlayers(int nr, String markers) {
        _nrOfPlayers = nr;
        for (int i = 0; i < _nrOfPlayers; i++)
            _playerList.add(new Player(this, markers.charAt(i)));
    }

    public int getCurrentPlayer() {
       return _currentPlayer;
    }

    public Board getBoard() {
        return _board;
    }

    public boolean checkMove(int r, int c) {
        if(_board.getBoard(r, c) == ' ') {
            //TODO setPiece och changePlayer ska ej vara i denna metod
            setPieceInBoard(r, c, _playerList.get(_currentPlayer).getMarker());
            changePlayer();
            return true;
        }
        return false;
    }

    public void updtBoard(int r, int c) {
        if(checkMove(r, c)) {
            setPieceInBoard(r, c, _playerList.get(_currentPlayer).getMarker());
            changePlayer();
        }
    }

    public void updtScore() {

    }

    public void changePlayer() {
        _currentPlayer++;
        _currentPlayer %= _nrOfPlayers;
    }

    public int getNrOfBoards() {
        return this._nrOfBoards;
    }

    public void checkWinner() {

    }

    public void checkLegalMove() {

    }




}

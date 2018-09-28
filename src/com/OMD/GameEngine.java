package com.OMD;

import java.util.ArrayList;

public class GameEngine {

    private Player _player;
    private Board _board;
    private ArrayList<Player> _playerList;

    private int _currentPlayer = 0;
    private int _nrOfBoards;
    private int _nrOfPlayers;
    private boolean _isOnline;

    GameEngine(int r, int c, int nrPlayers, boolean isOnline, String markers) {
        _board = new Board(r, c);
        _isOnline = isOnline;
        _nrOfPlayers = nrPlayers;
        _playerList = new ArrayList<Player>();
        createPlayers(nrPlayers, markers);
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
            _playerList.add(new Player(this, markers.charAt(i), "Player"+i));
    }

    public Board getBoard() {
        return _board;
    }

    public boolean checkMove(int r, int c) {
        if(_board.getBoardCoords(r, c) == ' ')
            return true;
        return false;
    }

    public void updateBoard(int r, int c) {
        if(checkMove(r, c)) {
            setPieceInBoard(r, c, _playerList.get(_currentPlayer).getMarker());
            changePlayer();
            updateGUI(r, c);
        }
    }

    public void updateGUI(int r, int c) {
        for (int i = 0; i < _nrOfPlayers; i++) {
            _playerList.get(i).getController().getView().updateView(r, c, _board.getBoardCoords(r, c));
        }
    }

    public void changePlayer() {
        _currentPlayer++;
        _currentPlayer %= _nrOfPlayers;
    }

    public ArrayList<Player> getPlayerlist() {
        return _playerList;
    }

    public int getCurrentPlayer() {
        return _currentPlayer;
    }

    public void updtScore() {

    }

    public int getNrOfBoards() {
        return this._nrOfBoards;
    }

    public void checkWinner() {

    }

    public void checkLegalMove() {

    }




}

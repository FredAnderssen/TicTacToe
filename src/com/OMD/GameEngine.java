package com.OMD;

import java.util.ArrayList;

public class GameEngine {

    private Player _player;
    private Board _board;
    private ArrayList<Player> _playerList;

    private int _currentPlayer = 0;
    private int _nrOfPlayers;
    private boolean _isOnline;

    GameEngine(int r, int c, int nrPlayers, boolean isOnline, String markers) {
        _board = new Board(r, c);
        _isOnline = isOnline;
        _nrOfPlayers = nrPlayers;
        _playerList = new ArrayList<Player>();
        createPlayers(nrPlayers, markers);
    }

    private void setPieceInBoard(int r, int c, char markup) {
       _board.setPiece(r, c, markup);
    }

    private void createPlayers(int nr, String markers) {
        _nrOfPlayers = nr;
        //TODO bondekod
        if(_isOnline) {
            for (int i = 0; i < _nrOfPlayers; i++) {
                _playerList.add(new Player(this, markers.charAt(i), "Player"+i));
            }
        }

        if(!_isOnline) {
            _playerList.add(new Player(this, markers.charAt(0), "Player0"));
            for (int i = 0; i < _nrOfPlayers; i++) {
                if(i != 0) {
                    _playerList.add(new Player(this, markers.charAt(i), "Player"+i, _playerList.get(0).getController()));
                }
            }
        }
    }

    public void updateBoard(int r, int c) {
        if(checkMove(r, c)) {
            setPieceInBoard(r, c, _playerList.get(_currentPlayer).getMarker());
            checkWinner(r, c);
            changePlayer();
            updateGUI(r, c);
        }
    }

    public boolean checkMove(int r, int c) {
        if(_board.getBoardCoords(r, c) == ' ')
            return true;
        return false;
    }

    public Board getBoard() {
        return _board;
    }

    public void checkWinner(int r, int c) {
        int size = getBoard().getBoardsize();

        //check col
        for (int i = 0; i < size; i++) {
            if(getBoard().getBoardCoords(r, i) != currentPlayerMarker())
                break;
            if(i == size - 1)
                currentPlayerWon();
        }

        //check row
        for (int i = 0; i < size; i++) {
            if(getBoard().getBoardCoords(i, c) != currentPlayerMarker())
                break;
            if(i == size -1 )
                currentPlayerWon();
        }

        //check diagonal
        if(r == c) {
            for (int i = 0; i < size; i++) {
                if(getBoard().getBoardCoords(i, i) != currentPlayerMarker())
                    break;
                if(i == size -1 )
                    currentPlayerWon();
            }
        }

        //check anti-diagonal
        if(r + c == size -1 ) {
            for (int i = 0; i < size; i++) {
                if(getBoard().getBoardCoords(i, (size-1)-i) != currentPlayerMarker())
                    break;
                if(i == size-1)
                    currentPlayerWon();
            }
        }
    }

    private char currentPlayerMarker() {
        return _playerList.get(_currentPlayer).getMarker();
    }

    private void currentPlayerWon() {
        _playerList.get(_currentPlayer).getController().getView().updateViewHaveWon(_playerList.get(_currentPlayer).getName());

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








}

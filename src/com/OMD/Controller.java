package com.OMD;

public class Controller {
    private View _view;
    private Player _player;


    Controller(Player player) {
        _player = player;
        _player.setController(this);
        _view = new View(this, _player.getName(), _player.getEngine().getBoard().getBoardRow(), _player.getEngine().getBoard().getBoardCol(), 50);
    }

    public void unitClicked(int r, int c) {
        _player.moveRequest(r, c);
    }

    public Player getPlayer(){
        return _player;
    }

    public View getView() {
        return _view;
    }

    public void updtInterface() {

    }

    public void pieceSelected() {

    }



}

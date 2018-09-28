package com.OMD;

public class Controller {
    private View _view;
    private Player _player;


    Controller(Player player) {
        _player = player;
        _player.setController(this);
        _view = new View(this, "test", _player.getEngine().getBoard().getBoardRow(), _player.getEngine().getBoard().getBoardCol(), 50);
    }

    public boolean unitClicked(int r, int c) {
        if(_player.moveRequest(r, c))
            return true;
        return false;
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

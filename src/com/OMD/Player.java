package com.OMD;

public class Player {

    private String _name;
    private int _score;
    private char _gameMarker;

    private Controller _controller;
    private GameEngine _engine;

    //lägg till controller här oxå i inparametern
    Player(GameEngine engine, char gameMarker) {
        _engine = engine;
        _gameMarker = gameMarker;
        if (getEngine().getIsOnline())
            _controller = new Controller(this);
        //TODO if its offline then?
    }

    public boolean moveRequest (int r, int c) {
        if(_engine.checkMove(r, c))
            return true;
        return false;
    }

    public Controller getController() {
        return _controller;
    }

    public GameEngine getEngine() {
        return _engine;
    }

    public char getMarker() {
        return _gameMarker;
    }

    public String getName() {
        return this._name;
    }

    public int getScore() {
        return this._score;
    }

    public void setController(Controller _control) {
        this._controller = _control;
    }

    public void setGameEngine(GameEngine _engine){
        this._engine = _engine;
    }







}

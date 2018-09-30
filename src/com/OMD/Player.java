package com.OMD;

public class Player {

    private String _playerName;
    private char _gameMarker;

    private Controller _controller;
    private GameEngine _engine;

    Player(GameEngine engine, char gameMarker, String name) {
        _engine = engine;
        _gameMarker = gameMarker;
        _playerName = name;
        _controller = new Controller(this);
    }

    Player(GameEngine engine, char gameMarker, String name, Controller controller) {
        _engine = engine;
        _gameMarker = gameMarker;
        _playerName = name;
        _controller = controller;
    }

    public void moveRequest (int r, int c) {
        _engine.updateBoard(r, c);
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
        return this._playerName;
    }

    public void setController(Controller _control) {
        this._controller = _control;
    }








}

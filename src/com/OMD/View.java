package com.OMD;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

public class View {

    private Controller _controller;
    private JButton[][] _buttons;
    private int _rows;
    private int _cols;
    private int _buttonSize;
    private String _playerName;
    private JLabel _myLabel;

    View(Controller _controller, String name, int rowSize, int colSize, int buttonSize) {
        this._controller = _controller;
        this._playerName = name;
        setButtonSize(buttonSize);
        setNrOfButtons(rowSize, colSize);
        presentFrame();
    }

    public void setButtonSize(int size) {
        this._buttonSize = size;
    }

    public void setNrOfButtons(int row, int col) {
        _rows = row;
        _cols = col;
    }

    public void presentFrame() {
        JFrame frame = new JFrame("SuperTicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel myButtonPanel = new JPanel();
        myButtonPanel.setLayout(new GridLayout( _rows, _cols));

        this.drawBoard(myButtonPanel);

        frame.getContentPane().add(presentMainPanel(myButtonPanel));

        displayWindow(frame);
    }

    public void drawBoard(JPanel myButtonPanel) {
        _buttons = new JButton[_rows][_cols];
        for(int r = 0; r < this._rows; r++)
            for (int c = 0; c < this._cols; c++) {
                final int _r = r;
                final int _c = c;
                JButton button = _buttons[r][c] = new JButton(" ");
                button.setPreferredSize(new Dimension(_buttonSize, _buttonSize));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        _controller.unitClicked(_r, _c);
                    }
                });
                myButtonPanel.add(button);
            }
    }

    public void updateView(int r, int c, char markup) {
        _buttons[r][c].setText(Character.toString(markup));
    }

    public void updateViewHaveWon(String name) {
        _myLabel.setText(name + " have won!");
    }

    private JPanel presentTextPanel() {
        JPanel myTextPanel = new JPanel();
        myTextPanel.setLayout(new GridLayout(1,1));
        myTextPanel.setPreferredSize(new Dimension(_buttonSize * _cols, _buttonSize));
        _myLabel = new JLabel(_playerName, SwingConstants.CENTER);
        myTextPanel.add(_myLabel);
        return myTextPanel;
    }

    private JPanel presentMainPanel(JPanel myBtnPanel) {
        JPanel myMainPanel = new JPanel();
        myMainPanel.setLayout(new BoxLayout(myMainPanel, BoxLayout.Y_AXIS));
        myMainPanel.add(myBtnPanel);
        myMainPanel.add(presentTextPanel());
        return myMainPanel;
    }

    private void displayWindow(JFrame frame) {
        System.out.print("Display");
        frame.pack();
        frame.setVisible(true);
    }

}

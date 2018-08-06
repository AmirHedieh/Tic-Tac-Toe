package com.example.amas.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    public static final int O_PLAYER = 0;
    public static final int X_PLAYER = 1;

    public static final int USED_CELL = 10;
    public static final int NOT_USED_CELL = 11;

    private int round = 1;
    private int winner = -1;
    int cells[] = {NOT_USED_CELL,NOT_USED_CELL,NOT_USED_CELL,
                   NOT_USED_CELL,NOT_USED_CELL,NOT_USED_CELL,
                   NOT_USED_CELL,NOT_USED_CELL,NOT_USED_CELL};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
    }

    public void gameTick(View view){
        fillCell(view);
        if(checkEnd()){
            showEnding();
        }
    }

    private void fillCell(View view){
        ImageView iv = (ImageView) view;
        int cellNumber = Integer.parseInt((String)iv.getTag());
        if(round % 2 == 1 && cells[cellNumber] == NOT_USED_CELL){ //O_Player
            iv.setImageResource(R.drawable.o);
            cells[cellNumber] = O_PLAYER;
            round++;
        }
        else if(round % 2 == 0 && cells[cellNumber] == NOT_USED_CELL){ //X_Player
            iv.setImageResource(R.drawable.x);
            cells[cellNumber] = X_PLAYER;
            round++;
        }
    }

    private Boolean checkEnd() {
        //horizontal
        if (cells[0] == cells[1] && cells[1] == cells[2] && cells[0] != NOT_USED_CELL) {
            if(cells[0] == O_PLAYER)
                winner = O_PLAYER;
            else
                winner = X_PLAYER;
            return true;
        }
        if (cells[3] == cells[4] && cells[4] == cells[5] && cells[3] != NOT_USED_CELL) {
            if(cells[3] == O_PLAYER)
                winner = O_PLAYER;
            else
                winner = X_PLAYER;
            return true;
        }
        if (cells[6] == cells[7] && cells[7] == cells[8] && cells[6] != NOT_USED_CELL) {
            if(cells[6] == O_PLAYER)
                winner = O_PLAYER;
            else
                winner = X_PLAYER;
            return true;
        }
        //vertical
        if (cells[0] == cells[3] && cells[3] == cells[6] && cells[0] != NOT_USED_CELL) {
            if(cells[0] == O_PLAYER)
                winner = O_PLAYER;
            else
                winner = X_PLAYER;
            return true;
        }
        if (cells[1] == cells[4] && cells[4] == cells[7] && cells[1] != NOT_USED_CELL) {
            if(cells[1] == O_PLAYER)
                winner = O_PLAYER;
            else
                winner = X_PLAYER;
            return true;
        }
        if (cells[2] == cells[5] && cells[5] == cells[8] && cells[2] != NOT_USED_CELL) {
            if(cells[2] == O_PLAYER)
                winner = O_PLAYER;
            else
                winner = X_PLAYER;
            return true;
        }
        //
        if (cells[0] == cells[4] && cells[4] == cells[8] && cells[0] != NOT_USED_CELL) {
            if(cells[0] == O_PLAYER)
                winner = O_PLAYER;
            else
                winner = X_PLAYER;
            return true;
        }
        if (cells[2] == cells[4] && cells[4] == cells[6] && cells[2] != NOT_USED_CELL) {
            if(cells[2] == O_PLAYER)
                winner = O_PLAYER;
            else
                winner = X_PLAYER;
            return true;
        }
        //
        return false;
    }

    private void showEnding(){
        if(winner == O_PLAYER)
            Toast.makeText(this, "O Won!!!!!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "X Won!!!!!", Toast.LENGTH_SHORT).show();
    }
}

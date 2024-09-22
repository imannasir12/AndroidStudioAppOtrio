//Name:Iman Nasir
//Date: October 22,2021
//Purpose:TicTacToe project
package com.example.nasirimanotrio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Game2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
    }

    //board
    int board[][] = new int[3][3];
    //turn indicator
    char turn = 'r';
    //size chosen variables
    char sPress = 'n';
    char mPress = 'n';
    char bPress = 'n';
    //win
    int win = 0;
    //count number of pieces
    int smallg = 0;
    int smallr = 0;
    int mediumg = 0;
    int mediumr = 0;
    int bigg = 0;
    int bigr = 0;
    //tags for all 9 board images
    String aTag = "eee_0";
    String bTag = "eee_0";
    String cTag = "eee_0";
    String dTag = "eee_0";
    String eTag = "eee_0";
    String fTag = "eee_0";
    String gTag = "eee_0";
    String hTag = "eee_0";
    String iTag = "eee_0";

    //flip method to change picture and update turn
    public void flip() {
        ImageView turnpic = (ImageView) findViewById(R.id.turn);
        if (turn == 'r') {
            turn = 'g';
            turnpic.setImageResource(R.drawable.green);
            //calls ai method
            aiTurn();
        } else {
            turn = 'r';
            turnpic.setImageResource(R.drawable.red);
        }
    }

    //if user presses the small button
    public void small(View view) {
        sPress = 'y';
        mPress = 'n';
        bPress = 'n';
    }

    //if user presses the medium button
    public void medium(View view) {
        mPress = 'y';
        sPress = 'n';
        bPress = 'n';
    }

    //if user presses the big button
    public void big(View view) {
        bPress = 'y';
        mPress = 'n';
        sPress = 'n';
    }

    //sets the small piece when the board position equals 0
    public void setPieceSmall0(ImageView i) {
        if (turn == 'g') {
            i.setImageResource(R.drawable.eeg_1);
            i.setTag("eeg_1");
        } else {
            i.setImageResource(R.drawable.eer_1);
            i.setTag("eer_1");
        }
    }

    //sets the small green piece when the board position equals 2
    public void setPieceSmall2Green(ImageView i, String j) {
        if (j.equals("ege_2")) {
            i.setImageResource(R.drawable.egg_3);
            i.setTag("egg_3");
        } else {
            i.setImageResource(R.drawable.erg_3);
            i.setTag("erg_3");
        }
    }

    //sets the small red piece when the board position equals 2
    public void setPieceSmall2Red(ImageView i, String j) {
        if (j.equals("ege_2")) {
            i.setImageResource(R.drawable.egr_3);
            i.setTag("egr_3");
        } else {
            i.setImageResource(R.drawable.err_3);
            i.setTag("err_3");
        }
    }

    //calls the small piece methods when the board position equals 2
    public void setPieceSmall2(ImageView i, String j) {
        if (turn == 'g')
            setPieceSmall2Green(i, j);
        else
            setPieceSmall2Red(i, j);
    }

    //sets the small green piece when the board position is 4
    public void setPieceSmall4Green(ImageView i, String j) {
        if (j.equals("gee_4")) {
            i.setImageResource(R.drawable.geg_5);
            i.setTag("geg_5");
        } else {
            i.setImageResource(R.drawable.reg_5);
            i.setTag("reg_5");
        }
    }

    //sets the small red piece when the board position is 4
    public void setPieceSmall4Red(ImageView i, String j) {
        if (j.equals("gee_4")) {
            i.setImageResource(R.drawable.ger_5);
            i.setTag("ger_5");
        } else {
            i.setImageResource(R.drawable.rer_5);
            i.setTag("rer_5");
        }
    }

    //calls the small piece methods when the board position equals 4
    public void setPieceSmall4(ImageView i, String j) {
        if (turn == 'g')
            setPieceSmall4Green(i, j);
        else
            setPieceSmall4Red(i, j);
    }

    //sets the small green piece when the board position is 6
    public void setPieceSmall6Green(ImageView i, String j) {
        if (j.equals("gge_6")) {
            i.setImageResource(R.drawable.ggg_7);
            i.setTag("ggg_7");
        } else if (j.equals("rre_6")) {
            i.setImageResource(R.drawable.rrg_7);
            i.setTag("rrg_7");
        } else if (j.equals("gre_6")) {
            i.setImageResource(R.drawable.grg_7);
            i.setTag("grg_7");
        } else {
            i.setImageResource(R.drawable.rgg_7);
            i.setTag("rgg_7");
        }
    }

    //sets the small red piece when the board position is 6
    public void setPieceSmall6Red(ImageView i, String j) {
        if (j.equals("gge_6")) {
            i.setImageResource(R.drawable.ggr_7);
            i.setTag("ggr_7");
        } else if (j.equals("rre_6")) {
            i.setImageResource(R.drawable.rrr_7);
            i.setTag("rrr_7");
        } else if (j.equals("gre_6")) {
            i.setImageResource(R.drawable.grr_7);
            i.setTag("grr_7");
        } else {
            i.setImageResource(R.drawable.rgr_7);
            i.setTag("rgr_7");
        }
    }

    //calls the small piece methods when the board position equals 6
    public void setPieceSmall6(ImageView i, String j) {
        if (turn == 'g')
            setPieceSmall6Green(i, j);
        else
            setPieceSmall6Red(i, j);
    }

    //calls small piece method depending on the number
    public void setPieceSmall(int num, ImageView i, String j) {
        if (num == 0)
            setPieceSmall0(i);
        else if (num == 2)
            setPieceSmall2(i, j);
        else if (num == 4)
            setPieceSmall4(i, j);
        else if (num == 6)
            setPieceSmall6(i, j);
        if (turn == 'g')
            smallg++;
        else
            smallr++;
    }

    //sets the medium piece when the board position equals 0
    public void setPieceMedium0(ImageView i) {
        if (turn == 'g') {
            i.setImageResource(R.drawable.ege_2);
            i.setTag("ege_2");
        } else {
            i.setImageResource(R.drawable.ere_2);
            i.setTag("ere_2");
        }
    }

    //sets the medium green piece when the board position equals 1
    public void setPieceMedium1Green(ImageView i, String j) {
        if (j.equals("eeg_1")) {
            i.setImageResource(R.drawable.egg_3);
            i.setTag("egg_3");
        } else {
            i.setImageResource(R.drawable.egr_3);
            i.setTag("egr_3");
        }
    }

    //sets the medium red piece when the board position equals 1
    public void setPieceMedium1Red(ImageView i, String j) {
        if (j.equals("eeg_1")) {
            i.setImageResource(R.drawable.erg_3);
            i.setTag("erg_3");
        } else {
            i.setImageResource(R.drawable.err_3);
            i.setTag("err_3");
        }
    }

    //calls the medium piece methods when the board position equals 1
    public void setPieceMedium1(ImageView i, String j) {
        if (turn == 'g')
            setPieceMedium1Green(i, j);
        else
            setPieceMedium1Red(i, j);
    }

    //sets the medium green piece when the board position equals 4
    public void setPieceMedium4Green(ImageView i, String j) {
        if (j.equals("gee_4")) {
            i.setImageResource(R.drawable.gge_6);
            i.setTag("gge_6");
        } else {
            i.setImageResource(R.drawable.rge_6);
            i.setTag("rge_6");
        }
    }

    //sets the medium red piece when the board position equals 4
    public void setPieceMedium4Red(ImageView i, String j) {
        if (j.equals("gee_4")) {
            i.setImageResource(R.drawable.gre_6);
            i.setTag("gre_6");
        } else {
            i.setImageResource(R.drawable.rre_6);
            i.setTag("rre_6");
        }
    }

    //calls the medium piece methods when the board position equals 4
    public void setPieceMedium4(ImageView i, String j) {
        if (turn == 'g')
            setPieceMedium4Green(i, j);
        else
            setPieceMedium4Red(i, j);
    }

    //sets the medium green piece when the board position equals 5
    public void setPieceMedium5Green(ImageView i, String j) {
        if (j.equals("geg_5")) {
            i.setImageResource(R.drawable.ggg_7);
            i.setTag("ggg_7");
        } else if (j.equals("rer_5")) {
            i.setImageResource(R.drawable.rgr_7);
            i.setTag("rgr_7");
        } else if (j.equals("ger_5")) {
            i.setImageResource(R.drawable.ggr_7);
            i.setTag("ggr_7");
        } else {
            i.setImageResource(R.drawable.rgg_7);
            i.setTag("rgg_7");
        }
    }

    //sets the medium red piece when the board position equals 5
    public void setPieceMedium5Red(ImageView i, String j) {
        if (j.equals("geg_5")) {
            i.setImageResource(R.drawable.grg_7);
            i.setTag("grg_7");
        } else if (j.equals("rer_5")) {
            i.setImageResource(R.drawable.rrr_7);
            i.setTag("rrr_7");
        } else if (j.equals("ger_5")) {
            i.setImageResource(R.drawable.grr_7);
            i.setTag("grr_7");
        } else {
            i.setImageResource(R.drawable.rrg_7);
            i.setTag("rrg_7");
        }
    }

    //calls the medium piece methods when the board position equals 5
    public void setPieceMedium5(ImageView i, String j) {
        if (turn == 'g')
            setPieceMedium5Green(i, j);
        else
            setPieceMedium5Red(i, j);
    }

    //calls medium piece method depending on the number
    public void setPieceMedium(int num, ImageView i, String j) {
        if (num == 0)
            setPieceMedium0(i);
        else if (num == 1)
            setPieceMedium1(i, j);
        else if (num == 4)
            setPieceMedium4(i, j);
        else if (num == 5)
            setPieceMedium5(i, j);
        if (turn == 'g')
            mediumg++;
        else
            mediumr++;
    }

    //sets the big piece when the board position equals 0
    public void setPieceBig0(ImageView i) {
        if (turn == 'g') {
            i.setImageResource(R.drawable.gee_4);
            i.setTag("gee_4");
        } else {
            i.setImageResource(R.drawable.ree_4);
            i.setTag("ree_4");
        }
    }

    //sets the big green piece when the board position equals 1
    public void setPieceBig1Green(ImageView i, String j) {
        if (j.equals("eeg_1")) {
            i.setImageResource(R.drawable.geg_5);
            i.setTag("geg_5");
        } else {
            i.setImageResource(R.drawable.ger_5);
            i.setTag("ger_5");
        }
    }

    //sets the big red piece when the board position equals 1
    public void setPieceBig1Red(ImageView i, String j) {
        if (j.equals("eeg_1")) {
            i.setImageResource(R.drawable.reg_5);
            i.setTag("reg_5");
        } else {
            i.setImageResource(R.drawable.rer_5);
            i.setTag("rer_5");
        }
    }

    //calls the big piece methods when the board position equals 1
    public void setPieceBig1(ImageView i, String j) {
        if (turn == 'g')
            setPieceBig1Green(i, j);
        else
            setPieceBig1Red(i, j);
    }

    //sets the big green piece when the board position equals 2
    public void setPieceBig2Green(ImageView i, String j) {
        if (j.equals("ege_2")) {
            i.setImageResource(R.drawable.gge_6);
            i.setTag("gge_6");
        } else {
            i.setImageResource(R.drawable.gre_6);
            i.setTag("gre_6");
        }
    }

    //sets the big green piece when the board position equals 2
    public void setPieceBig2Red(ImageView i, String j) {
        if (j.equals("ege_2")) {
            i.setImageResource(R.drawable.rge_6);
            i.setTag("rge_6");
        } else {
            i.setImageResource(R.drawable.rre_6);
            i.setTag("rre_6");
        }
    }

    //calls the big piece methods when the board position equals 2
    public void setPieceBig2(ImageView i, String j) {
        if (turn == 'g')
            setPieceBig2Green(i, j);
        else
            setPieceBig2Red(i, j);
    }

    //sets the big green piece when the board position equals 3
    public void setPieceBig3Green(ImageView i, String j) {
        if (j.equals("egg_3")) {
            i.setImageResource(R.drawable.ggg_7);
            i.setTag("ggg_7");
        } else if (j.equals("err_3")) {
            i.setImageResource(R.drawable.grr_7);
            i.setTag("grr_7");
        } else if (j.equals("egr_3")) {
            i.setImageResource(R.drawable.ggr_7);
            i.setTag("ggr_7");
        } else {
            i.setImageResource(R.drawable.grg_7);
            i.setTag("grg_7");
        }
    }

    //sets the big green piece when the board position equals 3
    public void setPieceBig3Red(ImageView i, String j) {
        if (j.equals("egg_3")) {
            i.setImageResource(R.drawable.rgg_7);
            i.setTag("rgg_7");
        } else if (j.equals("err_3")) {
            i.setImageResource(R.drawable.rrr_7);
            i.setTag("rrr_7");
        } else if (j.equals("egr_3")) {
            i.setImageResource(R.drawable.rgr_7);
            i.setTag("rgr_7");
        } else {
            i.setImageResource(R.drawable.rrg_7);
            i.setTag("rrg_7");
        }
    }

    //calls the big piece methods when the board position equals 3
    public void setPieceBig3(ImageView i, String j) {
        if (turn == 'g')
            setPieceBig3Green(i, j);
        else
            setPieceBig3Red(i, j);
    }

    //calls big piece method depending on the number
    public void setPieceBig(int num, ImageView i, String j) {
        if (num == 0)
            setPieceBig0(i);
        else if (num == 1)
            setPieceBig1(i, j);
        else if (num == 2)
            setPieceBig2(i, j);
        else if (num == 3)
            setPieceBig3(i, j);
        if (turn == 'g')
            bigg++;
        else
            bigr++;
    }

    //ai's turn
    public void aiTurn() {
        //random number for board position
        int n = (int) (Math.random() * 9);
        //random number for size
        int size = (int) (Math.random() * 3);
        if (size == 0)
            sPress = 'y';
        else if (size == 1)
            mPress = 'y';
        else if (size == 2)
            bPress = 'y';
        if (n == 0)
            aPress();
        else if (n == 1)
            bPress();
        else if (n == 2)
            cPress();
        else if (n == 3)
            dPress();
        else if (n == 4)
            ePress();
        else if (n == 5)
            fPress();
        else if (n == 6)
            gPress();
        else if (n == 7)
            hPress();
        else if (n == 8)
            iPress();
        //sets size presses to not selected
        sPress = 'n';
        mPress = 'n';
        bPress = 'n';
    }

    //checks if the user is able to place their piece in the position chosen
    public boolean check(int a, int b, ImageView i, String j) {
        //checks for small piece
        if (j.charAt(2) == 'e' && sPress == 'y' && ((turn == 'g' && smallg <= 2) || (turn == 'r' && smallr <= 2))) {
            setPieceSmall(board[a][b], i, j);
            return true;
        }  //checks for medium piece
        else if (j.charAt(1) == 'e' && mPress == 'y' && ((turn == 'g' && mediumg <= 2) || (turn == 'r' && mediumr <= 2))) {
            setPieceMedium(board[a][b], i, j);
            return true;
        }  //checks for big piece
        else if (j.charAt(0) == 'e' && bPress == 'y' && ((turn == 'g' && bigg <= 2) || (turn == 'r' && bigr <= 2))) {
            setPieceBig(board[a][b], i, j);
            return true;
        } else if (turn == 'r') {
            //size was not chosen
            if (sPress == 'n' && mPress == 'n' && bPress == 'n')
                Toast.makeText(getApplicationContext(), "Please choose a size", Toast.LENGTH_SHORT).show();
                //position is full
            else if ((sPress == 'y' && j.charAt(2) != 'e') || (mPress == 'y' && j.charAt(1) != 'e') || (bPress == 'y' && j.charAt(0) != 'e'))
                Toast.makeText(getApplicationContext(), "This position is already taken", Toast.LENGTH_SHORT).show();
                //used up all their pieces
            else
                makeDialogBox();
            //sets size presses to not selected
            sPress = 'n';
            mPress = 'n';
            bPress = 'n';
            return false;
        } else {
            //sets size presses to not selected
            sPress = 'n';
            mPress = 'n';
            bPress = 'n';
            //calls ai method again for new size and position
            aiTurn();
            return false;
        }
    }

    //dialog box to inform user they have used up their pieces
    public void makeDialogBox() {
        String a = "";
        if (sPress == 'y')
            a = "small";
        else if (mPress == 'y')
            a = "medium";
        else
            a = "big";
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("Sorry!" +
                        "\nYou have already used 3 " + a + " pieces.")
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Please choose another size", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    //updates board and changes turn after small piece is placed
    public void updateSmall(int a, int b) {
        board[a][b] += 1;
        flip();
        sPress = 'n';
    }

    //updates board and changes turn after medium piece is placed
    public void updateMedium(int a, int b) {
        board[a][b] += 2;
        flip();
        mPress = 'n';
    }

    //updates board and changes turn after big piece is placed
    public void updateBig(int a, int b) {
        board[a][b] += 4;
        flip();
        bPress = 'n';
    }

    //a position on board is clicked
    public void aClick(View view) {
        //user wants to go to home screen
        Intent i = new Intent(this, MainActivity.class);
        if (sPress == 'n' && mPress == 'n' && bPress == 'n') {
            startActivity(i);
            resetBoard();
        } else if (turn == 'r')
            aPress();
    }

    //b position on board is clicked
    public void bClick(View view) {
        if (turn == 'r')
            bPress();
    }

    //c position on board is clicked
    public void cClick(View view) {
        if (turn == 'r')
            cPress();
    }

    //d position on board is clicked
    public void dClick(View view) {
        if (turn == 'r')
            dPress();
    }

    //e position on board is clicked
    public void eClick(View view) {
        if (turn == 'r')
            ePress();
    }

    //f position on board is clicked
    public void fClick(View view) {
        if (turn == 'r')
            fPress();
    }

    //g position on board is clicked
    public void gClick(View view) {
        if (turn == 'r')
            gPress();
    }

    //h position on board is clicked
    public void hClick(View view) {
        if (turn == 'r')
            hPress();
    }

    //i position on board is clicked
    public void iClick(View view) {
        if (turn == 'r')
            iPress();
    }

    //a position
    public void aPress() {
        ImageView i = (ImageView) findViewById(R.id.a);
        //if choice is valid updates piece
        if (check(0, 0, i, aTag)) {
            if (sPress == 'y')
                updateSmall(0, 0);
            else if (mPress == 'y')
                updateMedium(0, 0);
            else if (bPress == 'y')
                updateBig(0, 0);
            aTag = i.getTag().toString();
            winCheck(i);
        }
    }

    //b position
    public void bPress() {
        ImageView i = (ImageView) findViewById(R.id.b);
        //if choice is valid updates piece
        if (check(0, 1, i, bTag)) {
            if (sPress == 'y')
                updateSmall(0, 1);
            else if (mPress == 'y')
                updateMedium(0, 1);
            else if (bPress == 'y')
                updateBig(0, 1);
            bTag = i.getTag().toString();
            winCheck(i);
        }
    }

    //c position
    public void cPress() {
        ImageView i = (ImageView) findViewById(R.id.c);
        //if choice is valid updates piece
        if (check(0, 2, i, cTag)) {
            if (sPress == 'y')
                updateSmall(0, 2);
            else if (mPress == 'y')
                updateMedium(0, 2);
            else if (bPress == 'y')
                updateBig(0, 2);
            cTag = i.getTag().toString();
            winCheck(i);
        }
    }

    //d position
    public void dPress() {
        ImageView i = (ImageView) findViewById(R.id.d);
        //if choice is valid updates piece
        if (check(1, 0, i, dTag)) {
            if (sPress == 'y')
                updateSmall(1, 0);
            else if (mPress == 'y')
                updateMedium(1, 0);
            else if (bPress == 'y')
                updateBig(1, 0);
            dTag = i.getTag().toString();
            winCheck(i);
        }
    }

    //e position
    public void ePress() {
        ImageView i = (ImageView) findViewById(R.id.e);
        //if choice is valid updates piece
        if (check(1, 1, i, eTag)) {
            if (sPress == 'y')
                updateSmall(1, 1);
            else if (mPress == 'y')
                updateMedium(1, 1);
            else if (bPress == 'y')
                updateBig(1, 1);
            eTag = i.getTag().toString();
            winCheck(i);
        }
    }

    //f position
    public void fPress() {
        ImageView i = (ImageView) findViewById(R.id.f);
        //if choice is valid updates piece
        if (check(1, 2, i, fTag)) {
            if (sPress == 'y')
                updateSmall(1, 2);
            else if (mPress == 'y')
                updateMedium(1, 2);
            else if (bPress == 'y')
                updateBig(1, 2);
            fTag = i.getTag().toString();
            winCheck(i);
        }
    }

    //g position
    public void gPress() {
        ImageView i = (ImageView) findViewById(R.id.g);
        //if choice is valid updates piece
        if (check(2, 0, i, gTag)) {
            if (sPress == 'y')
                updateSmall(2, 0);
            else if (mPress == 'y')
                updateMedium(2, 0);
            else if (bPress == 'y')
                updateBig(2, 0);
            gTag = i.getTag().toString();
            winCheck(i);
        }
    }

    //h position
    public void hPress() {
        ImageView i = (ImageView) findViewById(R.id.h);
        //if choice is valid updates piece
        if (check(2, 1, i, hTag)) {
            if (sPress == 'y')
                updateSmall(2, 1);
            else if (mPress == 'y')
                updateMedium(2, 1);
            else if (bPress == 'y')
                updateBig(2, 1);
            hTag = i.getTag().toString();
            winCheck(i);
        }
    }

    //i position
    public void iPress() {
        ImageView i = (ImageView) findViewById(R.id.i);
        //if choice is valid updates piece
        if (check(2, 2, i, iTag)) {
            if (sPress == 'y')
                updateSmall(2, 2);
            else if (mPress == 'y')
                updateMedium(2, 2);
            else if (bPress == 'y')
                updateBig(2, 2);
            iTag = i.getTag().toString();
            winCheck(i);
        }
    }

    //different win options
    public void winCheck(ImageView i) {
        checkLineWin();
        fullCircleWin(i);
    }

    //three pieces of the same colour are on the same board position
    public void fullCircleWin(ImageView check) {
        String i = check.getTag().toString();
        if (i.charAt(0) == 'g' && i.charAt(1) == 'g' && i.charAt(2) == 'g')
            win = 1;
        else if (i.charAt(0) == 'r' && i.charAt(1) == 'r' && i.charAt(2) == 'r')
            win = 2;
        win();
    }

    //different line win options
    public void checkLineWin() {
        //rows
        LineWin(aTag, bTag, cTag);
        LineWin(dTag, eTag, fTag);
        LineWin(gTag, hTag, iTag);
        //columns
        LineWin(aTag, dTag, gTag);
        LineWin(bTag, eTag, hTag);
        LineWin(cTag, fTag, iTag);
        //diagonal
        LineWin(aTag, eTag, iTag);
        LineWin(cTag, eTag, gTag);
    }

    //different line win variations
    public void LineWin(String a, String b, String c) {
        if (!a.equals("") && !b.equals("") && !c.equals("")) {
            //green player wins
            if (a.charAt(0) == 'g' && b.charAt(0) == 'g' && c.charAt(0) == 'g' && bigg <= 3)
                win = 1;
            else if (a.charAt(1) == 'g' && b.charAt(1) == 'g' && c.charAt(1) == 'g' && mediumg <= 3)
                win = 1;
            else if (a.charAt(2) == 'g' && b.charAt(2) == 'g' && c.charAt(2) == 'g' && smallg <= 3)
                win = 1;
            else if (a.charAt(0) == 'g' && b.charAt(1) == 'g' && c.charAt(2) == 'g' && smallg <= 3 && mediumg <= 3 && bigg <= 3)
                win = 1;
            else if (a.charAt(2) == 'g' && b.charAt(1) == 'g' && c.charAt(0) == 'g' && smallg <= 3 && mediumg <= 3 && bigg <= 3)
                win = 1;
                //red player wins
            else if (a.charAt(0) == 'r' && b.charAt(0) == 'r' && c.charAt(0) == 'r' && bigr <= 3)
                win = 2;
            else if (a.charAt(1) == 'r' && b.charAt(1) == 'r' && c.charAt(1) == 'r' && mediumr <= 3)
                win = 2;
            else if (a.charAt(2) == 'r' && b.charAt(2) == 'r' && c.charAt(2) == 'r' && smallr <= 3)
                win = 2;
            else if (a.charAt(0) == 'r' && b.charAt(1) == 'r' && c.charAt(2) == 'r' && smallr <= 3 && mediumr <= 3 && bigr <= 3)
                win = 2;
            else if (a.charAt(2) == 'r' && b.charAt(1) == 'r' && c.charAt(0) == 'r' && smallr <= 3 && mediumr <= 3 && bigr <= 3)
                win = 2;
        }
        win();
    }

    //alert box shows up if player wins or there is a tie
    public void alertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("OK", null);
        ImageView i = new ImageView(this);
        //green player wins
        if (win == 1) {
            i.setImageResource(R.drawable.eeg_1);
            builder.setMessage("Green player wins! The board has reset for you to play again!");
        }
        //red player wins
        else if (win == 2) {
            i.setImageResource(R.drawable.eer_1);
            builder.setMessage("Red player wins! The board has reset for you to play again!");
        }
        //there is a tie
        else {
            i.setImageResource(R.drawable.rgr_7);
            builder.setMessage("No winner! You have each used up all your pieces! The board has reset for you to play again.");
        }
        builder.setView(i);
        builder.setTitle("Game over!");
        builder.show();
    }

    //checks if there is a winner
    public void win() {
        if (win == 1 || win == 2 || (smallg == 3 && smallr == 3 && mediumg == 3 && mediumr == 3 && bigg == 3 && bigr == 3)) {
            alertDialog();
            resetBoard();
        }
    }

    //if user needs help
    public void hint(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("OK", null);
        builder.setTitle("Help?");
        builder.setMessage("It looks like you need some help!\n\nRemember, players take turns placing any sized piece on the board.\n\nThe position you choose MUST BE AVAILABLE for the corresponding size you have chosen.\n\nYou can use up to three pieces of any size. After that, you will not be able to use that size again.");
        builder.show();
    }

    //resets the board
    public void resetBoard() {
        //finds images
        ImageView a = (ImageView) findViewById(R.id.a);
        ImageView b = (ImageView) findViewById(R.id.b);
        ImageView c = (ImageView) findViewById(R.id.c);
        ImageView d = (ImageView) findViewById(R.id.d);
        ImageView e = (ImageView) findViewById(R.id.e);
        ImageView f = (ImageView) findViewById(R.id.f);
        ImageView g = (ImageView) findViewById(R.id.g);
        ImageView h = (ImageView) findViewById(R.id.h);
        ImageView i = (ImageView) findViewById(R.id.i);
        //resets images
        a.setImageResource(R.drawable.eee_0);
        b.setImageResource(R.drawable.eee_0);
        c.setImageResource(R.drawable.eee_0);
        d.setImageResource(R.drawable.eee_0);
        e.setImageResource(R.drawable.eee_0);
        f.setImageResource(R.drawable.eee_0);
        g.setImageResource(R.drawable.eee_0);
        h.setImageResource(R.drawable.eee_0);
        i.setImageResource(R.drawable.eee_0);
        //sets board positions to 0
        board[0][0] = 0;
        board[0][1] = 0;
        board[0][2] = 0;
        board[1][0] = 0;
        board[1][1] = 0;
        board[1][2] = 0;
        board[2][0] = 0;
        board[2][1] = 0;
        board[2][2] = 0;
        //sets turn back to red
        turn = 'r';
        ImageView turnpic = (ImageView) findViewById(R.id.turn);
        turnpic.setImageResource(R.drawable.red);
        //sets pieces used back to 0
        smallg = 0;
        smallr = 0;
        mediumg = 0;
        mediumr = 0;
        bigg = 0;
        bigr = 0;
        //sets size presses back to 0
        sPress = 'n';
        mPress = 'n';
        bPress = 'n';
        //sets win to 0
        win = 0;
        //resets strings
        aTag = "eee_0";
        bTag = "eee_0";
        cTag = "eee_0";
        dTag = "eee_0";
        eTag = "eee_0";
        fTag = "eee_0";
        gTag = "eee_0";
        hTag = "eee_0";
        iTag = "eee_0";
    }
}
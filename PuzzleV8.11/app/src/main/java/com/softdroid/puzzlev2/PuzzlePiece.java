package com.softdroid.puzzlev2;

import android.content.Context;

public class PuzzlePiece extends androidx.appcompat.widget.AppCompatImageView {
    public int xCoord;
    public int yCoord;
    public int pieceWidth;
    public int pieceHeight;
    public boolean canMove = true;

    public PuzzlePiece(Context context) {
        super(context);
    }
}
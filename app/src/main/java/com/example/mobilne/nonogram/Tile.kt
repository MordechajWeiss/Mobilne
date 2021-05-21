/*package com.example.mobilne.nonogram

import android.widget.ImageView

// Klasa reprezentująca pojedyncze pole nonogramu
class Tile(/*Board motherboard*/) /*: ImageView*/ {/*

    // publiczny interfejs do określania stanu pola
    public /*static*/ enum class State { UNSET, FULL, DOT }

    private var state = State.UNSET

    /*override*/ fun onClick() {

        /*
        switch(this.state) {
            case State.UNSET:
                this.state = State.FULL;
                break;
            case State.FULL:
                this.state = State.DOT;
                break;
            case State.DOT:
                this.state = State.UNSET;
                break;
        }
        */

        this.state++
        motherboard.checkCorrectness()

    }*/

}

 */

package nl.fontys.tictactoe.Interfaces;

import nl.fontys.tictactoe.Models.Speler;

import java.util.ArrayList;

public interface SpelInterface {
    public void StartSpel();
    public void voegSpelerToSpel();
    public ArrayList<Speler> getSpelers();
}

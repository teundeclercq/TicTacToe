package nl.fontys.tictactoe.Repositories;

import nl.fontys.tictactoe.Interfaces.SpelInterface;
import nl.fontys.tictactoe.Models.Spel;
import nl.fontys.tictactoe.Models.Speler;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class SpelRepository implements SpelInterface {
    private Spel spel = new Spel();

    @Override
    public void StartSpel() {
        //To be implemented.
    }

    @Override
    public void voegSpelerToSpel() {
        //To be implemented.
    }

    @Override
    public ArrayList<Speler> getSpelers() {
        //To be implemented.
        return null;
    }
}

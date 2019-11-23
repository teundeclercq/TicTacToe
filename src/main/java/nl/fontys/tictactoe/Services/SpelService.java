package nl.fontys.tictactoe.Services;

import nl.fontys.tictactoe.Interfaces.SpelInterface;
import nl.fontys.tictactoe.Models.Speler;
import nl.fontys.tictactoe.Repositories.SpelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SpelService implements SpelInterface {
    @Autowired
    private SpelRepository spelRepository;

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

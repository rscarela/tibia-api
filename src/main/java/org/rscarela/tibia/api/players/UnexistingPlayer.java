package org.rscarela.tibia.api.players;

/**
 * Created by rscarela on 7/7/17.
 */
public class UnexistingPlayer extends Player {

    @Override
    public boolean isValidPlayer() {
        return false;
    }

}

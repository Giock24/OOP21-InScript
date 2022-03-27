package drawphasemanager;

import shared.Player;

public class DrawPhaseManagerImpl implements DrawPhaseManager {
    
    private Player player;
    
    private DrawPhaseManagerImpl(final Player player) {
        this.player = player;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleEffect() {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawPhaseManager(final Player player, final Player playerIA) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final boolean isThePlayerTurn) {
        // TODO Auto-generated method stub

    }
    
    /**
     *   when called increment +1 Player's mana.
     */
    private void incrementMana() {
        // TODO Auto-generated method stub

    }
    
    /**
     *   when called you can decide to swap:
         from Player turn to IA turn or vice versa.
         
     * @param newPlayer is the player set (Player or IA)
     */
    private void setStatus(final Player newPlayer) {
        this.player = newPlayer;
    }

}

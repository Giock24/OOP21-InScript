package drawphasemanager;

import shared.Player;

public class DrawPhaseImpl implements DrawPhase {
	
	final static private int MANA = 1;
	private Player player;
	
	public DrawPhaseImpl(final Player player) {
		this.player = player;
	}

	/**
     *  {@inheritDoc}
     */
	@Override
	public void incrementMana() {
		// TODO Auto-generated method stub

	}

	/**
     *  {@inheritDoc}
     */
	@Override
	public void setStatus(final Player newPlayer) {
		this.player = newPlayer;
	}

}

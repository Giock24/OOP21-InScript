package gamemaster;

import java.util.ArrayList;
import java.util.Optional;

import cards.Card;
import shared.AppState;
import shared.AppStateSingleton;
import shared.Player;

public class GameMasterControllerImpl implements GameMasterController {
    
    private final GameMaster gameMaster;
    private final UpdateView updateView;
    private final OnGameEnd onGameEnd;
    private Optional<Card> selectedCardToPlace;
    private Optional<Card> selectedCardToShow;
    
    public GameMasterControllerImpl(UpdateView updateView,OnGameEnd onGameEnd) {
        this.updateView = updateView;
        this.onGameEnd = onGameEnd;
        selectedCardToPlace = Optional.empty();
        selectedCardToShow = Optional.empty();
        final AppState appState =  AppStateSingleton.getInstance(); 
        gameMaster= new GameMasterImpl(appState.getHumanPlayerDeck(),appState.getAIPlayerDeck());
        gameMaster.startGame(); //TODO cosider to split the operation in start game in different method for use also slowUpdate
    }

    /**
     * this method check if the game is over
     * 
     * @return true if the game is Over
     */
    private boolean checkGameEnd() {
        if(getHumanPlayer().getLifePoints() <= GameMaster.MIN_PLAYER_LIFE ) {
            this.onGameEnd.end(GameOverLoseMessage);
            return true;
        }
        if(getIAPlayer().getLifePoints() <= GameMaster.MIN_PLAYER_LIFE) {
            this.onGameEnd.end(GameOverWinMessage);
            return true;
        }
        if(getHumanPlayer().getDeck().size() <= 0 || getIAPlayer().getDeck().size() <= 0) {
            this.onGameEnd.end(GameOverTieMessage);
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Card> getCardToPlace() {
        return selectedCardToPlace;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Card> getCardToShow() {
        return selectedCardToShow;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player getHumanPlayer() {
        return gameMaster.getHumanPlayer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player getIAPlayer() {
        return gameMaster.getIAPlayer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSelectCardToShow(final Card card) {
        selectedCardToShow=Optional.of(card);
        updateView.update();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSelectCardToPlace(final Card card) {
        selectedCardToPlace=Optional.of(card);
        
        updateView.update();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCardPlacing(final int indexOfTheCellInTheBoard) {
        if(selectedCardToPlace.isPresent()) {
            gameMaster.getMainPhaseManager().positioning(selectedCardToPlace.get(), indexOfTheCellInTheBoard,false);
            selectedCardToPlace=Optional.empty();
            updateView.update();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onEndTurn() {
        
        
        gameMaster.getBattlePhaseManager().startBattle(false);
        updateView.update();
        if(checkGameEnd())return;
        gameMaster.getDrawPhaseManager().draw(true);
        if(checkGameEnd())return;
        gameMaster.getMainPhaseManagerAI().startAIMainPhase();
        if(checkGameEnd())return;
        updateView.update();
        gameMaster.getBattlePhaseManager().startBattle(true);
        updateView.update();
        if(checkGameEnd())return;
        gameMaster.getDrawPhaseManager().draw(false);
        updateView.update();
        if(checkGameEnd())return;

    
    }




}

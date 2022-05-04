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
    private final OnPhaseChange onPhaseChange;
    private final OnGameEnd onGameEnd;
    private Optional<Card> selectedCardToPlace;
    private Optional<Card> selectedCardToShow;
    
    public GameMasterControllerImpl(UpdateView updateView,OnPhaseChange onPhaseChange,OnGameEnd onGameEnd) {
        this.updateView = updateView;
        this.onPhaseChange = onPhaseChange;
        this.onGameEnd = onGameEnd;
        selectedCardToPlace = Optional.empty();
        selectedCardToShow = Optional.empty();
        final AppState appState =  AppStateSingleton.getInstance(); 
        gameMaster= new GameMasterImpl(appState.getHumanPlayerDeck(),appState.getAIPlayerDeck());
        gameMaster.startGame(); //TODO cosider to split the operation in start game in different method for use also slowUpdate
        this.onPhaseChange.change(MainPhaseMessage);
    }

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

    
    @Override
    public Optional<Card> getCardToPlace() {
        return selectedCardToPlace;
    }
    
    @Override
    public Optional<Card> getCardToShow() {
        return selectedCardToShow;
    }


    @Override
    public Player getHumanPlayer() {
        return gameMaster.getHumanPlayer();
    }

    @Override
    public Player getIAPlayer() {
        return gameMaster.getIAPlayer();
    }

    /**
     * handle the selection for the card to show in the card detail section
     */
    @Override
    public void onSelectCardToShow(final Card card) {
        selectedCardToShow=Optional.of(card);
        updateView.update();
    }

    /**
     *  handle the selection for the card to place in the board
     */
    @Override
    public void onSelectCardToPlace(final Card card) {
        selectedCardToPlace=Optional.of(card);
        
        updateView.update();
    }

    /**
     *  handle the card placing on the board
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
     * handle the turn end
     * 
     */
    @Override
    public void onEndTurn() {
        
        
        gameMaster.getBattlePhaseManager().startBattle(false);
        updateView.update();
        this.onPhaseChange.change(BattlePhaseMessage);
        if(checkGameEnd())return;
        gameMaster.getDrawPhaseManager().draw(true);
        this.onPhaseChange.change(DrawPhaseAIMessage);
        if(checkGameEnd())return;
        gameMaster.getMainPhaseManagerAI().startAIMainPhase();
        if(checkGameEnd())return;
        updateView.update();
        this.onPhaseChange.change(MainPhaseAIMessage);
        gameMaster.getBattlePhaseManager().startBattle(true);
        updateView.update();
        this.onPhaseChange.change(BattlePhaseAIMessage);
        if(checkGameEnd())return;
        gameMaster.getDrawPhaseManager().draw(false);
        updateView.update();
        this.onPhaseChange.change(DrawPhaseMessage);
        if(checkGameEnd())return;
        this.onPhaseChange.change(MainPhaseMessage);

    
    }




}

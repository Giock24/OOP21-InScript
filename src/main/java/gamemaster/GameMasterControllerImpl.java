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
    private final SlowUpdate slowUpdate;
    private final OnGameEnd onGameEnd;
    private Optional<Card> selectedCardToPlace;
    private Optional<Card> selectedCardToShow;
    private boolean isGameEnd;
    
    public GameMasterControllerImpl(UpdateView updateView,SlowUpdate slowUpdate,OnGameEnd onGameEnd) {
        this.updateView = updateView;
        this.slowUpdate = slowUpdate;
        this.onGameEnd = onGameEnd;
        selectedCardToPlace = Optional.empty();
        selectedCardToShow = Optional.empty();
        final AppState appState =  AppStateSingleton.getInstance(); 
        gameMaster= new GameMasterImpl(appState.getHumanPlayerDeck(),appState.getAIPlayerDeck());
        gameMaster.startGame(); //TODO cosider to split the operation in start game in different method for use also slowUpdate
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
    public void onSelectCardToShow(Card card) {
        selectedCardToShow=Optional.of(card);
        updateView.update();
    }

    /**
     *  handle the selection for the card to place in the board
     */
    @Override
    public void onSelectCardToPlace(Card card) {
        selectedCardToPlace=Optional.of(card);
        
        updateView.update();
    }

    /**
     *  handle the card placing on the board
     */
    @Override
    public void onCardPlacing(int indexOfTheCellInTheBoard) {
        System.out.print("on card placing/n");
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
        
        isGameEnd=gameMaster.getBattlePhaseManager().startBattle(false);
        updateView.update();
        slowUpdate.slow();
        if(isGameEnd) {
            this.onGameEnd.end();
        }
        isGameEnd=gameMaster.getDrawPhaseManager().draw(true);
        if(isGameEnd) {
            this.onGameEnd.end();
        }
        //isGameEnd=gameMaster.getMainPhaseManagerAI().startAIMainPhase();
        if(isGameEnd) {
            this.onGameEnd.end();
        }
        updateView.update();
        slowUpdate.slow();
        isGameEnd=gameMaster.getBattlePhaseManager().startBattle(true);
        updateView.update();
        slowUpdate.slow();
        if(isGameEnd) {
            this.onGameEnd.end();
        }
        isGameEnd=gameMaster.getDrawPhaseManager().draw(false);
        if(isGameEnd) {
            this.onGameEnd.end();
        }
    }




}

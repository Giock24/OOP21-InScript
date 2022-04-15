package gamemaster;

import java.util.ArrayList;
import java.util.Optional;

import cards.Card;
import shared.Player;

public class GameMasterControllerImpl implements GameMasterController {
    
    private final GameMaster gameMaster;
    private final UpdateView updateView;
    private final SlowUpdate slowUpdate;
    private Optional<Card> selectedCardToPlace;
    private Optional<Card> selectedCardToShow;
    
    public GameMasterControllerImpl(UpdateView updateView,SlowUpdate slowUpdate) {
        this.updateView = updateView;
        this.slowUpdate = slowUpdate;
        selectedCardToPlace = Optional.empty();
        selectedCardToShow = Optional.empty();
        //TODO add the deck here
        gameMaster= new GameMasterImpl(new ArrayList<Card>(), new ArrayList<Card>());
        gameMaster.startGame(); //TODO cosider to split the operation in start game in differt method for use also slowUpdate
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
        if(selectedCardToPlace.isPresent()) {
            gameMaster.getMainPhaseManager().positioning(selectedCardToPlace.get(), indexOfTheCellInTheBoard);
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
        slowUpdate.slow();
        gameMaster.getDrawPhaseManager().draw(true);
        gameMaster.getMainPhaseManagerAI().startAIMainPhase();
        updateView.update();
        slowUpdate.slow();
        gameMaster.getBattlePhaseManager().startBattle(true);
        updateView.update();
        slowUpdate.slow();
        gameMaster.getDrawPhaseManager().draw(false);
    }




}

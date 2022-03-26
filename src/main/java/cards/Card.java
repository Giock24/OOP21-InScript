package cards;

public interface Card {
    String getIdCard();
    String getName();
    int getLifePoint();
    int getAttack();
    int gatMana();
    Effect getEffect();
    int getPlacementRounds();
    void setArrack(int newValue);
    void setLifePoint(int newValue);
	
}

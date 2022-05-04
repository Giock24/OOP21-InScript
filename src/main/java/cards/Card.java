package cards;

import java.util.Optional;

public interface Card {
    int FIRST_ROUND_PLACED = 1;
    
    String getIdCard();
    String getName();
    int getLifePoint();
    int getAttack();
    int getMana();
    Optional<Effect> getEffect();
    int getPlacementRounds();
    void setPlacementRounds(int newValue);
    void setAttack(int newValue);
    void setLifePoint(int newValue);
    void setName(String newName);
    void setEffect(Optional<Effect> newEffect);
    String getImageURL();
    void setImageURL(String newImageURL);
}

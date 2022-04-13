package cards;

import java.util.Optional;

public interface Card {
    String getIdCard();
    String getName();
    int getLifePoint();
    int getAttack();
    int gatMana();
    Optional<Effect> getEffect();
    int getPlacementRounds();
    void setAttack(int newValue);
    void setLifePoint(int newValue);
    void setName(String newName);
    void setEffect(Optional<Effect> newEffect);
}

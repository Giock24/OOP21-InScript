package cards;

import java.util.Optional;

public class BaseCard implements Card {
	
    String idCard;
    String name;
    int lifeValue;
    int attackValue;
    int manaCost;
    int placementRounds;
    Optional<Effect> effect;
    	
    //file descrizione
    //file immagine
    	
    public BaseCard(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost, final Optional<Effect> effect) {
    	super();
    	this.idCard = idCard;
    	this.name = name;
    	this.lifeValue = lifeValue;
    	this.attackValue = attackValue;
    	this.manaCost = manaCost;
    	this.effect = effect;
    	this.placementRounds = 0;
    }
    
    	
    @Override
    public String getIdCard() {
    	
    	return this.idCard;
    }
    	
    @Override
    public String getName() {
    	
    	return this.name;
    }
    	
    @Override
    public int getLifePoint() {
    	
    	return this.lifeValue;
    }
    
    @Override
    public int getAttack() {
    	
    	return this.attackValue;
    }
    
    @Override
    public int gatMana() {
    	
    	return this.manaCost;
    }
    
    @Override
    public Optional<Effect> getEffect() {
    	
    	return this.effect;
    }
    
    @Override	
    public int getPlacementRounds() {
    	
    	return this.placementRounds;
    }

    @Override
    public void setAttack(final int newValue) {
        
        this.attackValue = newValue;
    }


    @Override
    public void setLifePoint(final int newValue) {
        
        this.lifeValue = newValue;
    }



    @Override
    public void setName(final String newName) {
        
        this.name = newName;  

    }


    @Override
    public void setEffect(final Optional<Effect> newEffect) {
        
        this.effect = newEffect;   

    }
	
}

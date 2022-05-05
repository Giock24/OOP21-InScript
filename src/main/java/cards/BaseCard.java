package cards;

import java.util.Objects;
import java.util.Optional;

import shared.CardIDgenerator;
import shared.CardIDgeneratorImpl;

public class BaseCard implements Card {
	
    String idCard;
    String name;
    int lifeValue;
    int attackValue;
    int manaCost;
    int placementRounds;
    Optional<Effect> effect;
    String imageURL;
    	
    public BaseCard( final String name, final int lifeValue, final int attackValue, final int manaCost, final String imageURL, final Optional<Effect> effect) {
    	super();
        final CardIDgenerator idGenerator = CardIDgeneratorImpl.getIntance();
    	this.idCard = idGenerator.generateID();
    	this.name = name;
    	this.lifeValue = lifeValue;
    	this.attackValue = attackValue;
    	this.manaCost = manaCost;
    	this.effect = effect;
    	this.placementRounds = 0;
    	this.imageURL = imageURL;
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
    public int getMana() {
    	
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


    @Override
    public void setPlacementRounds(final int newValue) {
        
        this.placementRounds = newValue;
        
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idCard);
    }


    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;   
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseCard other = (BaseCard) obj;
        return Objects.equals(idCard, other.idCard);
    }


    @Override
    public String getImageURL() {
        
        return this.imageURL;
    }


    @Override
    public void setImageURL(final String newImageURL) {
        
        this.imageURL = newImageURL;
    }
	
}

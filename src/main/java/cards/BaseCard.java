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
	
	public BaseCard(String idCard, String name, int lifeValue, int attackValue, int manaCost, Optional<Effect> effect) {
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
	
	public int getPlacementRounds() {
		
		return this.placementRounds;
	}


    @Override
    public void setAttack(int newValue) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void setLifePoint(int newValue) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void setName(String newName) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void setEffect(Optional<Effect> newEffect) {
        // TODO Auto-generated method stub
        
    }
	
}

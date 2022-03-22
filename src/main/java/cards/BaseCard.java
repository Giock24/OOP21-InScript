package cards;

public class BaseCard implements Card {
	
	String idCard;
	String name;
	int lifeValue;
	int attackValue;
	int manaCost;
	int placementRounds;
	Effect effect;
	
	//file descrizione
	//file immagine
	
	public BaseCard(String idCard, String name, int lifeValue, int attackValue, int manaCost, Effect effect) {
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
	public Effect getEffect() {
		
		return this.effect;
	}
	
	public int getPlacementRounds() {
		
		return this.placementRounds;
	}
	
}

package cards;

public abstract class AbstractEffect implements Effect {
	
	String effectName;
	String effectDescription;
	
	public AbstractEffect(final String effectName, final String effectDescription) {
		super();
		this.effectName = effectName;
		this.effectDescription = effectDescription;
	}
	
	
	public String getNameEffect() {
		return this.effectName;
	}
	
	
	public String getDescriptionEffect() {
		return this.effectDescription;
	}
	
}

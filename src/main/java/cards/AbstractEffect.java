package cards;

public abstract class AbstractEffect implements Effect {
	
    String effectName;
    String effectDescription;
    String imageEffectURL;
    	
    public AbstractEffect(final String effectName, final String effectDescription, final String imageEffectURL) {
    	super();
    	this.effectName = effectName;
    	this.effectDescription = effectDescription;
    	this.imageEffectURL = imageEffectURL;
    }
    	
    	
    public String getNameEffect() {
    	return this.effectName;
    }
    	
    	
    public String getDescriptionEffect() {
    	return this.effectDescription;
    }
    
    public String getImageEffectURL() {
        return this.imageEffectURL;    
    }
    
    public void setImageEffectURL(final String newImageEffectURL) {
        this.imageEffectURL = newImageEffectURL;
    }
    
    @Override
    public String toString() {
        return "\n"
                + "Effect Name : " + this.effectName + "\n"
                + "imageURL : " + this.imageEffectURL + "\n";
    }
	
}

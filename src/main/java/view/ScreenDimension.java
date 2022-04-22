package view;

import java.awt.Toolkit;

public enum ScreenDimension {
    
    HEIGHT(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3),
    WIDTH(HEIGHT.getValue() * 1.78),
    
    CARD_HEIGHT(HEIGHT.getValue() * 0.23),
    CARD_WIDTH(CARD_HEIGHT.getValue() * 0.58);
    
    
    private double value;
    private double minValue;
    
    ScreenDimension(final double value) {
        this.value = value;
        this.minValue = value;
    }
    
    /**
     * @return the size's value
     */
    public double getValue() {
        return this.value;
    }
    
    /**
     * @return min value to resize a Stage
     */
    public double getMinValue() {
        return this.minValue;
    }
    
    /**
     * @param value is the new size's value to set
     */
    public void setCurrentValue(final double value) {
        this.value = value;
    }

}

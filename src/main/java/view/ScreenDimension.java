package view;

import java.awt.Toolkit;

public enum ScreenDimension {
    
    HEIGHT(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3),
    WIDTH(HEIGHT.getValue() * 1.78);
    
    private double value;
    
    ScreenDimension(final double value) {
        this.value = value;
    }
    
    /**
     * @return the size's value
     */
    public double getValue() {
        return this.value;
    }

}

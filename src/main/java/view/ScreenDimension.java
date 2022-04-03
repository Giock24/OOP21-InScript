package view;

import java.awt.Toolkit;

public enum ScreenDimension {
    
    WIDTH(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2),
    HEIGHT(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3);
    
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

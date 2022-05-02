package gamemaster;

/**
 * the function pass with this interface will be change the grafich when the phase change
 *
 */
@FunctionalInterface
public interface OnPhaseChange {
    void change(String phase);
}

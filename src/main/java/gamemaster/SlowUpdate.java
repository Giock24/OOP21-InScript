package gamemaster;

/**
 * the function pass with this interface will be call for slow down the update during the IA turn
 * and let the user understand the change 
 *
 */
@FunctionalInterface
public interface SlowUpdate {
    void slow();
}

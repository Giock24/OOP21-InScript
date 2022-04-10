package gamemaster;

/**
 * the function pass with this interface will be call for update the view after a change
 *
 */
@FunctionalInterface
public interface UpdateView {
    void update();
}
package gamemaster;

/**
 *  the function pass with this interface will be call when the game end
 *
 */
@FunctionalInterface
public interface OnGameEnd {
    void end();
}

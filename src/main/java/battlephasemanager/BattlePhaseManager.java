package battlephasemanager;

import shared.PhaseManager;

public interface BattlePhaseManager extends PhaseManager {
    void startBattle(boolean isTheAIturn);
}

package codingdojo;

import java.util.List;

public class BuffList {
    private final List<Buff> buffs;

    public BuffList(List<Buff> buffs) {
        this.buffs = buffs;
    }

    List<Buff> getBuffs() {
        return buffs;
    }

    private float getSoakModifierTotal() {
        return (float) getBuffs()
                .stream()
                .mapToDouble(Buff::soakModifier)
                .sum();
    }

    float getSoakMultiplier() {
        return getSoakModifierTotal() + 1f;
    }
}
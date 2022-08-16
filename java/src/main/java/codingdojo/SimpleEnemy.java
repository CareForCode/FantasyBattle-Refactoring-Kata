package codingdojo;

import java.util.List;

public class SimpleEnemy implements Target {

    private final Armor armor;
    private final BuffList buffList;

    public SimpleEnemy(Armor armor, List<Buff> buffs) {
        this.armor = armor;
        this.buffList = new BuffList(buffs);
    }

    @Override
    public int getSoak() {
        return Math.round(armor.getDamageSoak() * buffList.getSoakMultiplier());
    }

}

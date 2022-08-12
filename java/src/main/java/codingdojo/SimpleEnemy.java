package codingdojo;

import java.util.List;

public class SimpleEnemy implements Target {

    private final Armor armor;
    private final BuffList buffList;

    public SimpleEnemy(Armor armor, List<Buff> buffs) {
        this.armor = armor;
        this.buffList = new BuffList(buffs);
    }

    Armor getArmor() {
        return this.armor;
    }

    @Override
    public int getSoak() {
        return Math.round(getArmor().getDamageSoak() * (buffList.getSoakModifierTotal() + 1f));
    }

}

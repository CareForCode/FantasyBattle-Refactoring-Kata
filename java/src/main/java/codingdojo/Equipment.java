package codingdojo;


class Equipment {
    // TODO add a ring item that may be equipped
    //  that may also add damage modifier
    private final Shield shield;
    private final Sword sword;
    private final ArmorList armorList;

    Equipment(Sword sword, Shield shield, HeadArmor headArmor, FeetArmor feetArmor, ChestArmor chestArmor) {
        this.shield = shield;
        this.sword = sword;
        this.armorList = new ArmorList(headArmor, feetArmor, chestArmor);
    }

    Shield getShield() {
        return shield;
    }
    Sword getSword() {
        return sword;
    }

    private int getBaseDamage() {
        return getSword().getBaseDamage();
    }

    private float getDamageModifier(int strength) {
        Shield leftHand = getShield();
        Sword rightHand = getSword();
        float strengthModifier = strength * 0.1f;
        return strengthModifier +
                leftHand.getDamageModifier() +
                rightHand.getDamageModifier() +
                armorList.getTotalDamageModifier();
    }

    int getTotalDamage(int strength) {
        int baseDamage = getBaseDamage();
        float damageModifier = getDamageModifier(strength);
        return Math.round(baseDamage * damageModifier);
    }
}

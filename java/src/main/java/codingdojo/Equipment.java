package codingdojo;


class Equipment {
    // TODO add a ring item that may be equipped
    //  that may also add damage modifier
    private final Shield shield;
    private final Sword sword;
    private final HeadArmor headArmor;
    private final FeetArmor feetArmor;
    private final ChestArmor chestArmor;

    Equipment(Sword sword, Shield shield, HeadArmor headArmor, FeetArmor feetArmor, ChestArmor chestArmor) {
        this.shield = shield;
        this.sword = sword;
        this.headArmor = headArmor;
        this.feetArmor = feetArmor;
        this.chestArmor = chestArmor;
    }

    Shield getShield() {
        return shield;
    }
    Sword getSword() {
        return sword;
    }
    HeadArmor getHeadArmor() {
        return headArmor;
    }
    FeetArmor getFeetArmor() {
        return feetArmor;
    }
    ChestArmor getChestArmor() {
        return chestArmor;
    }

    private int getBaseDamage() {
        return getSword().getBaseDamage();
    }

    private float getDamageModifier(int strength) {
        Shield leftHand = getShield();
        Sword rightHand = getSword();
        HeadArmor head = getHeadArmor();
        FeetArmor feet = getFeetArmor();
        ChestArmor chest = getChestArmor();
        float strengthModifier = strength * 0.1f;
        return strengthModifier +
                leftHand.getDamageModifier() +
                rightHand.getDamageModifier() +
                head.getDamageModifier() +
                feet.getDamageModifier() +
                chest.getDamageModifier();
    }

    int getTotalDamage(int strength) {
        int baseDamage = getBaseDamage();
        float damageModifier = getDamageModifier(strength);
        return Math.round(baseDamage * damageModifier);
    }
}

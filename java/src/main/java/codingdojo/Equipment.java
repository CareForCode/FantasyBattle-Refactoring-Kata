package codingdojo;


class Equipment {
    // TODO add a ring item that may be equipped
    //  that may also add damage modifier
    private final Shield leftHand;
    private final Sword rightHand;
    private final HeadArmor head;
    private final FeetArmor feet;
    private final ChestArmor chest;

    Equipment(Shield leftHand, Sword rightHand, HeadArmor head, FeetArmor feet, ChestArmor chest) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.head = head;
        this.feet = feet;
        this.chest = chest;
    }

    Shield getLeftHand() {
        return leftHand;
    }
    Sword getRightHand() {
        return rightHand;
    }
    HeadArmor getHead() {
        return head;
    }
    FeetArmor getFeet() {
        return feet;
    }
    ChestArmor getChest() {
        return chest;
    }

    private int getBaseDamage() {
        return getRightHand().getBaseDamage();
    }

    private float getDamageModifier(int strength) {
        Shield leftHand = getLeftHand();
        Sword rightHand = getRightHand();
        HeadArmor head = getHead();
        FeetArmor feet = getFeet();
        ChestArmor chest = getChest();
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

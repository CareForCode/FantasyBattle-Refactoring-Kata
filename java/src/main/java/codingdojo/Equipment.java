package codingdojo;


class Equipment {
    // TODO add a ring item that may be equipped
    //  that may also add damage modifier
    private final PlayerWeapon leftHand;
    private final PlayerWeapon rightHand;
    private final ArmorPiece head;
    private final Item feet;
    private final Item chest;

    Equipment(PlayerWeapon leftHand, PlayerWeapon rightHand, ArmorPiece head, Item feet, Item chest) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.head = head;
        this.feet = feet;
        this.chest = chest;
    }

    PlayerWeapon getLeftHand() {
        return leftHand;
    }
    PlayerWeapon getRightHand() {
        return rightHand;
    }
    ArmorPiece getHead() {
        return head;
    }
    Item getFeet() {
        return feet;
    }
    Item getChest() {
        return chest;
    }

    private int getBaseDamage() {
        PlayerWeapon leftHand = getLeftHand();
        PlayerWeapon rightHand = getRightHand();
        Item feet = getFeet();
        Item chest = getChest();
        return leftHand.getBaseDamage() +
                rightHand.getBaseDamage() +
                feet.getBaseDamage() +
                chest.getBaseDamage();
    }

    private float getDamageModifier(int strength) {
        PlayerWeapon leftHand = getLeftHand();
        PlayerWeapon rightHand = getRightHand();
        ArmorPiece head = getHead();
        Item feet = getFeet();
        Item chest = getChest();
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

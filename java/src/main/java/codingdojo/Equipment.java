package codingdojo;


class Equipment {
    // TODO add a ring item that may be equipped
    //  that may also add damage modifier
    private final Shield leftHand;
    private final Sword rightHand;
    private final ArmorPiece head;
    private final ArmorPiece feet;
    private final ArmorPiece chest;

    Equipment(Shield leftHand, Sword rightHand, ArmorPiece head, ArmorPiece feet, ArmorPiece chest) {
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
    ArmorPiece getHead() {
        return head;
    }
    ArmorPiece getFeet() {
        return feet;
    }
    ArmorPiece getChest() {
        return chest;
    }

    private int getBaseDamage() {
        return getRightHand().getBaseDamage();
    }

    private float getDamageModifier(int strength) {
        Shield leftHand = getLeftHand();
        Sword rightHand = getRightHand();
        ArmorPiece head = getHead();
        ArmorPiece feet = getFeet();
        ArmorPiece chest = getChest();
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

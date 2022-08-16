package codingdojo;

public class ArmorPiece implements PlayerArmor {

    private final float damageModifier;
    private final ArmorType armorType;

    public ArmorPiece(ArmorType armorType, float damageModifier) {
        this.damageModifier = damageModifier;
        this.armorType = armorType;
    }

    @Override
    public float getDamageModifier() {
        return damageModifier;
    }
}

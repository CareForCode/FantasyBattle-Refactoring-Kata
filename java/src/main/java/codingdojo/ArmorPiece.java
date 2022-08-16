package codingdojo;

public class ArmorPiece implements PlayerArmor {
    protected final float damageModifier;

    public ArmorPiece(float damageModifier) {
        this.damageModifier = damageModifier;
    }

    @Override
    public float getDamageModifier() {
        return damageModifier;
    }
}

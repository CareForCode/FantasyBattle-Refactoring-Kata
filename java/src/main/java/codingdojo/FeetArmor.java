package codingdojo;

public class FeetArmor implements PlayerArmor {

    private final float damageModifier;

    public FeetArmor(float damageModifier) {
        this.damageModifier = damageModifier;
    }

    @Override
    public float getDamageModifier() {
        return damageModifier;
    }
}

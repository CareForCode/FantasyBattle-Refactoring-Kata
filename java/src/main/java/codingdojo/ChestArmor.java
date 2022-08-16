package codingdojo;

public class ChestArmor implements PlayerArmor {

    private final float damageModifier;

    public ChestArmor(float damageModifier) {
        this.damageModifier = damageModifier;
    }

    @Override
    public float getDamageModifier() {
        return damageModifier;
    }
}

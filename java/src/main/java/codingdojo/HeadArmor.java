package codingdojo;

public class HeadArmor implements PlayerArmor {

    private final float damageModifier;

    public HeadArmor(float damageModifier) {
        this.damageModifier = damageModifier;
    }

    @Override
    public float getDamageModifier() {
        return damageModifier;
    }
}

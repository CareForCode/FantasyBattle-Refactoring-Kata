package codingdojo;

public class Shield implements Weapon {

    private final float damageModifier;

    public Shield(float damageModifier) {
        this.damageModifier = damageModifier;
    }

    @Override
    public int getBaseDamage() {
        return 0;
    }

    @Override
    public float getDamageModifier() {
        return damageModifier;
    }
}

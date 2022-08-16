package codingdojo;

public class Sword implements Weapon {

    private final int baseDamage;
    private final float damageModifier;

    public Sword(int baseDamage, float damageModifier) {
        this.baseDamage = baseDamage;
        this.damageModifier = damageModifier;
    }

    @Override
    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public float getDamageModifier() {
        return damageModifier;
    }
}

package codingdojo;

public class PlayerWeapon implements Weapon {

    private final int baseDamage;
    private final float damageModifier;

    public PlayerWeapon(int baseDamage, float damageModifier) {
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

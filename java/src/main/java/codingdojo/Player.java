package codingdojo;


class Player extends Target {
    private final Stats stats;
    private final Equipment equipment;

    Player(Stats stats, Equipment equipment) {
        this.stats = stats;
        this.equipment = equipment;
    }

    Damage calculateDamage(Target other) {
        int baseDamage = equipment.getBaseDamage();
        float damageModifier = equipment.getDamageModifier(stats.getStrength());
        int totalDamage = Math.round(baseDamage * damageModifier);
        int soak = getSoak(other, totalDamage);
        return new Damage(Math.max(0, totalDamage - soak));
    }

    private int getSoak(Target other, int totalDamage) {
        int soak = 0;
        if (other instanceof Player) {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak = totalDamage;
        } else if (other instanceof SimpleEnemy) {
            SimpleEnemy simpleEnemy = (SimpleEnemy) other;
            soak = Math.round(
                simpleEnemy.getArmor().getDamageSoak() *
                (
                    ((float) simpleEnemy.getBuffs()
                        .stream()
                        .mapToDouble(Buff::soakModifier)
                        .sum()) +
                    1f
                )
            );
        }
        return soak;
    }

}

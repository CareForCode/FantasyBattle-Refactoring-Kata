package codingdojo;


class Player extends Target {
    private final Stats stats;
    private final Equipment equipment;

    Player(Stats stats, Equipment equipment) {
        this.stats = stats;
        this.equipment = equipment;
    }

    Damage calculateDamage(Target other) {
        int totalDamage = equipment.getTotalDamage(stats.getStrength());
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
            soak = simpleEnemy.getSoak();
        }
        return soak;
    }

}

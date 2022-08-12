package codingdojo;


class Player implements Target {
    private final Stats stats;
    private final Equipment equipment;

    Player(Stats stats, Equipment equipment) {
        this.stats = stats;
        this.equipment = equipment;
    }

    Damage calculateDamage(Target other) {
        int totalDamage = equipment.getTotalDamage(stats.getStrength());
        int soak1 = 0;
        if (other instanceof Player) {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak1 = getSoak();
        } else if (other instanceof SimpleEnemy) {
            SimpleEnemy simpleEnemy = (SimpleEnemy) other;
            soak1 = simpleEnemy.getSoak();
        }
        int soak = soak1;
        return new Damage(Math.max(0, totalDamage - soak));
    }

    @Override
    public int getSoak() {
        return Integer.MAX_VALUE;
    }
}

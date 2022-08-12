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
        int soak = other.getSoak(totalDamage);
        return new Damage(Math.max(0, totalDamage - soak));
    }

}

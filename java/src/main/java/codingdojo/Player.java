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
        return new Damage(Math.max(0, totalDamage - other.getSoak()));
    }

    @Override
    public int getSoak() {
        // TODO: Not implemented yet
        //  Add friendly fire
        return Integer.MAX_VALUE;
    }
}

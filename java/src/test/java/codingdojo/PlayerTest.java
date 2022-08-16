package codingdojo;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class PlayerTest {

    public static final int INVENTORY_DMG = 65;
    private final Equipment equipment = new Equipment(
            new Sword(10, 1.0f), new Shield(1.4f),
            new HeadArmor( 1.2f),
            new FeetArmor( 0.1f),
            new ChestArmor( 1.4f),
            new Ring(0.2f));
    private final Stats stats = new Stats(13);
    private final Player player = new Player(stats, equipment);
    private final SimpleArmor armor = new SimpleArmor(1);

    @Test
    void damageEnemyWithoutBuffs() {
        SimpleEnemy target = new SimpleEnemy(armor, Collections.emptyList());

        Damage damage = player.calculateDamage(target);

        assertEquals(INVENTORY_DMG, damage.getAmount());
    }

    @Test
    void damageEnemyWithBuff() {
        float soak = 3f;
        SimpleEnemy target = new SimpleEnemy(armor, Collections.singletonList(new BasicBuff(soak)));

        Damage damage = player.calculateDamage(target);

        assertEquals(INVENTORY_DMG-soak, damage.getAmount());
    }

    @Test
    void damageOtherPlayer() {
        Player otherPlayer = new Player(stats, equipment);

        Damage damage = player.calculateDamage(otherPlayer);

        assertEquals(0, damage.getAmount());
    }
}

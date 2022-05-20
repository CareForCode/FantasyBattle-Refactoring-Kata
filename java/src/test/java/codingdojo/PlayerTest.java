package codingdojo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class PlayerTest {

    private final Inventory inventory = new Inventory(new Equipment(
            new BasicItem("lefthand", 1, 0.8f),
            new BasicItem("rightHand", 2, 0.5f),
            new BasicItem("head", 3, 0.3f),
            new BasicItem("feet", 5, 0.2f),
            new BasicItem("chest", 8, 0.1f)));
    private final Stats stats = new Stats(13);
    private final Player player = new Player(inventory, stats);
    private final SimpleArmor armor = new SimpleArmor(1);

    @Test
    void damageEnemyWithoutBuffs() {
        SimpleEnemy target = new SimpleEnemy(armor, Collections.emptyList());

        Damage damage = player.calculateDamage(target);

        assertEquals(60, damage.getAmount());
    }

    @Test
    void damageEnemyWithBuff() {
        SimpleEnemy target = new SimpleEnemy(armor, Collections.singletonList(new BasicBuff(3f, 5f)));

        Damage damage = player.calculateDamage(target);

        assertEquals(57, damage.getAmount());
    }
}

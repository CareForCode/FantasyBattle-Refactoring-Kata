package codingdojo;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class PlayerTest {

    public static final int INVENTORY_DMG = 60;
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
        Player otherPlayer = new Player(inventory, stats);

        Damage damage = player.calculateDamage(otherPlayer);

        assertEquals(0, damage.getAmount());
    }
}

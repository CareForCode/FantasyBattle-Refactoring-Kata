package codingdojo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class PlayerTest {
    @Test
    void damageEnemyWithoutBuffs() {
        Inventory inventory = new Inventory(new Equipment(
                new BasicItem("lefthand", 1, 0.8f),
                new BasicItem("rightHand", 2, 0.5f),
                new BasicItem("head", 3, 0.3f),
                new BasicItem("feet", 5, 0.2f),
                new BasicItem("chest", 8, 0.1f)));
        Stats stats = new Stats(13);
        SimpleEnemy target = new SimpleEnemy(new SimpleArmor(1), Collections.emptyList());
        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(60, damage.getAmount());
    }


    @Test
    void damageEnemyWithBuff() {
        Inventory inventory = new Inventory(new Equipment(
                new BasicItem("lefthand", 1, 0.8f),
                new BasicItem("rightHand", 2, 0.5f),
                new BasicItem("head", 3, 0.3f),
                new BasicItem("feet", 5, 0.2f),
                new BasicItem("chest", 8, 0.1f)));
        Stats stats = new Stats(13);
        SimpleEnemy target = new SimpleEnemy(new SimpleArmor(1), Collections.singletonList(new BasicBuff(3f, 5f)));
        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(57, damage.getAmount());
    }
}

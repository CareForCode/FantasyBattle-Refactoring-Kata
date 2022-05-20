package codingdojo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class PlayerTest {

    @Test
    void damageCalculations() {
        Inventory inventory = new Inventory(new Equipment(
                new BasicItem("", 0, 0.0f),
                new BasicItem("", 0, 0.0f),
                new BasicItem("", 0, 0.0f),
                new BasicItem("", 0, 0.0f),
                new BasicItem("", 0, 0.0f)));
        Stats stats = new Stats(0);
        SimpleEnemy target = new SimpleEnemy(new SimpleArmor(1), Collections.emptyList());
        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(0, damage.getAmount());
    }

    @Test
    void damageCalculations2() {
        Inventory inventory = new Inventory(new Equipment(
                new BasicItem("lefthand", 10, 1.0f),
                new BasicItem("rightHand", 10, 1.0f),
                new BasicItem("head", 10, 1.0f),
                new BasicItem("feet", 10, 1.0f),
                new BasicItem("chest", 10, 1.0f)));
        Stats stats = new Stats(0);
        SimpleEnemy target = new SimpleEnemy(new SimpleArmor(0), Collections.emptyList());
        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(250, damage.getAmount());
    }

}

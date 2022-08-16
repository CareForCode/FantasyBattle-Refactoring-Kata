package codingdojo;

import java.util.Arrays;
import java.util.List;

public class ArmorList {
    private final List<PlayerArmor> armorList;

    public ArmorList(PlayerArmor... armor) {
        armorList = Arrays.asList(armor);
    }

    public float getTotalDamageModifier() {
        return armorList.stream()
                .map(PlayerArmor::getDamageModifier)
                .reduce(0f, Float::sum);
    }
}
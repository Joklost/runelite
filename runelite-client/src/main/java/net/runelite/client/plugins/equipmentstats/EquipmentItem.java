package net.runelite.client.plugins.equipmentstats;


import lombok.Getter;
import lombok.Setter;
import net.runelite.api.EquipmentInventorySlot;

public class EquipmentItem {
    private static final StringBuilder builder = new StringBuilder();

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private EquipmentInventorySlot slot;

    @Getter
    @Setter
    private boolean twoHanded;

    @Getter
    @Setter
    private CombatStats combatStats;

    EquipmentItem() {
    }

    EquipmentItem(String name, EquipmentInventorySlot slot, boolean twoHanded, CombatStats combatStats) {
        this.name = name;
        this.slot = slot;
        this.twoHanded = twoHanded;
        this.combatStats = combatStats;
    }

    String buildTooltip() {

        if (!combatStats.isPureDefensiveItem()) {
            builder.append("Attack bonus:</br>")
                    .append(CombatStats.buildStatString("Stab: ", combatStats.getStabAttack(), null))
                    .append(CombatStats.buildStatString("Slash: ", combatStats.getSlashAttack(), null))
                    .append(CombatStats.buildStatString("Crush: ", combatStats.getCrushAttack(), null))
                    .append(CombatStats.buildStatString("Magic: ", combatStats.getRangeAttack(), null))
                    .append(CombatStats.buildStatString("Range: ", combatStats.getRangeAttack(), null))
                    .append("</br>");
        }

        if (!combatStats.isPureOffensiveItem()) {
            builder.append("Defence bonus:</br>")
                    .append(CombatStats.buildStatString("Stab: ", combatStats.getStabDefence(), null))
                    .append(CombatStats.buildStatString("Slash: ", combatStats.getSlashDefence(), null))
                    .append(CombatStats.buildStatString("Crush: ", combatStats.getCrushDefence(), null))
                    .append(CombatStats.buildStatString("Magic: ", combatStats.getRangeDefence(), null))
                    .append(CombatStats.buildStatString("Range: ", combatStats.getRangeDefence(), null))
                    .append("</br>");
        }

        if (!combatStats.isBonusLess()) {
            builder.append("Other bonuses:</br>");

            // There is no reason to show all of these, as items will
            // generally only have one or two of these.
            if (combatStats.getMeleeStrength() != 0) {
                builder.append(CombatStats.buildStatString("Melee strength: ", combatStats.getMeleeStrength(), null));
            }
            if (combatStats.getRangedStrength() != 0) {
                builder.append(CombatStats.buildStatString("Ranged strength: ", combatStats.getRangedStrength(), null));
            }
            if (combatStats.getMagicDamage() != 0) {
                builder.append(CombatStats.buildStatString("Magic damage: ", combatStats.getMagicDamage(), ".0%"));
            }
            if (combatStats.getPrayer() != 0) {
                builder.append(CombatStats.buildStatString("Prayer: ", combatStats.getPrayer(), null));
            }

            builder.append("</br>");
        }

        if (!combatStats.isRegularItem()) {
            builder.append("Target-specific:</br>");

            // There is no reason to show both of these, as no item actually has both.
            if (combatStats.getUndeadDamage() != 0) {
                builder.append(CombatStats.buildStatString("Undead: ", combatStats.getUndeadDamage(), ".0%"));
            }

            if (combatStats.getSlayerDamage() != 0) {
                builder.append(CombatStats.buildStatString("Slayer: ", combatStats.getSlayerDamage(), ".0%"));
            }
        }

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }
}

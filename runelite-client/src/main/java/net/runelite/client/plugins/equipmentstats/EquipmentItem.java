package net.runelite.client.plugins.equipmentstats;


import lombok.Getter;
import lombok.Setter;
import net.runelite.api.EquipmentInventorySlot;

public class EquipmentItem {
    private final StringBuilder builder = new StringBuilder();

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

    public String buildTooltip() {

        if (!combatStats.isPureDefensiveItem()) {
            builder.append("Attack bonus:</br>");

            // Possibly hide 0's here as well?
            builder.append(combatStats.buildStabAttackString()).append("</br>");
            builder.append(combatStats.buildSlashAttackString()).append("</br>");
            builder.append(combatStats.buildCrushAttackString()).append("</br>");
            builder.append(combatStats.buildMagicAttackString()).append("</br>");
            builder.append(combatStats.buildRangeAttackString()).append("</br>");
            builder.append("</br>");
        }

        if (!combatStats.isPureOffensiveItem()) {
            builder.append("Defence bonus:</br>");

            // And here too.
            builder.append(combatStats.buildStabDefenceString()).append("</br>");
            builder.append(combatStats.buildSlashDefenceString()).append("</br>");
            builder.append(combatStats.buildCrushDefenceString()).append("</br>");
            builder.append(combatStats.buildMagicDefenceString()).append("</br>");
            builder.append(combatStats.buildRangeDefenceString()).append("</br>");
            builder.append("</br>");
        }

        if (!combatStats.isBonusLess()) {
            builder.append("Other bonuses:</br>");

            // There is no reason to show all of these, as items will
            // generally only have one or two of these.
            if (combatStats.getMeleeStrength() != 0) {
                builder.append(combatStats.buildMeleeStrengthString()).append("</br>");
            }
            if (combatStats.getRangedStrength() != 0) {
                builder.append(combatStats.buildRangedStrengthString()).append("</br>");
            }
            if (combatStats.getMagicDamage() != 0) {
                builder.append(combatStats.buildMagicDamageString()).append("</br>");
            }
            if (combatStats.getPrayer() != 0) {
                builder.append(combatStats.buildPrayerString()).append("</br>");
            }

            builder.append("</br>");
        }

        if (!combatStats.isRegularItem()) {
            builder.append("Target-specific:</br>");

            // There is no reason to show both of these, as no item actually has both.
            if (combatStats.getUndeadDamage() != 0) {
                builder.append(combatStats.buildUndeadDamageString()).append("</br>");
            }

            if (combatStats.getSlayerDamage() != 0) {
                builder.append(combatStats.buildSlayerDamageString()).append("</br>");
            }
        }

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }
}

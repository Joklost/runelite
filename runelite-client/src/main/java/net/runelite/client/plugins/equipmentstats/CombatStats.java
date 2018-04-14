package net.runelite.client.plugins.equipmentstats;

import lombok.Getter;
import lombok.Setter;

class CombatStats {
    private final StringBuilder builder = new StringBuilder();

    // These boolean properties are used to determine what
    // to hide from the tooltip, as the tooltip will
    // become very large with every single stat included.

    @Getter
    private final boolean pureDefensiveItem;

    @Getter
    private final boolean pureOffensiveItem;

    @Getter
    private final boolean regularItem;

    @Getter
    private final boolean bonusLess;

    @Getter
    private final boolean statLess;


    @Getter
    @Setter
    private int stabAttack;

    String buildStabAttackString() {
        builder.append("Stab: ")
                .append(getStabAttack() > 0 ? "+" : "")
                .append(getStabAttack());

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    @Getter
    @Setter
    private int slashAttack;

    String buildSlashAttackString() {
        builder.append("Slash: ")
                .append(getSlashAttack() > 0 ? "+" : "")
                .append(getSlashAttack());

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    @Getter
    @Setter
    private int crushAttack;

    String buildCrushAttackString() {
        builder.append("Crush: ")
                .append(getCrushAttack() > 0 ? "+" : "")
                .append(getCrushAttack());

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    @Getter
    @Setter
    private int magicAttack;

    String buildMagicAttackString() {
        builder.append("Magic: ")
                .append(getMagicAttack() > 0 ? "+" : "")
                .append(getMagicAttack());

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    @Getter
    @Setter
    private int rangeAttack;

    String buildRangeAttackString() {
        builder.append("Range: ")
                .append(getRangeAttack() > 0 ? "+" : "")
                .append(getRangeAttack());

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    @Getter
    @Setter
    private int stabDefence;

    String buildStabDefenceString() {
        builder.append("Stab: ")
                .append(getStabDefence() > 0 ? "+" : "")
                .append(getStabDefence());

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    @Getter
    @Setter
    private int slashDefence;

    String buildSlashDefenceString() {
        builder.append("Slash: ")
                .append(getSlashDefence() > 0 ? "+" : "")
                .append(getSlashDefence());

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    @Getter
    @Setter
    private int crushDefence;

    String buildCrushDefenceString() {
        builder.append("Crush: ")
                .append(getCrushDefence() > 0 ? "+" : "")
                .append(getCrushDefence());

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    @Getter
    @Setter
    private int magicDefence;

    String buildMagicDefenceString() {
        builder.append("Magic: ")
                .append(getMagicDefence() > 0 ? "+" : "")
                .append(getMagicDefence());

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    @Getter
    @Setter
    private int rangeDefence;

    String buildRangeDefenceString() {
        builder.append("Range: ")
                .append(getRangeDefence() > 0 ? "+" : "")
                .append(getRangeDefence());

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    @Getter
    @Setter
    private int meleeStrength;

    String buildMeleeStrengthString() {
        builder.append("Melee strength: ")
                .append(getMeleeStrength() > 0 ? "+" : "")
                .append(getMeleeStrength());

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    @Getter
    @Setter
    private int rangedStrength;

    String buildRangedStrengthString() {
        builder.append("Ranged strength: ")
                .append(getRangedStrength() > 0 ? "+" : "")
                .append(getRangedStrength());

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    @Getter
    @Setter
    private int magicDamage;

    String buildMagicDamageString() {
        builder.append("Magic damage: ")
                .append(getMagicDamage() > 0 ? "+" : "")
                .append(getMagicDamage())
                .append(".0%");

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    @Getter
    @Setter
    private int prayer;

    String buildPrayerString() {
        builder.append("Prayer: ")
                .append(getPrayer() > 0 ? "+" : "")
                .append(getPrayer());

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    @Getter
    @Setter
    private int undeadDamage;

    String buildUndeadDamageString() {
        builder.append("Undead: ")
                .append(getUndeadDamage() > 0 ? "+" : "")
                .append(getUndeadDamage())
                .append(".0%");

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    @Getter
    @Setter
    private int slayerDamage;

    String buildSlayerDamageString() {
        builder.append("Slayer: ")
                .append(getSlayerDamage() > 0 ? "+" : "")
                .append(getSlayerDamage())
                .append(".0%");

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    CombatStats(int stabAttack, int slashAttack, int crushAttack, int magicAttack, int rangeAttack, int stabDefence, int slashDefence, int crushDefence, int magicDefence, int rangeDefence, int meleeStrength, int rangedStrength, int magicDamage, int prayer, int undeadDamage, int slayerDamage) {
        this.stabAttack = stabAttack;
        this.slashAttack = slashAttack;
        this.crushAttack = crushAttack;
        this.magicAttack = magicAttack;
        this.rangeAttack = rangeAttack;
        this.pureDefensiveItem = (stabAttack == 0) && (slashAttack == 0) && (crushAttack == 0) && (magicAttack == 0) && (rangeAttack == 0);

        this.stabDefence = stabDefence;
        this.slashDefence = slashDefence;
        this.crushDefence = crushDefence;
        this.magicDefence = magicDefence;
        this.rangeDefence = rangeDefence;
        this.pureOffensiveItem = (stabDefence == 0) && (slashDefence == 0) && (crushDefence == 0) && (magicDefence == 0) && (rangeDefence == 0);

        this.meleeStrength = meleeStrength;
        this.rangedStrength = rangedStrength;
        this.magicDamage = magicDamage;
        this.prayer = prayer;
        this.bonusLess = (meleeStrength == 0) && (rangedStrength == 0) && (magicDamage == 0) && (prayer == 0);

        this.undeadDamage = undeadDamage;
        this.slayerDamage = slayerDamage;
        this.regularItem = (undeadDamage == 0) && (slayerDamage == 0);

        this.statLess = this.pureDefensiveItem && this.pureOffensiveItem && this.bonusLess && this.regularItem;
    }
}

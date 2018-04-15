package net.runelite.client.plugins.equipmentstats;

import lombok.Getter;
import lombok.Setter;

class CombatStats {
    private static final StringBuilder builder = new StringBuilder();

    // These boolean properties are used to determine what
    // to hide from the tooltip, as the tooltip will
    // become very large with every single stat included.

    @Getter
    private static boolean pureDefensiveItem;

    @Getter
    private static boolean pureOffensiveItem;

    @Getter
    private static boolean regularItem;

    @Getter
    private static boolean bonusLess;

    @Getter
    private static boolean statLess;


     static String buildStatString(String prefix, int stat, String postfix) {
        builder.append(prefix)
                .append(stat > 0 ? "+" : "")
                .append(stat);

        if (postfix != null) {
            builder.append(postfix);
        }

        builder.append("</br>");

        final String text = builder.toString();
        builder.setLength(0);
        return text;
    }

    @Getter
    @Setter
    private int stabAttack;
    @Getter
    @Setter
    private int slashAttack;
    @Getter
    @Setter
    private int crushAttack;
    @Getter
    @Setter
    private int magicAttack;
    @Getter
    @Setter
    private int rangeAttack;
    @Getter
    @Setter
    private int stabDefence;
    @Getter
    @Setter
    private int slashDefence;
    @Getter
    @Setter
    private int crushDefence;
    @Getter
    @Setter
    private int magicDefence;
    @Getter
    @Setter
    private int rangeDefence;
    @Getter
    @Setter
    private int meleeStrength;
    @Getter
    @Setter
    private int rangedStrength;
    @Getter
    @Setter
    private int magicDamage;
    @Getter
    @Setter
    private int prayer;
    @Getter
    @Setter
    private int undeadDamage;
    @Getter
    @Setter
    private int slayerDamage;

    CombatStats(int stabAttack, int slashAttack, int crushAttack, int magicAttack, int rangeAttack, int stabDefence, int slashDefence, int crushDefence, int magicDefence, int rangeDefence, int meleeStrength, int rangedStrength, int magicDamage, int prayer, int undeadDamage, int slayerDamage) {
        this.stabAttack = stabAttack;
        this.slashAttack = slashAttack;
        this.crushAttack = crushAttack;
        this.magicAttack = magicAttack;
        this.rangeAttack = rangeAttack;
        pureDefensiveItem = (stabAttack == 0) && (slashAttack == 0) && (crushAttack == 0) && (magicAttack == 0) && (rangeAttack == 0);

        this.stabDefence = stabDefence;
        this.slashDefence = slashDefence;
        this.crushDefence = crushDefence;
        this.magicDefence = magicDefence;
        this.rangeDefence = rangeDefence;
        pureOffensiveItem = (stabDefence == 0) && (slashDefence == 0) && (crushDefence == 0) && (magicDefence == 0) && (rangeDefence == 0);

        this.meleeStrength = meleeStrength;
        this.rangedStrength = rangedStrength;
        this.magicDamage = magicDamage;
        this.prayer = prayer;
        bonusLess = (meleeStrength == 0) && (rangedStrength == 0) && (magicDamage == 0) && (prayer == 0);

        this.undeadDamage = undeadDamage;
        this.slayerDamage = slayerDamage;
        regularItem = (undeadDamage == 0) && (slayerDamage == 0);

        statLess = pureDefensiveItem && pureOffensiveItem && bonusLess && regularItem;
    }
}

package cards.skill;

import cards.AbstractGoblinSlayerCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class Autotomy extends AbstractGoblinSlayerCard {
    public static final String ID = "Autotomy";
    private static final String img = "ModResources/img/card/Strike.png";

    public Autotomy() {
        super(ID, img, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber = 2;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeBaseCost(0);
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new LoseHPAction(abstractPlayer, abstractPlayer, this.magicNumber));
        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new StrengthPower(abstractPlayer, this.magicNumber), this.magicNumber));
    }
    @Override
    public AbstractCard makeCopy() {
        return new Autotomy();
    }
}

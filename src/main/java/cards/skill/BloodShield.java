package cards.skill;

import cards.AbstractGoblinSlayerCard;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class BloodShield extends AbstractGoblinSlayerCard {
    public static final String ID = "BloodShield";
    private static final String img = "ModResources/img/card/Strike.png";

    // TODO: 2023/4/14 img要改
    public BloodShield() {
        super(ID, img, 1, CardType.SKILL, CardRarity.CURSE, CardTarget.SELF);
        this.baseBlock = 8;
        this.baseMagicNumber = 2;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeBlock(4);
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new LoseHPAction(abstractPlayer,abstractPlayer, this.magicNumber));
        addToBot(new GainBlockAction(abstractPlayer, this.block));
    }
    @Override
    public AbstractCard makeCopy() {
        return new BloodShield();
    }
}

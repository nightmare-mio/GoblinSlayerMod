package cards.skill;

import cards.AbstractGoblinSlayerCard;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.utility.ExhaustAllEtherealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class BoneArmor extends AbstractGoblinSlayerCard {
    public static final String ID = "BoneArmor";
    private static final String img = "ModResources/img/card/Strike.png";

    public BoneArmor() {
        super(ID, img, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        this.isEthereal = true;
        this.baseBlock = 12;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeBlock(8);
        }
    }

    public void triggerOnEndOfPlayerTurn() {
        addToTop(new ExhaustAllEtherealAction());
    }

    // TODO: 2023/4/15 50%消耗
    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new GainBlockAction(abstractPlayer, abstractPlayer, this.block));
    }
    @Override
    public AbstractCard makeCopy() {
        return new BoneArmor();
    }
}

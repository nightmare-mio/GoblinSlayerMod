package cards.skill;

import cards.AbstractGoblinSlayerCard;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Defence_GoblinSlayer extends AbstractGoblinSlayerCard {

    public static final String ID = "GoblinSlayer_Defence";
    private static final String img="ModResources/img/card/Strike.png";

    // TODO: 2023/4/14 img要改
    public Defence_GoblinSlayer() {
        super(ID, img, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        this.baseBlock=5;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeBlock(3);
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new GainBlockAction(abstractPlayer,this.baseBlock));
    }
    @Override
    public AbstractCard makeCopy() {
        return new Defence_GoblinSlayer();
    }
}

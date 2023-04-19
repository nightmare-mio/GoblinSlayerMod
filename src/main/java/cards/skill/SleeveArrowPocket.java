package cards.skill;

import cards.AbstractGoblinSlayerCard;
import cards.attack.SleeveArrow;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SleeveArrowPocket extends AbstractGoblinSlayerCard {
    public static final String ID = "SleeveArrowPocket";
    private static final String img = "ModResources/img/card/Strike.png";
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);


    public SleeveArrowPocket() {
        super(ID, img, 1, CardType.SKILL, CardRarity.CURSE, CardTarget.NONE);
        this.baseMagicNumber=2;
    }

    @Override
    public void upgrade() {
        if(!this.upgraded){
            upgradeName();
            this.isInnate=true;
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new MakeTempCardInHandAction(new SleeveArrow(), this.magicNumber));
    }
    @Override
    public AbstractCard makeCopy() {
        return new SleeveArrowPocket();
    }
}

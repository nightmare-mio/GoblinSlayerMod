package cards.skill;

import cards.AbstractGoblinSlayerCard;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class BurningBlood extends AbstractGoblinSlayerCard {
    private static final String ID = "BurningBlood";
    private static final String img = "ModResources/img/card/Strike.png";


    public BurningBlood() {
        super(ID, img, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.NONE);
        this.magicNumber=3;
    }

    @Override
    public void upgrade() {
        if(!this.upgraded){
            upgradeName();
            upgradeMagicNumber(1);
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new LoseHPAction(abstractPlayer,abstractPlayer,2));
        addToBot(new DrawCardAction(abstractPlayer,this.magicNumber));

    }
}

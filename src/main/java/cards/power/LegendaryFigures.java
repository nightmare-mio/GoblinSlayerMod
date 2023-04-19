package cards.power;

import cards.AbstractGoblinSlayerCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.CombustPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class LegendaryFigures extends AbstractGoblinSlayerCard {
    public static final String ID = "LegendaryFigures";
    private static final String img = "ModResources/img/card/Strike.png";


    public LegendaryFigures() {
        super(ID, img, 2, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        this.baseMagicNumber=3;
    }

    @Override
    public void upgrade() {
        if(!this.upgraded){
            upgradeName();
            upgradeBaseCost(-1);
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new ApplyPowerAction(abstractPlayer,abstractPlayer,new StrengthPower(abstractPlayer,this.magicNumber)));
        addToBot(new ApplyPowerAction(abstractPlayer,abstractPlayer,new DexterityPower(abstractPlayer,this.magicNumber)));
        addToBot(new ApplyPowerAction(abstractPlayer,abstractPlayer,new CombustPower(abstractPlayer,1,this.magicNumber)));

    }
    @Override
    public AbstractCard makeCopy() {
        return new LegendaryFigures();
    }
}

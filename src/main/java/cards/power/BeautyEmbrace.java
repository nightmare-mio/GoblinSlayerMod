package cards.power;

import cards.AbstractGoblinSlayerCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.RegenPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;

public class BeautyEmbrace extends AbstractGoblinSlayerCard {

    public static final String ID = "BeautyEmbrace";
    private static final String img = "ModResources/img/card/Strike.png";

    public BeautyEmbrace() {
        super(ID, img, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber=2;
        this.magicNumber=this.baseMagicNumber;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded){
            upgradeName();
            upgradeMagicNumber(-1);
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new RegenPower(abstractPlayer, 5), 5));
        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new VulnerablePower(abstractPlayer, this.magicNumber, false), this.magicNumber));

    }
    @Override
    public AbstractCard makeCopy() {
        return new BeautyEmbrace();
    }
}

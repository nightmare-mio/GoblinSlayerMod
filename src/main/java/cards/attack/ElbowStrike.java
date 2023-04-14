package cards.attack;

import cards.AbstractGoblinSlayerCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class ElbowStrike extends AbstractGoblinSlayerCard {
    private static final String ID = "ElbowStrike";
    private static final String img = "ModResources/img/card/Strike.png";

    public ElbowStrike() {
        super(ID, img, 1, CardType.ATTACK, CardRarity.BASIC, CardTarget.ENEMY);
        this.baseMagicNumber=2;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded){
            upgradeName();
            upgradeMagicNumber(2);
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new DamageAction(abstractMonster,new DamageInfo(abstractPlayer,this.magicNumber,this.damageTypeForTurn),AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        addToBot(new ApplyPowerAction(abstractMonster,abstractPlayer, new StrengthPower(abstractMonster, -this.magicNumber), -this.magicNumber, true, AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(abstractMonster, abstractPlayer, new GainStrengthPower(abstractMonster, this.magicNumber), this.magicNumber, true, AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    }
}

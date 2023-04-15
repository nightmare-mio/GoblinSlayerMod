package cards.attack;

import cards.AbstractGoblinSlayerCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class CutOff extends AbstractGoblinSlayerCard {
    private static final String ID = "CutOff";
    private static final String img = "ModResources/img/card/Strike.png";

    public CutOff() {
        super(ID, img, 3, CardType.ATTACK, CardRarity.RARE, CardTarget.ALL_ENEMY);
        this.baseDamage = 20;
        this.baseMagicNumber = 99;
        this.exhaust = true;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeDamage(10);
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new DamageAction(abstractMonster, new DamageInfo(abstractPlayer,this.damage,this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
            addToBot(new ApplyPowerAction(abstractMonster, abstractPlayer, new WeakPower(abstractMonster, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
            addToBot(new ApplyPowerAction(abstractMonster, abstractPlayer, new VulnerablePower(abstractMonster, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
        }
    }
}

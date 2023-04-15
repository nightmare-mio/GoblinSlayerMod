package cards.attack;

import cards.AbstractGoblinSlayerCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class StoneForce extends AbstractGoblinSlayerCard {
    private static final String ID = "StoneForce";
    private static final String img = "ModResources/img/card/Strike.png";


    public StoneForce() {
        super(ID, img, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        this.baseDamage = 10;
        this.baseMagicNumber = 5;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeMagicNumber(2);
        }
    }

    @Override
    public void calculateCardDamage(AbstractMonster mo) {
        AbstractPower strength = AbstractDungeon.player.getPower("Strength");
        if (strength != null) {
            strength.amount *= this.magicNumber;
        }
        super.calculateCardDamage(mo);

        if (strength != null) {
            strength.amount /= this.magicNumber;
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new DamageAction(abstractMonster, new DamageInfo(abstractPlayer, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
    }
}

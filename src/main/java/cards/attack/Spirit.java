package cards.attack;

import cards.AbstractGoblinSlayerCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

public class Spirit extends AbstractGoblinSlayerCard {
    private static final String ID = "Spirit";
    private static final String img = "ModResources/img/card/Strike.png";

    public Spirit() {
        super(ID, img, 0, CardType.ATTACK, CardRarity.CURSE, CardTarget.ENEMY);
        this.baseMagicNumber = 1;
        this.baseDamage = 6;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeDamage(2);
            upgradeMagicNumber(1);
        }
    }

    // TODO: 2023/4/15 50%消耗
    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new ApplyPowerAction(abstractMonster,abstractPlayer,new VulnerablePower(abstractMonster,this.magicNumber,false)));
        addToBot(new DamageAction(abstractMonster,new DamageInfo(abstractPlayer,this.damage,this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        addToBot(new DrawCardAction(abstractPlayer, 1));

    }
}

package cards.skill;

import cards.AbstractGoblinSlayerCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ExplosivePower;

public class DodgeCatapult extends AbstractGoblinSlayerCard {
    public static final String ID = "DodgeCatapult";
    private static final String img = "ModResources/img/card/Strike.png";


    public DodgeCatapult() {
        super(ID, img, 1, CardType.SKILL, CardRarity.CURSE, CardTarget.ENEMY);
        this.baseDamage=1;
        this.baseMagicNumber=1;
        this.exhaust=true;
    }

    @Override
    public void upgrade() {
        if(!this.upgraded){
            upgradeName();
            this.exhaust=false;
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new DamageAction(abstractMonster,new DamageInfo(abstractPlayer,this.damage,this.damageTypeForTurn)));
        addToBot(new ApplyPowerAction(abstractPlayer,abstractPlayer,new ExplosivePower(abstractPlayer,this.magicNumber)));
    }
    @Override
    public AbstractCard makeCopy() {
        return new DodgeCatapult();
    }
}

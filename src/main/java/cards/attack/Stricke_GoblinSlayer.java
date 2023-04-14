package cards.attack;

import cards.AbstractGoblinSlayerCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Stricke_GoblinSlayer extends AbstractGoblinSlayerCard {

    private static final String ID = "GoblinSlayer_Stricke";

    // TODO: 2023/4/14 img要改
    public Stricke_GoblinSlayer() {
        super(ID, "ModResources/img/card/Strike.png", 1, CardType.ATTACK, CardRarity.BASIC, CardTarget.ENEMY);
        this.baseDamage = 6;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeDamage(3);
        }
    }

    // TODO: 2023/4/6 修改动画效果
    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new DamageAction( abstractMonster, new DamageInfo(abstractPlayer,this.damage,this.damageTypeForTurn),AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
    }
}

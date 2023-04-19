package cards.power;

import cards.AbstractGoblinSlayerCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import power.PositionalWarfarePower;

public class PositionalWarfare extends AbstractGoblinSlayerCard {
    public static final String ID = "PositionalWarfare";
    private static final String img = "ModResources/img/card/Strike.png";

    public PositionalWarfare() {
        super(ID, img, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF_AND_ENEMY);
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
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new PositionalWarfarePower(abstractPlayer, this.magicNumber)));
        for (AbstractMonster m : (AbstractDungeon.getMonsters()).monsters) {
            if (!m.isDead && !m.isDying) {
                addToBot((AbstractGameAction) new ApplyPowerAction((AbstractCreature) m, abstractPlayer ,new PositionalWarfarePower(abstractMonster, this.magicNumber)));
            }
        }
    }
    @Override
    public AbstractCard makeCopy() {
        return new PositionalWarfare();
    }
}

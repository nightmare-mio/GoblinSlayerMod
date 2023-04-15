package cards.skill;

import cards.AbstractGoblinSlayerCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import power.UndeathPower;

public class LockBlood extends AbstractGoblinSlayerCard {
    private static final String ID = "LockBlood";
    private static final String img = "ModResources/img/card/Strike.png";



    public LockBlood() {
        super(ID, img, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber=1;
    }

    @Override
    public void upgrade() {
        if(!this.upgraded){
            upgradeName();
            upgradeMagicNumber(1);
        }
    }

    // TODO: 2023/4/15 50%消耗
    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        this.exhaust=true;
        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new UndeathPower(abstractPlayer, this.magicNumber), this.magicNumber));
    }
}

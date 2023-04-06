package helpers;

import basemod.abstracts.DynamicVariable;
import cards.AbstractGoblinSlayerCard;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class SecondaryMagicVariable extends DynamicVariable {
    @Override
    public String key() {
        return "KM2";
    }

    @Override
    public boolean isModified(AbstractCard abstractCard) {
        if (abstractCard instanceof AbstractGoblinSlayerCard) {
            AbstractGoblinSlayerCard c = (AbstractGoblinSlayerCard) abstractCard;
            return c.isSecondaryMagicNumModified;
        }
        return false;
    }

    @Override
    public int value(AbstractCard abstractCard) {
        if(abstractCard instanceof AbstractGoblinSlayerCard){
            AbstractGoblinSlayerCard c=(AbstractGoblinSlayerCard) abstractCard;
            return c.SecondaryMagicNum;
        }
        return 0;
    }

    @Override
    public int baseValue(AbstractCard abstractCard) {
        if(abstractCard instanceof AbstractGoblinSlayerCard){
            AbstractGoblinSlayerCard c=(AbstractGoblinSlayerCard) abstractCard;
            return c.baseSecondaryMagicNum;
        }
        return 0;
    }

    @Override
    public boolean upgraded(AbstractCard abstractCard) {
        if(abstractCard instanceof AbstractGoblinSlayerCard){
            AbstractGoblinSlayerCard c=(AbstractGoblinSlayerCard) abstractCard;
            return c.upgradedSecondaryMagicNum;
        }
        return false;
    }
}
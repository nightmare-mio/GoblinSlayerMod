package power;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;

public class PositionalWarfarePower extends AbstractGoblinSlayerPower {
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("PositionalWarfare");
    private static final String NAME = powerStrings.NAME;
    private static final String sid = UndeathPower.class.getSimpleName();
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public PositionalWarfarePower(AbstractCreature owner, int bufferAmt) {
        super(owner, bufferAmt);
        this.name=NAME;
        this.ID=sid.replace("power","");
        updateDescription();
        loadShionRegion(sid);
    }

    @Override
    public void updateDescription() {
        if (this.owner.isPlayer) {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
        } else {
            this.description = DESCRIPTIONS[2] + this.amount + DESCRIPTIONS[3];
        }
    }

    @Override
    public void atEndOfTurnPreEndTurnCards(boolean isPlayer) {
        flash();
        addToBot((AbstractGameAction) new GainBlockAction(this.owner, this.owner, this.amount));
    }
}

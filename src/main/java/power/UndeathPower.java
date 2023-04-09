package power;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.screens.CharSelectInfo;

/**
 * 不死
 */
public class UndeathPower extends AbstractPower {
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("Undeath");
    private static final String NAME = powerStrings.NAME;
    private static final String sid = UndeathPower.class.getSimpleName();
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public UndeathPower(AbstractCreature owner, int bufferAmt) {
        this.name = NAME;
        this.ID = sid.replace("power","");
        this.owner = owner;
        this.amount = bufferAmt;
        this.type=PowerType.BUFF;
        isTurnBased = false;

        updateDescription();
        Texture img84 = ImageMaster.loadImage(String.format("ModResources/img/power/%s84.png", sid));
        Texture img32 = ImageMaster.loadImage(String.format("ModResources/img/power/%s32.png", sid));
        if (img84 != null || img32 != null) {
            this.region128 = new TextureAtlas.AtlasRegion(img84, 0, 0, 84, 84);
            this.region48 = new TextureAtlas.AtlasRegion(img32, 0, 0, 32, 32);
        }

    }

    @Override
    public void updateDescription() {
        this.description = String.format(DESCRIPTIONS[0], this.amount);
    }

    @Override
    public int onAttackedToChangeDamage(DamageInfo info, int damageAmount) {
        if (damageAmount > AbstractDungeon.player.currentHealth) {
            damageAmount = AbstractDungeon.player.currentHealth - 1;
        }
        return super.onAttackedToChangeDamage(info, damageAmount);
    }

}

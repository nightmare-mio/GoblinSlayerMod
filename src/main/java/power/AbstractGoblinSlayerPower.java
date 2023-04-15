package power;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class AbstractGoblinSlayerPower extends AbstractPower {
    public AbstractGoblinSlayerPower(AbstractCreature owner, int bufferAmt) {
        this.owner = owner;
        this.amount = bufferAmt;
    }

    protected void loadShionRegion(String sid) {
        Texture img84 = ImageMaster.loadImage(String.format("ModResources/img/power/%s84.png", sid));
        Texture img32 = ImageMaster.loadImage(String.format("ModResources/img/power/%s32.png", sid));
        if (img84 != null || img32 != null) {
            this.region128 = new TextureAtlas.AtlasRegion(img84, 0, 0, 84, 84);
            this.region48 = new TextureAtlas.AtlasRegion(img32, 0, 0, 32, 32);
        }
    }

}

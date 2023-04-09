package relics;

import basemod.abstracts.CustomCard;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.defect.NewRipAndTearAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.List;
import java.util.Random;

public class Dice extends CustomRelic {
    public static final String ID = "GoblinSlayer_" + Dice.class.getSimpleName();

    public Dice() {
        super(ID, ImageMaster.loadImage("ModResources/img/relics/GoblinSlayer_Dice.png"), RelicTier.STARTER, AbstractRelic.LandingSound.SOLID);
    }

    @Override
    public void atTurnStart() {
        flash();
        Random random = new Random();
        int number = random.nextInt(6);
        addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new DexterityPower(AbstractDungeon.player, 1), 1));

        switch (number) {
            case 0:
                addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new DexterityPower(AbstractDungeon.player, 1), 1));
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }


}

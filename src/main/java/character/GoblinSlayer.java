package character;

import GoblinSlayerModCore.GoblinSlayerCore;
import basemod.abstracts.CustomPlayer;
import basemod.patches.com.megacrit.cardcrawl.screens.mainMenu.ColorTabBar.ColorTabBarFix;
import cards.AbstractGoblinSlayerCard;
import cards.Stricke_GoblinSlayer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.esotericsoftware.spine.AnimationState;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.events.city.Vampires;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.screens.CharSelectInfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GoblinSlayer extends CustomPlayer {

    private static final CharacterStrings characterStrings = CardCrawlGame.languagePack.getCharacterString("GoblinSlayer");
    private static final String[] ORB_TEXTURES = new String[]{"ModResources/img/UI/orb/layer5.png", "ModResources/img/UI/orb/layer4.png", "ModResources/img/UI/orb/layer3.png", "ModResources/img/UI/orb/layer2.png", "ModResources/img/UI/orb/layer1.png", "ModResources/img/UI/orb/layer6.png", "ModResources/img/UI/orb/layer5d.png", "ModResources/img/UI/orb/layer4d.png", "ModResources/img/UI/orb/layer3d.png", "ModResources/img/UI/orb/layer2d.png", "ModResources/img/UI/orb/layer1d.png"};
    private static final float[] LAYER_SPEED = new float[]{-40.0F, -32.0F, 20.0F, -20.0F, 0.0F, -10.0F, -8.0F, 5.0F, -5.0F, 0.0F};

    /**
     * 2D小人/注册角色
     */
    public GoblinSlayer(String name) {
        super(name, ConstEnum.GOBLINSLAYER, ORB_TEXTURES, "ModResources/img/UI/orb/vfx.png", LAYER_SPEED, null, null);

        this.dialogX = this.drawX + 0.0F * Settings.scale;
        this.dialogY = this.drawY + 150.0F * Settings.scale;
        initializeClass(null, "ModResources/img/char/shoulder.png", "ModResources/img/char/shoulder.png", null, getLoadout(), 0.0F, 0.0F, 200.0F, 220.0F, new EnergyManager(3));
        loadAnimation("ModResources/img/char/char_003_kalts.atlas", "ModResources/img/char/char_003_kalts.json", 1.8F);
        AnimationState.TrackEntry e = this.state.setAnimation(0, "Idle", true);
        e.setTime(e.getEndTime() * MathUtils.random());
        e.setTimeScale(1.2F);
    }

    @Override
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add("GoblinSlayer_Stricke");
        return retVal;
    }

    @Override
    public ArrayList<String> getStartingRelics() {
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add("GoblinSlayer_Dice");
        return retVal;
    }

    @Override
    public CharSelectInfo getLoadout() {
        return new CharSelectInfo(characterStrings.NAMES[0], characterStrings.TEXT[0], 40, 40, 0, 99, 5, this,
                getStartingRelics(), getStartingDeck(), false);
    }

    @Override
    public String getTitle(PlayerClass playerClass) {
        return characterStrings.NAMES[0];
    }

    @Override
    public AbstractCard.CardColor getCardColor() {
        return ConstEnum.GOBLINSLAYER_CARDCOLOR;
    }

    @Override
    public Color getCardRenderColor() {
        return GoblinSlayerCore.GetCharColor();
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        return new Stricke_GoblinSlayer();
    }

    @Override
    public Color getCardTrailColor() {
        return GoblinSlayerCore.GetCharColor();
    }

    @Override
    public int getAscensionMaxHPLoss() {
        return 5;
    }

    @Override
    public BitmapFont getEnergyNumFont() {
        return FontHelper.energyNumFontRed;
    }

    @Override
    public void doCharSelectScreenSelectEffect() {

    }

    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        return null;
    }

    @Override
    public String getLocalizedCharacterName() {
        return characterStrings.NAMES[0];
    }

    @Override
    public AbstractPlayer newInstance() {
        return new GoblinSlayer(this.name);
    }

    @Override
    public String getSpireHeartText() {
        return characterStrings.TEXT[1];
    }

    @Override
    public Color getSlashAttackColor() {
        return GoblinSlayerCore.GetCharColor();
    }

    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[0];
    }

    @Override
    public String getVampireText() {
        return Vampires.DESCRIPTIONS[1];
    }

    public static class ConstEnum {
        @SpireEnum
        public static AbstractPlayer.PlayerClass GOBLINSLAYER;
        @SpireEnum(name = "GoblinSlayer")
        public static AbstractCard.CardColor GOBLINSLAYER_CARDCOLOR;
        @SpireEnum(name = "GoblinSlayer")
        public static CardLibrary.LibraryType GOBLINSLAYER_LibraryType;
    }
}

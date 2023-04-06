package character;

import basemod.abstracts.CustomPlayer;
import basemod.patches.com.megacrit.cardcrawl.screens.mainMenu.ColorTabBar.ColorTabBarFix;
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
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.screens.CharSelectInfo;

import java.util.ArrayList;

public class GoblinSlayer extends CustomPlayer {

    private static final CharacterStrings characterStrings = CardCrawlGame.languagePack.getCharacterString("GoblinSlayer");
    private static final String[] ORB_TEXTURES = new String[]{"ModResources/img/UI/orb/layer5.png", "ModResources/img/UI/orb/layer4.png", "ModResources/img/UI/orb/layer3.png", "ModResources/img/UI/orb/layer2.png", "ModResources/img/UI/orb/layer1.png", "ModResources/img/UI/orb/layer6.png", "ModResources/img/UI/orb/layer5d.png", "ModResources/img/UI/orb/layer4d.png", "ModResources/img/UI/orb/layer3d.png", "ModResources/img/UI/orb/layer2d.png", "ModResources/img/UI/orb/layer1d.png"};

    /**
     * 2D小人/注册角色
     */
    public GoblinSlayer() {
        super(CardCrawlGame.languagePack.getCharacterString("GoblinSlayer").NAMES[0],
                ConstEnum.GOBLINSLAYER,
                ORB_TEXTURES, "ModResources/img/UI/orb/vfx.png", null, null, null);

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
        return null;
    }

    @Override
    public ArrayList<String> getStartingRelics() {
        return null;
    }

    @Override
    public CharSelectInfo getLoadout() {
        return null;
    }

    @Override
    public String getTitle(PlayerClass playerClass) {
        return characterStrings.NAMES[0];
    }

    @Override
    public AbstractCard.CardColor getCardColor() {
        return null;
    }

    @Override
    public Color getCardRenderColor() {
        return null;
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        return null;
    }

    @Override
    public Color getCardTrailColor() {
        return null;
    }

    @Override
    public int getAscensionMaxHPLoss() {
        return 5;
    }

    @Override
    public BitmapFont getEnergyNumFont() {
        return null;
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
        return null;
    }

    @Override
    public AbstractPlayer newInstance() {
        return null;
    }

    @Override
    public String getSpireHeartText() {
        return null;
    }

    @Override
    public Color getSlashAttackColor() {
        return null;
    }

    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[0];
    }

    @Override
    public String getVampireText() {
        return null;
    }

    public static class ConstEnum {
        @SpireEnum
        public static PlayerClass GOBLINSLAYER;

        @SpireEnum
        public static AbstractCard.CardColor GOBLINSLAYER_CARDCOLOR;

    }
}

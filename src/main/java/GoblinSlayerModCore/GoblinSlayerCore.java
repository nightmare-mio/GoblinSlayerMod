package GoblinSlayerModCore;

import basemod.BaseMod;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.ISubscriber;
import character.GoblinSlayer;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.localization.CardStrings;

@SpireInitializer
public class GoblinSlayerCore implements EditStringsSubscriber {


    private static final Color SCARLET = GetCharColor();

    /*
     * 添加mod至管理器
     * 添加颜色
     * */
    public GoblinSlayerCore() {
        BaseMod.subscribe(this);

        BaseMod.addColor(GoblinSlayer.ConstEnum.GOBLINSLAYER_CARDCOLOR, SCARLET, "ModResources/img/512/bg_attack_512.png", "ModResources/img/512/bg_skill_512.png", "ModResources/img/512/bg_power_512.png", "ModResources/img/char/cost_orb.png", "ModResources/img/1024/bg_attack.png", "ModResources/img/1024/bg_skill.png", "ModResources/img/1024/bg_power.png", "ModResources/img/char/card_orb.png", "ModResources/img/char/small_orb.png");
    }

    public static void initialize() {
        new GoblinSlayerCore();
    }

    /*
     * 加载 字符串\json\文本
     * */
    @Override
    public void receiveEditStrings() {
        String lang = "zh";

        BaseMod.loadCustomStringsFile(CardStrings.class, "ModResources/localization/Char_" + lang + ".json");
    }

    /*
     *   rbg 0-255=0-1.0\透明度0-1.0
     * */
    public static Color GetCharColor() {
        return new Color(0.86F, 0.07F, 0.23F, 1.0F);
    }
}

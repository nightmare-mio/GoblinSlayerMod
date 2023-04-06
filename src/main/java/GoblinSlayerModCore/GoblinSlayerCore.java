package GoblinSlayerModCore;

import basemod.BaseMod;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.ISubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.localization.CardStrings;

@SpireInitializer
public class GoblinSlayerCore implements EditStringsSubscriber {
    /*
     * 添加mod至管理器
     * */
    public GoblinSlayerCore() {
        BaseMod.subscribe(this);
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
}

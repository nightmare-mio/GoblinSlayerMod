package GoblinSlayerModCore;

import basemod.BaseMod;
import basemod.interfaces.ISubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

@SpireInitializer
public class GoblinSlayerCore {
    /*
     * 添加mod至管理器
     * */
    public GoblinSlayerCore() {
        BaseMod.subscribe((ISubscriber) this);
    }

    public static void initialize() {
        new GoblinSlayerCore();
    }

}

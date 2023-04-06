package cards;

import basemod.abstracts.CustomCard;
import character.GoblinSlayer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.characters.TheSilent;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import javafx.beans.property.ObjectProperty;

public abstract class AbstractGoblinSlayerCard extends CustomCard {

    public int baseSecondaryMagicNum;
    public int SecondaryMagicNum;
    public boolean upgradedSecondaryMagicNum;
    public boolean isSecondaryMagicNumModified;

    public AbstractGoblinSlayerCard(String ID, String img, int COST, AbstractCard.CardType TYPE, AbstractCard.CardRarity RARITY, AbstractCard.CardTarget TARGET) {
        this(ID, img, CardCrawlGame.languagePack.getCardStrings(ID), COST, TYPE, RARITY, TARGET);
    }

    private AbstractGoblinSlayerCard(String ID, String img, CardStrings strings, int COST, AbstractCard.CardType TYPE, AbstractCard.CardRarity RARITY, AbstractCard.CardTarget TARGET) {
        super(ID, strings.NAME, img, COST, strings.DESCRIPTION, TYPE, GoblinSlayer.ConstEnum.GOBLINSLAYER_CARDCOLOR, RARITY, TARGET);
    }
}

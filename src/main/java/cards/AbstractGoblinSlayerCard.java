package cards;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.characters.TheSilent;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import javafx.beans.property.ObjectProperty;

public abstract class AbstractGoblinSlayerCard extends CustomCard {

    private static CardColor CARDCOLORl;

    public AbstractGoblinSlayerCard(String ID, String img, int COST, AbstractCard.CardType TYPE, AbstractCard.CardRarity RARITY, AbstractCard.CardTarget TARGET) {
        this(ID, img, CardCrawlGame.languagePack.getCardStrings(ID), COST, TYPE, CARDCOLORl, RARITY, TARGET);
    }

    private AbstractGoblinSlayerCard(String ID, String img, CardStrings strings, int COST, AbstractCard.CardType TYPE, CardColor CARDCOLOR, AbstractCard.CardRarity RARITY, AbstractCard.CardTarget TARGET) {
        super(ID, strings.NAME, img, COST, strings.DESCRIPTION, TYPE, CARDCOLOR, RARITY, TARGET);
    }
}

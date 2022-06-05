package Simulador;

import DataBase.Rarity;
import DataBase.Summonable;

import java.util.ArrayList;
import java.util.List;

public class MultiSummon {
    private List<Summonable> summonResults;
    private List<Summonable> summonResults2;
    private SingleSummon singleSummon;

    public MultiSummon() {
        summonResults = new ArrayList<>();
        summonResults2 = new ArrayList<>();
        singleSummon = new SingleSummon();
    }

    /**
     * Metodo que recibe los resultados del singlesummon
     * los mete en un bucle y saca los resultados en un array
     * @return Array de cartas
     */
    public List<Summonable> summon() {
        summonResults.clear();
        boolean SRSummoned = false;
        boolean pjSummoned = false;
        for (int i = 0; i < 9; i++) {
            Summonable summoned = singleSummon.summon();
            summonResults.add(summoned);
            if (summoned.getRarity() == Rarity.SSR || summoned.getRarity() == Rarity.SR) {
                SRSummoned = true;
            }
            if (summoned instanceof GokuBanner) {
                pjSummoned = true;
            }
        }

        if (!SRSummoned) {
            Summonable summoned;
            do {
                summoned = singleSummon.summon();
            } while (summoned.getRarity() == Rarity.R);
            summonResults.add(summoned);
        } else if (!pjSummoned) {
            Summonable summoned;
            do {
                summoned = singleSummon.summon();
            } while (!(summoned instanceof GokuBanner));
            summonResults.add(summoned);
        } else {
            summonResults.add(singleSummon.summon());
        }
        return summonResults;
    }

    public List<Summonable> summon2() {
        summonResults2.clear();
        boolean SRSummoned = false;
        boolean ServantSummoned = false;
        for (int i = 0; i < 9; i++) {
            Summonable summoned = singleSummon.summon2();
            summonResults2.add(summoned);
            if (summoned.getRarity() == Rarity.SSR || summoned.getRarity() == Rarity.SR) {
                SRSummoned = true;
            }
            if (summoned instanceof FreezerBanner) {
                ServantSummoned = true;
            }
        }

        if (!SRSummoned) {
            Summonable summoned;
            do {
                summoned = singleSummon.summon2();
            } while (summoned.getRarity() == Rarity.R);
            summonResults2.add(summoned);
        } else if (!ServantSummoned) {
            Summonable summoned;
            do {
                summoned = singleSummon.summon2();
            } while (!(summoned instanceof FreezerBanner));
            summonResults2.add(summoned);
        } else {
            summonResults2.add(singleSummon.summon2());
        }
        return summonResults2;
    }
}
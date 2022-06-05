package Simulador;

import DataBase.Summonable;

import java.util.Random;

public class SingleSummon {
    private Summonable summonResult;
    private Summonable summonResult2;
    Random random;

    public SingleSummon() {
        summonResult = null;
        summonResult2 = null;
        random = new Random();
    }
    /**
     * Metodo que dependiendo de la rareza recoge las probabilidades de
     * la clase de constantes, utiliza un random y devuelve objeto
     * un personaje.
     * @return objeto de carta
     */
    public Summonable summon() {
        summonResult = null;

        int typeOfResult = random.nextInt(CONSTANTES.HUNDRED);
        int rateUpNum = random.nextInt(CONSTANTES.HUNDRED);
        boolean isRateUp;
        if (rateUpNum < CONSTANTES.RATE_UP_CHANCE) {
            isRateUp = true;
        } else {
            isRateUp = false;
        }
        do {
            if (typeOfResult >= CONSTANTES.SSR_GOKU_BEGIN && typeOfResult <= CONSTANTES.SSR_GOKU_END) {
                if (!CONSTANTES.goku_SSR_on_rateup) {
                    isRateUp = false;
                }
                summonResult = CONSTANTES.goku_SSR.get(random.nextInt(CONSTANTES.goku_SSR.size()));
            } else if (typeOfResult >= CONSTANTES.SR_GOKU_BEGIN && typeOfResult <= CONSTANTES.SR_GOKU_END) {
                if (!CONSTANTES.goku_SR_on_rateup) {
                    isRateUp = false;
                }
                summonResult = CONSTANTES.goku_SR.get(random.nextInt(CONSTANTES.goku_SR.size()));
            } else {
                if (!CONSTANTES.goku_R_on_rateup) {
                    isRateUp = false;
                }
                summonResult = CONSTANTES.goku_R.get(random.nextInt(CONSTANTES.goku_R.size()));
            }
        } while (summonResult.isRateUp() != isRateUp);

        return summonResult;
    }

    public Summonable summon2() {
        summonResult2 = null;

        int typeOfResult = random.nextInt(CONSTANTES.HUNDRED);
        int rateUpNum = random.nextInt(CONSTANTES.HUNDRED);
        boolean isRateUp;
        if (rateUpNum < CONSTANTES.RATE_UP_CHANCE) {
            isRateUp = true;
        } else {
            isRateUp = false;
        }
        do {
            if (typeOfResult >= CONSTANTES.SSR_FREEZER_BEGIN && typeOfResult <= CONSTANTES.SSR_FREEZER_END) {
                if (!CONSTANTES.freezer_SSR_on_rateup) {
                    isRateUp = false;
                }
                summonResult2 = CONSTANTES.freezer_SSR.get(random.nextInt(CONSTANTES.freezer_SSR.size()));
            } else if (typeOfResult >= CONSTANTES.SR_FREEZER_BEGIN && typeOfResult <= CONSTANTES.SR_FREEZER_END) {
                if (!CONSTANTES.freezer_SR_on_rateup) {
                    isRateUp = false;
                }
                summonResult2 = CONSTANTES.freezer_SR.get(random.nextInt(CONSTANTES.freezer_SR.size()));
            } else {
                if (!CONSTANTES.freezer_R_on_rateup) {
                    isRateUp = false;
                }
                summonResult2 = CONSTANTES.freezer_R.get(random.nextInt(CONSTANTES.freezer_R.size()));
            }
        } while (summonResult2.isRateUp() != isRateUp);

        return summonResult2;
    }
}
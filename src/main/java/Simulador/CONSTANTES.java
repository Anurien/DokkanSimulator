package Simulador;

import java.util.ArrayList;
import java.util.List;

public class CONSTANTES {
    //Clase de constantes para el calculo de probabilidad de que salgan las cartas al invocarlas
    public static final int HUNDRED = 100;
    public static final double CASH_PER_SINGLE_SUMMON = 2.35714;

    public static final int RATE_UP_CHANCE = 70;

    public static final int SSR_RATE_GOKU = 1;
    public static final int SSR_RATE_FREEZER = 4;

    public static final int SR_RATE_GOKU = 3;
    public static final int SR_RATE_FREEZER = 12;

    public static final int R_RATE_GOKU = 40;
    public static final int R_RATE_FREEZER = 40;

    public static final int SSR_GOKU_BEGIN = 0; //0
    public static final int SSR_GOKU_END = SSR_GOKU_BEGIN + SSR_RATE_GOKU - 1; //0
    public static final int SR_GOKU_BEGIN = SSR_GOKU_END + 1; //1
    public static final int SR_GOKU_END = SR_GOKU_BEGIN + SR_RATE_GOKU - 1; //3
    public static final int R_GOKU_BEGIN = SR_GOKU_END + 1; //4
    public static final int R_GOKU_END = R_GOKU_BEGIN + R_RATE_GOKU - 1; //43
    public static final int SSR_FREEZER_BEGIN = R_GOKU_END + 1; //44
    public static final int SSR_FREEZER_END = SSR_FREEZER_BEGIN + SSR_RATE_FREEZER - 1; //47
    public static final int SR_FREEZER_BEGIN = SSR_FREEZER_END + 1; //48
    public static final int SR_FREEZER_END = SR_FREEZER_BEGIN + SR_RATE_FREEZER - 1; //59;
    public static final int R_FREEZER_BEGIN = SR_FREEZER_END + 1; //60
    public static final int R_FREEZER_END = R_FREEZER_BEGIN + R_RATE_FREEZER - 1; //99

    public static List<GokuBanner> goku_SSR = new ArrayList<>();
    public static List<GokuBanner> goku_SR = new ArrayList<>();
    public static List<GokuBanner> goku_R = new ArrayList<>();
    public static List<FreezerBanner> freezer_SSR = new ArrayList<>();
    public static List<FreezerBanner> freezer_SR = new ArrayList<>();
    public static List<FreezerBanner> freezer_R = new ArrayList<>();

    public static boolean goku_SSR_on_rateup = false;
    public static boolean goku_SR_on_rateup = false;
    public static boolean goku_R_on_rateup = false;
    public static boolean freezer_SSR_on_rateup = false;
    public static boolean freezer_SR_on_rateup = false;
    public static boolean freezer_R_on_rateup = false;
}
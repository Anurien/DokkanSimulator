package Simulador;

import DataBase.Rarity;

import java.io.File;
import java.util.Scanner;

public class GachaInfoParser {
    private Scanner GokuData;
    private Scanner FreezerData;

    public GachaInfoParser(String Goku, String Freezer) throws Exception {
        GokuData = new Scanner(new File(Goku));
        FreezerData = new Scanner(new File(Freezer));
    }
    /**
     * Metodo que lee un fichero txt y extrae los datos de
     * las cartas y los guarda en un array.
     */
    public void parse() {
        while (GokuData.hasNextLine()) {
            String[] info = GokuData.nextLine().split("/");
            String name = info[0];
            int id = Integer.parseInt(info[2]);
            boolean rateUp = (info[3].equals("Y"));
            Rarity rarity;
            switch (info[1]) {
                case "SSR": {
                    rarity = Rarity.SSR;
                    CONSTANTES.goku_SSR.add(new GokuBanner(id, name, rarity, rateUp));
                    if (rateUp) {
                        CONSTANTES.goku_SSR_on_rateup = true;
                    }
                    break;
                }
                case "SR": {
                    rarity = Rarity.SR;
                    CONSTANTES.goku_SR.add(new GokuBanner(id, name, rarity, rateUp));
                    if (rateUp) {
                        CONSTANTES.goku_SR_on_rateup = true;
                    }
                    break;
                }
                case "R": {
                    rarity = Rarity.R;
                    CONSTANTES.goku_R.add(new GokuBanner(id, name, rarity, rateUp));
                    if (rateUp) {
                        CONSTANTES.goku_R_on_rateup = true;
                    }
                    break;
                }
            }
        }

        while (FreezerData.hasNextLine()) {
            String[] info = FreezerData.nextLine().split("/");
            String name = info[0];
            int id = Integer.parseInt(info[2]);
            boolean rateUp = (info[3].equals("Y"));
            Rarity rarity;
            switch (info[1]) {
                case "SSR": {
                    rarity = Rarity.SSR;
                    CONSTANTES.freezer_SSR.add(new FreezerBanner(id, name, rarity, rateUp));
                    if (rateUp) {
                        CONSTANTES.freezer_SSR_on_rateup = true;
                    }
                    break;
                }
                case "SR": {
                    rarity = Rarity.SR;
                    CONSTANTES.freezer_SR.add(new FreezerBanner(id, name, rarity, rateUp));
                    if (rateUp) {
                        CONSTANTES.freezer_SR_on_rateup = true;
                    }
                    break;
                }
                case "R": {
                    rarity = Rarity.R;
                    CONSTANTES.freezer_R.add(new FreezerBanner(id, name, rarity, rateUp));
                    if (rateUp) {
                        CONSTANTES.freezer_R_on_rateup = true;
                    }
                    break;
                }
            }
        }
    }
}

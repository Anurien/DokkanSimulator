import Simulador.GachaInfoParser;
import Simulador.MenuPrincipal;


public class Main {
    public static void main(String[] args) throws Exception {
        GachaInfoParser parser = new GachaInfoParser("src/resources/GokuData.txt", "src/resources/FreezerData.txt");
        parser.parse();
        new MenuPrincipal();

    }
}

import Simulador.Datos.GachaInfoParser;
import Simulador.Interfaz.MenuPrincipal;


public class Main {
    public static void main(String[] args) throws Exception {
        GachaInfoParser parser = new GachaInfoParser("src/main/resources/GokuData.txt", "src/main/resources/FreezerData.txt");
        parser.parse();
        new MenuPrincipal();

    }
}

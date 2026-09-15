import CONTROL.DRAWNCONTROL;
import MODEL.FIGURE.FIGURE;
import VIEW.DRAWNVIEW;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<FIGURE> modelLista = new ArrayList<>();
        DRAWNVIEW view = new DRAWNVIEW(modelLista);
        DRAWNCONTROL controller = new DRAWNCONTROL(view, modelLista);

        view.setVisible(true);
    }
}
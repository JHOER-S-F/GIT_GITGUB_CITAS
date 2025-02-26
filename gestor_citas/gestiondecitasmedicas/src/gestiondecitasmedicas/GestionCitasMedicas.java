package gestiondecitasmedicas;

import com.gestioncitas.views.citas.MainView;
import com.gestioncitas.views.citas.MainView;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author XTREME
 */
public class GestionCitasMedicas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Establecer el Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Error al establecer Look and Feel: " + e.getMessage());
        }

        // Iniciar la aplicación mostrando la vista principal
        SwingUtilities.invokeLater(() -> {
            MainView mainView = new MainView();
            mainView.setVisible(true);
        });
    }
}
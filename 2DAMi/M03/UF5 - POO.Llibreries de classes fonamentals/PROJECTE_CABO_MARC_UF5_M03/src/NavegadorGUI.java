import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** La clase <b>NavegadorGUI</b> nos permite crear la interfaz visible del navegador.
 * @author Marc Cabo Dieguez
 * @version 08/11/2020
 */

public class NavegadorGUI extends JFrame {
    private Navegador navegadorGUI = new Navegador("https://areajugones.es");

    private JFXPanel jfxPanel = new JFXPanel();
    private JPanel panel = new JPanel(new BorderLayout());
    private JButton btnEnrere = new JButton("<<");
    private JButton btnEndavant = new JButton(">>");
    private JTextField txtURL = new JTextField("https://areajugones.es");

    private JPanel topBar = new JPanel(new GridLayout(1, 3));

    /** Metodo que permite ajustar la ventana del navegador.
     */
    public NavegadorGUI() {
        setBounds(100, 100, 800, 600);
        setTitle("Un Navegador de prova");
        btnEndavant.addActionListener(new ListenerEndavant());
        btnEnrere.addActionListener(new ListenerEnrere());
        txtURL.addActionListener(new ListenerGoTo());

        topBar.add(txtURL);
        topBar.add(btnEnrere);
        topBar.add(btnEndavant);

        panel.add(topBar, BorderLayout.NORTH);
        panel.add(jfxPanel, BorderLayout.CENTER);

        add(panel);

        loadURL(txtURL.getText());
    }

    /** Metodo que llama a la funcion anarA para dirigirse a la URL indicada
     */
    class ListenerGoTo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            loadURL(navegadorGUI.anarA(txtURL.getText()));
            habilitarBotons();
        }
    }

    /** Metodo que llama a la funcion enrere.
     */
    class ListenerEnrere implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String url = navegadorGUI.enrere();
            loadURL(url);
            txtURL.setText(url);
            habilitarBotons();
        }
    }

    /** Metodo que llama a la funcion endavant.
     */
    class ListenerEndavant implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String url = navegadorGUI.endavant();
            loadURL(url);
            txtURL.setText(url);
            habilitarBotons();
        }
    }

    /** Metodo que permite hacer un set de los botones endavant/enrere para que sean visibles.
     */
    private void habilitarBotons() {
        btnEndavant.setEnabled(true);
        btnEnrere.setEnabled(true);
    }

    /** Metodo que permite crear las URLs pasadas por parametro.
     * @param url URL a visitar
     */
    private void loadURL(String url) {
        Platform.runLater(() -> {
            WebView webView = new WebView();
            jfxPanel.setScene(new Scene(webView));
            webView.getEngine().load(url);
            habilitarBotons();
        });
    }

}

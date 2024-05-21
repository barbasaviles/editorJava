package Controlador;

import Vista.editor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import prototype.DocumentacionEnBlanco;
import prototype.Documento;
import prototype.OrdenDePedido;
import prototype.SolicitudMatriculacion;

/**
 *
 * @author Juan
 */
public class EditorController implements ActionListener {

    editor view;
    DocumentacionEnBlanco documentacionEnBlanco;
    Integer index;
    boolean editando = false;

    public EditorController() {

        documentacionEnBlanco = DocumentacionEnBlanco.Instance();
        view = new editor();
        view.getMenuCertificado().addActionListener(this);
        view.getMenuMatriculacion().addActionListener(this);
        view.getMenuOrden().addActionListener(this);
        view.getBtnGuardar().addActionListener(this);
        view.getBtnImprimir().addActionListener(this);
        view.getBtnEditar().addActionListener(this);
        view.getBtnEliminar().addActionListener(this);
    }

    public void Run() {
        view.setResizable(false);
        view.setLocationRelativeTo(null);
        view.setTitle("Editor UNICOR");
        view.setVisible(true);
    }

    private void reloadDocumentos() {
        DefaultListModel model = new DefaultListModel();
        for (Documento documento : documentacionEnBlanco.getDocumentos()) {
            model.addElement(documento.getNombre());
        }
        view.getListDocumento().setModel(model);
    }

    private void guardarDoc(int index) {
        if (!view.getData().getText().equals("")) {
            Documento documento = documentacionEnBlanco.getDocumentos().get(index);
            documento.rellena(view.getData().getText());
            reloadDocumentos();
        } else {
            JOptionPane.showMessageDialog(view, "Es Obligatorio definir un contenido para el documento");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.getMenuCertificado()) {
            String nombre = JOptionPane.showInputDialog(view, "Nombre del Certificado");

            if (nombre != null && !nombre.equals("")) {
                editando = false;
                view.getData().requestFocus();
                OrdenDePedido documento = new OrdenDePedido();
                Documento copiaDocumento = documento.duplica();
                copiaDocumento.rellena("");
                copiaDocumento.setNombre(nombre);
                documentacionEnBlanco.incluye(copiaDocumento);
                view.getData().setText("");
            } else {
                JOptionPane.showMessageDialog(view, "Es Obligatorio el nombre del Certificado");
            }
        }

        if (e.getSource() == view.getMenuMatriculacion()) {
            String nombre = JOptionPane.showInputDialog(view, "Nombre de la Matriculacion");
            System.out.println(nombre);
            if (nombre != null && !nombre.equals("")) {
                editando = false;
                view.getData().requestFocus();
                SolicitudMatriculacion documento = new SolicitudMatriculacion();
                Documento copiaDocumento = documento.duplica();
                copiaDocumento.rellena("");
                copiaDocumento.setNombre(nombre);
                documentacionEnBlanco.incluye(copiaDocumento);
                view.getData().setText("");
            } else {
                JOptionPane.showMessageDialog(view, "Es Obligatorio el nombre de la Matriculacion");
            }
        }

        if (e.getSource() == view.getMenuOrden()) {
            String nombre = JOptionPane.showInputDialog(view, "Nombre de la Orden");

            if (nombre != null && !nombre.equals("")) {
                editando = false;
                view.getData().requestFocus();
                OrdenDePedido documento = new OrdenDePedido();
                Documento copiaDocumento = documento.duplica();
                copiaDocumento.rellena("");
                copiaDocumento.setNombre(nombre);
                documentacionEnBlanco.incluye(copiaDocumento);
                view.getData().setText("");

            } else {
                JOptionPane.showMessageDialog(view, "Es Obligatorio el nombre de la Orden");
            }
        }

        if (e.getSource() == view.getBtnGuardar()) {
            int totalDocs = documentacionEnBlanco.getDocumentos().size();
            if (editando) {
                guardarDoc(index);
            } else {
                if (totalDocs > 0) {
                    guardarDoc(totalDocs - 1);
                }
            }
        }

        if (e.getSource() == view.getBtnEditar()) {
            editando = true;
            index = view.getListDocumento().getSelectedIndex();
            documentacionEnBlanco.getDocumentos().get(index).visualiza();
        }

        if (e.getSource() == view.getBtnImprimir()) {
            Integer indexDoc = view.getListDocumento().getSelectedIndex();
            documentacionEnBlanco.getDocumentos().get(indexDoc).imprime();
        }
    }
}

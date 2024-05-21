/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototype;
import java.util.*;
/**
 *
 * @author wevergara
 */
public class DocumentacionEnBlanco extends Documentacion {

    private static DocumentacionEnBlanco instancia = null;

    private DocumentacionEnBlanco() {

        documentos = new ArrayList<Documento>();
    }

    public static DocumentacionEnBlanco Instance() {
        if (instancia == null) {
            instancia = new DocumentacionEnBlanco();
        }
        return instancia;
    }

    public void incluye(Documento doc) {
        documentos.add(doc);
    }

    public void excluye(Documento doc) {
        documentos.remove(doc);
    }
}

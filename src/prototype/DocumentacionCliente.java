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

public class DocumentacionCliente extends Documentacion {

    public DocumentacionCliente(String informacion) {
        documentos = new ArrayList<Documento>();
        DocumentacionEnBlanco documentacionEnBlanco = DocumentacionEnBlanco.Instance();
        List<Documento> documentosEnBlanco = documentacionEnBlanco.getDocumentos();
        for (Documento documento : documentosEnBlanco) {
            Documento copiaDocumento = documento.duplica();
            copiaDocumento.rellena(informacion);
            documentos.add(copiaDocumento);
        }
    }

    public void visualiza() {
        for (Documento documento : documentos) {
            documento.visualiza();
        }
    }

    public void imprime() {
        for (Documento documento : documentos) {
            documento.imprime();
        }
    }
}

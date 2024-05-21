/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototype;

import Vista.editor;

/**
 *
 * @author wevergara
 */
public class CertificadoCesion extends Documento {

    editor view;
    
    @Override
    public void visualiza() {
        System.out.println("Muestra el certificado de cesion: " + contenido);
        view.getData().setText(contenido);
    }

    @Override
    public void imprime() {
        System.out.println("Imprime el certificado de cesion: " + contenido);
    }
}

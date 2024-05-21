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
public class SolicitudMatriculacion extends Documento {

    editor view;
    
    @Override
    public void visualiza() {
        System.out.println("Muestra la solicitud de matriculacion: " + contenido);
        view.getData().setText(contenido);
    }

    @Override
    public void imprime() {
        System.out.println("Imprime la solicitud de matriculacion: " + contenido);
    }
}

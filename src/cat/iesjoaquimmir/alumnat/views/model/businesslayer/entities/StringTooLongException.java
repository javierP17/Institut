/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities;


public class StringTooLongException extends Exception {

    private String cadena;
    public StringTooLongException(String x) {
         cadena = new String(x);
    }
    public String toString(){
       return  String.format("El camp dni i telèfon han de estar formats per 9 caràcters");
    }
}

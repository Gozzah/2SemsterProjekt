/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.Exceptions;

/**
 *
 * @author Runej
 */
public class CarportException extends Exception {

    /**
     * Creates a new instance of <code>carportException</code> without detail
     * message.
     */
    public CarportException() {
    }

    /**
     * Constructs an instance of <code>carportException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CarportException(String msg) {
        super("hej med dig");
    }
}

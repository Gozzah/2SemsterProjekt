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
public class ProductsException extends Exception {

    /**
     * Creates a new instance of <code>ProductsException</code> without detail
     * message.
     */
    public ProductsException() {
    }

    /**
     * Constructs an instance of <code>ProductsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ProductsException(String msg) {
        super(msg);
    }
}

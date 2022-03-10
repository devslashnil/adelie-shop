package com.devslashnil.adelie.exception;

/**
 * Empty Cart
 *
 * Order can't be placed: cart is empty
 */
public class EmptyCartException extends CustomNotValidException {

    public EmptyCartException() {
        super("NotEmpty", "cart", "items");
    }

}

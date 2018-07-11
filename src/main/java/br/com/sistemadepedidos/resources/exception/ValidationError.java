/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemadepedidos.resources.exception;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grazziano Fagundes
 */
public class ValidationError extends StandardError {

    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Long timnestamp, Integer status, String error, String message, String path) {
        super(timnestamp, status, error, message, path);
    }

    

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }

}

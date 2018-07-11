package br.com.sistemadepedidos.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long timnestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError(Long timnestamp, Integer status, String error, String message, String path) {
        this.timnestamp = timnestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
    
    public Long getTimnestamp() {
        return timnestamp;
    }

    public void setTimnestamp(Long timnestamp) {
        this.timnestamp = timnestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
    
}

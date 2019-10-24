package com.nastsin.ec.springweb.dto;

public class ErrorMessage {
    private Integer status;
    private Integer errorCode;
    private String errorMessage;

    public ErrorMessage() {
    }

    public ErrorMessage(Integer status, Integer errorCode, String errorMessage) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorMessage that = (ErrorMessage) o;

        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (errorCode != null ? !errorCode.equals(that.errorCode) : that.errorCode != null) return false;
        return errorMessage != null ? errorMessage.equals(that.errorMessage) : that.errorMessage == null;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (errorCode != null ? errorCode.hashCode() : 0);
        result = 31 * result + (errorMessage != null ? errorMessage.hashCode() : 0);
        return result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "status=" + status +
                ", errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;


    }
}
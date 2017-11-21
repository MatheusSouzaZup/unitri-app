package com.unitriapp.matheus.unitriapp.model.response;

/**
 * Created by Matheus on 15/11/2017.
 */

public class ResponseError {
    public static final String UNEXPECTED = "333";
    public static final String JSON_PARSE_ERROR = "111";

    private String code;
    private String detail;
    private String title;
    private String text;
    private String httpCode;

    public ResponseError(String code, String detail, String title, String text, String httpCode) {
        this.code = code;
        this.detail = detail;
        this.title = title;
        this.text = text;
        this.httpCode = httpCode;
    }

    public ResponseError() {
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(String httpCode) {
        this.httpCode = httpCode;
    }

    @Override
    public String toString() {
        return "ResponseError{" +
                "code='" + code + '\'' +
                ", detail='" + detail + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", httpCode='" + httpCode + '\'' +
                '}';
    }

    public static final ResponseError getExceptionError() {
        final ResponseError error = new ResponseError();
        error.setTitle("Error inesperado");
        error.setCode(UNEXPECTED);
        error.setText("Desculpe-nos, não foi possível processar a sua solicitação no momento.");
        return error;
    }

    public static ResponseError getJsonParseException() {
        final ResponseError error = new ResponseError();
        error.setTitle("Json parse error");
        error.setCode(JSON_PARSE_ERROR);
        error.setText("Alguma coisa no serviço foi alterada.");
        return error;
    }
}


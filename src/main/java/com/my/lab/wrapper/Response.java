package com.epam.lab.wrapper;

import com.epam.lab.domain.Place;
import com.epam.lab.domain.User;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Response {

    @XmlElementRefs({@XmlElementRef(type = User.class), @XmlElementRef(type = Place.class),
            @XmlElementRef(type = Users.class), @XmlElementRef(type = Places.class)})
    private Object result;

    @XmlElementRefs({@XmlElementRef(type = User.class), @XmlElementRef(type = Place.class)})
    private Object[] results;

    @XmlElement
    private Status status;

    @XmlElement
    private String message;

    public Response() {
    }

    public Response(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public Response(Status status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public Response(Status status, String message, Object[] results) {
        this.status = status;
        this.message = message;
        this.results = results;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Object[] getResults() {
        return results;
    }

    public void setResults(Object[] results) {
        this.results = results;
    }

    public static Response success(String message) {
        return new Response(Status.SUCCESS, message);
    }

    public static Response success(String message, Object object) {
        return new Response(Status.SUCCESS, message, object);
    }

    public static Response success(String message, Object[] objects) {
        return new Response(Status.SUCCESS, message, objects);
    }

    public static Response failure(String message) {
        return new Response(Status.FAIL, message);
    }

    public static Response failure(String message, Object object) {
        return new Response(Status.FAIL, message, object);
    }

    public static Response failure(String message, Object[] objects) {
        return new Response(Status.FAIL, message, objects);
    }

    @XmlType
    @XmlEnum(String.class)
    public enum Status {
        @XmlEnumValue("success")
        SUCCESS,
        @XmlEnumValue("fail")
        FAIL
    }
}

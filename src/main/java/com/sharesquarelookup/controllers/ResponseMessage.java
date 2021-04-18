package com.sharesquarelookup.controllers;

public class ResponseMessage {
    public String message;
    public boolean actionExecuted;

    public static ResponseMessage Create(String m, boolean executed) {
        ResponseMessage message = new ResponseMessage();
        message.message = m;
        message.actionExecuted = executed;
        return  message;
    }
}

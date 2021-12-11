package io.hashimati.baseApp.domains;

import io.hashimati.baseApp.domains.enums.MessageType;

public class Message<T> {
    private T data;
    private MessageType messageType;
    private String message;

    public Message(T data, MessageType messageType, String message){
           this.data = data;
           this.messageType = messageType;
           this.message = message;
    }
    public static <M>Message just(M data, MessageType messageType, String message){
        return new Message<M>(data, messageType, message);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

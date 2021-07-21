package org.acme.logger.enums;

public enum MessageType {

    MESSAGE (1, "message"),
    ERROR (2, "error"),
    WARNING (3, "warning");

    private int id;
    private String type;

    private MessageType(final int id, final String type) {
        this.id = id;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

}

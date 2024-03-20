package com.sparta.shh.readwrite;

public class ToDo
{
    private String description;
    private String who;
    private String estTime;
    private String dateEntered;
    private String isDone;

    public ToDo(String description, String who, String estTime,
                String dateEntered, String isDone) {
        this.description = description;
        this.who = who;
        this.estTime = estTime;
        this.dateEntered = dateEntered;
        this.isDone = isDone;
    }

    public String getDescription() {
        return description;
    }

    public String getWho() {
        return who;
    }

    public String getEstTime() {
        return estTime;
    }

    public String getDateEntered() {
        return dateEntered;
    }

    public String getIsDone() {
        return isDone;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "description='" + description + '\'' +
                ", who='" + who + '\'' +
                ", estTime='" + estTime + '\'' +
                ", dateEntered='" + dateEntered + '\'' +
                ", isDone='" + isDone + '\'' +
                '}';
    }
}

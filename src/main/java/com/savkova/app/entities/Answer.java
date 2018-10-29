package com.savkova.app.entities;

public class Answer
{
    private final int id;
    private final int rate;

    public Answer(int id, int rate)
    {
        this.id = id;
        this.rate = rate;
    }

    public int getId()
    {
        return id;
    }

    public int getRate()
    {
        return rate;
    }
}

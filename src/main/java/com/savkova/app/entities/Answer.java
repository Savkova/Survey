package com.savkova.app.entities;

public class Answer
{
    private int id;
    private int rate;

    public Answer(final int id, final int rate)
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

package com.savkova.app;

public enum AgeGroup
{
    AGE_GROUP25(0, 25),
    AGE_GROUP35(25, 35),
    AGE_GROUP45(35, 45),
    AGE_GROUP55(45, 65),
    AGE_GROUP65(65, 150);

    final private int minAge;
    final private int maxAge;
    private int votes;
    private double rating;

    AgeGroup(final int minAge, final int maxAge)
    {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public int getMinAge()
    {
        return minAge;
    }

    public int getMaxAge()
    {
        return maxAge;
    }

    public int getVotes()
    {
        return votes;
    }

    public double getRating()
    {
        return rating;
    }

    void updateRating(final double rate)
    {
        this.rating += rate;
        this.votes += 1;
    }

    @Override
    public String toString()
    {
        return String.format("%3d - %3d", minAge, maxAge);
    }
}

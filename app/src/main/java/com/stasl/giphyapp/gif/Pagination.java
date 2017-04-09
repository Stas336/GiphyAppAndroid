package com.stasl.giphyapp.gif;

public class Pagination
{
    private String count;

    private String offset;

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public String getOffset ()
    {
        return offset;
    }

    public void setOffset (String offset)
    {
        this.offset = offset;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [count = "+count+", offset = "+offset+"]";
    }
}
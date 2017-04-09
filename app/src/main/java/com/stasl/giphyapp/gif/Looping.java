package com.stasl.giphyapp.gif;

public class Looping
{
    private String mp4_size;

    private String mp4;

    public String getMp4_size ()
    {
        return mp4_size;
    }

    public void setMp4_size (String mp4_size)
    {
        this.mp4_size = mp4_size;
    }

    public String getMp4 ()
    {
        return mp4;
    }

    public void setMp4 (String mp4)
    {
        this.mp4 = mp4;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [mp4_size = "+mp4_size+", mp4 = "+mp4+"]";
    }
}

package com.stasl.giphyapp.gif;

public class Original_mp4
{
    private String height;

    private String mp4_size;

    private String width;

    private String mp4;

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    public String getMp4_size ()
    {
        return mp4_size;
    }

    public void setMp4_size (String mp4_size)
    {
        this.mp4_size = mp4_size;
    }

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
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
        return "ClassPojo [height = "+height+", mp4_size = "+mp4_size+", width = "+width+", mp4 = "+mp4+"]";
    }
}

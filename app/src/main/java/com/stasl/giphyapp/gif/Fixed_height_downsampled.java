package com.stasl.giphyapp.gif;

public class Fixed_height_downsampled
{
    private String webp;

    private String height;

    private String width;

    private String url;

    private String webp_size;

    private String size;

    public String getWebp ()
    {
        return webp;
    }

    public void setWebp (String webp)
    {
        this.webp = webp;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getWebp_size ()
    {
        return webp_size;
    }

    public void setWebp_size (String webp_size)
    {
        this.webp_size = webp_size;
    }

    public String getSize ()
    {
        return size;
    }

    public void setSize (String size)
    {
        this.size = size;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [webp = "+webp+", height = "+height+", width = "+width+", url = "+url+", webp_size = "+webp_size+", size = "+size+"]";
    }
}
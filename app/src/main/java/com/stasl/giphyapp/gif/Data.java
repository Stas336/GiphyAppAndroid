package com.stasl.giphyapp.gif;

public class Data
{
    private String source_post_url;

    private String trending_datetime;

    private String type;

    private String url;

    private String content_url;

    private String id;

    private String import_datetime;

    private String username;

    private String is_indexable;

    private String source;

    private String source_tld;

    private String embed_url;

    private Images images;

    private String bitly_gif_url;

    private String slug;

    private String bitly_url;

    private String rating;

    private User user;

    public String getSource_post_url ()
    {
        return source_post_url;
    }

    public void setSource_post_url (String source_post_url)
    {
        this.source_post_url = source_post_url;
    }

    public String getTrending_datetime ()
    {
        return trending_datetime;
    }

    public void setTrending_datetime (String trending_datetime)
    {
        this.trending_datetime = trending_datetime;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getContent_url ()
    {
        return content_url;
    }

    public void setContent_url (String content_url)
    {
        this.content_url = content_url;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getImport_datetime ()
    {
        return import_datetime;
    }

    public void setImport_datetime (String import_datetime)
    {
        this.import_datetime = import_datetime;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    public String getIs_indexable ()
    {
        return is_indexable;
    }

    public void setIs_indexable (String is_indexable)
    {
        this.is_indexable = is_indexable;
    }

    public String getSource ()
    {
        return source;
    }

    public void setSource (String source)
    {
        this.source = source;
    }

    public String getSource_tld ()
    {
        return source_tld;
    }

    public void setSource_tld (String source_tld)
    {
        this.source_tld = source_tld;
    }

    public String getEmbed_url ()
    {
        return embed_url;
    }

    public void setEmbed_url (String embed_url)
    {
        this.embed_url = embed_url;
    }

    public Images getImages ()
    {
        return images;
    }

    public void setImages (Images images)
    {
        this.images = images;
    }

    public String getBitly_gif_url ()
    {
        return bitly_gif_url;
    }

    public void setBitly_gif_url (String bitly_gif_url)
    {
        this.bitly_gif_url = bitly_gif_url;
    }

    public String getSlug ()
    {
        return slug;
    }

    public void setSlug (String slug)
    {
        this.slug = slug;
    }

    public String getBitly_url ()
    {
        return bitly_url;
    }

    public void setBitly_url (String bitly_url)
    {
        this.bitly_url = bitly_url;
    }

    public String getRating ()
    {
        return rating;
    }

    public void setRating (String rating)
    {
        this.rating = rating;
    }

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [source_post_url = "+source_post_url+", trending_datetime = "+trending_datetime+", type = "+type+", url = "+url+", content_url = "+content_url+", id = "+id+", import_datetime = "+import_datetime+", username = "+username+", is_indexable = "+is_indexable+", source = "+source+", source_tld = "+source_tld+", embed_url = "+embed_url+", images = "+images+", bitly_gif_url = "+bitly_gif_url+", slug = "+slug+", bitly_url = "+bitly_url+", rating = "+rating+", user = "+user+"]";
    }
}

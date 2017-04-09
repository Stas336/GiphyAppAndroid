package com.stasl.giphyapp.gif;

public class User
{
    private String twitter;

    private String display_name;

    private String banner_url;

    private String username;

    private String profile_url;

    private String avatar_url;

    public String getTwitter ()
    {
        return twitter;
    }

    public void setTwitter (String twitter)
    {
        this.twitter = twitter;
    }

    public String getDisplay_name ()
    {
        return display_name;
    }

    public void setDisplay_name (String display_name)
    {
        this.display_name = display_name;
    }

    public String getBanner_url ()
    {
        return banner_url;
    }

    public void setBanner_url (String banner_url)
    {
        this.banner_url = banner_url;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    public String getProfile_url ()
    {
        return profile_url;
    }

    public void setProfile_url (String profile_url)
    {
        this.profile_url = profile_url;
    }

    public String getAvatar_url ()
    {
        return avatar_url;
    }

    public void setAvatar_url (String avatar_url)
    {
        this.avatar_url = avatar_url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [twitter = "+twitter+", display_name = "+display_name+", banner_url = "+banner_url+", username = "+username+", profile_url = "+profile_url+", avatar_url = "+avatar_url+"]";
    }
}

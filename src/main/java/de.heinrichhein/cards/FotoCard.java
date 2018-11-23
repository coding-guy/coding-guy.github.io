package de.heinrichhein.cards;

/**
 * created at 23.11.2018
 */
public class FotoCard extends Card {

    private String url;

    private String title;


    private FotoCard( String url, String title ) {
        this.url = url;
        this.title = title;
    }


    public static FotoCard of( String url, String title ) {
        return new FotoCard( url, title );
    }


    public String getUrl() {
        return url;
    }


    public String getTitle() {
        return title;
    }
}

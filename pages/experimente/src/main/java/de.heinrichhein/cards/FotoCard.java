package de.heinrichhein.cards;

/**
 * created at 23.11.2018
 */
public class FotoCard extends Card {

    private String url;

    private String title;


    private FotoCard( String title, String url ) {
        this.url = url;
        this.title = title;
    }


    public static FotoCard of( String title, String url ) {
        return new FotoCard( title, url );
    }


    public String getUrl() {
        return url;
    }


    public String getTitle() {
        return title;
    }
}

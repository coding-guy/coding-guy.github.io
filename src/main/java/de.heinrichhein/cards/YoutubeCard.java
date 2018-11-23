package de.heinrichhein.cards;

/**
 * created at 23.11.2018
 */
public class YoutubeCard extends Card {

    private String title;

    private String videoId;

    private int start;

    private int end;


    private YoutubeCard( String title, String videoId, int start, int end ) {
        this.title = title;
        this.videoId = videoId;
        this.start = start;
        this.end = end;
    }


    public static YoutubeCard of( String title, String videoId, int start, int end ) {
        return new YoutubeCard( title, videoId, start, end );
    }


    public String getTitle() {
        return title;
    }


    public String getVideoId() {
        return videoId;
    }


    public int getStart() {
        return start;
    }


    public int getEnd() {
        return end;
    }
}

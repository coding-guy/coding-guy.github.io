package de.heinrichhein.cards;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


/**
 * created at 23.11.2018
 */
public class HTMLTemplateReplacement {

    static File YOUTUBE_MASTER_FILE;

    static String YOUTUBE_MASTER;

    static File FOTO_MASTER_FILE;

    static String FOTO_MASTER;

    static File GENERATION_DIR;


    public static void main( String... args ) throws IOException {
        YOUTUBE_MASTER_FILE = new File( "./youtube_master.html" );
        YOUTUBE_MASTER = new String( Files.readAllBytes( YOUTUBE_MASTER_FILE.toPath() ) );


        FOTO_MASTER_FILE = new File( "./foto_master.html" );
        FOTO_MASTER = new String( Files.readAllBytes( FOTO_MASTER_FILE.toPath() ) );

        GENERATION_DIR = new File( YOUTUBE_MASTER_FILE.getParentFile(), "generated" );
        if( !GENERATION_DIR.exists() )
            Files.createDirectory( GENERATION_DIR.toPath() );

        new HTMLTemplateReplacement().run();
    }


    public void run() {
        try {
            CardStore cardStore = new CardStore();
            for( Card card : cardStore.getCards() ) {
                if( card instanceof FotoCard ) {
                    renderFotoCard( (FotoCard)card );
                }
                else {
                    renderYoutubeCard( (YoutubeCard)card );
                }
            }
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }


    private void renderFotoCard( FotoCard fotoCard ) {
        try {
            String filename = fotoCard.getTitle().replaceAll( "[^0-9a-zA-Z]", "" ) + ".html";
            File fotoCardFile = new File( FOTO_MASTER_FILE.getParentFile(), "/generated/" + filename );
            Files.deleteIfExists( fotoCardFile.toPath() );
            String content = FOTO_MASTER.replace( "{{title}}", fotoCard.getTitle() )
                    .replace( "{{url}}", fotoCard.getUrl() );

            Files.write( fotoCardFile.toPath(), content.getBytes() );
        }
        catch( IOException e ) {
            e.printStackTrace();
        }
    }


    private void renderYoutubeCard( YoutubeCard youtubeCard ) {
        try {
            String filename = youtubeCard.getTitle().replaceAll( "[^0-9a-zA-Z]", "" ) + ".html";
            File youtubeCardFile = new File( YOUTUBE_MASTER_FILE.getParentFile(), "/generated/" + filename );
            Files.deleteIfExists( youtubeCardFile.toPath() );
            String content = YOUTUBE_MASTER.replace( "{{title}}", youtubeCard.getTitle() )
                    .replace( "{{videoid}}", youtubeCard.getVideoId() )
                    .replace( "{{start}}", "" + youtubeCard.getStart() )
                    .replace( "{{start}}", "" + youtubeCard.getEnd() );

            Files.write( youtubeCardFile.toPath(), content.getBytes() );
        }
        catch( IOException e ) {
            e.printStackTrace();
        }
    }

}

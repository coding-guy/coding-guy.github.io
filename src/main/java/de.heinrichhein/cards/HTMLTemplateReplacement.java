package de.heinrichhein.cards;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


/**
 * created at 23.11.2018
 */
public class HTMLTemplateReplacement {

    static File YOUTUBE_MASTER_FILE;

    static String YOUTUBE_MASTER;

    static File FOTO_MASTER_FILE;

    static String FOTO_MASTER;

    static File TOC_MASTER_FILE;

    static String TOC_MASTER;

    static File GENERATION_DIR;


    public static void main( String... args ) throws IOException {
        YOUTUBE_MASTER_FILE = new File( "./youtube_master.html" );
        YOUTUBE_MASTER = new String( Files.readAllBytes( YOUTUBE_MASTER_FILE.toPath() ) );


        FOTO_MASTER_FILE = new File( "./foto_master.html" );
        FOTO_MASTER = new String( Files.readAllBytes( FOTO_MASTER_FILE.toPath() ) );


        TOC_MASTER_FILE = new File( "./toc_master.html" );
        TOC_MASTER = new String( Files.readAllBytes( TOC_MASTER_FILE.toPath() ) );

        GENERATION_DIR = new File( YOUTUBE_MASTER_FILE.getParentFile(), "generated" );
        if( !GENERATION_DIR.exists() )
            Files.createDirectory( GENERATION_DIR.toPath() );

        new HTMLTemplateReplacement().run();
    }


    public void run() {
        try {
            List<String> filenames = new ArrayList<>();
            CardStore cardStore = new CardStore();
            for( Card card : cardStore.getCards() ) {
                String filename;
                if( card instanceof FotoCard ) {
                    filename = renderFotoCard( (FotoCard)card );
                }
                else {
                    filename = renderYoutubeCard( (YoutubeCard)card );
                }

                if( null != filename )
                    filenames.add( filename );
            }

            buildToc( filenames );
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }


    private void buildToc( List<String> filenames ) {
        try {
            String toc = "";
            for( String filename : filenames ) {
                String url = "./generated/" + filename;
                toc += String.format( "<li><a href=\"%s\">%s</a></li>", url, url );
            }

            File tocFile = new File( "./index.html" );
            Files.deleteIfExists( tocFile.toPath() );

            String content = TOC_MASTER.replace( "{{title}}", "Verzeichnis" ).replace( "{{toc}}", toc );

            Files.write( tocFile.toPath(), content.getBytes() );
        }
        catch( IOException e ) {
            e.printStackTrace();
        }
    }


    private String renderFotoCard( FotoCard fotoCard ) {
        try {
            String filename = fotoCard.getTitle().replaceAll( "[^0-9a-zA-Z]", "" ) + ".html";
            File fotoCardFile = new File( GENERATION_DIR, filename );
            Files.deleteIfExists( fotoCardFile.toPath() );
            String content = FOTO_MASTER.replace( "{{title}}", fotoCard.getTitle() )
                    .replace( "{{url}}", fotoCard.getUrl() );

            Files.write( fotoCardFile.toPath(), content.getBytes() );
            return filename;
        }
        catch( IOException e ) {
            e.printStackTrace();
        }

        return null;
    }


    private String renderYoutubeCard( YoutubeCard youtubeCard ) {
        try {
            String filename = youtubeCard.getTitle().replaceAll( "[^0-9a-zA-Z]", "" ) + ".html";
            File youtubeCardFile = new File( GENERATION_DIR, filename );
            Files.deleteIfExists( youtubeCardFile.toPath() );
            String content = YOUTUBE_MASTER.replace( "{{title}}", youtubeCard.getTitle() )
                    .replace( "{{videoid}}", youtubeCard.getVideoId() )
                    .replace( "{{start}}", "" + youtubeCard.getStart() )
                    .replace( "{{end}}", "" + youtubeCard.getEnd() );

            Files.write( youtubeCardFile.toPath(), content.getBytes() );
            return filename;
        }
        catch( IOException e ) {
            e.printStackTrace();
        }

        return null;
    }

}

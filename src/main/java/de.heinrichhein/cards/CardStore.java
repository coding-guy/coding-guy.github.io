package de.heinrichhein.cards;

import java.util.ArrayList;
import java.util.List;


/**
 * created at 23.11.2018
 */
public class CardStore {
    private List<Card> cards = new ArrayList<>();


    public CardStore() {
        this.cards.add( YoutubeCard.of( "Luftballon - Reißzwecken", "ZJ_7nsXeHQs", 5, 13 ) );
        this.cards.add( YoutubeCard.of( "Kerzenlöscher", "ZJ_7nsXeHQs", 19, 38 ) );
        this.cards.add( YoutubeCard.of( "Münze trocknen", "ZJ_7nsXeHQs", 58, 72 ) );
        this.cards.add( YoutubeCard.of( "Farbensprudel", "ZJ_7nsXeHQs", 84, 114 ) );
        this.cards.add( YoutubeCard.of( "Zuckerwasser mischen", "JsbK5d6RCIg", 16, 85 ) );
        this.cards.add( YoutubeCard.of( "Warmes kaltes Wasser", "JsbK5d6RCIg", 88, 166 ) );
        this.cards.add( YoutubeCard.of( "Trügerische Linse", "wXwSpcfYBD4", 191, 219 ) );
        this.cards.add( YoutubeCard.of( "Bunter Regen", "wXwSpcfYBD4", 289, 353 ) );
        this.cards.add( YoutubeCard.of( "Der Weg der Luft", "wXwSpcfYBD4", 289, 353 ) );
        this.cards.add( FotoCard.of( "Der Weg der Luft",
                "https://photos.google.com/share/AF1QipMW37-71MiKy6pxvNDMxTTE34pZAypQxArXz6StKreBZjALFzSZ8iKK0tf29XnlLg/photo/AF1QipOeR-3w_GfqreYcM9QYbETSUNQsGZLu4lAVgzyn?key=WlhkOF9Rd0JoTkRFSmNHSzJIcS03TTNMWkFtYWVn" ) );
        this.cards.add( FotoCard.of( "Saugnapf",
                "https://photos.google.com/share/AF1QipPRxYhwM0HFRrCQdCVtLgnyhx9xay-z3bdSLd7odD5fk5Fif9KEGO1NMWejypCn1Q/photo/AF1QipOUIn4nk6udCSimy_d3xCb6lH8fGghfryBMfX6V?key=ejlWR1BjZVRtMUVibWtSc3RkMUg3YnYtYWZySHJR" ) );
        this.cards.add( YoutubeCard.of( "Kinetische Flüssigkeit", "eJxzLARExps", 780, 842 ) );
        this.cards.add( YoutubeCard.of( "Ei in der Flasche", "eJxzLARExps", 302, 316 ) );
    }


    public List<Card> getCards() {
        return cards;
    }
}

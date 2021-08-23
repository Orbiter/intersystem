package ai.susi.intersystem;

import java.util.Map;

public interface IntersystemClient {

    //
    // declaring protocol
    //

    /**
     * Declare a spoken language to the server. This means that messages send with the sendMessage
     * method are formulated in the given language. The server may do a translation to present this.
     * If the server translates into another language, the reverse operation should be applied when
     * sending text back with the receive methods because this client expects answers in the same
     * language.
     * @param language
     */
    public void setLanguage(String language);

    /**
     * Declares if the server should echo texts that are returned with the receive methods.
     * @param on
     */
    public void setEcho(boolean on);

    /**
     * Set (a) hotword(s) to the server. These words are triggerwords which may be used for
     * speech-to-text inputs in case that the server has no visual interface built in.
     * The server may i.e. wait for inputs when called by receiveText() until the recognized
     * sentence contains all or any of the given words.
     * @param all
     * @param word
     */
    public void setHotwords(boolean all, String... word);

    /**
     * The volume may be used for servers with visual and voice-interfaces as well:
     * visual interfaces may print the text in bold for full volume.
     * @param volume - a number between 0 (silent) and 1 (maximum)
     */
    public void setVolumne(double volume);

    /**
     * If the redraw flag is set to true, the server attempts to redraw objects over a previously
     * painted object. Such objects may be any visuals like matrix plots, images, videos.
     * @param on
     */
    public void setRedraw(boolean on);


    /**
     * Set a timeout for all input methods where the server has to wait until the user does some input.
     * If the timeout shall be infinite, set millis to 0 or MAXINT/MAXLONG.
     * All input methods that run into a timeout return NULL.
     * @param millis
     */
    public void setTimeout(long millis);


    //
    // sending data
    //

    /**
     * Send a text message to the server. The message should be given in the declared language.
     * In case that the server has no display attached, it is also possible that it just speaks
     * the message using text-to-speech.
     * @param message
     */
    public void sendMessage(String message);

    /**
     * Send a plot matrix to the server. The matrix is rendered in the given row length. The number
     * of characters should be dividable by the given rowlength without a remainer.
     * If the redraw flag is set to true, the server attempts to redraw the matrix over a previously
     * painted matrix.
     * @param matrix
     * @param rowlength
     */
    public void showPlot(Character[] matrix, int rowlength);

    /**
     * Plot a character onto a previously painted matrix plot.
     * The coordinate system has (0,0) in the upper left corner.
     * @param cell
     * @param row
     * @param col
     */
    public void showPlot(Character cell, int row, int col);

    /**
     * Draw an image. The image may be given in various formats according to the mime type.
     * The server should at least support png and gif graphics.
     * @param id
     * @param image
     * @param mimetype
     */
    public void showImage(String id, byte[] image, String mimetype);

    /**
     * Draw an image using a given provider. The id is an identifier that the providers accepts.
     * @param id
     * @param provider
     */
    public void showImage(String id, String provider);

    /**
     * Present a video.
     * @param id
     * @param video
     * @param mimetype
     */
    public void playVideo(String id, byte[] video, String mimetype);
    public void playVideo(String id, String provider);

    /**
     * Play a audio file.
     * @param id
     * @param audio
     * @param mimetype
     */
    public void playAudio(String id, byte[] audio, String mimetype);
    public void playAudio(String id, String provider);

    /**
     * Create any kind of attention
     */
    public void buzz();


    //
    // receiving data
    //

    /**
     * Call the server to return any key. The first key that is pressed is returned.
     * The call can carry a message which acts as a question to the other party.
     * It can be left empty, then no message is send. If a message is attached, it
     * is handled as if send with the sendMessage() method.
     * @param message
     * @return one character
     */
    public Character askKey(String message);

    /**
     * Receive one single character until timeout. The possible characters must be passed in the charMap
     * and all characters that have no key in the charMap are ignored (as no key was pressed).
     * The server should be tolerant for uppercase/lowercase chars; however only the character as given in the
     * key of the map is returned.
     * In case that returnNoMatch is true, the method returns in the same way as when a timeout has occurred.
     * The call can carry a message which acts as a question to the other party.
     * It can be left empty, then no message is send. If a message is attached, it
     * is handled as if send with the sendMessage() method.
     * @param message
     * @param showOptions
     * @param returnNoMatch
     * @param chars
     * @return
     */
    public Character askKey(String message, boolean showOptions, boolean returnNoMatch, @SuppressWarnings("unchecked") Map.Entry<Character, String>... chars);

    /**
     * Receive one given word (a tag) as given in the tagMap. No other inputs are accepted.
     * The call can carry a message which acts as a question to the other party.
     * It can be left empty, then no message is send. If a message is attached, it
     * is handled as if send with the sendMessage() method.
     * @param message
     * @param showOptions
     * @param tags
     * @return
     */
    public String askTag(String message, boolean showOptions, @SuppressWarnings("unchecked") Map.Entry<String, String>... tags);

    public Boolean askDecision(String message, String falseMeaning, String trueMeaning, boolean showOptions);

    public String askText(String message);

    public String askPassword(String message);


    //
    // Decoration
    //

    public void dashLog(long time, String source, String message);

    public void dashImage(int order, String caption, byte[] image, String mimetype);

}

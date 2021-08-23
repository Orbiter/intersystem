package ai.susi.intersystem;

import java.io.PrintStream;
import java.util.Map.Entry;

public class IntersystemLocalClient implements IntersystemClient {

    private String language = "en";
    private boolean echo = true, redraw = false;
    private boolean hotwordAll = true;
    private String[] hotwords = new String[0];
    private double volume = 0.7d;
    long timeout = Long.MAX_VALUE;
    PrintStream out = System.out;

    public IntersystemLocalClient(PrintStream out) {
        this.out = out;
    }

    @Override
    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public void setEcho(boolean on) {
        echo = on;
    }

    @Override
    public void setHotwords(boolean all, String... word) {
        hotwordAll = all;
        hotwords = word;
    }

    @Override
    public void setVolumne(double volume) {
        this.volume = volume;
    }

    @Override
    public void setRedraw(boolean on) {
        redraw = on;
    }

    @Override
    public void setTimeout(long millis) {
        timeout = millis <= 0 ? Long.MAX_VALUE : millis;
    }

    @Override
    public void sendMessage(String message) {
        out.println(message);
    }

    @Override
    public void showPlot(Character[] matrix, int rowlength) {
        // TODO Auto-generated method stub

    }

    @Override
    public void showPlot(Character cell, int row, int col) {
        // TODO Auto-generated method stub

    }

    @Override
    public void showImage(String id, byte[] image, String mimetype) {
        // TODO Auto-generated method stub

    }

    @Override
    public void showImage(String id, String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void playVideo(String id, byte[] video, String mimetype) {
        // TODO Auto-generated method stub

    }

    @Override
    public void playVideo(String id, String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void playAudio(String id, byte[] audio, String mimetype) {
        // TODO Auto-generated method stub

    }

    @Override
    public void playAudio(String id, String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void buzz() {
        // TODO Auto-generated method stub

    }

    @Override
    public Character askKey(String message) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Character askKey(String message, boolean showOptions, boolean returnNoMatch,
            Entry<Character, String>... chars) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String askTag(String message, boolean showOptions, Entry<String, String>... tags) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean askDecision(String message, String falseMeaning, String trueMeaning, boolean showOptions) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String askText(String message) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String askPassword(String message) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void dashLog(long time, String source, String message) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dashImage(int order, String caption, byte[] image, String mimetype) {
        // TODO Auto-generated method stub

    }

}

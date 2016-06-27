package com.example.pivotal.androidbootcamp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Actions {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("clock")
    @Expose
    private String clock;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("side")
    @Expose
    private String side;
    @SerializedName("yard_line")
    @Expose
    private Integer yardLine;
    @SerializedName("down")
    @Expose
    private Integer down;
    @SerializedName("yfd")
    @Expose
    private Integer yfd;

    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("play_type")
    @Expose
    private String playType;
    @SerializedName("sequence")
    @Expose
    private Integer sequence;
    

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The clock
     */
    public String getClock() {
        return clock;
    }

    /**
     * @param clock The clock
     */
    public void setClock(String clock) {
        this.clock = clock;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary The summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return The updated
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * @param updated The updated
     */
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    /**
     * @return The side
     */
    public String getSide() {
        return side;
    }

    /**
     * @param side The side
     */
    public void setSide(String side) {
        this.side = side;
    }

    /**
     * @return The yardLine
     */
    public Integer getYardLine() {
        return yardLine;
    }

    /**
     * @param yardLine The yard_line
     */
    public void setYardLine(Integer yardLine) {
        this.yardLine = yardLine;
    }

    /**
     * @return The down
     */
    public Integer getDown() {
        return down;
    }

    /**
     * @param down The down
     */
    public void setDown(Integer down) {
        this.down = down;
    }

    /**
     * @return The yfd
     */
    public Integer getYfd() {
        return yfd;
    }

    /**
     * @param yfd The yfd
     */
    public void setYfd(Integer yfd) {
        this.yfd = yfd;
    }


    /**
     * @return The details
     */
    public String getDetails() {
        return details;
    }

    /**
     * @param details The details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * @return The playType
     */
    public String getPlayType() {
        return playType;
    }

    /**
     * @param playType The play_type
     */
    public void setPlayType(String playType) {
        this.playType = playType;
    }

    /**
     * @return The sequence
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * @param sequence The sequence
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

}

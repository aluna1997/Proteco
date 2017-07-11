package com.unam.aluna.memories;

/**
 * Created by aluna on 7/07/17.
 */

public class WonderModel {
    String cardName;
    int imageResourceId;
    int isfav;
    int isturned;

    public WonderModel() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }


    public WonderModel(String cardName) {
        this.cardName = cardName;
    }


    public int getIsturned() {
        return isturned;
    }

    public void setIsturned(int isturned) {
        this.isturned = isturned;
    }

    public int getIsfav() {
        return isfav;
    }

    public void setIsfav(int isfav) {
        this.isfav = isfav;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}

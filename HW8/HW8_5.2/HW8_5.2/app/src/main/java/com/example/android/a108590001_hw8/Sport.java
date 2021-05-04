package com.example.android.a108590001_hw8;

import android.os.Parcel;
import android.os.Parcelable;

class Sport implements Parcelable {
    private String title;
    private String info;
    private final int imageResource;
    private String details;

    Sport(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
        this.details = details;
    }

    private Sport(Parcel in) {
        title = in.readString();
        info = in.readString();
        details = in.readString();
        imageResource = in.readInt();
    }

    public static final Creator<Sport> CREATOR = new Creator<Sport>() {
        @Override
        public com.example.android.a108590001_hw8.Sport createFromParcel(Parcel in) {
            return new com.example.android.a108590001_hw8.Sport(in);
        }

        @Override
        public com.example.android.a108590001_hw8.Sport[] newArray(int size) {
            return new com.example.android.a108590001_hw8.Sport[size];
        }
    };

    String getTitle() {
        return title;
    }

    String getInfo() {
        return info;
    }

    public int getImageResource() {
        return imageResource;
    }

    String getDetails() {
        return details;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(info);
        dest.writeString(details);
        dest.writeInt(imageResource);
    }
}


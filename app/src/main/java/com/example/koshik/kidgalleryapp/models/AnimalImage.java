package com.example.koshik.kidgalleryapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by koshik on 27-11-2016.
 */

public class AnimalImage implements Parcelable {
    private String name;
    private String species;
    private String description;
    private String thumbnail;
    private String image;

    public AnimalImage() {

    }

    public AnimalImage(String name, String species, String description, String thumbnail, String image) {
        this.name = name;
        this.species = species;
        this.description = description;
        this.thumbnail = thumbnail;
        this.image = image;
    }

    private AnimalImage(Parcel source) {
        name = source.readString();
        species = source.readString();
        description = source.readString();
        thumbnail = source.readString();
        image = source.readString();
    }

    public static final Creator<AnimalImage> CREATOR = new Creator<AnimalImage>() {
        @Override
        public AnimalImage createFromParcel(Parcel in) {
            return new AnimalImage(in);
        }

        @Override
        public AnimalImage[] newArray(int size) {
            return new AnimalImage[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        applyDefaultValues();
        parcel.writeString(name);
        parcel.writeString(species);
        parcel.writeString(description);
        parcel.writeString(thumbnail);
        parcel.writeString(image);

    }

    private void applyDefaultValues() {
        if (name == null)
            name = "";
        if (species == null)
            species = "";
        if (description == null)
            description = "";
        if (thumbnail == null)
            thumbnail = "";
        if (image == null)
            image = "";
    }
}

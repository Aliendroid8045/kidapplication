package com.example.koshik.kidgalleryapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by koshik on 23-12-2016.
 */

public class CountryIModelPojo implements Parcelable {


    public static final Creator<CountryIModelPojo> CREATOR = new Creator<CountryIModelPojo>() {
        @Override
        public CountryIModelPojo createFromParcel(Parcel in) {
            return new CountryIModelPojo(in);
        }

        public CountryIModelPojo[] newArray(int size) {
            return new CountryIModelPojo[size];
        }
    };
    private String countryname;
    private String fullname;
    private String capitalname;
    private String phonecode;
    private String language;
    private String currency;
    private String region;
    private String description;
    private String thumbnail;
    private String image;

    public CountryIModelPojo() {

    }

    public CountryIModelPojo(String countryName, String fullName, String capitalname, String phoneCode, String language, String currency, String region, String description, String thumbnail, String image) {

        this.countryname = countryName;
        this.fullname = fullName;
        this.capitalname = capitalname;
        this.phonecode = phoneCode;
        this.language = language;
        this.currency = currency;
        this.region = region;
        this.description = description;
        this.thumbnail = thumbnail;
        this.image = image;
    }

    private CountryIModelPojo(Parcel source) {
        countryname = source.readString();
        fullname = source.readString();
        capitalname = source.readString();
        phonecode = source.readString();
        language = source.readString();
        currency = source.readString();
        region = source.readString();
        description = source.readString();
        thumbnail = source.readString();
        image = source.readString();
    }

    public String getCountryName() {
        return countryname;
    }

    public void setCountryName(String countryName) {
        this.countryname = countryName;
    }

    public String getFullName() {
        return fullname;
    }

    public void setFullName(String fullName) {
        this.fullname = fullName;
    }

    public String getcapitalname() {
        return capitalname;
    }

    public void setcapitalname(String capitalname) {
        this.capitalname = capitalname;
    }

    public String getPhoneCode() {
        return phonecode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phonecode = phoneCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public void writeToParcel(Parcel parcel, int i) {
        applyDefaultValues();
        parcel.writeString(countryname);
        parcel.writeString(fullname);
        parcel.writeString(capitalname);
        parcel.writeString(phonecode);
        parcel.writeString(language);
        parcel.writeString(currency);
        parcel.writeString(region);
        parcel.writeString(description);
        parcel.writeString(thumbnail);
        parcel.writeString(image);
    }


    private void applyDefaultValues() {
        if (countryname == null)
            countryname = "";
        if (capitalname == null)
            capitalname = "";
        if (fullname == null)
            fullname = "";
        if (phonecode == null)
            phonecode = "";
        if (language == null)
            language = "";
        if (currency == null)
            currency = "";
        if (region == null)
            region = "";
        if (thumbnail == null)
            thumbnail = "";
        if (description == null)
            description = "";
        if (image == null)
            image = "";
    }
}

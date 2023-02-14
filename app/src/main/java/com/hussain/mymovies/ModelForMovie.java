package com.hussain.mymovies;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelForMovie implements Parcelable {
   private String title;
   private int imgid;
   private String poster_path;

   public ModelForMovie(String title, String poster_path) {
      this.title = title;
      this.poster_path = poster_path;
   }

   public ModelForMovie(String title, int imgid) {
      this.title = title;
      this.imgid = imgid;
   }

   protected ModelForMovie(Parcel in) {
      title = in.readString();
      imgid = in.readInt();
      poster_path = in.readString();
   }

   public static final Creator<ModelForMovie> CREATOR = new Creator<ModelForMovie>() {
      @Override
      public ModelForMovie createFromParcel(Parcel in) {
         return new ModelForMovie(in);
      }

      @Override
      public ModelForMovie[] newArray(int size) {
         return new ModelForMovie[size];
      }
   };

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public int getImgid() {
      return imgid;
   }

   public void setImgid(int imgid) {
      this.imgid = imgid;
   }

   @Override
   public int describeContents() {
      return 0;
   }

   @Override
   public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(title);
      dest.writeInt(imgid);
      dest.writeString(poster_path);
   }
}

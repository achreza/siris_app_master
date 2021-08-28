package com.example.reza.pbobeta;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by docotel on 3/7/16.
 */
public class Member implements Parcelable {

    private String id;
    private String name;
    private String team;


    public Member() {
    }

    protected Member(Parcel in) {
        id = in.readString();
        name = in.readString();
        team = in.readString();

    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel in) {
            return new Member(in);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(team);

    }
}
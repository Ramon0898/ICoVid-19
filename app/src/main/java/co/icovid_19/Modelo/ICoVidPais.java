package co.icovid_19.Modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class ICoVidPais implements Parcelable {

    String mCovidCountry,mflag;
    int mTodayCases, mTodayDeaths;
    int mCases,mDeaths,mRecovered,mActive,mCritical;



    public ICoVidPais(String mCovidCountry, int mCases, int mTodayCases, int mDeaths, int mTodayDeaths, int mRecovered, int mActive, int mCritical, String mflag) {
        this.mCovidCountry = mCovidCountry;
        this.mCases = mCases;
        this.mTodayCases = mTodayCases;
        this.mDeaths = mDeaths;
        this.mTodayDeaths = mTodayDeaths;
        this.mRecovered = mRecovered;
        this.mActive = mActive;
        this.mCritical = mCritical;
        this.mflag = mflag;
    }

    public String getmCovidCountry() {
        return mCovidCountry;
    }

    public int getmCases() {
        return mCases;
    }

    public int getmTodayCases() {
        return mTodayCases;
    }

    public int getmDeaths() {
        return mDeaths;
    }

    public int getmTodayDeaths() {
        return mTodayDeaths;
    }

    public int getmRecovered() {
        return mRecovered;
    }

    public int getmActive() {
        return mActive;
    }

    public int getmCritical() {
        return mCritical;
    }

    public String getMflag() {
        return mflag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mCovidCountry);
        dest.writeInt(this.mCases);
        dest.writeInt(this.mTodayCases);
        dest.writeInt(this.mDeaths);
        dest.writeInt(this.mTodayDeaths);
        dest.writeInt(this.mRecovered);
        dest.writeInt(this.mActive);
        dest.writeInt(this.mCritical);
        dest.writeString(this.mflag);
    }

    protected ICoVidPais(Parcel in) {
        this.mCovidCountry = in.readString();
        this.mCases = in.readInt();
        this.mTodayCases = in.readInt();
        this.mDeaths = in.readInt();
        this.mTodayDeaths = in.readInt();
        this.mRecovered = in.readInt();
        this.mActive = in.readInt();
        this.mCritical = in.readInt();
        this.mflag = in.readString();
    }

    public static final Creator<ICoVidPais> CREATOR = new Creator<ICoVidPais>() {
        @Override
        public ICoVidPais createFromParcel(Parcel source) {
            return new ICoVidPais(source);
        }

        @Override
        public ICoVidPais[] newArray(int size) {
            return new ICoVidPais[size];
        }
    };
}

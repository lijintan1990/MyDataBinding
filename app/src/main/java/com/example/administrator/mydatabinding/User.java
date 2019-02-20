package com.example.administrator.mydatabinding;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

public class User extends BaseObservable{
    private String firstName;
    private String lastName;

    /**
     * 在单个或者比较少的数据需要监听时使用ObservableField
     * (ObservableBoolean,ObservableChar,ObservableInt,ObservableParcelable.....)
     */
    private ObservableField<Boolean> isShow = new ObservableField<>();

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}

package com.example.administrator.mydatabinding;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

/**
 * User类继承BaseObservable,可以实现真正的双向绑定，改变了数据，界面会跟着变化。
 * 除此之外，还有一种更细粒度的绑定方式，可以具体到成员变量，这种方式无需继承 BaseObservable，一个简单的 POJO 就可以实现。

 public class PlainUser {
 public final ObservableField<String> firstName = new ObservableField<>();
 public final ObservableField<String> lastName = new ObservableField<>();
 public final ObservableInt age = new ObservableInt();
 }
 */
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

    /**
     * @Bindable的作用是标记getter方法会在BR中生成一个元素
     * @return
     */
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

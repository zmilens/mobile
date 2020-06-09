package com.example.contacts;

import android.net.Uri;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity (tableName = "contacts")
public class Contact {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "surname")
    public String surname;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "patronymic")
    public String patronymic;

    @ColumnInfo(name = "phone")
    public String phone;

    @ColumnInfo(name = "email")
    public String email;

    @Ignore
    public Uri photo;

    @ColumnInfo (name = "photo", typeAffinity = ColumnInfo.BLOB)
    public byte[] photoData;

    //переопределяем строчки так как отображается только имя и телефон
    @Ignore
    @Override
    public String toString(){
        return surname
                + (name.isEmpty() ? ""
                : (surname.isEmpty() ? name : " " + name))
                + (patronymic.isEmpty() ? ""
                : (name.isEmpty() ? patronymic : " " + patronymic));
    }
}

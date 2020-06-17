package com.example.randomusers.injection;

import com.example.randomusers.model.Id;
import com.example.randomusers.model.Name;
import com.example.randomusers.model.Registered;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class Description {
    private Id id;
    private Registered registered;
    private String phone;
    private Name name;
    private String email;

    @Provides
    @Singleton
    public Description create() {
        return new Description();
    }

    public Registered getRegistered() {
        return registered;
    }

    public void setRegistered(Registered registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

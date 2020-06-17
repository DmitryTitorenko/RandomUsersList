package com.example.randomusers.view.user_description;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.randomusers.R;
import com.example.randomusers.injection.Description;
import com.example.randomusers.view.base.BaseFragment;

import javax.inject.Inject;
import javax.inject.Provider;

import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class UserDescriptionFragment extends BaseFragment implements IUserDescription {

    TextView tvId;
    TextView tvAge;
    TextView tvPhone;
    TextView tvName;
    TextView tvEmail;

    @InjectPresenter
    UserDescriptionPresenter presenter;

    @Inject
    Provider<UserDescriptionPresenter> presenterProvider;

    @ProvidePresenter
    UserDescriptionPresenter providePresenter() {
        return presenterProvider.get();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.description, container, false);
        tvId = view.findViewById(R.id.tvId);
        tvAge = view.findViewById(R.id.tvAge);
        tvPhone = view.findViewById(R.id.tvPhone);
        tvName = view.findViewById(R.id.tvName);
        tvEmail = view.findViewById(R.id.tvEmail);
        return view;
    }

    @Override
    public void getDescription(Description description) {
        String id = "Id: " + description.getId().getValue();
        String age = "Age: " + (description.getRegistered().getAge());
        String phone = "Phone: " + description.getPhone();
        String name = "Name: " + description.getName().getFirst();
        String email = "Email: " + description.getEmail();
        tvId.setText(id);
        tvAge.setText(age);
        tvPhone.setText(phone);
        tvName.setText(name);
        tvEmail.setText(email);
    }
}

package com.example.randomusers.view.users;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randomusers.R;
import com.example.randomusers.injection.Description;
import com.example.randomusers.model.ResponseUserList;
import com.example.randomusers.view.base.BaseFragment;

import javax.inject.Inject;
import javax.inject.Provider;

import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class UsersFragment extends BaseFragment implements IUsersView {

    private RecyclerView recyclerView;

    @InjectPresenter
    UsersPresenter presenter;

    @Inject
    Provider<UsersPresenter> presenterProvider;

    @ProvidePresenter
    UsersPresenter providePresenter() {
        return presenterProvider.get();
    }

    @Inject
    Description description;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.users_fragment, container, false);
        recyclerView = view.findViewById(R.id.rvUserImages);
        return view;
    }

    @Override
    public void getUsers(ResponseUserList list) {
        initAdapter(list);
    }

    public void initAdapter(ResponseUserList list) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(manager);

        UsersAdapter.IOnclickListener onclick = (item) -> {
            description.setId(item.getId());
            description.setRegistered(item.getRegistered());
            description.setPhone(item.getPhone());
            description.setName(item.getName());
            description.setEmail(item.getEmail());
            NavHostFragment.findNavController(UsersFragment.this).navigate(R.id.action_usersFragment_to_userDescriptionFragment);
        };

        UsersAdapter adapter = new UsersAdapter(list, onclick);
        recyclerView.setAdapter(adapter);
    }
}

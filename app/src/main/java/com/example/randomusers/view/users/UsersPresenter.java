package com.example.randomusers.view.users;

import com.example.randomusers.data.repository.Repo;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class UsersPresenter extends MvpPresenter<IUsersView> {

    Repo repo;
    Disposable disposable;

    @Inject
    UsersPresenter(Repo repo) {
        this.repo = repo;
    }

    @Override
    protected void onFirstViewAttach() {
        getUserList();
        super.onFirstViewAttach();
    }

    public void getUserList() {
        disposable = repo.getUserList().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> getViewState().getUsers(it));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}

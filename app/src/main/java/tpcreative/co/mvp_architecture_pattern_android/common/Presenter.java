package tpcreative.co.mvp_architecture_pattern_android.common;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Presenter<V> {

    @Nullable
    private volatile V view;

    @CallSuper
    public void bindView(@NonNull V view) {
        this.view = view;
    }

    @Nullable
    protected V view() {
        return view;
    }

    @CallSuper
    private void unbindView(@NonNull V view) {
        this.view = null;
    }

    @CallSuper
    public void unbindView() {
        unbindView(view);
    }

}

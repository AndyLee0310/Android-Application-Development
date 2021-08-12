package com.example.a108590001_hw10;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class Source_Code_Loader extends AsyncTaskLoader<String> {
    private String mQString;
    private String mTrfProtocol;
    Context mContext;

    public Source_Code_Loader(@NonNull Context context, String qString, String trfProtocol) {
        super(context);
        mContext = context;
        mQString = qString;
        mTrfProtocol = trfProtocol;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return Network_Utils.getSourceCode(mContext, mQString, mTrfProtocol);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}

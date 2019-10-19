package edu.calvin.cs262.hh32;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class SourceLoader extends AsyncTaskLoader<String> {

        private String mQueryString;
        private String mTransferProtocol;
        Context mContext;

        public SourceLoader(@NonNull Context context, String queryString, String transferProtocol) {
            super(context);
            mContext = context;
            mQueryString = queryString;
            mTransferProtocol = transferProtocol;
        }

        @Nullable
        @Override
        public String loadInBackground() {
            return NetworkUtils.getSourceCode(mContext, mQueryString, mTransferProtocol);
        }

        @Override
        protected void onStartLoading() {
            super.onStartLoading();
            forceLoad();
        }
}

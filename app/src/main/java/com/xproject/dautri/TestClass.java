package com.xproject.dautri;

import android.widget.ProgressBar;
import android.widget.SeekBar;

public class TestClass {

    class ThreadLoading implements Runnable {

        ProgressBar progressBar;

        public ThreadLoading(ProgressBar progressBar) {
            this.progressBar = progressBar;
        }

        @Override
        public void run() {

        }
    }
}

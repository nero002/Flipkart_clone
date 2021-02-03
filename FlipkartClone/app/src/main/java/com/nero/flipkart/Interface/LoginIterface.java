package com.nero.flipkart.Interface;

import android.os.Bundle;

public interface LoginIterface {
    void onDataRecived();

    void continueWithEmail(Bundle bundle);

    void continueWithPhone(Bundle bundle);
}

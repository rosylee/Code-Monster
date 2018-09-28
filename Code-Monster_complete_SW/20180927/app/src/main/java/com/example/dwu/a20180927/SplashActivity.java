package com.example.dwu.a20180927;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import com.example.dwu.management.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.kakao.auth.AuthType;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.LoginButton;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.kakao.util.helper.Utility.getPackageInfo;

public class SplashActivity extends AppCompatActivity {
    private SessionCallback callback;
    private int RC_SIGN_IN = 200;

    public static String getKeyHash(final Context context) {
        PackageInfo packageInfo = getPackageInfo(context, PackageManager.GET_SIGNATURES);
        if (packageInfo == null)
            return null;

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                return Base64.encodeToString(md.digest(), Base64.NO_WRAP);
            } catch (NoSuchAlgorithmException e) {
                Log.w("", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hr_activity_splash);

        String sns = hr_Utility.get(this, "sns");

        if(!sns.isEmpty()) {
            hr_UserManager.getInstance().setType(sns);
            startActivity(new Intent(this, hr_MainActivity.class));
            Log.d("SNS", "SNS = " + sns);
        } else {
            Log.d("SNS is empty", "SNS is empty = " + sns);
        }

        Log.d("gethash", getKeyHash(this));
        callback = new SessionCallback();
        Session.getCurrentSession().addCallback(callback);

        SignInButton googleButton = findViewById(R.id.google_login);
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail()
                        .build();


                GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(SplashActivity.this, gso);
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);

                //GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(SplashActivity.this);
                //updateUI(account);
            }
        });
        LoginButton loginButton = findViewById(R.id.com_kakao_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Session.getCurrentSession().checkAndImplicitOpen();
                Session.getCurrentSession().open(AuthType.KAKAO_LOGIN_ALL, SplashActivity.this);
                UserManagement.getInstance().requestMe(new MeResponseCallback() {
                    @Override
                    public void onSessionClosed(ErrorResult errorResult) {
                        Log.d("onSessionClosed", "onSessionClosed");
                    }

                    @Override
                    public void onNotSignedUp() {
                        Log.d("onNotSignedUp", "onNotSignedUp");
                    }

                    @Override
                    public void onSuccess(UserProfile result) {
                        Log.d("onSuccess", "onSuccess");
                        Log.d("onSuccess", result.getNickname());
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Session.getCurrentSession().removeCallback(callback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);

            finish();
            final Intent intent = new Intent(this, hr_MainActivity.class);
            startActivity(intent);


            hr_UserManager.getInstance().setType("Google");
            hr_Utility.set(this, "sns", "Google");
        }

        if(Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    protected void redirectSignupActivity() {
        hr_UserManager.getInstance().setType("KakaoTalk");
        hr_Utility.set(this, "sns", "KakaoTalk");
        finish();
        final Intent intent = new Intent(this, hr_MainActivity.class);
        startActivity(intent);

    }

    private class SessionCallback implements ISessionCallback {

        @Override
        public void onSessionOpened() {
            redirectSignupActivity();
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if(exception != null) {
                Logger.e(exception);
            }
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            //updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("", "signInResult:failed code=" + e.getStatusCode());
            //updateUI(null);
        }
    }
}

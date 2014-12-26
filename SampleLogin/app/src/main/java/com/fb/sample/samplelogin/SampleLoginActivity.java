package com.fb.sample.samplelogin;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;

import java.util.Arrays;
import java.util.List;


public class SampleLoginActivity extends Activity {
    private LoginButton mFBLogin;
    private Button mPost;
    private Session mSession;

    private static final List<String> PERMISSIONS = Arrays.asList("publish_actions");

    private Session.StatusCallback callback = new Session.StatusCallback() {

        @Override
        public void call(Session session, SessionState state, Exception exception) {
            if (session != null && session.isOpened()) {
                mPost.setEnabled(true);
            } else {
                mPost.setEnabled(false);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_login);
        mPost = (Button) findViewById(R.id.post);
        mFBLogin = (LoginButton) findViewById(R.id.login_button);
        mFBLogin.setUserInfoChangedCallback(new LoginButton.UserInfoChangedCallback() {

            @Override
            public void onUserInfoFetched(GraphUser user) {
                System.out.println("user info fetched+"+user);
                if (user != null) {
                    System.out.println("user " + user);
                }else{
                }
            }
        });

        mPost.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
               mSession.requestNewPublishPermissions(new Session.NewPermissionsRequest(SampleLoginActivity.this, PERMISSIONS));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sample_login, menu);
        return true;
    }
    @Override
    protected void onResume() {
        super.onResume();
        Session session = Session.getActiveSession();
        mSession = session;
        if(session != null) {
            session.addCallback(callback);
        }
        System.out.println("resume " + session);
        if (session != null && session.isOpened()) {
            mPost.setEnabled(true);
        } else {
            mPost.setEnabled(false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

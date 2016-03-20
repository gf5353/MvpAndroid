package org.gf535.mvpandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.gf535.mvpandroid.presenter.UserPresenter;
import org.gf535.mvpandroid.presenter.action.I_UserPresenter;


public class MainActivity extends AppCompatActivity {
    private UserPresenter userPresenter;
    private boolean mIsSub = false;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mIsSub) {
                    userPresenter.subUser("");
                } else {
                    userPresenter.unSubUser("");
                }
            }
        });
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userPresenter.getInfo();
            }
        });
        userPresenter = new UserPresenter();

        userPresenter.addListener(onSubListener);//动态配置所需要的业务
        userPresenter.addListener(new I_UserPresenter.OnGetUserInfoListener() {
            @Override
            public void onGetUserInfo(Object info) {
                Toast.makeText(getBaseContext(), String.valueOf(info), Toast.LENGTH_LONG).show();
            }
        });
    }


    /**
     * View处理Presenter 相应的数据
     */
    private UserPresenter.OnSubListener onSubListener = new UserPresenter.OnSubListener() {
        @Override
        public void onSubChange(boolean isSub) {
            mIsSub = isSub;
            Snackbar.make(fab, "订阅状态" + isSub, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        userPresenter.release();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

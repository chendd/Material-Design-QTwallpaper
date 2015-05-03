package us.wili.qtwallpaper.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import us.wili.qtwallpaper.R;


public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{
    public static final int HOT = 1;
    public static final int CATEGORY = 2;
    public static final int PERSONAL = 3;

    private RadioGroup menuGroup;
    private FrameLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getActionBar().setCustomView(R.layout.my_action_bar);
        menuGroup = (RadioGroup)findViewById(R.id.tab_group);
        content = (FrameLayout)findViewById(R.id.content);
        menuGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }
}

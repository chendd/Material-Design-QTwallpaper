package us.wili.qtwallpaper.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.HashMap;

import us.wili.qtwallpaper.R;
import us.wili.qtwallpaper.fragment.CategoryFragment;
import us.wili.qtwallpaper.fragment.HotFragment;
import us.wili.qtwallpaper.fragment.PersonalFragment;
import us.wili.qtwallpaper.utils.UIUtils;


public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{
    public static final int HOT_PAGE = 0;
    public static final int CATEGORY_PAGE = 1;
    public static final int PERSONAL_PAGE = 2;
    private HashMap<Integer,Fragment> fragments = new HashMap<>();
    private int fragmentContentId;
    private int currentTab;
    private boolean isExit = false;

    private RadioGroup menuGroup;
    private TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UIUtils.setImmersiveActivity(getWindow().getDecorView());
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.my_action_bar);
        titleText = (TextView)actionBar.getCustomView();

        setContentView(R.layout.activity_main);
        menuGroup = (RadioGroup)findViewById(R.id.tab_group);
        fragmentContentId = R.id.content;

        fragments.put(HOT_PAGE, new HotFragment());
        fragments.put(CATEGORY_PAGE, new CategoryFragment());
        fragments.put(PERSONAL_PAGE, new PersonalFragment());
        FragmentTransaction ft = MainActivity.this.getSupportFragmentManager().beginTransaction();
        ft.add(fragmentContentId, fragments.get(HOT_PAGE));
        currentTab = HOT_PAGE;
        ft.commit();
        menuGroup.setOnCheckedChangeListener(this);
    }

    private void showTab(int index){
        switch (index){
            case HOT_PAGE:
                titleText.setText(R.string.hot);
                break;
            case CATEGORY_PAGE:
                titleText.setText(R.string.category);
                break;
            case PERSONAL_PAGE:
                titleText.setText(R.string.personal);
                break;
        }
        FragmentTransaction ft = MainActivity.this.getSupportFragmentManager().beginTransaction();
        ft.hide(fragments.get(currentTab));
        ft.show(fragments.get(index));
        ft.commit();
        menuGroup.setOnCheckedChangeListener(null);
        ((RadioButton)menuGroup.getChildAt(currentTab)).setChecked(false);
        currentTab = index;
        ((RadioButton)menuGroup.getChildAt(currentTab)).setChecked(true);
        menuGroup.setOnCheckedChangeListener(this);
    }

    public void changeTab(int index){
        ((RadioButton)menuGroup.getChildAt(index)).setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for(int i=0; i<group.getChildCount(); i++){
            if(group.getChildAt(i).getId() == checkedId){
                Fragment fragment = fragments.get(i);
                FragmentTransaction ft = MainActivity.this.getSupportFragmentManager().beginTransaction();
                if(!fragment.isAdded()){
                    ft.add(fragmentContentId,fragment);
                }
                showTab(i);
                ft.commit();
            }
        }
    }
}

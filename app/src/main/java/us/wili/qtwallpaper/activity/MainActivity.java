package us.wili.qtwallpaper.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.HashMap;

import us.wili.qtwallpaper.R;
import us.wili.qtwallpaper.fragment.CategoryFragment;
import us.wili.qtwallpaper.fragment.HotFragment;
import us.wili.qtwallpaper.fragment.PersonalFragment;


public class MainActivity extends AppCompatActivity {
    public static final int HOT_PAGE = 0;
    public static final int CATEGORY_PAGE = 1;
    public static final int PERSONAL_PAGE = 2;
    private HashMap<Integer,Fragment> fragments = new HashMap<>();
    private HashMap<Integer,String> fragmentsTitles = new HashMap<>();

    private Toolbar toolbar;
    private AppBarLayout appbar;
    private ViewPager viewpager;
    private TabLayout tabs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initialize();

        setSupportActionBar(toolbar);

        viewpager.setAdapter(new MainAdapter(getSupportFragmentManager()));
        tabs.setupWithViewPager(viewpager);
    }


    private void initialize() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tabs = (TabLayout) findViewById(R.id.tabs);
    }

    private class MainAdapter extends FragmentPagerAdapter {

        public MainAdapter(FragmentManager fm) {
            super(fm);
            fragments.put(HOT_PAGE, new HotFragment());
            fragments.put(CATEGORY_PAGE, new CategoryFragment());
            fragments.put(PERSONAL_PAGE, new PersonalFragment());
            fragmentsTitles.put(HOT_PAGE, getString(R.string.hot));
            fragmentsTitles.put(CATEGORY_PAGE, getString(R.string.category));
            fragmentsTitles.put(PERSONAL_PAGE, getString(R.string.personal));
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentsTitles.get(position);
        }
    }
}

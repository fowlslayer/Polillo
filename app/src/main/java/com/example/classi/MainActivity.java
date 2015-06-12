package com.example.classi;

import android.app.ActionBar;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    LoginDataBaseAdapter loginDataBaseAdapter;

	// declare properties
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    private ActionBarDrawerToggle mDrawerToggle;


    // nav drawer title
    private CharSequence mDrawerTitle;

    int n = 0;

    // used to store app title
    private CharSequence mTitle;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //centra il titolo nella action bar
        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getActionBar().setCustomView(R.layout.action_bar);


        // for proper titles
        mTitle = mDrawerTitle = getTitle();

        // initialize properties
        mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // list the drawer items
        ObjectDrawerItem[] drawerItem = new ObjectDrawerItem[4];

        drawerItem[0] = new ObjectDrawerItem(R.drawable.icon_menu, "Lissone Moderna");
        drawerItem[1] = new ObjectDrawerItem(R.drawable.icon_non_preferito, "Favoriti");
        drawerItem[2] = new ObjectDrawerItem(R.drawable.icon_user, "Profilo");
        drawerItem[3] = new ObjectDrawerItem(R.drawable.icon_logout, "Logout");


        // Pass the folderData to our ListView adapter
        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.listview_item_row, drawerItem);

        // Set the adapter for the list view
        mDrawerList.setAdapter(adapter);

        // set the item click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        // for app icon control for nav drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.icon_user_menu,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /**
             * Called when a drawer has settled in a completely closed state.
             */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(mTitle);
            }

            /**
             * Called when a drawer has settled in a completely open state.
             */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(mDrawerTitle);
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        // enable ActionBar app icon to behave as action to toggle nav drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);


        if (savedInstanceState == null) {
            // on first time display view for first nav item
            selectItem(0);
        }


        Bundle extras = getIntent().getExtras();
        if(extras !=null && n==0)
        {
            n++;
            selectItem(2);
        }

    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
       if (mDrawerToggle.onOptionsItemSelected(item)) {
           return true;
       }
       
       return super.onOptionsItemSelected(item);
	}
	
	// to change up caret
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }


	// navigation drawer click listener
	private class DrawerItemClickListener implements ListView.OnItemClickListener {
		
	    @Override
	    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	        selectItem(position);
	    }
	    
	}

    private void selectItem(int position) {

        // update the main content by replacing fragments
    	
        Fragment fragment = null;
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        Bundle extras = getIntent().getExtras();
        
        switch (position) {
        case 0:
            if(extras !=null)
            {
                String userName = extras.getString("Username");
                Bundle bundle = new Bundle();
                bundle.putString("userName", userName);
                String loggato = loginDataBaseAdapter.getLoggato(userName);
                if(loggato!=null && loggato.equals("si"))
                {
                    fragment = new HomeFragment();
                    fragment.setArguments(bundle);
                }
                else
                    fragment = new HomeFragment();
            }
            else
            {
                fragment = new HomeFragment();
            }
            break;
        case 1:
            if(extras !=null)
            {
            String userName = extras.getString("Username");
            Bundle bundle = new Bundle();
            bundle.putString("userName", userName);
            String loggato = loginDataBaseAdapter.getLoggato(userName);
            if(loggato!=null && loggato.equals("si"))
            {
                fragment = new FavoritiFragment();
            }
            else
                Toast.makeText(getApplicationContext(),"Non sei loggato", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Non sei loggato", Toast.LENGTH_LONG).show();
        }
        break;
        case 2:
           if(extras !=null)
           {
                String userName = extras.getString("Username");
                Bundle bundle = new Bundle();
                bundle.putString("userName", userName);
                String loggato = loginDataBaseAdapter.getLoggato(userName);
                if(loggato!=null && loggato.equals("si"))
                {
                    fragment = new ProfiloFragment();
                    fragment.setArguments(bundle);
                }
                else
                    fragment = new LoginFragment();
           }
           else
           {
                fragment = new LoginFragment();
           }
            break;
        case 3:
            if(extras !=null)
            {
                String userName = extras.getString("Username");
                Bundle bundle = new Bundle();
                bundle.putString("userName", userName);
                String loggato = loginDataBaseAdapter.getLoggato(userName);
                if (loggato != null && loggato.equals("si")) {
                    loginDataBaseAdapter.setLoggato(userName, "no");
                    fragment = new HomeFragment();
                    Toast.makeText(getApplicationContext(),"Sei stato sloggato", Toast.LENGTH_LONG).show();
                }
            }
        //    Intent logOut = new Intent(getApplicationContext(), Login.class);
        //    startActivity(logOut);
            break;
 
        default:
            break;
        }


        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack( "tag" ).commit();
 
            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            //metodo inserito da me per far cambiare il titolo
            setCustomTitle(mNavigationDrawerItemTitles[position]);

            //setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
            
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
    
    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    public void setCustomTitle(String title)
    {
        TextView textViewTitle = (TextView) findViewById(R.id.mytext);
        textViewTitle.setText(title);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }
}

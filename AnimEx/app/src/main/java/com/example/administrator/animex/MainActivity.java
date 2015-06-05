package com.example.administrator.animex;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity implements IOnItemClickListener {

    private RecyclerView mRvAnimList;

    private Resources mRes;
    private AnimFunctionAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        init();
    }

    private void findView() {
        mRvAnimList = (RecyclerView) findViewById(R.id.rv_anim_list);
    }

    private void init() {
        mRes = getResources();
        mAdapter = new AnimFunctionAdapter(this, getResources().getStringArray(R.array.anim_function_array));

        mRvAnimList.setAdapter(mAdapter);
        mRvAnimList.setHasFixedSize(true);
        mRvAnimList.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(View view, int pos) {
        Intent intent = new Intent();

         switch (pos) {
             case 0: {
                 intent.setClass(this, CrossFadingActivity.class);
             }
             break;

             case 1: {
                 intent.setClass(this, ViewPagerSlideActivity.class);
             }
             break;

             case 2: {
                 Toast.makeText(this, "Not be implemented yet.", Toast.LENGTH_SHORT).show();
                 return;
             }

             case 3: {
                 intent.setClass(this, ZoomActivity.class);
             }
             break;
         }

        startActivity(intent);
    }
}

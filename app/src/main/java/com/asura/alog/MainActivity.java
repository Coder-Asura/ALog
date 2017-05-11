package com.asura.alog;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.asura.alog.utils.ALog;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        if (toolbar != null) {
            toolbar.setTitleTextColor(Color.WHITE);
            setSupportActionBar(toolbar);
        }
    }

    public void logI(View view) {
        ALog.i("这是一条 INFO 级别日志");
    }

    public void logIWithMap(View view) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Value 0");
        map.put(1, "Value 1");
        map.put(2, "Value 2");
        map.put(3, "Value 3");
        ALog.i(map);
    }

    public void logD(View view) {
        ALog.d("这是一条 DEBUG 级别日志");
    }

    public void logDWithArgs(View view) {
        String param0 = "第一个参数";
        String param1 = "第二个参数";
        String param2 = "第三个参数";
        int param3 = 666;
        ALog.d("logDWithArgs", "param0", param0, "param1", param1, "param2", param3);
        ALog.d("logDWithArgs", "param0", param0, "param3", param3);
    }

    public void logE(View view) {
        ALog.e("这是一条 ERROR 级别日志");
    }

    public void logEWithArgs(View view) {
        String param0 = "第一个参数";
        ALog.e("这是一条 ERROR 级别日志 param0", param0);
    }

    public void logEWithException(View view) {
        Throwable throwable = new Throwable("我是一个异常");
        ALog.e(throwable, "我故意写的一个异常");
    }

    public void logWithJson(View view) {
        String json = "[{\"name\":\"Asura\"},{\"name\":\"Asura2\"},{\"name\":\"Asura3\"}]";
        ALog.json("这是一条 JSON 字符串", json);
    }

    public void logWithXml(View view) {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><name>Asura</name>";
        ALog.xml("这是一条 XML 字符串", xml);
    }

    public void logWithNewTag(View view) {
        ALog.t("Asura", "我换了一个tag，你看不见我，看不见我，看不见我...");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about_me, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_github:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/qq709238339")));
                break;
            case R.id.action_jian_shu:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jianshu.com/u/f22d6bddfd1c")));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

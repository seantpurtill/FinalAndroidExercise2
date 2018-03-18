package org.hpeters.day13exercise;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView lvCustomers;
    AgentDataSource source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        source = new AgentDataSource(this);

        lvCustomers = findViewById(R.id.lvCustomers);
        ArrayList list = source.getAllAgents();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lvCustomers.setAdapter(adapter);

    }
}

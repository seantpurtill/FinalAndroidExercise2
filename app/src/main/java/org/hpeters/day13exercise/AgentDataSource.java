package org.hpeters.day13exercise;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;


public class AgentDataSource {
    SQLiteDatabase db;
    DBHelper helper;

    public AgentDataSource(Context context) {
        helper = new DBHelper(context);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        db = helper.getWritableDatabase();
    }

    public Agent getAgent(int AgentId)
    {
        String [] args = { AgentId + "" };
        Cursor cursor = db.rawQuery("select * from Agents where AgentId='?'", args);
        cursor.moveToNext();
        Agent c = new Agent(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                cursor.getString(4), cursor.getString(5), cursor.getString(5), cursor.getInt(7));
        cursor.close();
        return c;
    }

    public ArrayList<Agent> getAllAgents()
    {
        ArrayList<Agent> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from Agents", null);
        while (cursor.moveToNext()) {
            list.add(new Agent(cursor.getInt(0),
                    cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4),
                    cursor.getString(5), cursor.getString(6),
                     cursor.getInt(7)));
        }
        cursor.close();
        return list;
    }

    public void insert(Agent a)
    {
        ContentValues values = new ContentValues();
        values.put("agentID", a.getAgentID());
        values.put("agtFirstName", a.getAgtFirstName());
        values.put("agtMiddleInitial", a.getAgtMiddleInitial());
        values.put("agtLastName", a.getAgtLastName());
        values.put("agtBusPhone", a.getAgtBusPhone());
        values.put("agtEmail", a.getAgtEmail());
        values.put("agtPosition", a.getAgtPosition());
        values.put("agencyID", a.getAgencyID());

        db.insert("Agents", null, values);
    }


    public void update(Agent c)
    {

    }

    public void delete(int AgentId)
    {

    }
}

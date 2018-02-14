/*
 *  Copyright 2017 The Android Open Source Project
 *  Licensed under the @{PK Solutions} , Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       http://www.example.org/licenses/LICENSE-2.0 {this is not required (^.^) }
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.test.sdg.newfeatures.activities.room.list;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.sdg.newfeatures.R;
import com.test.sdg.newfeatures.activities.room.list.model.RoomUser;
import com.test.sdg.newfeatures.activities.room.list.model.RoomUserViewModel;

import java.util.ArrayList;
import java.util.List;

public class RoomListActivity extends AppCompatActivity {

    private static final String TAG = "ROOM_LIST_ACTIVITY";

    private RecyclerView roomListRecyclerView;
    private List<RoomUser> roomUserList = new ArrayList<>();
    private RoomUserViewModel roomUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initializeUI();
    }

    private void initializeUI() {
        initializeList();

        roomListRecyclerView = findViewById(R.id.RoomListActivity_room_List_RecyclerView);
        roomListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RoomUserRecyclerAdapter adapter = new RoomUserRecyclerAdapter(this, roomUserList);
        roomListRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        roomUserViewModel = ViewModelProviders.of(this).get(RoomUserViewModel.class);
        roomUserViewModel.init();
        roomUserViewModel.getListLiveData().observeForever(list -> {
            roomUserList.clear();
            roomUserList.addAll(list);
            adapter.notifyDataSetChanged();
        });

    }

    private void initializeList() {
        roomUserList.add(new RoomUser("first", "last"));
        roomUserList.add(new RoomUser("first2", "last2"));


    }

    public void addItemToRoom(View view) {
        Log.d(TAG, "addItemToRoom: ");
        new SaveDatabase().execute();
    }
}

class SaveDatabase extends AsyncTask<RoomUser, Void, List<RoomUser>> {

    @Override
    protected List<RoomUser> doInBackground(RoomUser... roomUsers) {

        return null;
    }

}

class RoomUserRecyclerAdapter extends RecyclerView.Adapter<RoomUserRecyclerAdapter.RoomUserViewHolder> {

    private Context context;
    private List<RoomUser> roomUserList;
    private LayoutInflater layoutInflater;

    public RoomUserRecyclerAdapter(Context context, List<RoomUser> roomUserList) {
        this.context = context;
        this.roomUserList = roomUserList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RoomUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RoomUserViewHolder(layoutInflater.inflate(R.layout.single_item_room_user,
                parent, false));
    }

    @Override
    public void onBindViewHolder(RoomUserViewHolder holder, int position) {
        final RoomUser roomUser = this.roomUserList.get(position);
        holder.firstName.setText(roomUser.getFirstName());
        holder.lastName.setText(roomUser.getLastName());
    }

    @Override
    public int getItemCount() {
        return this.roomUserList.size();
    }

    public static class RoomUserViewHolder extends RecyclerView.ViewHolder {

        private TextView firstName;
        private TextView lastName;

        public RoomUserViewHolder(View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.single_item_room_user_first_name_textView);
            lastName = itemView.findViewById(R.id.single_item_room_user_last_name_textView);
        }
    }
}

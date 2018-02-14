package com.test.sdg.newfeatures

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.*
import android.widget.TextView
import com.test.sdg.newfeatures.activities.example.ExampleActivity
import com.test.sdg.newfeatures.activities.lifecycle.LifeCycleActivity
import com.test.sdg.newfeatures.activities.live.data.LiveDataActivity
import com.test.sdg.newfeatures.activities.room.list.RoomListActivity
import com.test.sdg.newfeatures.activities.user.profile.UserProfileActivity
import com.test.sdg.newfeatures.application.model.ActivityItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "MAIN_ACTIVITY"
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        Log.d(TAG, ": onCreate()")

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        initializeUI()
    }

    private fun initializeUI() {
        recyclerView = findViewById(R.id.MainActivity_list_RecyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val activityList = ArrayList<ActivityItem>()
        activityList.add(ActivityItem("ExampleActivity", ExampleActivity::class.java))
        activityList.add(ActivityItem("UserProfileActivity", UserProfileActivity::class.java))
        activityList.add(ActivityItem("RoomListActivity", RoomListActivity::class.java))
        activityList.add(ActivityItem("LifeCycleActivity", LifeCycleActivity::class.java))
        activityList.add(ActivityItem("LiveDataActivity", LiveDataActivity::class.java))
        val adapter = ActivityAdapter(this,activityList )

        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, ": onStart()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, ": onRestart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, ": onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, ": onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, ": onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, ": onDestroy()")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    class ActivityAdapter(private val mContext: Context, private val activityList:
    List<ActivityItem>) :
            RecyclerView
    .Adapter<ActivityAdapter.ActivityViewHolder>() {

        private var layoutInflater: LayoutInflater = LayoutInflater.from(mContext)

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ActivityViewHolder {
            return ActivityViewHolder(layoutInflater.inflate(R.layout.single_activity_item, parent,
                    false))
        }

        override fun getItemCount(): Int {
            return activityList.size
        }

        override fun onBindViewHolder(holder: ActivityViewHolder?, position: Int) {
            holder?.activityNameTextView?.text = activityList[position].activityName
            holder?.rootLayoutCardView?.setOnClickListener {
                mContext.startActivity(Intent(mContext,activityList[position].activityClass ))
            }
        }

        class ActivityViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
            val activityNameTextView: TextView = itemView!!.findViewById(R.id
                    .single_activity_name_item_textView)
            val rootLayoutCardView: CardView = itemView!!.findViewById(R.id
                    .single_activity_item_root_CardView)
        }
    }
}

package io.synople.csmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.synople.csmusic.fragments.MainFragment
import android.widget.Button
import android.content.Context;
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.synople.csmusic.fragments.PlusOneFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainFrameLayout, PlusOneFragment.newInstance())
            .commit()
    }
}


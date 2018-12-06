package com.badikirwan.dicoding.footballmatch.view.playerdetails

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.badikirwan.dicoding.footballmatch.R
import com.badikirwan.dicoding.footballmatch.model.Player
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_player_detail.*
import org.jetbrains.anko.startActivity

class PlayerDetailActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_PARAM = "EXTRA_PARAM"

        fun start(context: Context?, player: Player) {
            context?.startActivity<PlayerDetailActivity>(EXTRA_PARAM to player)
        }
    }

    private lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_detail)

        player = intent.getParcelableExtra(EXTRA_PARAM)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = player.strPlayer

        getData()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getData() {
        tv_weight.text = player.strWeight
        tv_height.text = player.strHeight
        tv_position.text = player.strPosition
        tv_description.text = player.strDescriptionEN
        Glide.with(this).load(player.strFanart1).into(iv_player)
    }
}

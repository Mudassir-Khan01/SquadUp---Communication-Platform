package com.cometchat.SquadUpApp.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.cometchat.chatuikit.shared.resources.utils.Utils
import com.cometchat.SquadUpApp.AppUtils.Companion.changeIconTintToBlack
import com.cometchat.SquadUpApp.AppUtils.Companion.changeIconTintToWhite
import com.cometchat.SquadUpApp.AppUtils.Companion.isNightMode
import com.cometchat.SquadUpApp.constants.StringConstants
import com.cometchat.kotlinsampleapp.R
import com.cometchat.kotlinsampleapp.databinding.ActivityComponentListBinding

class ComponentListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComponentListBinding
    private lateinit var parentView: LinearLayout
    private lateinit var title: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComponentListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        parentView = binding.parentView
        title = binding.title
        setUpUI()
        if (intent != null) {
            title.text = intent.getStringExtra(StringConstants.MODULE)
            if (intent.getStringExtra(StringConstants.MODULE)
                    .equals(StringConstants.CONVERSATIONS, ignoreCase = true)
            ) {
                findViewById<View>(R.id.moduleChats).visibility = View.VISIBLE
            } else if (intent.getStringExtra(StringConstants.MODULE)
                    .equals(StringConstants.USERS, ignoreCase = true)
            ) {
                findViewById<View>(R.id.moduleUsers).visibility = View.VISIBLE
            } else if (intent.getStringExtra(StringConstants.MODULE)
                    .equals(StringConstants.GROUPS, ignoreCase = true)
            ) {
                findViewById<View>(R.id.noduleGroups).visibility = View.VISIBLE
            }

            else if (intent.getStringExtra(StringConstants.MODULE)
                    .equals(StringConstants.SHARED, ignoreCase = true)
            ) {
                findViewById<View>(R.id.shared).visibility = View.VISIBLE
            } else if (intent.getStringExtra(StringConstants.MODULE)
                    .equals(StringConstants.CALLS, ignoreCase = true)
            ) {
                findViewById<View>(R.id.module_calls).visibility = View.VISIBLE
            }
        }

        //back
        binding.backIcon.setOnClickListener { onBackPressed() }

        //chats
        binding.conversationWithMessages.setOnClickListener {
            handleIntent(
                R.id.conversationWithMessages
            )
        }

        binding.contacts.setOnClickListener {
            handleIntent(
                R.id.contacts
            )
        }

        //users
        binding.userWithMessages.setOnClickListener {
            handleIntent(
                R.id.userWithMessages
            )
        }
        binding.users.setOnClickListener {
            handleIntent(
                R.id.users
            )
        }
        binding.userDetails.setOnClickListener {
            handleIntent(
                R.id.user_details
            )
        }

        //groups
        binding.groupWithMessages.setOnClickListener {
            handleIntent(R.id.groupWithMessages)
        }
        binding.groups.setOnClickListener {
            handleIntent(R.id.groups)
        }
        binding.createGroup.setOnClickListener {
            handleIntent(R.id.create_group)
        }
        binding.joinProtectedGroup.setOnClickListener {
            handleIntent(R.id.join_protected_group)
        }

        binding.callLogs.setOnClickListener {
            handleIntent(R.id.call_logs)
        }
        binding.callLogsWithDetails.setOnClickListener {
            handleIntent(R.id.call_logs_with_details)
        }
        binding.callLogRecording.setOnClickListener {
            handleIntent(R.id.call_log_recording)
        }
        //resources
        binding.soundManager.setOnClickListener {
            handleIntent(R.id.soundManager)
        }
        binding.theme.setOnClickListener {
            handleIntent(R.id.theme)
        }
        binding.localize.setOnClickListener {
            handleIntent(R.id.localize)
        }

    }

    private fun setUpUI() {
        if (isNightMode(this)) {
            changeIconTintToWhite(this, binding.backIcon)
            changeIconTintToWhite(this, binding.imageCwm)
            changeIconTintToWhite(this, binding.imageContacts)
            changeIconTintToWhite(this, binding.imageUwm)
            changeIconTintToWhite(this, binding.imageU)
            changeIconTintToWhite(this, binding.imageUd)
            changeIconTintToWhite(this, binding.imageGwm)
            changeIconTintToWhite(this, binding.imageG)
            changeIconTintToWhite(this, binding.imageCg)
            changeIconTintToWhite(this, binding.imageJp)
            changeIconTintToWhite(this, binding.imageAudio)
            changeIconTintToWhite(this, binding.imageTranslate)
            Utils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.app_background_dark))
            parentView.setBackgroundColor(
                ContextCompat.getColor(
                    this, R.color.app_background_dark
                )
            )
        } else {
            changeIconTintToBlack(this, binding.backIcon)
            changeIconTintToBlack(this, binding.imageCwm)
            changeIconTintToBlack(this, binding.imageContacts)
            changeIconTintToBlack(this, binding.imageUwm)
            changeIconTintToBlack(this, binding.imageU)
            changeIconTintToBlack(this, binding.imageUd)
            changeIconTintToBlack(this, binding.imageGwm)
            changeIconTintToBlack(this, binding.imageG)
            changeIconTintToBlack(this, binding.imageCg)
            changeIconTintToBlack(this, binding.imageJp)

            changeIconTintToBlack(this, binding.imageAudio)
            changeIconTintToBlack(this, binding.imageTranslate)

            Utils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.app_background))
            parentView.setBackgroundColor(
                ContextCompat.getColor(
                    this, R.color.app_background
                )
            )
        }
    }

    private fun handleIntent(id: Int) {
        val intent = Intent(this, ComponentLaunchActivity::class.java)
        intent.putExtra("component", id)
        startActivity(intent)
    }
}
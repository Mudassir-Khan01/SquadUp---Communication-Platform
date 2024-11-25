package com.cometchat.SquadUpApp.activity

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.cometchat.chatuikit.shared.resources.utils.Utils
import com.cometchat.SquadUpApp.AppUtils
//import com.cometchat.SquadUpApp.fragments.calls.CallButtonFragment
import com.cometchat.SquadUpApp.fragments.calls.CallLogDetailsFragment
import com.cometchat.SquadUpApp.fragments.calls.CallLogHistoryFragment
import com.cometchat.SquadUpApp.fragments.calls.CallLogParticipantsFragment
import com.cometchat.SquadUpApp.fragments.calls.CallLogRecordingFragment
import com.cometchat.SquadUpApp.fragments.calls.CallLogWithDetailsFragment
import com.cometchat.SquadUpApp.fragments.calls.CallLogsFragment
import com.cometchat.SquadUpApp.fragments.conversations.ContactsFragment
import com.cometchat.SquadUpApp.fragments.conversations.ConversationsFragment
import com.cometchat.SquadUpApp.fragments.conversations.ConversationsWithMessagesFragment
import com.cometchat.SquadUpApp.fragments.groups.AddMemberFragment
import com.cometchat.SquadUpApp.fragments.groups.BannedMembersFragment
import com.cometchat.SquadUpApp.fragments.groups.CreateGroupFragment
import com.cometchat.SquadUpApp.fragments.groups.GroupDetailsFragment
import com.cometchat.SquadUpApp.fragments.groups.GroupMembersFragment
import com.cometchat.SquadUpApp.fragments.groups.GroupsFragment
import com.cometchat.SquadUpApp.fragments.groups.GroupsWithMessagesFragment
import com.cometchat.SquadUpApp.fragments.groups.JoinProtectedGroupFragment
import com.cometchat.SquadUpApp.fragments.groups.TransferOwnershipFragment
//import com.cometchat.SquadUpApp.fragments.messages.MessageComposerFragment
//import com.cometchat.SquadUpApp.fragments.messages.MessageHeaderFragment
//import com.cometchat.SquadUpApp.fragments.messages.MessageInformationFragment
//import com.cometchat.SquadUpApp.fragments.messages.MessageListFragment
//import com.cometchat.SquadUpApp.fragments.messages.MessagesFragment
import com.cometchat.SquadUpApp.fragments.shared.resources.LocalizeFragment
import com.cometchat.SquadUpApp.fragments.shared.resources.SoundManagerFragment
import com.cometchat.SquadUpApp.fragments.shared.resources.ThemeFragment
//import com.cometchat.SquadUpApp.fragments.shared.views.AudioBubbleFragment
//import com.cometchat.SquadUpApp.fragments.shared.views.AvatarFragment
//import com.cometchat.SquadUpApp.fragments.users.UserDetailsFragment
import com.cometchat.kotlinsampleapp.R
import com.cometchat.kotlinsampleapp.databinding.ActivityComponentLaunchBinding

class ComponentLaunchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComponentLaunchBinding
    private lateinit var parentView: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComponentLaunchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getIntExtra("component", 0)
        parentView = binding.container
        setUpUI()
        when (id) {
            R.id.conversationWithMessages -> {
                loadFragment(ConversationsWithMessagesFragment())
            }

            R.id.groupWithMessages -> {
                loadFragment(GroupsWithMessagesFragment())
            }
            R.id.groups -> {
                loadFragment(GroupsFragment())
            }

            R.id.create_group -> {
                loadFragment(CreateGroupFragment())
            }

            R.id.join_protected_group -> {
                loadFragment(JoinProtectedGroupFragment())
            }

            R.id.soundManager -> {
                loadFragment(SoundManagerFragment())
            }

            R.id.theme -> {
                loadFragment(ThemeFragment())
            }

            R.id.localize -> {
                loadFragment(LocalizeFragment())
            }

            R.id.contacts -> {
                loadFragment(ContactsFragment())
            }
            R.id.call_logs -> {
                loadFragment(CallLogsFragment())
            }

            R.id.call_logs_with_details -> {
                loadFragment(CallLogWithDetailsFragment())
            }


            R.id.call_log_recording -> {
                loadFragment(CallLogRecordingFragment())
            }
        }
    }

    private fun setUpUI() {
        if (AppUtils.isNightMode(this)) {
            Utils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.app_background_dark))
            parentView.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.app_background_dark
                )
            )
        } else {
            Utils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.app_background))
            parentView.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.app_background
                )
            )
        }
    }

    private fun loadFragment(fragment: Fragment?) {
        if (fragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
        }
    }
}
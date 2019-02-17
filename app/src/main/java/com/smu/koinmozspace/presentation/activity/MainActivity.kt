package com.smu.koinmozspace.presentation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.smu.koinmozspace.R
import com.smu.koinmozspace.data.responses.Team
import com.smu.koinmozspace.domain.router.openFragment
import com.smu.koinmozspace.external.constant.Constant
import com.smu.koinmozspace.presentation.activity.fragment.DetailFragment

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), MainContract.View {

    val presenter: MainPresenter by inject()

    override fun setupUIListener() {
        btnSearch.setOnClickListener{
            val searchText = etSearchTeam.text.toString()
            presenter.searchTeams(searchText)

        }
    }

    override fun showTeamData(teamData: Team?) {
        val bundle = Bundle()
        bundle.putParcelable(Constant.BUNDLE_KEY,teamData)
        supportFragmentManager.openFragment(R.id.layoutSearchResult, DetailFragment(), bundle)
    }

    override fun showError(message: String) {
        toast(message)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.setupView(this)
        setupUIListener()
    }

}

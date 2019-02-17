package com.smu.koinmozspace.presentation.activity

import com.smu.koinmozspace.data.responses.Team

/**
 * Created by sapuser on 2/17/2019.
 */
class MainContract{
    interface View{
        fun setupUIListener()
        fun showTeamData(teamData: Team?)
        fun showError(message: String)
    }

    interface UserActionListener{
        fun setupView(view: View)
        fun searchTeams(searchText: String?)
        fun fetchTeamsData(teamData: Team?)
    }
}
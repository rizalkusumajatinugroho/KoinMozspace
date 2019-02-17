package com.smu.koinmozspace.presentation.activity

import android.content.Context
import com.google.gson.Gson
import com.smu.koinmozspace.data.responses.FootballClubData
import com.smu.koinmozspace.data.responses.Team

/**
 * Created by sapuser on 2/17/2019.
 */
class MainPresenter (val context: Context, val gson: Gson): MainContract.UserActionListener{

    private var view: MainContract.View? = null

    override fun searchTeams(searchText: String?) {
        if (!searchText.isNullOrEmpty()){
            try {
                val inputStream = context.assets.open("json/football_club.json")
                val inputString = inputStream.bufferedReader().use { it.readText() }
                val footballJson = gson.fromJson(inputString, FootballClubData::class.java)
                val footballData = footballJson.teams?.filter {
                    it?.strTeam?.toLowerCase()?.contains(searchText?.toLowerCase().toString()) == true
                }

                if (!footballData.isNullOrEmpty()){
                    fetchTeamsData(footballData.first())
                }else{
                    view?.showError("Data tidak ditemukan")
                }

            }catch (error: Exception){
                view?.showError(error.message.toString())
            }
        }else{
            view?.showError("Silahkan isi nama team yang dicari")
        }
    }

    override fun fetchTeamsData(teamData: Team?) {
        view?.showTeamData(teamData)
    }

    override fun setupView(view: MainContract.View) {
        this.view = view
    }

}
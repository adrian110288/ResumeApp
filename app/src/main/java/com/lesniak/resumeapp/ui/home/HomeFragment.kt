package com.lesniak.resumeapp.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lesniak.resumeapp.R
import com.lesniak.resumeapp.util.appComponent
import javax.inject.Inject

private const val TAG = "HomeFragment"

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        appComponent.homeComponent().create(this).inject(this)
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}

package com.riztech.vidiotest.util

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.nioso.core.util.hideKeyboard
import com.riztech.vidiotest.MainActivity
import com.riztech.vidiotest.VidioApp
import com.riztech.vidiotest.di.component.AppComponent

abstract class BaseFragment : Fragment() {
    protected lateinit var ctx: Context
    protected lateinit var act: Activity
    protected lateinit var manager: FragmentManager
    protected var saveView: View? = null
    protected lateinit var tagNetworking: String
    abstract fun setLayoutId(): Int
    abstract fun daggerInitial()

    abstract fun initialize(view: View, savedInstanceState: Bundle?)
    abstract fun observer()

    val appComponent: AppComponent by lazy {
        initializeAppComponent()
    }
    val main: MainActivity by lazy {
        (requireActivity() as MainActivity)
    }

    override fun onAttach(context: Context) {
        daggerInitial()
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        if (saveView == null) {
            saveView = inflater.inflate(setLayoutId(), container, false)
        }
        return saveView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAsset()

        initialize(view, savedInstanceState)
        observer()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
        try {
            hideKeyboard(ctx, view)
        } catch (e: Exception) {

        }
    }


    private fun setAsset() {
        context?.let {
            ctx = it
        }
        activity?.let {
            act = it
        }
        parentFragmentManager.let {
            manager = it
        }
    }

    fun showMessage(message: String) {
        Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show()
    }

    fun showMessage(@StringRes message: Int) {
        Toast.makeText(ctx, getString(message), Toast.LENGTH_SHORT).show()
    }

    private fun initializeAppComponent(): AppComponent {
        return (requireActivity().application as VidioApp).appComponent
    }

    fun startFragment(dest: NavDirections) {
        findNavController().navigate(dest)
    }

    fun back(){
        findNavController().navigateUp()
    }

    fun showLoadingDialog() {
        if (requireActivity() is MainActivity){//validation for instrumented test purpose
            (requireActivity() as MainActivity).showDialogLoading()
        }
    }

    fun hideLoadingDialog() {
        if (requireActivity() is MainActivity){//validation for instrumented test purpose
            (requireActivity() as MainActivity).hideDialogLoading()
        }
    }


}
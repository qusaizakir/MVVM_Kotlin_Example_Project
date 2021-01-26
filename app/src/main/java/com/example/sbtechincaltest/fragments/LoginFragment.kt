package com.example.sbtechincaltest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.afollestad.materialdialogs.MaterialDialog
import com.example.sbtechincaltest.R
import com.example.sbtechincaltest.viewmodels.LoginViewModel
import kotlinx.android.synthetic.main.login_fragment.*


class LoginFragment : BaseFragment<LoginViewModel>()  {

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun getViewModelClass(): Class<LoginViewModel> = LoginViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Inputs
        login_email_et.doAfterTextChanged { text -> viewModel.inputs.emailInput(text.toString()) }
        login_password_et.doAfterTextChanged { text -> viewModel.inputs.passwordInput(text.toString()) }
        login_login_btn.setOnClickListener { viewModel.inputs.loginClickEvent() }

        //Outputs
        viewModel.outputs.loginClicked().subscribe { login -> if(login) goToPhotoScreen() else showErrorDialog() }.autoDispose()

    }

    private fun showErrorDialog() {
        context?.let {
            MaterialDialog(it).show {
                title(R.string.empty_error_dialog_title)
                message(R.string.empty_error_dialog_content)
                positiveButton (R.string.empty_error_dialog_ok) { dismiss() }
            }
        }
    }

    private fun goToPhotoScreen() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, PhotoFragment.newInstance())
            ?.commitNow()
    }

}
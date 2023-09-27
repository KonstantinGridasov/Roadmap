package com.gkreduction.roadmap.ui.main.fragment.exam

import android.view.View
import com.gkreduction.domain.entity.QuestionAnswer
import com.gkreduction.roadmap.R
import com.gkreduction.roadmap.databinding.FragmentExamBinding
import com.gkreduction.roadmap.ui.base.BaseFragment
import com.gkreduction.roadmap.ui.main.MainActivity

class ExamFragment :
    BaseFragment<ExamViewModel>(
        R.layout.fragment_exam,
        ExamViewModel::class.java
    ), View.OnClickListener {


    override fun onStart() {
        super.onStart()
        (binding as FragmentExamBinding).viewModel = viewModel
        (binding as FragmentExamBinding).listener = this
        viewModel?.getQuestions()
        initObservers()
    }

    private fun initObservers() {
        activity?.let {
            viewModel?.onSkip?.observe(it) { item ->
                (binding as FragmentExamBinding).skip.text = viewModel?.getTitleByItem(item)
            }
            viewModel?.onBad?.observe(it) { item ->
                (binding as FragmentExamBinding).bad.text = viewModel?.getTitleByItem(item)
            }
            viewModel?.onRight?.observe(it) { item ->
                (binding as FragmentExamBinding).right.text = viewModel?.getTitleByItem(item)
            }

            viewModel?.question?.observe(it) { item ->
                (binding as FragmentExamBinding).textQuestion.text = item
            }

            viewModel?.answer?.observe(it) { item ->
                showDialog(item)
            }
            viewModel?.statusFinish?.observe(it) { item ->
                showDialogFinish(item)
            }
        }

    }

    override fun onClick(p0: View?) {
        when (p0) {
            (binding as FragmentExamBinding).buttonSkip -> {
                viewModel?.onSkipClick()
            }
            (binding as FragmentExamBinding).ivBad -> {
                viewModel?.onBadClick()
            }
            (binding as FragmentExamBinding).ivRight -> {
                viewModel?.onRightClick()
            }
            (binding as FragmentExamBinding).ivHelp -> {
                viewModel?.getAnswerId()
            }
        }
    }

    private fun showDialog(item: QuestionAnswer) {
        (activity as? MainActivity)?.showDialogHelp(item) {viewModel?.clearAnswer()}

    }

    private fun showDialogFinish(status: Boolean) {
        (activity as? MainActivity)?.showDialogFinish(status) { viewModel?.clearQuestion() }
    }
}


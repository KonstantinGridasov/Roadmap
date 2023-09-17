package com.gkreduction.interview.di.module

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.gkreduction.data.repository.NetworkRepositoryImpl
import com.gkreduction.domain.usecase.GetRoadmapsUseCase
import com.gkreduction.interview.di.scope.MainScope
import com.gkreduction.interview.ui.main.MainViewModel
import com.gkreduction.interview.ui.main.fragment.answer.AnswerFragment
import com.gkreduction.interview.ui.main.fragment.answer.AnswerViewModel
import com.gkreduction.interview.ui.main.fragment.category.CategoryFragment
import com.gkreduction.interview.ui.main.fragment.category.CategoryViewModel
import com.gkreduction.interview.ui.main.fragment.exam.ExamFragment
import com.gkreduction.interview.ui.main.fragment.exam.ExamViewModel
import com.gkreduction.interview.ui.main.fragment.home.HomeFragment
import com.gkreduction.interview.ui.main.fragment.home.HomeViewModel
import com.gkreduction.interview.ui.main.fragment.question.QuestionFragment
import com.gkreduction.interview.ui.main.fragment.question.QuestionViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {

    @ContributesAndroidInjector
    internal abstract fun contributeCategoryFragment(): CategoryFragment

    @ContributesAndroidInjector
    internal abstract fun contributeQuestionFragment(): QuestionFragment

    @ContributesAndroidInjector
    internal abstract fun contributeAnswerFragment(): AnswerFragment

    @ContributesAndroidInjector
    internal abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    internal abstract fun contributeExamFragment(): ExamFragment


    companion object {
        @Provides
        @MainScope
        fun providesGetRoadmapsUseCase(
            service: NetworkRepositoryImpl,
        ) =
            GetRoadmapsUseCase(service)


        @Provides
        fun provideViewModelFactory(
            app: Application,
            getRoadmapsUseCase: GetRoadmapsUseCase
        ): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    modelClass: Class<T>,
                    extras: CreationExtras
                ): T {
                    return when {
                        modelClass.isAssignableFrom(ExamViewModel::class.java) ->
                            ExamViewModel(
                                app
                            ) as T
                        modelClass.isAssignableFrom(HomeViewModel::class.java) ->
                            HomeViewModel(
                                app,
                                getRoadmapsUseCase
                            ) as T

                        modelClass.isAssignableFrom(MainViewModel::class.java) ->
                            MainViewModel(
                                app
                            ) as T

                        modelClass.isAssignableFrom(CategoryViewModel::class.java) ->
                            CategoryViewModel(
                                app
                            ) as T

                        modelClass.isAssignableFrom(QuestionViewModel::class.java) ->
                            QuestionViewModel(
                                app
                            ) as T
                        modelClass.isAssignableFrom(AnswerViewModel::class.java) ->
                            AnswerViewModel(
                                app
                            ) as T

                        else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                    }
                }
            }
        }
    }

}
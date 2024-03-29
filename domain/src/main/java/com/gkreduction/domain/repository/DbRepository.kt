package com.gkreduction.domain.repository

import com.gkreduction.domain.entity.ItemRoadmap
import com.gkreduction.domain.entity.QuestionAnswer
import com.gkreduction.domain.entity.Roadmap

interface DbRepository {
    suspend fun updateQuestion(): Boolean
    suspend fun updateDb(): Boolean
    suspend fun getRoadmaps(): List<Roadmap>
    suspend fun getRoadmapById(id: Long): List<ItemRoadmap>
    suspend fun getQuestionByItem(
        item: ItemRoadmap,
        random: Boolean,
        size: Int
    ): List<QuestionAnswer>

    suspend fun getQuestionById(param: Long): QuestionAnswer

}
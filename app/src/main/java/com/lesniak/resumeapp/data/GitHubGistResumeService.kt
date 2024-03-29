package com.lesniak.resumeapp.data

import com.lesniak.resumeapp.data.models.Bio
import com.lesniak.resumeapp.data.models.Skill
import com.lesniak.resumeapp.data.models.WorkExperience
import retrofit2.http.GET

interface GitHubGistResumeService {

    @GET("137493acaf58061c34130aba9ea0235d/raw/5f028c05720459a40a70ca751ff56b99b77386ad/resume-bio.json")
    suspend fun getBio(): Bio

    @GET("1eb6692e767ff19af3821ce667c03534/raw/72b47fa38b1c2d71153c7f322a9428ce97a1c9f5/resume-skills.json")
    suspend fun getSkills(): List<Skill>

    @GET("dc24fb5803f91bfc574e54a38a107989/raw/1151488a6d5ec0266460fc8afbc8adaa87d78546/resume-experience.json")
    suspend fun getWorkExperience(): List<WorkExperience>
}
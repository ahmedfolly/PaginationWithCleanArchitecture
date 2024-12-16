package com.example.paginationtraining.moviesList

import com.example.paginationtraining.moviesList.data.APIService
import com.example.paginationtraining.moviesList.data.GetMoviesRepoImp
import com.example.paginationtraining.moviesList.domain.GetMoviesListUseCase
import com.example.paginationtraining.moviesList.domain.GetMoviesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DI {
    @Provides
    fun provideGetMoviesUseCase(repo: GetMoviesRepo): GetMoviesListUseCase {
        return GetMoviesListUseCase(repo)
    }

    @Provides
    fun provideGetMoviesRepo(api: APIService): GetMoviesRepo {
        return GetMoviesRepoImp(api)
    }

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor)
            .build()
    }


}
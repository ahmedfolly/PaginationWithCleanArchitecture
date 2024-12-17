package com.example.paginationtraining.moviesList

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.paginationtraining.moviesList.data.APIService
import com.example.paginationtraining.moviesList.data.GetMoviesRepoImp
import com.example.paginationtraining.moviesList.data.local.MoviesDao
import com.example.paginationtraining.moviesList.data.local.MoviesDatabase
import com.example.paginationtraining.moviesList.domain.GetMoviesListUseCase
import com.example.paginationtraining.moviesList.domain.GetMoviesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DI {
    @Volatile
    private var INSTANCE: MoviesDatabase? = null
    @Provides
    fun provideGetMoviesUseCase(repo: GetMoviesRepo): GetMoviesListUseCase {
        return GetMoviesListUseCase(repo)
    }

    @Provides
    fun provideGetMoviesRepo(api: APIService, dao: MoviesDao): GetMoviesRepo {
        return GetMoviesRepoImp(api, dao)
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

    @Provides
    fun provideDao(roomDatabase: MoviesDatabase): MoviesDao {
        return roomDatabase.getDao()
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MoviesDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context,
                MoviesDatabase::class.java,
                "movie_database"
            ).build()
            INSTANCE = instance
            instance
        }

    }

}
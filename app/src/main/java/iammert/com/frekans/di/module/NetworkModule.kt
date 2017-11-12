package iammert.com.frekans.di.module

import dagger.Module
import dagger.Provides
import iammert.com.frekans.BuildConfig
import iammert.com.frekans.data.remote.FrekansService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by mertsimsek on 12/11/2017.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder().baseUrl(BuildConfig.API_URL).build()

    @Provides
    @Singleton
    fun provideFrekansService(retrofit: Retrofit) = retrofit.create(FrekansService::class.java)
}
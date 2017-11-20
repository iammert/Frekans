package iammert.com.frekans.di.module

import dagger.Module
import dagger.Provides
import iammert.com.frekans.BuildConfig
import iammert.com.frekans.data.remote.FrekansService
import iammert.com.frekans.util.extension.debug
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by mertsimsek on 12/11/2017.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okhttpBuilder = OkHttpClient.Builder()
        debug { okhttpBuilder.addInterceptor(loggingInterceptor) }
        return okhttpBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BuildConfig.API_URL)
                    .build()

    @Provides
    @Singleton
    fun provideFrekansService(retrofit: Retrofit) = retrofit.create(FrekansService::class.java)
}
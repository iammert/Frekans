package iammert.com.player

import dagger.Module
import dagger.Provides
import iammert.com.player.ExoPlayerSourceProvider
import iammert.com.player.MediaSourceProvider
import javax.inject.Singleton

/**
 * Created by mertsimsek on 19/12/2017.
 */
@Module
class PlayerModule {

    @Provides
    fun provideMediaSource(exoPlayerSourceProvider: ExoPlayerSourceProvider): MediaSourceProvider {
        return exoPlayerSourceProvider
    }
}
/*
 *
 *  * Created by Ariful Jannat Arif on 12/10/20 7:48 PM
 *  * cse.ariful@gmail.com
 *  * Bismillahir Rahmanir Rahim
 *  * Last modified 12/10/20 7:48 PM
 *
 */

package com.arif.classroom.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ActivityRetainedComponent::class)
object ProvideModule {

    /*  @Provides
      @Singleton
      fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
          return AppDatabase.getDatabse(context)
      }

      @Provides
      @Singleton
      fun provideDao(appDatabase: AppDatabase): DbDao {
          return appDatabase.downloadsDao()
      }*/


    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }
/*
        @Provides
        fun provideMediaRepository(@ApplicationContext context: Context):MediaRepository{
            return MediaRepository(context)
        }*/

}
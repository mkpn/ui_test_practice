package makoto.yoshida.uitesttutorial.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import makoto.yoshida.uitesttutorial.domain.TestRepository

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationModule {
    @Provides
    fun provideTestRepository(@ApplicationContext context: Context): TestRepository {
        return TestRepository(context)
    }
}
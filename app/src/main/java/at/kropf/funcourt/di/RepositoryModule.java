package at.kropf.funcourt.di;

import javax.inject.Singleton;

import at.kropf.funcourt.db.AppDatabase;
import at.kropf.funcourt.repository.UserRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    UserRepository provideUserRepository(AppDatabase database) {
        return new UserRepository(database);
    }

}
